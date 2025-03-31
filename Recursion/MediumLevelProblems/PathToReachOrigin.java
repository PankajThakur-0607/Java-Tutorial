package MediumLevelProblems;

public class PathToReachOrigin {

    // O(2 ^ (n * m)) && O(n + m)
    private static final int MOD = 1000000007;

    public static int ways(int n, int m) {
        return getWays(n, m);
    }

    private static int getWays(int n, int m) {
        if (n == 0 && m == 0) {
            return 1;
        }

        if (n < 0 || m < 0) {
            return 0;
        }

        int nextWay = getWays(n - 1, m);
        int nextWay1 = getWays(n, m - 1);

        return (nextWay + nextWay1) % MOD;

    }

    public static void main(String[] args) {
        int n = 2, m = 2;
        System.out.println(ways(n, m));

        // System.out.println(2 ^ 0);
    }
}
