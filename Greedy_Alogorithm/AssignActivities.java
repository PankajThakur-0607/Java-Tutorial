package Greedy_Alogorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AssignActivities {
    

    public static int assignActivity(int start[] , int end[]){
        int n = start.length;
        ArrayList<Integer> storeAct = new ArrayList<>();
        int activities[][] = new int[n][3];

        for(int i = 0; i < n ; i++ ){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];

        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        int maxAct  = 1;
        storeAct.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i = 1; i < end.length ; i++){
            if(activities[i][1] >= lastEnd ){
                maxAct++;
                lastEnd = activities[i][2];
                storeAct.add(activities[i][0]);
            }
        }
        
        return maxAct;   
    } 


    public static void main(String[] args) {
        
        int start[]  = {1,3,0,5,8,5};
        int end[] =    {2,4,6,7,9,9};

        System.out.println(assignActivity(start, end));
    }
}
