package MediumLevelProblems;

public class LC_552_Student_Attendence_Record {
    static final int MOD = 1000000007;

    public static int checkRecord(int n) {
        return helper(n, 0, 0, 0);
    }

    private static int helper(int n, int A, int L, int P) {
        if (A == 2 || L >= 3) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        int absent = helper(n - 1, A + 1, 0, P) % MOD;
        int late = helper(n - 1, A, L + 1, P) % MOD;
        int present = helper(n - 1, A, 0, P + 1) % MOD;

        return ((absent + late) % MOD + present) % MOD;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(checkRecord(n));
    }
}
