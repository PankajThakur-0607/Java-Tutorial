package EasyLevelProblems;

import java.util.Arrays;

public class BubbleSortRec {

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort_Rec(int arr[], int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort_Rec(arr, row, col + 1);
        } else {
            bubbleSort_Rec(arr, row - 1, 0);
        }
    }
    
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(arr));
        // bubbleSort(arr);
        bubbleSort_Rec(arr, arr.length - 1, 0);

        System.out.println(Arrays.toString(arr));

    }
}
