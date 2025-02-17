package MediumLevelProblems;

public class Steps_ToMinimizeCount {

    static int minCount;

    // O(3^N) && O(N)
    public static void helper(int N, int count) {
        if (N == 1) {
            minCount = Math.min(minCount, count);
            return;
        }

        if (N % 3 == 0) {
            helper(N / 3, count + 1);
        }

        if (N % 2 == 0) {
            helper(N / 2, count + 1);
        }

        helper(N - 1, count + 1);
    }

    public static int minSteps(int N) {
        if (N <= 1) {
            return 0;
        }
        helper(N, 0);
        return minCount;
    }

    public static void main(String[] args) {
        int N = 10;
        minCount = N;
        System.out.println(minSteps(N));

    }
}
