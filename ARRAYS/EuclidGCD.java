package ARRAYS;

public class EuclidGCD {
    

    // Using Recursion 
    // Time Complexity --> O(log(min(a , b)))   
    public static int gcd_V1(int a , int b) {
          if (b == 0) {
             return a ;
          } 

          return gcd_V1(b , a % b);
    }

    // Using Iteration
    // Time Complexity --> O(log(min(a , b)))
    public static int gcd_V2(int a , int b){
        if (a == 0) {
            return b ;
        }
        if (b == 0 ) {
            return a;
        }

        while (a != b) {
            if (a > b) {
                 a = a - b ;
            } else{
                b = b - a ;
            }
        }

        return a ;
    }

    public static void main(String[] args) {
        
        System.out.println(gcd_V1(24, 60));

        System.out.println(gcd_V2(24, 60));
    }
}
