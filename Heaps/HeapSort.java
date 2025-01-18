package Heaps;

import java.util.*;

// import ARRAYS.pairs;
// import EXAMS.forEachLoop;

public class HeapSort {
    
    public static void heapify(int arr[] , int i , int size){
        int left = 2 * i +1;
        int right = 2*i + 2;
        int maxIdx = i;

        if (left <  size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx] ) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }
   public static void heapSort(int arr[]){
     int n  = arr.length ;
     // step1 - build maxheap
     for(int i = n/2; i >=0 ; i--){
        heapify(arr, i , n);
     }

     // step 2 push largest elemnt at end
      for(int i = n-1 ; i>=0 ; i--){
        // swap (largest-first with last)
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        heapify(arr ,0 , i);

    
      }
   }

   static class Pair implements Comparable<Pair> {
        int val; 
        int idx;
         public Pair(int val , int idx){
            this.val = val;
            this.idx = idx;
         }

         @Override
         public int compareTo(Pair p2){
            return p2.val - this.val;
         }
  }

    
   
    public static void main(String[] args) {
        // int arr[] = {1,2,4,5,3};
        // heapSort(arr);
        // for(int i =0 ; i< arr.length ; i++ ){
        //     System.out.print(arr[i] + " ");
        // } 

        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int res[] = new int[arr.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
       // 1st Window
        for(int i = 0; i< k; i++){
            pq.add(new Pair(arr[i], i) );
        }

        res[0] = pq.peek().val;


        for(int i = k ; i < arr.length ; i++){
            while (!pq.isEmpty() &&  pq.peek().idx <= (i - k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i - k +1] = pq.peek().val;

        }


        // print result
        for(int i =0; i < res.length ; i++){
            System.out.print(res[i] + " ");
        }



    }
}
