

import java.util.Scanner;

public class _2DArr {
  
    public static int[][] addition(int input1[][] , int input2[][] ){
            
       int n = input1.length;
       int m = input1[0].length;
       int r = input2.length;
       int c = input2[0].length;

       if (r != n || m != c) {
           System.out.println("The order is Wrong  ");
           System.out.println("please write the correct order of row and colmn");
           return new int[][]{};
       }

       int ans[][] = new int[n][m];

       for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = input1[i][j] + input2[i][j];
            }
       }
       return ans;
}

    public static int[][] substraction(int input1[][] , int input2[][]){
            
       int n = input1.length;
       int m = input1[0].length;
       int r = input2.length;
       int c = input2[0].length;

       if (r != n || m != c) {
           System.out.println("The order is Wrong  ");
           System.out.println("please write the correct order of row and colmn");
           return new int[][]{};
       }

       int ans[][] = new int[n][m];

       for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = input1[i][j] - input2[i][j];
            }
       }
       return ans;
}


     public static int[][] multiplication(int input1[][] , int input2[][]){
          int row1 = input1.length;
          int col1 = input1[0].length;
          int row2 = input2.length;
          int col2 = input2[0].length;

          if (col1 !=  row2) {
               System.out.println("Multiplication Not Possible");
               return new int[][]{};
          }

          int c[][] = new int[row1][col2];

          for (int i = 0; i < row1; i++) {
               for (int j = 0; j < col2; j++) {
                    for (int k = 0; k < row2; k++) {
                         c[i][j] += input1[i][k] * input2[k][j];
                    }
               }
          }
          return c;
     }
    

     public static int[][] inputMatrix(int number) {


          Scanner sc = new Scanner(System.in);


          System.out.print("Enter number of rows for matrix " + number + ": ");
           int row = sc.nextInt();
       
          
           System.out.print("Enter number of columns for matrix " + number + ": ");
           int col = sc.nextInt();

           int arr[][] = new int[row][col];

           System.out.println("Enter the element of matrix " + number + ": ");
           for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                   arr[i][j] = sc.nextInt();
                }
           }
       
           return arr;
     }


     public static void printMatrix(int print[][]){

          for (int i = 0; i < print.length; i++) {
               for (int j = 0; j < print[0].length; j++) {
                    System.out.print(print[i][j] + " ");
               }
               System.out.println();
          }
     }
    public static void main(String[] args) {
        
    //     // using Default Method
    //     int row = 3 ; 
    //     int col = 3 ;
    //     int value = 1;
    //     int nums[][] = new int[row][col];
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             nums[i][j] = value++;
    //         }
    //     }

    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             System.out.print(nums[i][j] + " ");
    //         }
    //         System.out.println();
    //     }


    //     // Direct Method of declaration 
    //     int arr[][] = {{1,2,3} , {4,5,6}};

    //     for (int i = 0; i < 2; i++) {
    //         for (int j = 0; j < 3; j++) {
    //         System.out.println("arr[" + i + "][" + j + "] = "
    //                             + arr[i][j]);
    //         }
    //     }



    // Scanner sc = new Scanner(System.in);

    // System.out.print("Enter number of rows: ");
    // int rows = sc.nextInt();

    // System.out.print("Enter number of columns: ");
    // int cols = sc.nextInt();

    // int arr2D[][] = new int[row][cols];


    // for (int i = 0; i < rows; i++) {
    //     for (int j = 0; j < cols; j++) {
    //         arr2D[i][j] = (i +1) * (j + 1);
    //     }
    // }
    // for (int i = 0; i < rows; i++) {
    //     for (int j = 0; j < cols; j++) {
    //         System.out.print(arr2D[i][j] + " ");
    //     }
    //     System.out.println();
    // }



    // // 3 D Array

    // int arr[][][] = {{{1,2} , {3,4}} , {{5,6} , {7,8}}};
    
    // // Elements in three-dimensional arrays are commonly referred by x[i][j][z] where ‘i’ is the array number, ‘j’ is the row number and ‘z’ is the column number. 
    // for (int i = 0; i < 2; i++) {   
    //     for (int j = 0; j < 2; j++) {
    //         for (int z = 0; z < 2; z++) {
    //             System.out.println("arr[" + i + "][" + j + "][" + z + "]= " + arr[i][j][z]);
    //         }
    //     }
    // }

     int [][] input1 = inputMatrix(1);
     int [][] input2 = inputMatrix(2);
     
     

    System.out.println("Addition of Two matrix are : ");
    int [][] ans = addition(input1, input2);
    printMatrix(ans);
    

    System.out.println("Substraction of Two matrix are : ");
    int ans2[][] = substraction(input1, input2);
     printMatrix(ans2);


     System.out.println("Multiplication of Two matrix are : ");
     int ans3[][] = multiplication(input1, input2);
     printMatrix(ans3);
     
     
   

   









    }
}
