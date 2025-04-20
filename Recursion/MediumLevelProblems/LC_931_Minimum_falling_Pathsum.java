package MediumLevelProblems;

public class LC_931_Minimum_falling_Pathsum {

    public static int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        int minPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            minPathSum = Math.min(minPathSum, helper(matrix, N, 0, i));
        }

        return minPathSum;
    }

    private static int helper(int[][] matrix, int N, int row, int col) {
        if (row >= N || col >= N || col < 0) {
            return Integer.MAX_VALUE;
        }

        int moveDownleft = helper(matrix, N, row + 1, col - 1);
        int moveDown = helper(matrix, N, row + 1, col);
        int moveDownRight = helper(matrix, N, row + 1, col + 1);

        int minPath = Math.min(moveDown, Math.min(moveDownleft, moveDownRight));

        return (minPath == Integer.MAX_VALUE) ? matrix[row][col] : matrix[row][col] + minPath;
    }

    public static void main(String[] args) {
        // int matrix[][] = {
        // { 2, 1, 3 },
        // { 6, 5, 4 },
        // { 7, 8, 9 }
        // };

        int matrix[][] = {
                { -19, 57 },
                { -40, -5 },
        };
        System.out.println(minFallingPathSum(matrix));

    }
}