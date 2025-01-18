package Greedy_Alogorithm;

import java.util.Arrays;

public class FractionalKnapSack {
    

    
    // O(n) + O(n log n )  + O(N)  && O(N)
    public static int fractionalKnapsack(int value[] , int weight[] , int capacity){
        int n = value.length;

        double ratio[][] = new double[n][2];
        for(int i = 0; i < n ; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double)  weight[i] ;
        }

        
        Arrays.sort(ratio , (a , b) -> Double.compare(b[1], a[1]));
        int maxProfit = 0;
        for(int i = 0; i < ratio.length; i++) {
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]){
                capacity -= weight[idx];
                maxProfit += value[idx];
            }else{
                maxProfit +=  (ratio[i][1] * capacity);
                break;
            }
        }
        return maxProfit ;
    }
    public static void main(String[] args) {
        
        int value[] = {120,80,70,60};
        int weight[] = {10,40,20,30}; 
        int capacity = 70;
        System.out.println(fractionalKnapsack(value, weight , capacity));
    }
}
