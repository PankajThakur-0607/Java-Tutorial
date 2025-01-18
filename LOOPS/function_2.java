package LOOPS;
import java.util.*;
public class function_2 {
    public static boolean isPrime(int n) {
        if(n ==2){
            return true;
        }
        for(int i =2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void primesInRange(int n ){
        for(int i =2 ; i<=n; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }
    public static void binToDec(int binNum) {
        int pow = 0;
        int decNum = 0;
        int myNum = binNum;
        while(binNum > 0){
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));
            pow ++;
            binNum = binNum/10;
        }
        System.out.println("decimal of " + myNum + "  is:  " + decNum);
    }

    public static void decToBin(int n){
        int pow = 0;
        int binNum = 0;
        int myNum = n;
        while(n > 0){
            int rem = n % 2 ;
            binNum = binNum + (rem * (int)Math.pow(10, pow));
            pow++;
            n = n/2;
        }
        System.out.println("binary of " + myNum + " is: " + binNum);
    }


    public static void sumOfDigits(int n){
        int myNum = n;
        int sum = 0;
        while(n > 0){
          int lastDigit = n % 10;
          sum = sum + lastDigit;
          n = n/10;
        }
        System.out.println("the sum of " + myNum + " is: " + sum);
    }

        public static boolean isEven(int n){
            if(n % 2 == 0){
                return true;
            }
            return false;
        }

        
        public static void main(String[] args) {
          // System.out.println(isPrime(16)); 
          
        //   // print of all prime numbers
        //    primesInRange(20);
           
        // // binary to decimal
        // binToDec(1010);

        // // decimal to binary
        // decToBin(15);

        // // sum of n integers
        // sumOfDigits(1234); 


        // // no is even or not
        //     Scanner sc = new Scanner(System.in);
        //     System.out.println("Enter the Number: ");
        //     int n = sc.nextInt();
        //     if(isEven(n)){
        //         System.out.println("Number is even");
        //     }
        //     else {
        //         System.out.println("Number is odd");
        //     }

        
        
        



        }
    
}
