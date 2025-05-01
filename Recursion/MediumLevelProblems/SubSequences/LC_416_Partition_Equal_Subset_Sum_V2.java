package MediumLevelProblems.SubSequences;

import java.util.Arrays;

public class LC_416_Partition_Equal_Subset_Sum_V2 {

    static boolean solve(int nums[], int index, int sum) {
        if (sum == 0)
            return true;
        if (index == nums.length || sum < 0)
            return false;

        return solve(nums, index + 1, sum - nums[index]) || solve(nums, index + 1, sum);
    }

    // O(N + totalSum *(2^N)) && O(N)
    public static boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();

        for (int subSet1 = 1; subSet1 <= totalSum / 2; subSet1++) {

            boolean isSubset = solve(nums, 0, subSet1);

            if (!isSubset)
                continue;

            int subSet2 = totalSum - subSet1;
            if (subSet1 == subSet2)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        System.out.println(canPartition(arr));
    }
}
