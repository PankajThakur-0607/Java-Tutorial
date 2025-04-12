package MediumLevelProblems;
class Dice_Combination {
    final static int MOD = 1000000007;
    public static int diceCombination(int n) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= 6 && n - i >= 0; i++) {
            if (n - i >= 0) {
                count = (count + diceCombination(n - i)) % MOD;
            }
        }
        return count % MOD;
    }

    public static void main(String[] args) {

        int n = 7;
        System.out.println(diceCombination(n));

    }
}