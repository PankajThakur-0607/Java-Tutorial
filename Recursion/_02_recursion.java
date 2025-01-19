


public class _02_recursion {
    
    public static void printSumParameterizdWay(int N , int sum){
        if (N < 1) {
            System.out.println(sum);
            return;
        }


        printSumParameterizdWay(N-1, sum + N);

    }


  public static int  printSumFunctionalWay(int n){
        if(n == 0){
            return 0;
        }

        return n + printSumFunctionalWay(n-1);
    }

    //TC - O(N)  SC - O(N)
  public static int  factorial(int n){
        if(n == 0){
            return 1;
        }

        return n * factorial(n-1);
    }

    public static void reverseArr_V1(int grid[][] , int row , int startCol , int endCol){

        if (startCol >= endCol) {
            return;
        }

        int temp = grid[row][startCol];
        grid[row][startCol] = grid[row][endCol];
        grid[row][endCol] = temp;


        reverseArr_V1(grid, row, startCol+1, endCol-1);
        
    }

    public static void reverseArr_V2(int grid[][] , int row , int startCol , int endCol){

        if (startCol >= endCol || row >= grid.length) {
            return;
        }

        int temp = grid[row][startCol];
        grid[row][startCol] = grid[row][endCol];
        grid[row][endCol] = temp;


        reverseArr_V2(grid, row, startCol+1, endCol-1);

        if (startCol == 0) {
            reverseArr_V2(grid, row+1, startCol, endCol);
        }
        
    }

    public static boolean checkPalindrome(String str , int idx , int n){
        if (idx >= n) {
            return true;
        }

        if (str.charAt(idx) != str.charAt(n - idx - 1) ) {
            return false;
        }

        return checkPalindrome(str, idx+1, n);
    }


    // TC  --> O(2 ^ n)
    public static int fibboSeries(int n){
        if (n <= 1) {
            return n;
        }

        return fibboSeries(n-1) + fibboSeries(n - 2);
    }
    // TC  --> O(2 ^ n)
    public static void printFibboSeries(int n , int i){
        if (i > n) {
            return;
        } 

        System.out.print(fibboSeries(i) + " ");
        
        printFibboSeries(n, i+1);
        
    }

    

    public static void main(String[] args) {
        // printSumParameterizdWay(3, 0);

        // System.out.println(printSumFunctionalWay(3));

        // System.out.println(factorial(5));

        int grid[][] = {{1,2,3},{4,5,6},{7,8,9}};
        
        // for(int i = 0; i < grid.length; i++){
        //     reverseArr_V1(grid, i, 0, grid[0].length-1);
        // }

        // reverseArr_V2(grid, 0, 0, grid[0].length-1);
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // System.out.print(grid[i][j] + " ");
            }
            // System.out.println();
        }


        // String str = "MADAM";
        // System.out.println(checkPalindrome(str, 0, str.length()));

        // int n = 5;
        // System.out.println(fibboSeries(9));

        printFibboSeries(5 , 0);

        // System.out.println(3 + 5);

    }
}
