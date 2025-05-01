package MediumLevelProblems.SubSequences;

public class Perfect_Sum_Problem {

    public static int perfectSum(int[] nums, int target) {
        return helper(nums, target, 0);
    }

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

    public static void main(String[] args) {
        int nums[] = { 0, 10, 0 };
        int target = 0;

        System.out.println(perfectSum(nums, target));

    }
}
