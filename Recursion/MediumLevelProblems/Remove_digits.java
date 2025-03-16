public class Remove_digits {

    public static int removeDigits(int n) {

        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        int curr = n;
        int minSteps = Integer.MAX_VALUE;

        while (curr != 0) {
            int digits = curr % 10;
            curr /= 10;

            if (digits == 0) {
                continue;
            }

            int nextSteps = removeDigits(n - digits);
            if (nextSteps != Integer.MAX_VALUE) {
                minSteps = Math.min(minSteps, nextSteps + 1);
            }

        }

        return minSteps;

    }

    public static void main(String[] args) {
        int n = 27;

        System.out.println(removeDigits(n));
    }
}
