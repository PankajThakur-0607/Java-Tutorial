package MediumLevelProblems;

public class LC_322_CoinsChange {

    public static int helper(int coins[], int amount, int n) {
        if (amount == 0) {
            return 0;
        }
        if (n == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int takeCoins = Integer.MAX_VALUE;
        if (coins[n] <= amount) {
            takeCoins = helper(coins, amount - coins[n], n);
            if (takeCoins != Integer.MAX_VALUE) {
                takeCoins = 1 + takeCoins;
            }
        }

        int skipCoins = helper(coins, amount, n - 1);

        System.out.println("Take: " + takeCoins + ", Skip: " + skipCoins);

        return Math.min(takeCoins, skipCoins);
    }

    public static int coinsChange(int coins[], int amount) {
        int n = coins.length;
        return helper(coins, amount, n - 1);
    }

    public static void main(String[] args) {
        int coins[] = { 3, 2, 5 };
        int amount = 13;

        System.out.println(coinsChange(coins, amount));
    }
}
