
public class RotateArray {
  
     // Rotate 1 by 1
    // Solution 1
    // Time Complexity - O(n * d)
    // Space Complexity --> O(1)
    public static void rotateLeft(int arr[] , int d){
        int n = arr.length;
        int p = 0;
        while (p < d) {
            int temp = arr[0];
            for(int i = 0 ; i<n-1 ; i++){
                arr[i] = arr[i +1];
            }
            arr[n-1] = temp;
            p++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    // Time Complexity - O(n * d)
    // Space Complexity --> O(1)
    public static void rotateRight(int arr[] , int d){
        int n = arr.length; 
        int p = 0;
        while (p < d) {
            int temp = arr[n-1];
            for(int i = n-1 ; i >= 1 ; i--){
                arr[i] = arr[i - 1];
            }

            arr[0] = temp;
            p++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    // Using Temprorary Array
    // Solution 2
    // Time Complexity --> O(n)
    // Space Complexity --> O(n)
    public static void rotateUsingTempArr_V1(int arr[] , int d){
        int temp[] = new int[arr.length];

        int j = 0;
        for(int i = 0 ; i < (temp.length - d) ; i++){
            temp[i] = arr[i + d];
            j++;
        }

        for(int i = 0 ; i < d ; i++){
            temp[j] = arr[i];
            j++;
        }


        for (int i = 0; i < temp.length; i++) {
                System.out.print(temp[i] + " ");
        }
        System.out.println();

    }

    // Solution 2
    // Time Complexity --> O(n)
    // Space Complexity --> O(n)
    public static void rotateUsingTempArr_V2(int arr[] , int d){

        int j = 0; 
        int temp[] = new int[arr.length];

        for(int i = d ; i < temp.length ; i++){
            temp[j] = arr[i];
            j++;
        }
        for (int i = 0; i < d; i++) {
                temp[j] = arr[i];
                j++;
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }


    // Juggling Algorithm 
    // Time Complexity --> O(N)
    // Space Complexity --> O(1)

    public static void juggling_Algo_left(int arr[] , int n , int d ){
          d = d % n ;
        int gcd_V1 = gcd(n, d);
        int  currPos , k , temp ;

        for(int i = 0; i< gcd_V1 ; i++){
            currPos = i ;
            temp = arr[i];
            while (true) {
                k = currPos + d;   // current Positon of i + d ( sort by Number);
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break ;
                }
                arr[currPos] = arr[k];   // Copy the Shifted Elent to its Appropriate Index
                currPos  = k ;   // Update the positon to k number 
            }
          arr[currPos] = temp;
        }


        for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
        }
        System.out.println();

    }


    // Juggling Algorithm 
    // Time Complexity --> O(N)
    // Space Complexity --> O(1)
    public static void juggling_Algo_right(int arr[] , int n , int d){

        d = d % n ;
        int GCD = gcd(n, d);

        int currPos , nextPos , temp;

        for(int i = 0 ; i < GCD ; i++){
            temp = arr[n - i - 1];
            currPos = n - i - 1;

            while (true) {
                 
                nextPos = currPos - d ;
                if (nextPos < 0) {
                    nextPos += n ;
                }
                if (nextPos == n - i - 1) {
                    break;
                }

                arr[currPos] = arr[nextPos];
                currPos = nextPos ;

            }

            arr[currPos] = temp;
        }

    }

    public static int gcd(int n , int d){
        if (d == 0) {
            return n ;
        }

        return gcd(d, n % d);

    }

    public static void reverse(int arr[] , int i ,int j){
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }


    // Soluiton 4
    // Time Complexity --> O(N)
    // Space Complexity --> O(1)
    public static void reverseAlgo_right(int arr[] , int d , int n){
        
        int mod = d % n ;
        if (mod == 0 || d == n) {
             return;
        }

        reverse(arr , n - mod , n-1);
        reverse(arr , 0 , n - mod -1);
        reverse(arr , 0 , n-1);


        
    }


     // Soluiton 4
    // Time Complexity --> O(N)
    // Space Complexity --> O(1)
    public static void reverseAlgo_left(int arr[], int d, int n)
    {
        
        int mod = d % n ;
        if(mod == 0 || n == d){
            return;
        }
        reverse(arr , 0 , mod-1);
        reverse(arr , mod , n -1);
        reverse(arr , 0 , n -1);
    }


  
    
public static void main(String[] args) {
    
    int arr[] = {1,2,3,4,5,6,7};
    int d = 3 ;
    int n = arr.length;


    // Solution 1
    // rotateLeft(arr, d);
    //  rotateRight(arr, d);


    // Solution 2 
    // rotateUsingTempArr_V1(arr, d);
    // rotateUsingTempArr_V2(arr , d);


     // Solution 3 
    // juggling_Algo_left(arr, n, d);
       juggling_Algo_right(arr, n, d);



    // Solution 4
    //   reverseAlgo_left(arr, d , n);
    //  reverseAlgo_right(arr, d, n);


    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
   }


}

    

}
