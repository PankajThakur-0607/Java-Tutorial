package EasyLevelProblems;

public class SumOfDigitUsingRecursion {

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sum += lastDigit;
            n = n / 10;
        }

        return sum;
    }

    public static int sumOfDigits_rec(int n, int sum) {

        if (n <= 0) {
            return sum;
        }

        sum += n % 10;
        return sumOfDigits_rec(n / 10, sum);
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println(sumOfDigits(n));
        System.out.println(sumOfDigits_rec(n, 0));
    }
}
