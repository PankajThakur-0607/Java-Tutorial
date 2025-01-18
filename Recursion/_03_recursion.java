package Recursion;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _03_recursion {
    
    static ArrayList<ArrayList<Integer>> twoDArrayList = new ArrayList<>();

    public static void generateAllSubSequences(int arr[], int n, ArrayList<Integer> ans, int idx) {
        if (idx == n) {
            // Create a new ArrayList based on 'ans' and add it to 'twoDArrayList'
            twoDArrayList.add(new ArrayList<>(ans));
            return;
        }
        
        // Include the current element
        ans.add(arr[idx]);
        generateAllSubSequences(arr, n, ans, idx + 1);
        // Backtrack: remove the last element
        ans.remove(ans.size() - 1);

        // Exclude the current element
        generateAllSubSequences(arr, n, ans, idx + 1);
    }










    
        
    public static void generateAllSubSequencesUpToK(int arr[], int n, ArrayList<Integer> ans, int idx , AtomicInteger X) {
        if (X.get() <= 0) {
            return;
        }
        
        if (idx == n) {
            if(X.get() > 0) {
                // Create a new ArrayList based on 'ans' and add it to 'twoDArrayList'
                twoDArrayList.add(new ArrayList<>(ans));
                X.decrementAndGet();
            }
            return;
        }
        
        // Include the current element
        ans.add(arr[idx]);
        generateAllSubSequencesUpToK(arr, n, ans, idx + 1 , X);
        // Backtrack: remove the last element
        ans.remove(ans.size() - 1);

        // Exclude the current element
        generateAllSubSequencesUpToK(arr, n, ans, idx + 1 , X);
    }








    static ArrayList<ArrayList<Integer>> kSumSubSequence = new ArrayList<>();

    public static void printSubSequenceToK(int arr[] ,int n , int idx , ArrayList<Integer> ans, int sum , int k){

        
        if (idx == n) {
            // Base condition: when index reaches the length of the array
            if (sum == k) {
                kSumSubSequence.add(new ArrayList<>(ans));
            }
             // Return to avoid further processing
            return;
        }
        // Include the current element
        ans.add(arr[idx]);
        sum += arr[idx];
        printSubSequenceToK(arr, n, idx+1, ans, sum, k);
        // Exclude the current element
        ans.remove(ans.size() - 1);
        sum -= arr[idx];

        printSubSequenceToK(arr, n, idx+1, ans, sum, k);
    }











    public static void main(String[] args) { 
        ArrayList<Integer> ans = new ArrayList<>();
        int arr[] = {1,2,1};
        int n = arr.length;
        AtomicInteger X = new AtomicInteger(3);
        // // Start the recursion with index 0
        generateAllSubSequencesUpToK(arr, n, ans, 0, X);

        // Print the 2D ArrayList
        for (ArrayList<Integer> row : twoDArrayList) {
            for (Integer elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        //     printSubSequenceToK(arr, arr.length, 0, ans, 0, 2);
        // for (ArrayList<Integer> row : kSumSubSequence) {
        //     for (Integer elem : row) {
        //         System.out.print(elem + " ");
        //     }
        //     System.out.println();
        // }
    }
}
  