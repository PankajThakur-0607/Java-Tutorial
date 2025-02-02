package EasyLevelProblems;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }

    public static boolean isPowerOfTwo_rec(int n) {
        if (n % 2 != 0) {
            return n == 1;
        }

        return isPowerOfTwo_rec(n / 2);
    }

    public static boolean isPowerOfTwo_Optimized(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        int n = 2248;

        System.out.println(isPowerOfTwo(n));
        System.out.println(isPowerOfTwo_rec(n));
        System.out.println(isPowerOfTwo_Optimized(n));

    }
}
