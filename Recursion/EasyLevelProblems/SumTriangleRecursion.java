package EasyLevelProblems;

import java.util.ArrayList;
import java.util.List;

public class SumTriangleRecursion {

    static ArrayList<ArrayList<Integer>> allTriangleSum = new ArrayList<>();
    static int R, C;

    public static void getTriangle(int arr[], int i) {

        // for (int i = 0; i < R - 1; i++) {
        // ArrayList<Integer> curr = new ArrayList<>();
        // calculateSum(arr, 0, C - i - 1, curr);
        // allTriangleSum.add(curr);
        // }

        // while (i < R - 1) {
        // ArrayList<Integer> curr = new ArrayList<>();
        // calculateSum(arr, 0, C - i - 1, curr);
        // allTriangleSum.add(curr);
        // i++;
        // }

        if (i >= R - 1) {
            return;
        }

        ArrayList<Integer> curr = new ArrayList<>();
        calculateSum(arr, 0, C - i - 1, curr);
        allTriangleSum.add(curr);
        getTriangle(arr, i + 1);

    }

    public static void calculateSum(int arr[], int start, int end, ArrayList<Integer> curr) {

        // for (int j = start; j < end; j++) {
        //     arr[j] = arr[j] + arr[j + 1];
        //     curr.add(arr[j]);
        // }

        // while (start < end) {
        //     arr[start] = arr[start] + arr[start + 1];
        //     curr.add(arr[start]);
        //     // calculateSum(arr, start + 1, end, curr);
        //     start++;
        // }
        
        if (start >= end) {
            return ;
        }
        
        arr[start] = arr[start] + arr[start + 1];
        curr.add(arr[start]);
        calculateSum(arr, start + 1, end, curr);


    }


    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        R = arr.length;
        C = arr.length;
        List<Integer> curr = new ArrayList<>();
        for (int i : arr) {
            curr.add(i);
        }
        allTriangleSum.add(new ArrayList<>(curr));
        getTriangle(arr, 0);
        System.out.println(allTriangleSum);

    }
}
