package BackTracking;

public class practice {

    public static boolean isSafe(int maze[][] , int i , int j) {
        return    (i >= 0 && i < maze.length && j >= 0 && j< maze.length && maze[i][j] == 1);
    }
    
    public static boolean solveMaze(int maze[][]) {
        int n = maze.length;
        int sol[][] = new int[n][n];
        if(mazeSolver(maze, 0, 0, sol) == false){
            System.out.println("solution does not exist");
            return false;
        }
        printsolution(sol);
        return true;
    }

    public static boolean mazeSolver(int maze[][] , int i , int j , int sol[][]){
        //base case
        if(i == maze.length -1 && j == maze.length -1 && maze[i][j]==1){
            sol[i][j] = 1;
            return true ;
        }


        if(isSafe(maze , i , j)== true){
            if(sol[i][j] == 1){
                return false;
               }
               sol[i][j] = 1;
             if(mazeSolver(maze, i+1, j, sol)){
                return true ;
            }
             if(mazeSolver(maze, i, j+1, sol)){
                return true ;
            }
            else{
                sol[i][j] = 0;
                return false;
            }
        }
        return false;
    }

    public static void printsolution(int sol[][]) {
        for(int i = 0; i < sol.length ; i++){
            for(int j = 0 ; j< sol.length ; j++){
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }




    // question no 2

    final static char[][] L = {{}, {}, {'a','b','c'}, {'d','e','f'}, 
    {'g', 'h', 'i'}, {'j','k','l'}, {'m', 'n','0'},{'p', 'q', 'r','s'},
    {'t','u', 'v'}, {'w','x','y','z'}};

    public static void letterCombination(String D){
        int len = D.length();
        if(len == 0){
            System.out.println("");
            return;
        }
        bfs(0, len, new StringBuilder(), D);

    }

    public static void bfs(int pos , int len , StringBuilder sb, String D) {
        if(pos == len){
            System.out.println(sb.toString());
        }
    
    else{
        char letters[] = L[Character.getNumericValue(D.charAt(pos))];
        for(int i = 0; i < letters.length; i++){
            bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), D);
        }
    }
}

    public static void main(String[] args) {
        // int maze[][] = {{1,0,0,0},
        //                 {1,1,0,1},
        //                 {0,1,0,0},
        //                 {1,1,1,1}};
        //     solveMaze(maze);
        letterCombination("89");
    }
}
