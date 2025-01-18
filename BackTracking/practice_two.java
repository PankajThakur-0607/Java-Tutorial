package BackTracking;

public class practice_two {
    
    public static boolean mazeSolver(int maze[][], int row, int col , int sol[][] ){
          if (row == maze.length-1 &&  col == maze.length-1) {
            sol[row][col] = 1;
            return true;
          }
        
        
        if (isSafe(maze, row, col)) {
                sol[row][col] = 1;
                if (mazeSolver(maze, row+1, col, sol)) {
                    return true;
                }
                if (mazeSolver(maze, row, col+1, sol)) {
                    return true ;
                }
                sol[row][col] = 0; // backtracking
                return false;
            }
                return false;
    }


    public static boolean isSafe(int maze[][] , int row , int col ){
            if (row < maze.length && col < maze.length && maze[row][col] == 1) {
                return true;
            }
            return false;
    }


    public static void printSol(int sol[][]){
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j] + " " );
            }
            System.out.println();
        }
    }

        public static boolean  solveKnight(int row, int col, int i , int[][] sol , int[] xMove, int[] yMove  ){
              int nextI , nextJ ;
            //base case
            if (i == N * N) {
                return true;
            }

            for(int k = 0 ; k < 8 ; k++){
              nextI = row + xMove[k];
              nextJ = col + yMove[k];
                if (isSafe(nextI , nextJ , sol)) {
                    sol[nextI][nextJ] = i;
                    if (solveKnight(row, col, i+1, sol, xMove, yMove)) {
                        return true ;
                    }
                    else {
                        sol[nextI][nextJ] = -1;
                        
                    }


        }
    }
    return false;
}

public static boolean isSafe(int i , int j, int sol[][]  ) {
    return (i >= 0 && i < N && j >= 0 && j < N && sol[i][j] == -1);
    
}


        public static boolean Knight() {
            int sol[][] = new int[8][8];
            for(int i = 0; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    sol[i][j] = -1;
                }
            }
            int xMove[] = {2 , 1,-1,-2,-2,-1,1,2};
            int yMove[] = {1, 2, 2, 1, -1, -2,-2,-1};
    
            //As the knight starts from cell(0,0)
            sol[0][0] = 0;
    
            if(!solveKnight(0, 0, 1, sol, xMove, yMove)){
                System.out.print("solution does not exist");
                return false;
            }
            else{
                printKnight(sol);
            }
            return true;
        }

        public static void printKnight( int sol[][]) {
            for(int i = 0; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    System.out.print(sol[i][j] + " ");
                    
                }
                System.out.println();
            }
            
        }
        static int N = 8;



        



    public static void main(String[] args) {
        Knight();
          


    }


}
