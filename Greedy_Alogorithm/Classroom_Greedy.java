package Greedy_Alogorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Classroom_Greedy {

    public static class Job {
        int deadline;
        int id;
        int profit;

        public Job(int i, int d, int p) {
            deadline = d;
            id = i;
            profit = p;
        }

    }

    public static void fractionalKnapSack(int[] weight, int[] value, int W) {

        // sorting
        double ratio[][] = new double[value.length][2];

        // 0th col => idx 1st col => ratio

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }
        // ascending order

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int totVal = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) { // include full item
                capacity -= weight[idx];
                totVal += value[idx];
            } else {
                // include fractional item
                totVal += (int) (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("final value: " + totVal);
    }

    public static void main (String args[]) {
           
        
        // // Activity Selection
        // int start[] = {1,3,0,5,8,5};
        //     int end[] =   {2,4,6,7,9,9};


        // // sorting 
        // int activities [][] = new int[start.length][3];

        // for(int i = 0; i < start.length ; i++){
        //     activities[i][0] = i ;
        //     activities[i][1] = start[i];
        //     activities[i][2] = end[i];
        // }
        //     // lambda Functions -> shortform
        // Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        //     // end time basis sorted
        //     int maxAct = 0;
        //     ArrayList<Integer> ans = new ArrayList<>();

        //     // 1st activity
        //     maxAct = 1;
        //     ans.add(activities[0][0]);
        //     int lastEnd = activities[0][2];
        //     for(int i = 1 ; i < end.length ; i++){
        //         if (activities[i][1] >= lastEnd) {
                    
        //             // activity select 
        //             maxAct++;
        //             ans.add(activities[i][0]);
        //             lastEnd = activities[i][2];
        //         }
        //     }

        //     System.out.println("Max activiites= " + maxAct);

        //     for(int i = 0 ; i < ans.size(); i++){
        //         System.out.print("A" + ans.get(i) + " ");
        //     }



        // // Fractional Kanpsack
        //     int weight[] = {10,20,30};
        //     int val[] = {120,140,150};
        //     int W = 50;

        //     fractionalKnapSack(weight, val, W);


            // // Min Absolute Difference Pair

            // int A[] = {4,1,8,7,2,6};
            // int B[] = {2,5,6,5,5,9};

            // Arrays.sort(A);
            // Arrays.sort(B);

            // int minDiff = 0 ;
            // for(int i = 0 ; i < A.length ; i++){
            //     minDiff += Math.abs(A[i] - B[i]);
            // }


            // System.out.println("min absolute value of pairs = " + minDiff);



    // Max Lentgh Chain of Pairs   O(nlogn)

    // int pairs[][] = {{5,24}, {39,60} , {5,28} , {27,40} , {50,90}};

    //         int pairsIdx [][] = new int[pairs.length][3];

    //         for(int i = 0; i < pairsIdx.length ; i++){
    //              pairsIdx[i][0] = i;
                 
    //         }

    // Arrays.sort(pairs , Comparator.comparingDouble(o -> o[1]));

    // ArrayList<Integer> ans = new ArrayList<>();

    // int chainLen = 1;
    // int chainEnd = pairs[0][1]; // Last selected pair and // chain end
    // ans.add(pairsIdx[0][0]); 
    // for(int i = 1 ; i < pairs.length; i++){
    //     if (pairs[i][0] > chainEnd ) {
    //         chainLen++ ;
    //         ans.add(pairsIdx[i][0]);
    //         chainEnd = pairs[i][1];
            

    //     }
    // }

    // System.out.println("Max lenght of chain is: " + chainLen);
    // System.out.println(ans);



//     // Indian Coin 
//   Integer coins[] = {1,2,5,10,20,50,100,200,500,2000};

//   Arrays.sort(coins, Comparator.reverseOrder());

//   int countOfCoins = 0 ;
//   int amount = 1059;

//   ArrayList <Integer> ans = new ArrayList<>();
//   for(int i = 0 ; i < coins.length ; i++){
//     if (coins[i] <= amount) {
//         while (coins[i] <= amount) {
//             countOfCoins++;
//             ans.add(coins[i]);
//             amount -= coins[i];
//         }
//     }
//   }
//   System.out.println("total count are: " + countOfCoins);


//     for(int i = 0 ; i < ans.size() ; i++){
//         System.out.print(ans.get(i) + " ");
//     }



        // // Job Sequencing 
         

        // int jobsInfo[][] = {{4,20} ,{1,10}, {1,40}, {1,30}} ;

        // ArrayList<Job> jobs = new ArrayList<>();
        // for(int i = 0 ; i < jobsInfo.length; i++){
        //     jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1])); 
        // }

        // Collections.sort(jobs ,((obj1,obj2) -> obj2.profit - obj1.profit));
        // // descending order of profit 

        // ArrayList <Integer> seq = new ArrayList<>();
        // int time = 0 ;
        // for(int i =0 ; i< jobs.size(); i++){
        //     Job curr = jobs.get(i);
        //     if (curr.deadline > time) {
        //         seq.add(curr.id);
        //         time++;
        //     }
        // }

        // System.out.println("max jobs = " + seq.size());
        // for(int i =0 ; i <seq.size(); i++ ){
        //     System.out.print
        //     (seq.get(i) + " ");
        // }




        // Chocola Problem    // SPOJ platform 
        int n = 4, m = 6;
        Integer costVer[] = {2,1,3,1,4}; // m-1
        Integer costHor[] = {4,1,2}; // n-1 

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0 , v = 0;  // pointers 
        int hp = 1 , vp = 1; // initial pices = 1 * 1
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
             if (costVer[v] <= costHor[h]) { // horizontal cut
                 cost += (vp * costHor[h]);
                 hp++;
                 h++;
             } else{
                cost += (hp * costVer[v]);
                v++;
                vp++;
             }
        }


        while (h < costHor.length) {
             cost += (vp * costHor[h]);
                 hp++;
                 h++;
        }

        while (v < costVer.length) {
            cost += (hp * costVer[v]);
                v++;
                vp++;
             }


             System.out.println("minimum cost = " + cost);
        }
        
        


    }

