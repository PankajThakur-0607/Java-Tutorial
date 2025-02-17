package MediumLevelProblems;

public class LC_213_HouseRobber_II {

    // O(2 ^ N) && O(N )
    static int helper(int nums[], int n, int index) {
        if (index >= n) {
            return 0;
        }

        int pick = nums[index] + helper(nums, n, index + 2);
        int skip = helper(nums, n, index + 1);

        return Math.max(pick, skip);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int startIdx0 = helper(nums, n - 1, 0);
        int startIdx1 = helper(nums, n, 1);

        return Math.max(startIdx0, startIdx1);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };

        System.out.println(rob(nums));
    }
}
