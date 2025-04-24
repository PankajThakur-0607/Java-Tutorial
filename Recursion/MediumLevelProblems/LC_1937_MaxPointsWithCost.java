package MediumLevelProblems;

public class LC_1937_MaxPointsWithCost {
    static int M;
    static int N;

    public static long maxPoints(int[][] points) {
        M = points.length;
        N = points[0].length;
        return helper(points, 0, -1);
    }

    private static long helper(int[][] points, int R, int prevCol) {

        if (R == M) {
            return 0;
        }

        long maxPoints = 0;
        for (int C = 0; C < N; C++) {
            int absCellDiff = (prevCol != -1) ? Math.abs(prevCol - C) : 0;
            long currPoints = (points[R][C] - absCellDiff) + helper(points, R + 1, C);
            maxPoints = Math.max(currPoints, maxPoints);
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        // int points[][] = {
        //         { 1, 2, 3 },
        //         { 1, 5, 1 },
        //         { 3, 1, 1 }
        // };

        int points[][] = {
                { 1, 5 },
                { 2, 3 },
                { 4, 2 }
        };

        System.out.println(maxPoints(points));
    }
}
