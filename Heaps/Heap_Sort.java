package Heaps;

public class Heap_Sort {
    
    public static void heapify(int idx , int size , int arr[]){
        int maxIdx = idx ;
        int leftChild = 2 * idx + 1;
        int rightChild = 2 * idx + 2;

        if(leftChild < size && arr[leftChild] > arr[maxIdx]){
            maxIdx = leftChild;
        }
        if(rightChild < size && arr[rightChild] > arr[maxIdx]){
            maxIdx = rightChild;
        }

        if (maxIdx != idx) {
            int temp = arr[idx];
            arr[idx] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(maxIdx, size, arr);
        }
    }
    public static void heapSort(int arr[]){

        //Step - 1  Build Max Heap
        int n = arr.length;
        for(int i = n / 2 ; i >=0 ; i-- ){
            heapify(i , n , arr);
        }


        // Step - 2 push largest at end ;
        for(int i = n - 1 ; i >= 0 ; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(0 , i , arr);
        }


    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,3};
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
