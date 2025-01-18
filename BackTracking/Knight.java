package BackTracking;

public class Knight {

        static int N = 8;

    public static boolean isSafe( int i , int j, int sol[][]  ) {
        return (i >= 0 && i < N && j >= 0 && j < N && sol[i][j] == -1);
        
    }

    public static void printHorse(int sol[][]) {
        for(int i = 0; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                System.out.print(sol[i][j] + " ");
                
            }
            System.out.println();
        }
        
    }

    public static boolean Horse() {
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

        if(!solveHorse(0, 0, 1, sol, xMove, yMove)){
            System.out.print("solution does not exist");
            return false;
        }
        else{
            printHorse(sol);
        }
        return true;
    }

    public static boolean solveHorse(int i , int j , int movei , int sol[][],int xMove[], int yMove[]){
            int k , next_i , next_j;
            if(movei == N*N){
                return true;
            }

            for(k = 0 ; k < 8 ; k++){
                next_i = i + xMove[k];
                next_j = j + yMove[k];
                if(isSafe(next_i, next_j, sol)){
                    sol[next_i] [next_j] = movei ;
                    if(solveHorse(next_i, next_j, movei +1, sol, xMove, yMove)){
                        return true ;
                    }
                    sol[next_i][next_j] = -1 ; // backtracking
                }
                
            }
            return false;
        
        }
    public static void main(String[] args) {
        Horse();
     

    }
}
