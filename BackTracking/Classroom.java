package BackTracking;

import ARRAYS.reverseArray;

public class Classroom {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArr(int arr[], int i, int val) {
        // base case TC ---> O(n) SC ---> O(n)
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        // recursion / kaam
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2; // backtracking

    }

    public static void findSubsets(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // Yes Choice
        findSubsets(str, ans + str.charAt(i), i + 1);
        // No Choice
        findSubsets(str, ans, i + 1);
    }

    public static void findPermutation(String str, String ans) {
        // base case 
            if ( str.length() == 0) {
                System.out.println(ans);
                return;
            }
        // recursion
        for (int i = 0; i < str.length(); i++) {
                char curr = str.charAt(i);
        // abcde --> ab + de = abde   c is removed 
            String newStr = str.substring(0,i) + str.substring(i+1);
            findPermutation(newStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);
        String str = "abc";
        findPermutation(str, "");

    }
}
