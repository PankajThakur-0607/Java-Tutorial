package MediumLevelProblems.SubSequences;

import java.util.Arrays;

public class Partition_With_Given_Difference {

    static int n;

    private static int helper(int[] nums, int target, int index) {

        if (index == nums.length - 1) {
            if (target == 0)
                return (nums[index] == 0) ? 2 : 1;
            else
                return (nums[index] == target) ? 1 : 0;
        }

        int currTake = 0;
        if (target >= nums[index]) {
            currTake = helper(nums, target - nums[index], index + 1);
        }
        int currSkip = helper(nums, target, index + 1);

        return currTake + currSkip;
    }

    public static int countPartitions(int[] arr, int d) {
        n = arr.length;

        int totalSum = Arrays.stream(arr).sum();
        // System.out.println(totalSum);
        int countPart = 0;
        for (int currentVal = 1; currentVal <= totalSum; currentVal++) {

            int countSubset = helper(arr, currentVal, 0);

            int remainingSum = totalSum - currentVal;
            if (currentVal >= remainingSum && (currentVal - remainingSum) == d) {
                countPart += countSubset;
            }

        }

        return countPart;

    }

    public static void main(String[] args) {
        int arr[] = {5 , 2 , 6 , 4};
        int d = 3 ;

        System.out.println(countPartitions(arr, d));
    }
}
