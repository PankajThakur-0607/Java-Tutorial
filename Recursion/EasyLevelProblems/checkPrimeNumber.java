package EasyLevelProblems;

public class checkPrimeNumber {

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime_rec(int n, int idx) {
        if (idx > (int) Math.sqrt(n)) {
            return true;
        }

        if (n % idx == 0) {
            return false;
        }

        return isPrime_rec(n, idx + 1);
    }

    public static void main(String[] args) {
        int n = 73;
        System.out.println(isPrime(n));
        System.out.println(isPrime_rec(n, 2));
    }
}
