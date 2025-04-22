package MediumLevelProblems;

public class Arrange_Balls {

    static final int MOD = 1000000007;

    public static int CountWays(int p, int q, int r) {
        return helper(p, q, r, 0);
    }

    // O(3^(p*q*r)) && O(p + q + r)
    private static int helper(int p, int q, int r, int prevBall) {
        if (p == 0 && q == 0 && r == 0) {
            return 1;
        }

        if (p < 0 || q < 0 || r < 0) {
            return 0;
        }
        int count = 0;
        if (prevBall != 1)
            count = helper(p - 1, q, r, 1);
        if (prevBall != 2)
            count = (count + helper(p, q - 1, r, 2)) % MOD;
        if (prevBall != 3)
            count = (count + helper(p, q, r - 1, 3)) % MOD;

        return (count % MOD);
    }

    public static void main(String[] args) {
        int p = 1;
        int q = 1;
        int r = 1;

        System.out.println(CountWays(p, q, r));
    }
}
