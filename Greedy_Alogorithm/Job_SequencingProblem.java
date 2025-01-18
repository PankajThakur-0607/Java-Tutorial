package Greedy_Alogorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Job_SequencingProblem {
    
    static class Job {
    int id, profit, deadline;

    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
    
}
    public static List<Integer> jobSequence_V1(Job jobs[] , int n){
        Arrays.sort(jobs , (a , b) -> {
            return b.profit - a.profit;
        });

        int countEmployee = 0;
        int countProfit = 0;
        int time = 0 ;
        for(int i = 0; i < n; i++){
            if(jobs[i].deadline > time ){
                countProfit += jobs[i].profit;
                countEmployee++;
                time++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(countEmployee);
        ans.add(countProfit);

        return ans;
    }
    public static List<Integer> jobSequence_V2(Job jobs[] , int n){
        Arrays.sort(jobs , (a , b) -> {
            return b.profit - a.profit;
        });

        int countEmployee = 0;
        int countProfit = 0;
        int maxDeadline = 0;
        for(int i = 0; i < n ; i++ ){
            maxDeadline = Math.max(jobs[i].deadline, maxDeadline);
        }

        int storeDeadline[] = new int[maxDeadline + 1];
        Arrays.fill(storeDeadline, -1);

        for(int i = 0; i < n; i++){
            
            for(int j = jobs[i].deadline; j > 0 ; j--){
                if (storeDeadline[j] == -1) {
                    storeDeadline[j] = jobs[i].id;
                    countProfit += jobs[i].profit;
                    countEmployee++;
                    break;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(countEmployee);
        ans.add(countProfit);

        return ans;
    }
    public static void main(String[] args) {
        // Job[] jobs = {
        //         new Job(1, 11, 321),
        //         new Job(2, 2, 62),
        //         new Job(3, 5, 456),
        //         new Job(4, 8, 394),
        //         new Job(5, 11, 424),
        //         new Job(6, 10, 22),
        //         new Job(7, 1, 393),
        //         new Job(8, 6, 87),
        //         new Job(9, 3, 118),
        //         new Job(10, 8, 384),
        //         new Job(11, 10, 83)
        // };

        Job[] jobs = { new Job(1, 4, 20), new Job(2, 1, 1), new Job(3, 1, 40), new Job(4, 1, 30) };


        List<Integer> ans = jobSequence_V1(jobs, 4);
        for (Integer integer : ans) {
            System.out.println(integer);
        }
        List<Integer> ans2 = jobSequence_V2(jobs, 4);
        for (Integer integer : ans2) {
            System.out.println(integer);
        }
    }
}
