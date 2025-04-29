package MediumLevelProblems;

public class LC_1463_Cherry_PickUp_II {
    static int M;
    static int N;
    static int directions[][] = { { 1, -1 }, { 1, 0 }, { 1, 1 } };


    // O(9 ^ (M * N)) && O(M)
    public static int cherryPickup(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        return maxCherries(grid, 0, 0, N - 1);
    }

    private static int maxCherries(int[][] grid, int R, int C1, int C2) {

        if (R == M || C1 < 0 || C1 == N || C2 < 0 || C2 == N) {
            return 0;
        }

        int currCherries = grid[R][C1];
        if (C1 != C2)
            currCherries += grid[R][C2];

        int pickMaxCherries = 0;

        for (int dir[] : directions) {
            int newC1 = C1 +  dir[1];

            for (int dir2[] : directions) {
                int newC2 = C2 +  dir2[1];
                pickMaxCherries = Math.max(pickMaxCherries, maxCherries(grid, R + 1, newC1, newC2));
            }
        }

        return (pickMaxCherries + currCherries);
    }

    public static void main(String[] args) {
        // int[][] grid = {
        // { 3, 1, 1 },
        // { 2, 5, 1 },
        // { 1, 5, 5 },
        // { 2, 1, 1 }
        // };

        // int grid[][] = {
        //         { 3, 1 },
        //         { 4, 2 }
        // };

        int[][] grid = {
                { 1, 0, 0, 0, 0, 0, 1 },
                { 2, 0, 0, 0, 0, 3, 0 },
                { 2, 0, 9, 0, 0, 0, 0 },
                { 0, 3, 0, 5, 4, 0, 0 },
                { 1, 0, 2, 3, 0, 0, 6 }
        };

        System.out.println(cherryPickup(grid));
    }
}
