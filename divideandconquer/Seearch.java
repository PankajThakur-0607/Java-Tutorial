package divideandconquer;

import javax.print.attribute.standard.RequestingUserName;

public class Seearch {
    
    public static int search(int arr[] , int tar , int si , int ei ){

        // base case 
        if (si > ei) {
            return -1 ;
        }
        // kaam

        int mid = si + (ei - si)/2 ;
        // case Found 
        if (arr[mid] == tar) {
            return mid;
        }

        // mid on l1
        if (arr[si] <= arr[mid]) {
             // case a: left
             if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid-1);
             } else{
                //case b : right
                return search(arr, tar, mid+1, ei);
             }
        } 
        // mid on L2
        else {
            // case a: right
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid+1, ei);
            } else{
                return search(arr, tar, si, mid-1);
            }
        }


       

    }

    public static int SortedRotatedArray(int arr[] , int tar){
        int left = 0 ;
          int  right = arr.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;


            if (arr[mid] == tar) {
                return mid ;
            }

            if (arr[left] <= arr[mid]) {
                
                if (arr[left] <= tar && tar <= arr[mid]) {
                    right = mid-1 ;
                } else{
                    left = mid +1 ;
                }
            } else{
                if (arr[mid] <= tar && tar <= arr[right]) {
                    left = mid +1 ;

                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;
    //   System.out.println("target is at index : " + search(arr, target, 0, arr.length-1));
       
        System.out.println(SortedRotatedArray(arr, target ));

        
    }
}
