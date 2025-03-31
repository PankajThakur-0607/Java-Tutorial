package MediumLevelProblems;

public class Catalan_Number {

    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Long and Integer OverFlow occur in this solution
    public static int CatalanNumber_V1(int n) {
        long numerator = factorial(2 * n);
        long denominator = factorial(n + 1) * factorial(n);
        long solution = numerator / denominator;
        return (int) solution;
    }

    public static int CatalanNumber_V2(int N) {
        // Stores the values of Catalan's triangle
        int[][] dp = new int[N + 1][N + 1];

        for (int R = 0; R <= N; R++) {
            for (int C = 0; C <= R; C++) {
                // If it's the first column, fill it with 1
                if (C == 0) {
                    dp[R][C] = 1;
                }
                // If it's the last column, store the value from the previous column in the same
                // row
                else if (C == R) {
                    dp[R][C] = dp[R][C - 1];
                }
                // Otherwise, sum the value from the previous row (same column) and previous
                // column (same row)
                else {
                    dp[R][C] = (dp[R - 1][C] + dp[R][C - 1]);
                }
            }
        }

        return dp[N][N - 1];
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(CatalanNumber_V1(n));
        System.out.println(CatalanNumber_V2(n));
        System.out.println((int) Math.log10(n) + 1);
    }
}
