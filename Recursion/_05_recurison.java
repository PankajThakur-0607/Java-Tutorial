package Recursion;

public class _05_recurison {

    public static void main(String[] args) {
        // int ans = fibo(4);
        // System.out.println(ans);
        // int arr[] = { 1, 2, 3, 4, 5 };
        // System.out.println(binarySearch(arr, 0, arr.length - 1, 4));

        // printNToOne(5);
        // print1ToN(5);

        // printBoth(5);

        // System.out.println(factorial(5));
        // int ans = sumOfN(6);
        // System.out.println(ans);

        // System.out.println(sumOfDigits(1345));

        // System.out.println(productOfSum(1342));

        // reverseNum_V1(1432);
        // System.out.println(sum);
        // System.out.println(reverseNum_V2(1234));

        System.out.println(isPalindrome(1231));
    }

    public static boolean isPalindrome(int n) {
        return n == reverseNum_V2(n);
    }


    static int sum = 0;
    public static void reverseNum_V1(int n) {

        if (n <= 0) {
            return;
        }

        int rem = n % 10;
        sum = sum * 10 + rem;
        reverseNum_V1(n / 10);

    }

    public static int reverseNum_V2(int n) {

        int digits = (int) (Math.log10(n)) + 1;
        System.out.println(digits);
        return helper(n, digits);
    }

    public static int helper(int n, int digits) {

        if (n % 10 == n) {
            return n;
        }

        return (n % 10) * (int) Math.pow(10, digits - 1) + helper(n / 10, digits - 1);
    }

    public static int productOfSum(int n) {
        // base case
        if (n % 10 == n) {
            return n;
        }
        // recursive case
        return n % 10 * productOfSum(n / 10);
    }

    // O(N) && O(N)
    public static int sumOfDigits(int n) {

        if (n <= 0) {
            return 0;
        }

        return n % 10 + sumOfDigits(n / 10);
    }

    public static int sumOfN(int n) {
        if (n == 1) {
            return 1;
        }

        return n + sumOfN(n - 1);
    }

    public static void printBoth(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printBoth(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void print1ToN(int n) {

        if (n == 0) {
            return;
        }

        print1ToN(n - 1);
        System.out.println(n);
    }

    public static int fibo(int n) {

        if (n < 2) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    public static int binarySearch(int arr[], int si, int ei, int target) {
        if (si > ei) {
            return -1;

        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] > target) {
            return binarySearch(arr, si, mid, target);
        }

        return binarySearch(arr, mid + 1, ei, target);
    }

    public static void printNToOne(int n) {

        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNToOne(n - 1);
    }
}
