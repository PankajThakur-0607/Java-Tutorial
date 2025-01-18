package divideandconquer;

public class practice {
    

    public static void printArr(String a[]){
        for(int i = 0; i < a.length ; i++){
            System.out.print( a[i] + " " + ","  );
        }
        System.out.println();
    }

    // question no 1

    public static String[] mergeSort(String arr[] , int si , int ei ){
        //base
        if(si == ei){
            String A [] = {arr[si]};
            return A;
        }
        // kaam
        int mid = si + (ei - si)/2 ;
        String arr1[] = mergeSort(arr, si, mid );
        String arr2[] = mergeSort(arr, mid +1, ei);

        String arr3[] = merge(arr1, arr2);
        return arr3;

        
    }

    public static String[] merge(String[] arr1 , String arr2[]) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0;
        int j = 0;
        int idx = 0 ;
        String arr3[] = new String[m + n];

    

    while(i < m && j <n){
        if(isAlphabetsSmall(arr1[i], arr2[j])){
            arr3[idx] = arr1[i];
            i++ ;
            idx ++ ;
        }
        else{
            arr3[idx] = arr2[j];
            j++ ;
            idx++;
        }
    }

    while( i < m){
        arr3[idx ++] = arr1[i ++];
    }
    while( j < n){
        arr3[idx ++] = arr2[j ++];
    }
    return arr3; 

}



    public static boolean isAlphabetsSmall(String str1 , String str2){
        if(str1.compareTo(str2) < 0){
            return true;
        }
        return false;
    }


    // question no 2

    // // Brute force Approach
    // public static int majorityElements(int arr[]){

    //     int maxterm = arr.length/2 ;
        
    //     for(int i = 0 ; i< arr.length-1 ; i++){
    //         int count = 0;
    //         for(int j = 0 ; j < arr.length ; j++){
    //             if(arr[j] == arr[i]){
    //                 count ++;
    //             }
    //         }
    //         if(count > maxterm){
    //             return arr[i];
    //         }
    //     }
    //     return -1 ;
    //     }




    public static int countInRange(int[] num , int n , int si , int ei){
        int count = 0;
        for(int i = si ; i < ei ; i++){
            if(num[i] == n){
                count++;
            }
        }
        return count;

    }
    public static int majorityElements(int arr[] , int si, int ei ){
        // base
        if(si == ei){
            return arr[ei];
        }

        // kaam
        int mid = si + (ei - si)/2 ;
        int left = majorityElements(arr, si, mid);
        int right = majorityElements(arr, mid +1, ei);

        // if two halves agree on the majority elements , return it.
        if(left == right){
            return left ;
        }

        // otherwise 
        int leftCount = countInRange(arr, left, si, ei);
        int rightCount = countInRange(arr, right, si, ei);

        return leftCount > rightCount ? left : right;
       


    }

    public static int getInvCount(int arr[]){
        int n = arr.length;
        int invCount = 0;   // TC O(n^2)
        for(int i = 0 ; i < n -1 ; i++){
            for(int j = 1 + 1 ; j < n ; j++){
                if(arr[i] > arr[j]){
                    invCount ++ ;
                }
            }
        }
        return invCount ;
    }
    


    // question no 3 

    public static int Count(int arr[] , int left , int right){
        int invCount = 0 ;

        if(right > left){
            int mid  = (right + left) / 2;
        

            invCount = Count(arr, left, mid );
            invCount += Count(arr, mid +1, right);
            invCount += mergecount(arr, left, mid +1, right);
        }
        
        return invCount ;
    }

    public static int mergecount(int arr[] , int left , int mid , int right){
        int invCount = 0;

        int i = left , j = mid + 1, k = 0;

        int temp[] = new int[right - left +1];

        while((i < mid) && (j <= right)){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++ ;
            }
            else
            {      
                temp[k] = arr[j];
                invCount += (mid -i);
                j++;
            }
            k++;
        }

        while(i < mid ){
            temp[k++] = arr[i++];
        }
        while(j <= right){
            temp[k++] = arr[j++];
        }

        for(i = left , k= 0 ; i <= right ; i++ , k++){
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static int getInversion(int arr[]){
        int n = arr.length;
        return Count(arr, 0, n -1);
    }




    public static int floorSqrt(int x){
        if(x== 0 || x== 1){
            return x;
        }
        int i = 1 , result = 1;

        while(result <= x){
            i++;
            result = i * i ;
        }
        return i - 1;
    }


    public static void main(String[] args) {
        String arr[] = { "sun " , "earth "   , "mercury" , "mars"};
        String a[] = mergeSort(arr, 0, arr.length -1);
        for(int i =0 ; i < a.length ; i++){
            System.out.println(a[i]);
        }

        // printArr(a);


      //  int arr[] = {2,2,1,1,2,1,2};
    //   int major =  majorityElements(arr);
    //         System.out.println(major);
        //   int major =  majorityElements(arr, 0, arr.length-1 );
        //     System.out.println(major);
        // int arr[] = {20,6,4,5,1};
        //     System.out.println(getInvCount(arr));

        // int arr [] = {20,6,4,5,1};
        // System.out.println("Inversion count = " +  getInversion(arr));

        // int x = 11;
        // System.out.println(floorSqrt(x));     


     }
}
