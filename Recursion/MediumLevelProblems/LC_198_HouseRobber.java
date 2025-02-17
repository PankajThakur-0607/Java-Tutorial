package MediumLevelProblems;

// O(2 ^ N / 2) && O(N / 2)
public class LC_198_HouseRobber {

    public static int helper(int nums[], int n) {
        if (n == 0) {
            return nums[n];
        }

        if (n < 0) {
            return 0;
        }
        int pick = nums[n] + helper(nums, n - 2);
        int skip = helper(nums, n - 1);

        return Math.max(pick, skip);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        return helper(nums, n - 1);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1 };
        System.out.println(rob(nums));

    }
}
