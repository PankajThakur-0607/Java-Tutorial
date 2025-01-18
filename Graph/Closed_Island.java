

public class Closed_Island {
    
public static void dfs(int grid[][] , int i , int j){
    int row = grid.length;
    int col = grid[0].length; 
    if (i < 0 || j < 0 || i>= row || j >= col || grid[i][j] == 1) {
        return ;
    }

    grid[i][j] = 1;

    int newRow[] = {-1,1,0,0};
    int newCol[] = {0,0,-1,1};
    
    for(int k = 0 ; k < 4 ; k++){
        int nR = i + newRow[k];
        int nC = j + newCol[k];

        dfs(grid, nR, nC);
    }

}
    public static int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for(int i =0 ; i < m ;i++){
                for(int j = 0; j< n ; j++){
                    if (i ==0 || j == 0 || i == m-1 || j == n-1 && (grid[i][j] == 0)) {
                        dfs(grid , i , j);
                    }
                }
            } 

            int count = 0;
            for(int i =0 ; i < m ;i++){
                for(int j = 0; j< n ; j++){
                    if (grid[i][j] == 0) {
                        dfs(grid , i , j);
                        count++;
                    }
                }
            }

            return count ;
    }

    public static void main(String[] args) {
        int grid[][] = {{1,1,1,1,1,1,1,0},
                        {1,1,1,1,1,1,1,0},
                        {1,0,1,0,1,1,1,0},
                        {1,0,0,0,0,1,0,1},
                        {1,1,1,1,1,1,1,0}};

                        System.out.println(closedIsland(grid));
    }
}
