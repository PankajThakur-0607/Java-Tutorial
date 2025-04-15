
package MediumLevelProblems;

public class LC_64_MinimumPath {

    public static int minPathSum(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        return helper(grid , m , n , 0 , 0);
    }
   private static int helper(int[][] grid, int m, int n, int row, int col) {
        if (row == m || col == n) {
            return Integer.MAX_VALUE;
        }

        if (row == m-1 && col == n - 1) {
            return grid[row][col];
        }


        int right = helper(grid, m, n, row + 1 , col) ;
        if (right != Integer.MAX_VALUE) {
            right += grid[row][col];
        }
        int down = helper(grid, m, n, row , col + 1) ;
        if (down != Integer.MAX_VALUE) {
            down += grid[row][col];
        }

        
        return Math.min(right, down) ;
    }
 public static void main(String[] args) {
        int[][] grid = {
             { 1, 3, 1 },
             { 1, 5, 1 },
             { 4, 2, 1 }
     };

        System.out.println(minPathSum(grid));

    }
}