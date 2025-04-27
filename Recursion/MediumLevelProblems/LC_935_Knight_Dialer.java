package MediumLevelProblems;

public class LC_935_Knight_Dialer {

    public static final int directions[][] = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 2, -1 }, { 2, 1 },
            { 1, -2 }, { 1, 2 } };
    public static int keypad[][] = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 },
            { -1, 0, -1 }
    };

    static int totalRows = 4, totalColumns = 3;

    // O(10 * (8 ^ N)) && O(N)
    public static int knightDialer(int n) {
        int totalUniqueNumbers = 0;
        for (int R = 0; R < totalRows; R++) {
            for (int C = 0; C < totalColumns; C++) {
                totalUniqueNumbers = (totalUniqueNumbers + helper(n - 1, R, C));
            }
        }

        return totalUniqueNumbers;
    }

    private static int helper(int n, int R, int C) {

        if (R >= totalRows || C >= totalColumns || R < 0 || C < 0 || keypad[R][C] == -1) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        int count = 0;

        for (int[] dir : directions) {
            int newR = R + dir[0];
            int newC = C + dir[1];

            count = (count + helper(n - 1, newR, newC));
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(knightDialer(n));
    }

}