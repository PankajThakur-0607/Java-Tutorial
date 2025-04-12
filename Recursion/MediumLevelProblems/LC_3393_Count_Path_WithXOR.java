package MediumLevelProblems;

public class LC_3393_Count_Path_WithXOR {

    static int m;
    static int n;
    static final int MOD = 1000000007;

    public static int countPathsWithXorValue(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        return helper(grid, 0, 0, 0, k);
    }

    private static int helper(int[][] grid, int startRow, int startCol, int xorValue, int k) {
        if (startRow == m || startCol == n) {
            return 0;
        }

        if (startRow == m - 1 && startCol == n - 1) {

            if ((xorValue ^ grid[startRow][startCol]) == k) {
                return 1;
            }

            return 0;
        }

        int goDown = helper(grid, startRow + 1, startCol, xorValue ^ grid[startRow][startCol], k);
        int goRight = helper(grid, startRow, startCol + 1, xorValue ^ grid[startRow][startCol], k);

        return (goDown + goRight) % MOD;
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 2, 1, 5 },
                { 7, 10, 0 },
                { 12, 6, 4 },
        };
        int k = 11;
        System.out.println(countPathsWithXorValue(grid, k));

    }
}
