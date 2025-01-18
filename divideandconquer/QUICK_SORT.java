package divideandconquer;

public class QUICK_SORT{


    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[] , int si , int ei){
        if (si >= ei) {
            return;
        }
       
        int pivotidx  = partition(arr, si, ei)  ;

        quickSort(arr, si, pivotidx - 1);
        quickSort(arr, pivotidx+1, ei);
    }


    public static int partition(int arr[] , int si , int ei){
        int pivot = arr[ei];
        int i = si -1 ;

        for (int j = si; j < ei; j++) {

                if (arr[j] <= pivot) {
                    i++ ;

                    // swop
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
                i++ ;
                // swop
                    int temp = pivot;
                    arr[ei] = arr[i];
                    arr[i] = temp;

      return i;

    }

    
   
    public static void main(String[] args) {

        int arr[] = {6,3,9,8,2,5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
        
    }
    
}
