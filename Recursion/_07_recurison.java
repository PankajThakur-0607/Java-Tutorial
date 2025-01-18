package Recursion;

public class _07_recurison {

    public static boolean isSorted_V1(int arr[], int start, int end) {

        if (arr[start] > arr[start + 1]) {
            return false;
        }

        if (start == end - 1) {
            return true;
        }

        return isSorted_V1(arr, start + 1, end);
    }

    public static boolean isSorted_V2(int arr[], int index) {
        if (index == arr.length - 1) {
            return true;
        }

        return arr[index] < arr[index + 1] && isSorted_V2(arr, index + 1);
    }

    public static boolean linearSearch(int arr[], int index, int target) {

        if (index == arr.length) {
            return false;
        }

        if (arr[index] == target) {
            return true;
        }

        return linearSearch(arr, index + 1, target);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 8, 9 };
        System.out.println("Array is Sorted : " + isSorted_V1(arr, 0, arr.length - 1));
        System.out.println("Array is Sorted : " + isSorted_V2(arr, 0));

        System.out.println("Array Found : " + linearSearch(arr, 0, 9));
        
    }
}
