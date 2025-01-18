package Greedy_Alogorithm;

import java.util.*;

public class minDIff_Sum {
    
    public static int  minDiffSum(int A[] , int B[] ) {

        Arrays.sort(A);
        Arrays.sort(B);
        int minSum = 0;
        for(int i = 0 ; i < A.length ; i++){
            minSum += Math.abs(A[i] - B[i]);
        }

        return minSum;

    }

    public static void main(String[] args) {
        int A[] = {7,9,1,5};
        int B[] = {3,4,7,8};

        System.out.print(minDiffSum(A, B));
    }   
}



