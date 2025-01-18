package Recursion;

import java.util.ArrayList;

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

    public static boolean linearSearch_V1(int arr[], int index, int target) {

        if (index == arr.length) {
            return false;
        }

        if (arr[index] == target) {
            return true;
        }

        return linearSearch_V1(arr, index + 1, target);
    }

    public static boolean linearSearch_V2(int arr[], int index, int target) {
        if (index < 0) {
            return false;
        }

        if (arr[index] == target) {
            return true;
        }

        return linearSearch_V2(arr, index - 1, target);
    }

    public static int linearSearch_V3(int arr[], int index, int target) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return linearSearch_V3(arr, index + 1, target);
    }

    public static ArrayList<Integer> linearSearch_V4_AllIndexes(int arr[], int index, int target,
            ArrayList<Integer> ans) {
        if (index == arr.length) {
            return ans;
        }

        if (arr[index] == target) {
            ans.add(index);
        }

        return linearSearch_V4_AllIndexes(arr, index + 1, target, ans);
    }


    // O(N) && O(N) + O(N)
    public static ArrayList<Integer> linearSearch_V5_AllIndexes(int arr[], int index, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = linearSearch_V5_AllIndexes(arr, index + 1, target);
        list.addAll(ansFromBelowCalls);

        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 3, 5, 7 };
        System.out.println("Array is Sorted : " + isSorted_V1(arr, 0, arr.length - 1));
        System.out.println("Array is Sorted : " + isSorted_V2(arr, 0));

        System.out.println("Array Found : " + linearSearch_V1(arr, 0, 9));
        System.out.println("Array Found : " + linearSearch_V2(arr, arr.length - 1, 9));
        System.out.println("Array Found : " + linearSearch_V3(arr, 0, 9));
        System.out.println("Array Found : " + linearSearch_V4_AllIndexes(arr, 0, 3, new ArrayList<>()));
        System.out.println("Array Found : " + linearSearch_V5_AllIndexes(arr, 0, 3));

    }
}
