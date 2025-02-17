package MediumLevelProblems;

public class LC_2466_CountWays_GoodString {
    static final int MOD = 1000000007;

    public static int countGoodStrings() {
        int low = 3, high = 3, zero = 1, one = 1;

        return helper(low, high, zero, one, 0);
    }

    // O(2^N) && O(N)
    private static int helper(int low, int high, int zero, int one, int strLen) {
        if (strLen > high) {
            return 0;
        }

        int appendZero = helper(low, high, zero, one, strLen + zero);
        int appendOne = helper(low, high, zero, one, strLen + one);
        int numGoodStrs = (((appendOne + appendZero) % MOD) + ((strLen >= low && strLen <= high) ? 1 : 0) % MOD);
        return numGoodStrs;
    }

    public static void main(String[] args) {
        System.out.println(countGoodStrings());
    }
}