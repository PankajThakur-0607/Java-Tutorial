package MediumLevelProblems;

public class LC_2684_Max_Num_of_Moves_in_a_Grid {
    static int M;
    static int N;
    static int directions[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

    // O(M * 3 ^ (M * N)) && O(M + N )
    public static int maxMoves(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        int count = 0;
        for (int R = 0; R < M; R++) {
            count = Math.max(count, getMaxMoves(grid, R, 0));
        }

        return count;
    }

    public static boolean isValid(int R, int C) {
        return R >= 0 && R < M && C < N;
    }

    private static int getMaxMoves(int[][] grid, int R, int C) {

        if (R < 0 || R == M || C == N) {
            return 0;
        }

        int countMoves = 0;
        for (int[] dir : directions) {
            int newR = R + dir[0];
            int newC = C + dir[1];

            if (isValid(newR, newC) && grid[newR][newC] > grid[R][C]) {
                countMoves = Math.max(countMoves, 1 + getMaxMoves(grid, newR, newC));
            }
        }
        return countMoves;
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 2, 4, 3, 5 },
                { 5, 4, 9, 3 },
                { 3, 4, 2, 11 },
                { 10, 9, 13, 15 }
        };

        System.out.println(maxMoves(grid));
    }
}
