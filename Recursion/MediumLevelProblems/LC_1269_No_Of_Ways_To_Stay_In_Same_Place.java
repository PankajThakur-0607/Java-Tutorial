package MediumLevelProblems;

public class LC_1269_No_Of_Ways_To_Stay_In_Same_Place {

    static final int MOD = 1000000007;

    public static int numWays(int steps, int arrLen) {
        return helper(steps, arrLen, 0);
    }

    private static int helper(int steps, int arrLen, int index) {
        if (index < 0 || index == arrLen || steps < 0) {
            return 0;
        }

        if (steps == 0) {
            if (index == 0) {
                return 1;
            }

            return 0;
        }

        int moveLeft = helper(steps - 1, arrLen, index - 1);
        int stay = helper(steps - 1, arrLen, index);
        int moveRight = helper(steps - 1, arrLen, index + 1);

        return (moveLeft + moveRight + stay) % MOD;

    }

    public static void main(String[] args) {
        int steps = 4;
        int arrLen = 2;

        System.out.println(numWays(steps, arrLen));
    }
}
