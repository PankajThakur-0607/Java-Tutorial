package Recursion;

public class _01_recursion {
    
    public static void reverseOrder(int[] arr , int size , int idx){
            if (idx == size)
                return;

            reverseOrder(arr, size, idx+1);
            System.out.print(arr[idx] + " ");
    }

    static int evenSum = 0;
    static int oddSum = 0;

    public static void oddEvenSum(int num[] , int size , int idx){
        if (idx == size) {
            System.out.println("even sum , " + evenSum);
            System.out.println("odd sum , " + oddSum);
            return;
        }
        
        if (num[idx] % 2 != 0) {
            oddSum += num[idx];
        }else {
            evenSum += num[idx];
        }
        
        oddEvenSum(num, size, idx+1);
    }


    public static void printMatrix_V1(int grid[][] , int row , int col, int M){

        if (col >= M) {
            return;
        }

        if (col < M) {
            System.out.print(grid[row][col] + " ");
            printMatrix_V1(grid, row, col+1, M);
        }
        
    }

    public static void printMatrix_V2(int grid[][] , int row , int col , int N , int M){

        if (col >= M || row >= N) {
            return;
        }

            System.out.print(grid[row][col] + " ");
            printMatrix_V2(grid, row, col+1, N, M);

        if (col == 0) {
            System.out.println();
            printMatrix_V2(grid, row+1, col, N , M);
        }
        

        
    }
    static int count = 0;
    public static void printCount(){
            if (count == 10) {
                return;
            }

            System.out.println(count);
            count++;
            printCount();
    }

    public static void printNtimes(int idx , int N){
        if (idx > N) {
            return;
        }

        System.out.println("i am grateful  " + idx);

        printNtimes(idx + 1, N);

    }
    // TC - O(N)  SC - O(N)
    public static void printReverseN(int idx , int N){
        if (N < idx) {
            return;
        }

        System.out.println(N);
        printReverseN(idx, N -1);
    }


    public static void printNtimesRecursion(int idx , int N){

        if (idx < 1) {
            return;
        }

        printNtimesRecursion(idx -1, N);
        System.out.println(idx);
    }

    public static void printReverseN_Recursion(int idx , int N){
        if (idx > N) {
            return;
        }
        printReverseN_Recursion(idx+1, N);

        System.out.println(idx);
    }


public static void main(String[] args) {
    
    // int arr[] = {1,2,3,4,5};
    // reverseOrder(arr, arr.length, 0);

    // int num[] = {1,2,3,5,8,2,6};
    // oddEvenSum(num, num.length, 0);

    // int grid[][] = {{1,2,3},{4,5,6},{7,8,9}};

    // for (int i = 0; i < grid.length; i++) {
    //      printMatrix_V1(grid, i, 0, grid[0].length);
    //      System.out.println();
    // }
    //     System.out.println();

    // printMatrix_V2(grid, 0, 0, grid.length ,  grid[0].length);
        
    // printCount();

    // printNtimes(1, 5);

    // printReverseN(1, 5);

    printNtimesRecursion(5, 5);
        System.out.println("-------------");
    printReverseN_Recursion(1 ,5);






}


}
