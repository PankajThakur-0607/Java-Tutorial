package Graph;

import java.sql.Time;
import java.util.LinkedList;
import java.util.Queue;

import ARRAYS.pairs;

public class RottenOranges {
    
   static class Pair{
        int row;
        int col;
        int time;

        public Pair(int row , int col , int t){
            this.row = row;
            this.col = col;
            this.time = t;

        }
    }

        // Solution 1 
   // Time Complexity: O(NxM + NxMx4) ~ O(N x M), For the worst case, all of the cells will have fresh oranges, so the BFS function will be called for (N x M) nodes and for every node, we are traversing for 4 neighbours, it will take O(N x M x 4) time.

   //  Space Complexity ~ O(N x M), O(N x M) for copied input array and recursive stack space takes up N x M locations at max. 
    public static int orangesRotting_V1(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int countFresh = 0;
        for(int i = 0 ; i < n; i ++){
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int tm = 0;
        int xdir[] = {-1,1,0,0};
        int ydir[] = {0,0,-1,1};
        
        while (!q.isEmpty()) {
            int t = q.peek().time;
            int r = q.peek().row;
            int c = q.peek().col;
            tm = Math.max(tm, t);
            q.remove();

            for(int i = 0 ; i<4; i++){

                int newRow = xdir[i] + r;
                int newCol = ydir[i]+ c;
                if (newRow >=0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    q.add(new Pair(newRow, newCol, t + 1));
                    vis[newRow][newCol] = 2;
                    countFresh--;
                }
            }
        }
        if (countFresh != 0) {
            return -1;
        }

        return tm;
    }

    // Solution 2 
    // Time Complexity - O(n * m)
    // Space Complexity - O(n * m)
    public static int orangesRotting_V2(int grid[][]){
        int n = grid.length;
        int m = grid[0].length;

        int countFresh = 0;
        Queue<int []> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        if (countFresh == 0) {
            return 0;
        }
        int xdir[] = {-1 , 1 ,0 , 0};
        int ydir[] = {0 ,0 , 1 , -1};

        int count = 0;
        while (!q.isEmpty()) {
            
            int size = q.size();
            for(int i = 0 ; i<size ; i++){
                int point[] = q.poll();
                for(int j = 0 ; j < 4 ; j++){
                int x = point[0] + xdir[j];
                int y = point[1] + ydir[j];

                if (x < 0 || x>= n || y < 0 || y >= m || grid[x][y] == 0 || grid[x][y] == 2) {
                    continue;
                }

                grid[x][y] = 2;
                q.offer(new int[] {x,y});
                countFresh--;
            }
        }
        
            count++;

        }
        System.out.println();
        if (countFresh == 0) {
            return (count -1);
        }

        return -1 ;
    }

    public static void main(String[] args) {
        int grid[][] = {{2,1,1},
                        {1,1,0},
                        {0,1,1}};

        System.out.println(orangesRotting_V1(grid));

        System.out.println(orangesRotting_V2(grid));
    
     

    }

}
