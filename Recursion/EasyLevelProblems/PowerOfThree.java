package EasyLevelProblems;


public class PowerOfThree {

    // O(log n) && O(1)
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public static boolean isPowerOfThree_rec(int n) {
        if (n <= 0) {
            return false;
        }

        if (n % 3 != 0) {
            return n == 1;
        }

        return isPowerOfThree_rec(n / 3);

    }

    public static boolean isPowerOfTwo_Optimized(int n) {

        return n > 0 && (1162261467 % n) == 0;
    }

    public static void main(String[] args) {

        int n = 81;
        System.out.println(isPowerOfThree(n));
        System.out.println(isPowerOfThree_rec(n));
        System.out.println(isPowerOfTwo_Optimized(n));
    }
}
