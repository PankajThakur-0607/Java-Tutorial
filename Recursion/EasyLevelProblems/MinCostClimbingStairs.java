package EasyLevelProblems;

public class MinCostClimbingStairs {
    
    public static int helper(int cost[] , int n){
        if (n == 0) {
            return cost[n];
        }

        if (n < 0) {
            return 0;
        }
        
        int pick = cost[n] +  helper(cost, n - 1);
        int skip = cost[n] + helper(cost, n - 2);
        return Math.min(pick, skip);

    }
    public  static int minCostClimbingStairs(int[] cost) {
        int n = cost.length ;
        int startIdx0 = helper(cost, n - 1);
        int startIdx1 = helper(cost, n - 2);
        return Math.min(startIdx0, startIdx1); 
    }

    public static void main(String[] args) {
        int[] cost = {10 , 15 , 20};
        System.out.println(minCostClimbingStairs(cost));

    }
}
