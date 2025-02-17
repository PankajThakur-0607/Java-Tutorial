package MediumLevelProblems;

public class LC_983_MinimumCostForTickets {

    public static int solve(int[] days, int[] costs, int n, int index) {
        if (index >= n) {
            return 0;
        }

        int cost_1 = costs[0] + solve(days, costs, n, index + 1);

        // for 7 days
        int maxDay = days[index] + 7;
        int j = index + 1;
        while (j < n && days[j] < maxDay) {
            j++;
        }

        int cost_2 = costs[1] + solve(days, costs, n, j);

        // for 30 days
        maxDay = days[index] + 30;
        j = index + 1;
        while (j < n && days[j] < maxDay) {
            j++;
        }
        int cost_3 = costs[2] + solve(days, costs, n, j);

        int minPrice = Math.min(cost_1, Math.min(cost_2, cost_3));

        return minPrice;

    }

    public static int mincostTickets_V1(int[] days, int[] costs) {
        int n = days.length;
        return solve(days, costs, n, 0);
    }

    public static int mincostTickets_V2(int[] days, int[] costs) {
        int n = days.length;
        return solve_V2(days, costs, n, 0);
    }

    public static int solve_V2(int[] days, int[] costs, int n, int index) {
        if (index >= n) {
            return 0;
        }

        int cost_1 = costs[0] + solve(days, costs, n, getNextStartDay(days, days[index] + 1 - 1, index + 1, n));

        int cost_2 = costs[1] + solve(days, costs, n, getNextStartDay(days, days[index] + 7 - 1, index + 1, n));

        int cost_3 = costs[2] + solve(days, costs, n, getNextStartDay(days, days[index] + 30 - 1, index + 1, n));

        int minPrice = Math.min(cost_1, Math.min(cost_2, cost_3));

        return minPrice;
    }

    private static int getNextStartDay(int[] days, int target, int index, int n) {
        for (int start = index; start < n; start++) {
            if (days[start] > target) {
                return start;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int days[] = { 1, 4, 6, 7, 8, 20 };
        int costs[] = { 2, 7, 15 };
        System.out.println(mincostTickets_V2(days, costs));
        System.out.println(mincostTickets_V1(days, costs));

    }
}
