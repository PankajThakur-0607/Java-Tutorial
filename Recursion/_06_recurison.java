package Recursion;

public class _06_recurison {

    static int countZero = 0;

    public static void countZeroes_V1(int n) {

        if (n == 0) {
            return;
        }
        if (n % 10 == 0) {
            countZero++;
        }

        countZeroes_V1(n / 10);
    }

    public static int countZeroes_V2(int n, int count) {

        if (n == 0) {
            return count;
        }

        if (n % 10 == 0) {
            return countZeroes_V2(n / 10, count + 1);
        }

        return countZeroes_V2(n / 10, count);

    }

    public static void main(String[] args) {
        int n = 30204;
        countZeroes_V1(n);
        System.out.println(countZero);

        System.out.println(countZeroes_V2(n, 0));

    }
}
