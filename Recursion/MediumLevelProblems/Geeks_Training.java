package MediumLevelProblems;

public class Geeks_Training {

    static int N;

    public static int solve(int arr[][], int R, int skipColumn) {
        if (R == N)
            return 0;

        int maxPoints = 0;
        for (int C = 0; C < 3; C++) {
            if (C != skipColumn) {
                int currPoints = arr[R][C] + solve(arr, R + 1, C);
                maxPoints = Math.max(currPoints, maxPoints);
            }
        }

        return maxPoints;
    }

    // O(2 ^ N) && O(N)
    public static int maximumPoints(int arr[][]) {
        N = arr.length;
        return solve(arr, 0, -1);
    } 
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 5 },
                { 3, 1, 1 },
                { 3, 3, 3 }
        };

        System.out.println(maximumPoints(arr));
    }
}
