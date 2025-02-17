package MediumLevelProblems;

public class MaximizeTheCutStatement {

    static int maxCut = 0;

    // O(3^N) && O(N)
    public static int maximizeCuts(int n, int x, int y, int z) {
        helper(n, x, y, z, 0);
        return maxCut;

    }

    private static void helper(int n, int x, int y, int z, int count) {
        if (n == 0) {
            maxCut = Math.max(maxCut, count);
            return;
        }

        if (n < 0) {
            return;
        }

        helper(n - x, x, y, z, count + 1);
        helper(n - y, x, y, z, count + 1);
        helper(n - z, x, y, z, count + 1);
    }

    public static void main(String[] args) {
        int n = 5, x = 5, y = 3, z = 2;
        System.out.println(maximizeCuts(n, x, y, z));

    }
}
