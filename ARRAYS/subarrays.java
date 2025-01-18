package ARRAYS;
import java.util.*;


public class subarrays {
    public static void subArrays(int numbers[]){  //O(n^3)
      int ts = 0; 
      int  currSum = 0;
        for (int i = 0; i < numbers.length; i++) {
          int start = i;
          for (int j = i; j < numbers.length; j++) {
            int end = j;
            for (int k = start; k <= end; k++) {
               System.out.print(numbers[k] + " ");
              // currSum += numbers[k];

              
            }
            ts++;
            System.out.println();
          }
          System.out.println();
        }
        // System.out.println(currSum);
        System.out.println("total subarray is : " + ts);
    }

              // Brute force Approach

        public static void maxSubarraySum(int numbers[]){ // O(n^3)
           int currSum = 0;
           int maxSum = Integer.MIN_VALUE;
           for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
              currSum = 0;
              for(int k= i ; k <= j ; k++){
                currSum += numbers[k];
              }
              System.out.println(currSum);
              if (maxSum < currSum) {
                    maxSum = currSum;
              }
            }
           }
           System.out.println("max sum is: " + maxSum);
           
        }


        public static void prefixSum(int numbers[]){
          int currSum = 0;
          int maxSum = Integer.MIN_VALUE;
          int prefix[]  = new int[numbers.length];
           prefix[0] = numbers[0];
          // calculate prefix
          for (int i = 1; i < prefix.length; i++) {
              prefix[i] = prefix[i-1] + numbers[i];
          }

          for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
              int end = j;
                
              currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                if (maxSum < currSum) {
                    maxSum = currSum ;
                }
            }
          }
          
         System.out.println("Max sum is: " + maxSum);
      }

      public static void kadanes(int numbers[]) {  //O(n)
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        int maxSoFar = Integer.MIN_VALUE;
        
        for (int i = 0; i < numbers.length; i++) {
            cs = cs + numbers[i];
            if (cs < 0) {
              cs =0;
            }
            ms = Math.max(ms, cs);
           
          
        }
        System.out.println("Our max sum is: " + ms);
      }


    public static void main(String[] args) {
        int numbers[] = {-2,-1};
        
      // subArrays(numbers);
      // maxSubarraySum(numbers);
      prefixSum(numbers);
        //  kadanes(numbers);

    }
}
