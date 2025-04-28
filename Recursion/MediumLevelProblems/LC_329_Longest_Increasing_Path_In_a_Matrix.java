package MediumLevelProblems;

public class LC_329_Longest_Increasing_Path_In_a_Matrix {
    static int M;
    static int N;
    static int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    // O(M * N * 4 ^ (M * N)) && O(M * N)
    public static int longestIncreasingPath(int[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;
        int maxLen = 0;
        for (int R = 0; R < M; R++) {
            for (int C = 0; C < N; C++) {
                maxLen = Math.max(maxLen, getLongestIncPath(matrix, R, C));
            }
        }

        return maxLen;
    }

    public static boolean isValid(int R, int C) {
        return R >= 0 && R < M && C >= 0 && C < N;
    }

    private static int getLongestIncPath(int[][] matrix, int R, int C) {

        int maxLen = 1;

        for (int[] dir : directions) {
            int newR = R + dir[0];
            int newC = C + dir[1];

            if (isValid(newR, newC) && matrix[newR][newC] > matrix[R][C]) {
                maxLen = Math.max(maxLen, 1 + getLongestIncPath(matrix, newR, newC));
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int matrix[][] = {
                { 3, 4, 5 },
                { 3, 2, 6 },
                { 2, 1, 1 }
        };

        System.out.println(longestIncreasingPath(matrix));
    }
}
