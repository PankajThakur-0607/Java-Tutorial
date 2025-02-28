package MediumLevelProblems;


public class FrogJump_II {

    static int n;

    public static int getMinValue(int costs[], int k, int index) {
        if (index == n - 1) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        for (int jump = 1; (jump < index + k && jump + index < n); jump++) {
            int j = index + jump;
            int currCost = Math.abs(costs[index] - costs[j]) + getMinValue(costs, k, j);
            minCost = Math.min(minCost, currCost);
        }
        return minCost;
    }

    public static int minimizeCost(int k, int costs[]) {
        n = costs.length;
        return getMinValue(costs, k, 0);

    }

    public static void main(String[] args) {
        int costs[] = { 10, 20 , 30};
        System.out.println(minimizeCost(2, costs));

    }
}
