package ARRAYS;

import java.util.Scanner;

import Classes.inheritance;

import java.util.*;

public class Array_questions {
    
 public static boolean isPrime(int n){
    boolean isPrime = true;
    if (n == 2) {
        return true;
    }

    for(int i = 2 ; i <= Math.sqrt(n) ; i++){
        if (n % i == 0) {
            isPrime = false;
            break;
        }
    }
    
    return isPrime;
 }

 public static void primeInRange(int n){
    for(int i = 2 ; i <= n ; i++){

        if (isPrime(i)) {
        System.out.print(i + " ");
       }

    }
 }

 

 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // int arr[] = {2,6,1,0,5};
        // int m1 =3 , m2 =2;
        // // int a[] = new int[arr.length];
        // for(int i =0; i < arr.length; i++){
        //     int x  =  arr[i] - m1;
        //      if (x < m2) {
        //          arr[i]++;
        //      }

        // }

        // for(int i = 0; i< arr.length ; i++){
        //     System.out.print(arr[i] + " ");
        // }


        // int arr[] = {2,5,1,3,6,8};
        // int i = 0;
        // int count = 0;
        // while (i < arr.length) {
        //     count = arr[i];
        //     i = i + arr[i];
            
        // }
        //    System.out.println(count); 
            
          
        // System.out.println("Enter the Number: ");
        // int n = sc.nextInt();
        //     int sum = 0;
        // while (n > 0) {
        //       int lastDigit = n % 10;
        //       sum = sum + lastDigit;
        //       n = n / 10;

        // }
        // System.out.println(sum);

    //     int pow = n;
    //     int rev= 0;
    //    while (n > 0) {
    //      int lastDigit = n % 10;
         
    //      rev = (rev * 10) + lastDigit  ;
        
    //      n = n /10;
    //    }
    //    System.out.println(rev);



      System.out.println("Enter the Number: ");
        int n = sc.nextInt();

        primeInRange(n);


            
        
        
        
    }
}
