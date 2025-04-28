package MediumLevelProblems;

public class LC_576_Out_Of_Boundary_Path {

    static int M;
    static int N;
    static int MOD = 1000000007;
    static int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        M = m;
        N = n;

        return getOutOfBoundPaths(startRow, startColumn, maxMove);
    }

    private static int getOutOfBoundPaths(int R, int C, int maxMove) {

        if (R == M || C == N || R < 0 || C < 0) {
            return (maxMove >= 0) ? 1 : 0;
        }

        if (maxMove < 0) {
            return 0;
        }

        int countPath = 0;

        for (int dir[] : directions) {
            int newR = R + dir[0];
            int newC = C + dir[1];
            countPath = (countPath + getOutOfBoundPaths(newR, newC, maxMove - 1)) % MOD;
        }

        return countPath;
    }

    public static void main(String[] args) {
        int m = 1;
        int n = 3;
        System.out.println(findPaths(m, n, 3, 0, 1));
    }
}
