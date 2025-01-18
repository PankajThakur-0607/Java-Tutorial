package Greedy_Alogorithm;

import java.util.Arrays;

public class chainOfPair {
    
        // O(N Log N) && O(1)
    public static int chainPair(int pair[][]){
    
        Arrays.sort(pair, (a,b) -> Integer.compare(a[1], b[1]));
        int maxChain = 1;
        int chainEnd = pair[0][1];
        for(int i = 1; i < pair.length ; i++){
            if(pair[i][0] >= chainEnd){
                maxChain++;
                chainEnd = pair[i][1];
            }
        }
        return maxChain;
    }

    public static void main(String[] args) {

        int pair[][] = {{5 , 24} , {39 , 60} , {5,28} , {27,40}  , {50 , 90}};
        System.out.println(chainPair(pair));
    }
}
