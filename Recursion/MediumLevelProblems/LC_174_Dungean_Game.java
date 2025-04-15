package MediumLevelProblems;

public class LC_174_Dungean_Game {


    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length ;
        int n = dungeon[0].length;
        return helper(dungeon , m , n , 0 , 0) ;
    }
    private static int helper(int[][] dungeon, int m, int n, int row, int col) {
        if (row == m || col == n) {
            return Integer.MAX_VALUE;
        }

        if (row == m - 1 && col == n - 1) {
            return (dungeon[row][col] <= 0) ? -dungeon[row][col] + 1 : dungeon[row][col] ;
        }

        int moveRight = helper(dungeon, m, n, row, col + 1);
        int moveDown = helper(dungeon, m, n, row  + 1 , col);

        int minHealthLeft = Math.min(moveRight, moveDown) - dungeon[row][col] ;

        return (minHealthLeft <= 0) ? 1 : minHealthLeft ;
    }
    public static void main(String[] args) {
        int [][] dungean = {
            {-2,-3,3},
            {-5,-10,1},
            {10,30,-5}
        };
        System.out.println(calculateMinimumHP(dungean));
    }
}
