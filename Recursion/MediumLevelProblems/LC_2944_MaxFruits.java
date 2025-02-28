package MediumLevelProblems;

public class LC_2944_MaxFruits {


    // O(n/2 ^ n/2) && O(n);
    public static int minimumCoins(int[] prices) {
        int n = prices.length;
        return getMinCoins(prices, n, 0);
    }

    public static int getMinCoins(int[] prices, int n, int index) {
        if (index >= n) {
            return 0;
        }

        int minimumCoins = Integer.MAX_VALUE;

        for (int j = index + 1; (j <= index + index + 2); j++) {
            int nextPossibleCoins = getMinCoins(prices, n, j);
            minimumCoins = Math.min(minimumCoins, nextPossibleCoins);
        }

        return prices[index] + minimumCoins;
    }

    
    public static void main(String[] args) {
        int prices[] = { 1, 10, 1, 1 };         
        System.out.println(minimumCoins(prices));

    }
}
