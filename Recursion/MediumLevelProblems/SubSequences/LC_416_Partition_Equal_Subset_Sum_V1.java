package MediumLevelProblems.SubSequences;

import java.util.Arrays;

public class LC_416_Partition_Equal_Subset_Sum_V1 {


    // O(N + 2 ^(N)) && O(N) -- > O(2 ^ N) && O(N)
    public static boolean canPartition(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return true;
        }

        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0) {
            return false;
        }
        return isPossible(nums, totalSum / 2, 0);
    }

    private static boolean isPossible(int[] nums, int sum, int index) {
        if (index == nums.length) {
            return false;
        }

        if (sum == 0) {
            return true;
        }

        boolean currPick = false;
        if (sum >= nums[index]) {
            currPick = isPossible(nums, sum - nums[index], index + 1);
        }
        boolean currSkip = isPossible(nums, sum, index + 1);

        return currPick || currSkip;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 , 4};
        System.out.println(canPartition(arr));

    }
}
