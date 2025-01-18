package LOOPS;

import java.util.*;



public class functions {
    public static int calculateSum(int a , int b) {// formal parameters
        int sum = a + b;
        return sum;
    }
    public static void swap(int a , int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);   
        System.out.println("b = "+ b);
    }
    public static int factorial(int n) {
        int f =1;
        for(int i =1 ; i<=n ; i++){
            f = f * i ;
        }
        return f;
    }
    public static int binCoeff(int n , int r){
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n -r);

        int binCoeff = fact_n / (fact_r * fact_nmr);
        return binCoeff;
    }

    public static int sum(int a , int b ) {
        int sum = a + b;
        return sum;
    }
    public static int sum(int a , int b , int c) {
        int sum = a + b + c;
        return sum;
    }


    public static void main(String[] args) { 
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int sum = calculateSum(a, b); // actual parameters   // function call ke liye
        // System.out.println("sum is: " + sum);


//         swap code ;
//         int a = 5 ;
//         int b = 10;
//     //swap
//    swap(a, b); // java call by value follow klrta h 
//     means value ki copy pass hoti h 
   

    // // factorial code 
    //    int f = factorial(6);
    //     System.out.println(f);
    

    // // binomial Coefficeint 
    //     System.out.println("the bincoeff is: " + binCoeff(5, 2));

        //function overloading
        System.out.println(sum(4, 5));
        System.out.println(sum(4, 5, 6));
    }
}
