package MediumLevelProblems;

import java.util.Arrays;

public class FrogJump {

    public static int solve_V1(int height[], int n, int index, int prevHeight) {

        if (index == n - 1) {
            return Math.abs(prevHeight - height[index]);
        }

        if (index >= n) {
            return Integer.MAX_VALUE;
        }

        int climbOneStep = solve_V1(height, n, index + 1, height[index]);
        int climbTwoStep = solve_V1(height, n, index + 2, height[index]);

        return Math.abs(height[index] - prevHeight) + Math.min(climbOneStep, climbTwoStep);
    }

    public static int minCost_V1(int height[]) {
        int n = height.length;
        return solve_V1(height, n, 0, height[0]);
    }

    public static int solve_V2(int height[], int n, int index, int[] dp) {
        if (index >= n - 1) {
            return 0;
        }

        if (dp[index] != -1)
            return dp[index];

        int cost_1 = Math.abs(height[index] - height[index + 1]) + solve_V2(height, n, index + 1, dp);

        int jumpCost2 = (index + 2) < n ? Math.abs(height[index] - height[index + 2]) : Integer.MAX_VALUE;
        int cost_2 = jumpCost2 + solve_V2(height, n, index + 2, dp);

        int minCost = Math.min(cost_1, cost_2);

        return dp[index] = minCost;
    }

    public static int minCost_V2(int height[]) {
        int n = height.length;

        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve_V2(height, n, 0, dp);
    }

    public static void main(String[] args) {
        int height[] = { 20, 30, 40, 50 };
        System.out.println(minCost_V2(height));
        System.out.println(minCost_V1(height));
    }
}
