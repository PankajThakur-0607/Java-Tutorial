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

    // TC -- > O(log N) && SC O(N)
    public static int searchRotatedArray(int arr[], int target, int si, int ei) {
        if (si > ei) {
            return -1;
        }
        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[si] <= arr[mid]) {

            if (target > arr[si] && target < arr[mid]) {
                return searchRotatedArray(arr, target, si, mid - 1);
            } else {
                return searchRotatedArray(arr, target, mid + 1, ei);
            }
        }

        if (target > arr[mid] && target < arr[ei]) {
            return searchRotatedArray(arr, target, mid + 1, ei);
        }
        return searchRotatedArray(arr, target, si, mid - 1);
    }

    public static void main(String[] args) {
        int n = 30204;
        countZeroes_V1(n);
        System.out.println(countZero);

        System.out.println(countZeroes_V2(n, 0));

        int arr[] = { 5, 6, 7, 8, 9, 1, 2, 3 };
        System.out.println("Fount at Index : " + searchRotatedArray(arr, 4, 0, arr.length - 1));
    }
}
