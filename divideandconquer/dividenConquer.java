package divideandconquer;

public class dividenConquer {
    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

        public static void mergeSort(int arr[] , int si , int ei){
            // base case 
            if (si >= ei) {
                return;
            }
          // kaam
          
          int mid = si + (ei - si)/2 ;
          // left part
          mergeSort(arr, si, mid);
          // right part
          mergeSort(arr, mid +1, ei);

          // merge both part
          merge(arr, si, mid, ei);
        }
        public static void merge(int arr[] , int si , int mid , int ei){
            // left (0,3) = 4 idx , right (4,6) = 3 idx  --> total = 7 idx so we have to take + 1 in temo[] arr;
            int temp[] = new int [ei - si +1];
            int i = si ; // iterator for left part 
            int j = mid+1 ; // iterator for right part
            int k = 0 ;  // iterator for temp[] array

            while (i <= mid && j <= ei) {
                    // left part 
                if (arr[i] < arr[j]) {
                    temp[k] = arr[i];
                    i++ ;
                    
                } else {
                   temp[k] = arr[j];
                    j++;
                    
                }
                k++;
            }
            
                // leftover part of left array
                while (i <= mid) {
                    temp[k] = arr[i];
                    i++ ; k++;
                }
                 // leftover part of right array
                while (j <= ei) {
                   temp[k] = arr[j];
                    k++ ; j++ ;
                }

                // copy temp to original arr 
                for ( k = 0 , i = si; k < temp.length; k++ , i++) {
                    arr[i] = temp [k];
                }
            



        }









        

    public static void main(String[] args) {
       int arr[] = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);

    }
}
