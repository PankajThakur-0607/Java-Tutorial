package EasyLevelProblems;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minPosValueIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minPosValueIdx] > arr[j]) {
                    minPosValueIdx = j;
                }
            }

            int temp = arr[minPosValueIdx];
            arr[minPosValueIdx] = arr[i];
            arr[i] = temp;

        }
    }

    public class RecursiveSelectionSort {

        private static void selectionSort_rec_V1(int arr[], int row, int col, int maxIdx) {

            if (row == 0) {
                return;
            }

            if (col < row) {
                if (arr[maxIdx] < arr[col]) {
                    maxIdx = col;
                }
                selectionSort_rec_V1(arr, row, col + 1, maxIdx);
            } else {
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[row - 1];
                arr[row - 1] = temp;
                selectionSort_rec_V1(arr, row - 1, 0, 0);
            }
        }

        private static int getMinIndex(int arr[], int start, int minPos) {

            if (start >= arr.length) {
                return minPos;
            }
            if (arr[minPos] > arr[start]) {
                minPos = start;
            }
            return getMinIndex(arr, start + 1, minPos);

        }

        private static void selectionSort_rec_V2(int arr[], int n, int index) {
            if (index >= n - 1) {
                return;
            }
            int minPosValueIdx = getMinIndex(arr, index, index);
            int temp = arr[minPosValueIdx];
            arr[minPosValueIdx] = arr[index];
            arr[index] = temp;

            selectionSort_rec_V2(arr, n, index + 1);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(arr));
        // selectionSort(arr);

        RecursiveSelectionSort.selectionSort_rec_V1(arr, arr.length, 0, 0);
        RecursiveSelectionSort.selectionSort_rec_V2(arr, arr.length, 0);
        System.out.println(Arrays.toString(arr));

    }
}
