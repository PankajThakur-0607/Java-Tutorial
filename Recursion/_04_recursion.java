import java.util.Arrays;

public class _04_recursion {

    public static void printTriangleReverse(int r, int c) {
        if (r == 0) {
            return;
        }

        if (c < r) {
            System.out.print("*" + " ");
            printTriangleReverse(r, c + 1);
        } else {
            System.out.println();
            printTriangleReverse(r - 1, 0);
        }
    }

    public static void printTriangle_V1(int r, int c, int n) {
        if (c == n) {
            return;
        }

        if (c < r) {
            System.out.print("*" + " ");
            printTriangle_V1(r, c + 1, n);
        } else {
            System.out.println();
            printTriangle_V1(r + 1, 0, n);
        }
    }

    public static void printTriangle_V2(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            printTriangle_V2(row, col + 1);
            System.out.print("*" + " ");
        } else {
            printTriangle_V2(row - 1, 0);
            System.out.println();
        }
    }

    public static void bubbleSort(int arr[], int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {

            if (arr[col] > arr[col + 1]) {

                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort(arr, row, col + 1);
        } else {
            bubbleSort(arr, row - 1, 0);
        }
    }

    public static void selectionSort(int arr[], int row, int col, int maxIdx) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            if (arr[col] > arr[maxIdx]) {
                maxIdx = col;
            }
            selectionSort(arr, row, col + 1, maxIdx);
        } else {
            int temp = arr[row - 1];
            arr[row - 1] = arr[maxIdx];
            arr[maxIdx] = temp;
            selectionSort(arr, row - 1, 0, 0);
        }
    }

    public static void main(String[] args) {

        // printTriangleReverse(5, 0);
        // printTriangle_V1(1, 0, 4);
        // printTriangle_V2(4, 0);
        // System.out.println();

        int arr[] = { 4, 3, 2, 1 };
        System.out.println(Arrays.toString(arr));
        // bubbleSort(arr, arr.length - 1, 0);
        selectionSort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));

    }

}
