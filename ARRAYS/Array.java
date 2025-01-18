package ARRAYS;
import java.util.*;

public class Array {
    public static void update(int marks[]){
        for(int i =0; i < marks.length; i++){
            marks[i] = marks[i] + 1;
        }
    }

    private static int findForgottenNotesBruteForce(int[] notes, int forgottenAmount) {
        for (int i = 0; i < notes.length; i++) {
            int currentSum = 0;

            for (int j = i; j < notes.length; j++) {
                currentSum += notes[j];

                if (currentSum == forgottenAmount) {
                    return j - i + 1; 
                } else if (currentSum > forgottenAmount) {
                    break; 
                }
            }
        }

        return 0;
    }
    public static void main(String [] args){
    //     Scanner sc = new Scanner(System.in);
    //     int marks[] = {45,46,47};
    //     // int marks[] = new int[100];
    //     int arr2[];
        


    //     // marks[0] = sc.nextInt(); // physics
    //     // marks[1] = sc.nextInt(); // maths
    //     // marks[2] = sc.nextInt(); // chemistry

    //     // System.out.println("phy: " + marks[0]);
    //     // System.out.println("maths: " + marks[1]);
    //     // System.out.println("chem:  " + marks[2]);
    //     // System.out.println();
    //    // System.out.println("lenght of an array: " + marks.length);
    //    update(marks);
    //    for(int i =0 ; i< marks.length; i++){
    //         System.out.println(marks[i] + " ");


    Scanner sc = new Scanner(System.in);
        System.out.print("Total money Customer has : ");
        int n = sc.nextInt();
        System.out.print("Total notes the laundry man has: ");
        int x = sc.nextInt();  
        int arr[] = new int[x];

        for(int i = 0 ; i< arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
         int result = findForgottenNotesBruteForce(arr, n);
        
        
        System.out.print(result);
            
    }
 }


  
    
     


   
        
        
        
      
 



