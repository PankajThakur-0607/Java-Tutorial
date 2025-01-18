package Two_D_Arrays;
import java.util.*;
public class Matrices {

    public static boolean search(int matrix[][] , int key){
        for(int i = 0; i< matrix.length; i++){
            for(int j =0; j< matrix[0].length; j++){
              if(matrix[i][j] == key){
                System.out.println("found at cell (" + i +"," +j+ ")");
                return true;
              }
                
            }
            
          
        }
        System.out.println("Key not found");
        return false;
    }

    public static void printSpiral(int matrix[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length -1;
        int endCol = matrix[0].length -1 ;
        while(startRow <= endRow && startCol <= endCol){
             // top 
             for(int j = startCol ; j <= endCol ; j++ ){
              System.out.print(matrix[startRow][j] + " ");
         }
             //right
             for(int i = startRow +1 ; i<= endRow ; i++){
              System.out.print(matrix[i][endCol] + " ");
             }

             //bottom
             for(int j = endCol -1 ; j >= startCol   ; j-- ){
              if(startRow == endRow){
                break;
              }
              System.out.print(matrix[endRow][j] + " ");
             }

             //left
             for(int i = endRow-1 ; i >= startRow + 1; i-- ){
              if(startCol == endCol){
                break;
              }
              System.out.print(matrix[i][startCol] + " ");
             }
           

            startCol ++;
            startRow++;
            endRow--;
            endCol--;
          }
        }
          public static int diagonalsum(int matrix[][]){
            int sum =0;
            // for(int i =0 ; i< matrix.length ; i++){
            //   for(int j =0; j < matrix[0].length; j++){
            //     //Pd
            //     if(i == j ){
            //       sum += matrix[i][j];
            //     }
            //     else if( (i + j) == matrix.length-1){
            //       sum += matrix[i][j];
            //     }
            //   }
            // }
            // return sum;

            for(int i = 0; i< matrix.length; i++){
             //pd
              sum += matrix[i][i];
              //sd
              if(i != matrix.length - 1 -i)
                sum += matrix[i][matrix.length - i - 1];
              
            }
            return sum;
          }

          public static boolean staircaseSearch(int matrix[][] , int key){
            // int row = 0, col = matrix[0].length -1;
            // while(row < matrix.length && col >= 0){
            //   if(matrix[row][col] == key){
            //     System.out.println("found key at (" + row + "," + col + ")");
            //     return true;
            //   }

            //  else if(key < matrix[row][col]){
            //     col--;
            //   }
            //   else{
            //     row++;
            //   }
            // }
            // System.out.println("Key not found");
            // return false;
            
            int col = 0, row = matrix[0].length -1;
            while(col < matrix.length && row >= 0){
              if(matrix[row][col] == key){
                System.out.println("found key at (" + row + "," + col + ")");
                return true;
              }

             else if(key < matrix[row][col]){
                row--;
              }
              else{
                col++;
              }
            }
            System.out.println("Key not found");
            return false;

          }

          public static void chanceOf7(int matrix [][]){
            int count = 0;
            for(int i = 0; i< matrix.length ; i++){
              for(int j =0 ; j< matrix[0].length; j++){
                  if(matrix[i][j] == (7) ){
                    count++;
                  }
              }
              
            }
            System.out.println("count of 7 is:" + count);
          }


       
          public static void printMatrix(int matrix[][]){
            for(int i =0 ; i < matrix .length ; i++){
              for(int j =0; j< matrix[0].length ; j++){
                System.out.print(matrix[i][j] + " ");
              }
              System.out.println();
            }
          }
        
       

    

    
    public static void main(String[] args) {
        // int matrix[][] = new int[3][3];
        // int n = matrix.length, m = matrix[0].length;

        // for(int i = 0; i< n; i++){
        //     for(int j =0; j< m; j++){
        //         Scanner sc = new Scanner(System.in);
        //         matrix[i][j] =  sc.nextInt();
        //     }
        // }
        // //output
        // for(int i = 0; i< n; i++){
        //     for(int j =0; j< m; j++){
        //       System.out.print(matrix[i][j] + " "); 
                
        //     }
        //     System.out.println();
        // }

        // search(matrix, 10);
        // int matrix [][] = {{1,2,3,4},
        //                    {5,6,7,8},
        //                    {9,10,11,12},
        //                    {13,14,15,16}};
            //  printSpiral(matrix);
          // System.out.println( diagonalsum(matrix)); 

          // int matrix[][]= {{10,20,30,40},
          //                 { 15,15,35,45},
          //                 {27,29,37,48},
          //                 {32,33,39,50}};
          // int key = 33;
          // staircaseSearch(matrix, key);


        //   int matrix[][] = {{4,7,8} , {7,8,7} };
        //  chanceOf7(matrix);


        // // Print out the sum of the numbers inthe second row of the “nums” array.
        // int matrix[][] = {{1,4,9},{11,4,3},{2,2,3}};
        // int row = 0 ,  startcol = 0 ,endcol = matrix.length -1;
        // int sum = 0;
        //   for(int j =startcol  ; j <= endcol ; j++  ){
        //     sum += matrix[row +1][j];
        //   }
        //   System.out.println(sum);
          

        int matrix [][] = {{2,3,7},
                           {5,6,7},
                           {8,9,3}};
         int [][] transpose = new int[matrix[0].length ][matrix.length ];
          for(int i = 0; i< matrix.length ; i++){
            for(int j =0 ; j< matrix[0].length ; j++){
              transpose[j][i] = matrix[i][j];
                                }
                             }
          printMatrix(transpose);
                           
                       
        

    }
}
