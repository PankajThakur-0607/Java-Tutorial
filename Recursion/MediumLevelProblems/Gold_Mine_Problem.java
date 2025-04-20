package MediumLevelProblems;

public class Gold_Mine_Problem {

    // O(M * (3 ^ (M * N))) && O(M + N)
    public static int maxGold(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;
        int maxGold = 0;

        for (int j = 0; j < m; j++) {
            maxGold = Math.max(maxGold, helper(mat, m, n, j, 0));
        }
        return maxGold;
    }

    private static int helper(int[][] mat, int m, int n, int row, int col) {
        if (row >= m || col >= n || row < 0 || col < 0) {
            return 0;
        }

        int moveUpRight = helper(mat, m, n, row - 1, col + 1);
        int moveRight = helper(mat, m, n, row, col + 1);
        int moveDownRight = helper(mat, m, n, row + 1, col + 1);

        return mat[row][col] + Math.max(moveRight, Math.max(moveUpRight, moveDownRight));
    }

    public static void main(String[] args) {
        // int mat[][] = {
        // { 1, 3, 1, 5 },
        // { 2, 2, 4, 1 },
        // { 5, 0, 2, 3 },
        // { 0, 6, 1, 2 }
        // };

        int mat[][] = {
                { 1, 3, 3 },
                { 2, 1, 4 },
                { 0, 7, 5 }
        };

        System.out.println(maxGold(mat));
    }
}
