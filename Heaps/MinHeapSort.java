package Heaps;

public class MinHeapSort {


    public static void heapify(int arr[] , int idx , int size){
        int leftChild = 2 * idx + 1;
        int rightChild = 2 * idx +2 ;
        int minIdx = idx ;

        while (leftChild < size && arr[leftChild] < arr[minIdx]) {
            minIdx = leftChild;
        }
        while (rightChild < size && arr[rightChild] < arr[minIdx]) {
            minIdx = rightChild;
        }

        if (minIdx != idx) {
            int temp = arr[idx];
            arr[idx] = arr[minIdx];
            arr[minIdx] = temp;
            heapify(arr, minIdx, size);
        }
    }
    public static void minHeap(int arr[]){

        int n = arr.length;
        // step 1 build min heap

        for(int i = n/2 ; i >= 0 ; i--){
            heapify(arr , i , n);
        }
        
        // step 2 - swap 1st and last 
        for(int i = n-1 ; i >=0 ; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr , 0 , i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};
        minHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
