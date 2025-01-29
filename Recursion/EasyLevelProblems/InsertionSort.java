package EasyLevelProblems;

import java.util.Arrays;

public class InsertionSort {

    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;

            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            prev = prev + 1;
            arr[prev] = prev + 1;
        }
    }

    public static void insertionSort_V2(int arr[], int n) {
        if (n <= 1) {
            return;
        }

        insertionSort_V2(arr, n - 1);
        int lastElement = arr[n - 1];
        int prevIdx = n - 2;

        while (prevIdx != -1 && arr[prevIdx] > lastElement) {
            arr[prevIdx + 1] = arr[prevIdx];
            prevIdx--;
        }
        arr[prevIdx + 1] = lastElement;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 1, 3, 4 };
        System.out.println(Arrays.toString(arr));
        // insertSort(arr);
        insertionSort_V2(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }
}