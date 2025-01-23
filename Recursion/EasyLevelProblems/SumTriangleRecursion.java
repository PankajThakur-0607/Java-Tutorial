package EasyLevelProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class SumTriangleRecursion {

    static ArrayList<ArrayList<Integer>> allTriangleSum = new ArrayList<>();
    static int R, C;

    public static void getTriangle(int arr[], int i) {

        if (i >= R - 1) {
            return;
        }

        ArrayList<Integer> curr = new ArrayList<>();
        calculateSum(arr, 0, C - i - 1, curr);
        allTriangleSum.add(curr);
        getTriangle(arr, i + 1);

    }

    public static void calculateSum(int arr[], int start, int end, ArrayList<Integer> curr) {

        if (start >= end) {
            return;
        }

        arr[start] = arr[start] + arr[start + 1];
        curr.add(arr[start]);
        calculateSum(arr, start + 1, end, curr);

    }
// -----------------------------------------------------------------------------------------------------------
    static ArrayList<ArrayList<Integer>> storeAllSum = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static int n;

    public static void fillLastRowRecursively(int nums[], int start) {
        if (start < n) {
            storeAllSum.get(n - 1).add(nums[start]);
            fillLastRowRecursively(nums, start + 1);
        }

    }

    public static void fillRowsRecursively(int nums[], int start, int end) {

        if (start < end + 1) {
            nums[start] = nums[start] + nums[start + 1];
            storeAllSum.get(end).add(nums[start]);
            fillRowsRecursively(nums, start + 1, end);
        }
    }

    public static void initialiseAndFillLastRow(int nums[]) {
        for (int i = 0; i < n; i++) {
            storeAllSum.add(new ArrayList<>());
        }

        fillLastRowRecursively(nums, 0);

    }

    public static void callFillRows(int arr[], int start, int end) {
        if (start <= end) {
            return;
        }

        fillRowsRecursively(arr, 0, start);
        callFillRows(arr, start - 1, end);

    }

    public static ArrayList<Integer> getTraingleReverse_V2(int nums[]) {
        callFillRows(nums, n - 2, 0);
        for (ArrayList<Integer> list : storeAllSum) {
            ans.addAll(list);
        }

        return ans;

    }

// ---------------------------------------------------------------------------------------------------------------------
     public static void helper(int nums[], int temp[] , int start , int end) {
       
        if(start >= end - 1) {
            return;
        }
        
        temp[start] = nums[start] + nums[start + 1];
        helper(nums, temp, start + 1, end);
    }

    public static void sumTriangle(int nums[]) {

        if (nums.length < 1) {
            return;
        }
        int temp[] = new int[nums.length - 1];
        helper(nums, temp , 0 , nums.length);
        sumTriangle(temp);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4 };
        // R = arr.length;
        // C = arr.length;
        // List<Integer> curr = new ArrayList<>();
        // for (int i : arr) {
        // curr.add(i);
        // }
        // allTriangleSum.add(new ArrayList<>(curr));
        // getTriangle(arr, 0);
        // System.out.println(allTriangleSum);

        int nums[] = { 1, 2, 3, 4 };
        n = nums.length;
        initialiseAndFillLastRow(nums);

        System.out.println(getTraingleReverse_V2(nums));

    }
}
