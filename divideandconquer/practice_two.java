package divideandconquer;

import ARRAYS.reverseArray;

public class practice_two {

  public static String[] mergeString(String str[], int si, int ei) {

    if (si == ei) {
      String[] A = { str[si] };
      return A;
    }
    int mid = si + (ei - si) / 2;
    String str1[] = mergeString(str, si, mid);
    String str2[] = mergeString(str, mid + 1, ei);

    String str3[] = mergeStr(str1, str2);

    return str3;
  }

  public static String[] mergeStr(String str1[], String str2[]) {

    int m = str1.length;
    int n = str2.length;
    int i = 0;
    int j = 0;
    int idx = 0;
    String str3[] = new String[m + n];

    while (i < m && j < n) {
      if (isAlphabetically(str1[i], str2[j])) {
        str3[idx] = str1[i];
        i++;
        idx++;

      } else {
        str3[idx] = str2[j];
        j++;
        idx++;
      }
    }

    while (i < m) {
      str3[idx++] = str1[i++];
    }

    while (j < n) {
      str3[idx++] = str2[j++];
    }

    return str3;
  }

  public static boolean isAlphabetically(String str1, String str2) {
    if (str1.compareTo(str2) < 0) {
      return true;
    }
    return false;
  }
    // brute force approach
  // public static int countMajorityElement(int arr[]) {
  //     int majorityCount = arr.length/2;
  //   for (int i = 0; i < arr.length; i++) {
  //     int count = 0;
  //     for (int j = 0; j < arr.length; j++) {
  //       if (arr[i] == arr[j]) {
  //         count += 1;
  //       }
  //     }
  //      if (count > majorityCount) {
  //     return arr[i];
  //   }
  //   }
  //   return -1;
   
  // }



  // using Divide and conquer
  public static int majorityElementRec(int[] nums, int lo, int hi) {
    // base case: the only element in an array of size 1 is the majority element
    if (lo == hi) {
        return nums[lo];
    }

    // recurse on left and right halves of this slice
    int mid = (hi - lo) / 2 + lo;
    int left = majorityElementRec(nums, lo, mid);
    int right = majorityElementRec(nums, mid + 1, hi);

    // if the two halves agree on the majority element, return it
    if (left == right) {
        return left;
    }

    // otherwise, count each element and return the "winner"
    int leftCount = countInRange(nums, left, lo, hi);
    int rightCount = countInRange(nums, right, lo, hi);

    return leftCount > rightCount ? left : right;
}

// public static int majorityElement(int[] nums) {
//     return majorityElementRec(nums, 0, nums.length - 1);
// }

public static int countInRange(int[] nums, int num, int lo, int hi) {
  int count = 0;
  for (int i = lo; i <= hi; i++) {
      if (nums[i] == num) {
          count++;
      }
  }
  return count;
}



// public static int invCount(int n []){ // brute Force  TC --> O(n^2)
//     int inverseCount = 0;
//     for (int i = 0; i < n.length; i++) {
//       for (int j = i + 1; j < n.length; j++) {
//         if (n[i] > n[j]) {
//           inverseCount ++ ;
//         }
//       }
//     }
//     return inverseCount;
// }

public static int mergeInvCount (int[] n , int left, int right){
    int invCount =0;

    if (right > left) {
      int mid = left + (right - left)/2;
      invCount = mergeInvCount(n, left, mid);
      invCount += mergeInvCount(n, mid +1, right);
      invCount += mergeasortInvCount(n, left, mid+1, right);
    }
    return invCount;
}

public static int mergeasortInvCount(int n[] , int left, int mid , int right){
  int invCount = 0;
   int i = left; 
   int j = mid ; 
   int k = 0;
  //  System.out.print(left + " ");
   
  //  System.out.print(right + " ");
   System.out.print(mid + " ");
   int temp[] = new int[right - left + 1];

   while (i < mid && j <= right ) {
      if (n[i] <= n[j]) {
         temp[k++] = n[i++];
      } else{
        temp[k++] = n[j++];
          invCount += (mid-i);
      }
   }


   while (i < mid) {
    temp[k++] = n[i++];
    }

    while (j <= right) {
      temp[k++] = n[j++];
    }

    for ( i = left, k = 0; i <= right ; i++,k++) {
      n[i] = temp[k];
    }

    return invCount;
}


  public static void main(String[] args) {

    // String str[] = { "sun", "earth", "mars", "mercury" };
    // String a[] = mergeString(str, 0, str.length - 1);
    // for (int i = 0; i < a.length; i++) {
    // System.out.println(a[i]);
    // }

    // int nums[] = {2,2,1,1,1,2,2};
    // System.out.println(majorityElementRec(nums, 0, nums.length-1));

    int n[] = {2,4,8,1,3,5};
    //  System.out.println(invCount(n));
 System.out.println(mergeInvCount(n, 0, n.length-1));





  }
}
