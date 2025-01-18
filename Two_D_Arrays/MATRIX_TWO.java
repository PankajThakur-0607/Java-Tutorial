package Two_D_Arrays;

import java.util.Scanner;

import ARRAYS.largest;
import LOOPS.star;

public class MATRIX_TWO {

    public static boolean search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.print("found at cell: " + "(" + i + "," + j + ")");
                    return true;
                }
            }
            System.out.println();

        }

        return false;
    }

    public static void print_Spiral(int matrix[][]) {
        int startRow = 0 ;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length-1;

        while (startRow <= endRow && startCol <= endCol) {
           
            // j --> column iteration
            // i --> row iteration

            //Top
            for(int j = startCol; j <= endCol ; j++){
                System.out.print(matrix[startRow][j] + " ");
            }
            

            // Right
            for (int i = startRow+1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }


            //Bottom
            for(int j = endCol-1; j >= startCol ; j--){
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }


            // Left
            for(int i = endRow-1 ; i >= startRow + 1 ; i--){
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

             
             startRow++;
             startCol++;
             endRow--;
             endCol--;
        }
    }

    public static int diagonal_Sum(int matrix[][]) {
        int sum = 0;
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix.length; j++) {
        // if(i == j){
        // sum+= matrix[i][j];
        // }
        // else if (i+j == matrix.length-1) {
        // sum+= matrix[i][j];
        // }
        // }
        // }
        // return sum;

        for (int i = 0; i < matrix.length; i++) {
            // PD
            sum += matrix[i][i];

            // SD
            if (i != (matrix.length - 1) - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;
    }

    public static void check7(int array[][]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 7) {
                    sum++;
                }
            }

        }
        System.out.println(sum);

    }

    public static int arraySum(int nums[][]) {
        int sum = 0;

        for (int j = 0; j < nums[0].length; j++) {

            sum += nums[1][j];

        }
        // System.out.println(sum);
        return sum;
    }

    public static void transpose(int matrix2[][]){
        
    }

    public static void printMatrix(int matrix2[][]){
        for(int i =0 ; i < matrix2 .length ; i++){
          for(int j =0; j< matrix2[0].length ; j++){
            System.out.print(matrix2[i][j] + " ");
          }
          System.out.println();
        }
      }

      public static void largestMatrix(int matrix2[][]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i =0 ; i < matrix2 .length ; i++){
          for(int j =0; j< matrix2[0].length ; j++){
            largest = Math.max(largest, matrix2[i][j]);
            smallest = Math.min(smallest, matrix2[i][j]);
          }
          System.out.println();
        }
        System.out.println("largest NO in matrix is: " + largest);
        System.out.println("Smallest NO in matrix is: " + smallest);
      }

    public static void main(String[] args) {
        // int matrix[][] = new int[3][3];
        // int n = matrix.length , m = matrix[0].length;

        // Scanner sc = new Scanner(System.in);
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // matrix[i][j] = sc.nextInt();
        // }
        // }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(matrix[i][j] + " ");
        // }
        // System.out.println();

        // }
        // search(matrix, 5);

        int matrix[][] = { { 1,2,3,4,5,26,31,32 },
                           { 6,7,8,9,10,27,33,34},
                           {11,12,13,14,15,28,35,36},
                           {16,17,18,19,20,29,37,38},
                           {21,22,23,24,25,30,39,40}};

        print_Spiral(matrix);
        // System.out.println(diagonal_Sum(matrix));

        // int array[][] = {{4,7,8},{8,8,7},{7,7,6}};
        // check7(array);

        // int nums[][] = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
        //    System.out.println(arraySum(nums));
        
    //     int matrix2[][] =  {{11,12,13}, {14,15,16}};
    //     printMatrix(matrix2);

    //     int transpose[][] = new int [matrix2[0].length][matrix2.length];
            
    // for (int i = 0; i < matrix2.length; i++) {
    //     for (int j = 0; j < matrix2[0].length; j++) {
    //         transpose[j][i] = matrix2[i][j];
    //     }
    // }

    // printMatrix(transpose);
    // largestMatrix(matrix2);
        



    }
}
