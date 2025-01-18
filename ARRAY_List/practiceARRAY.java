package ARRAY_List;

import java.util.ArrayList;
import java.util.Collections;

public class practiceARRAY {

    public static Boolean ismonotonic(ArrayList<Integer> list) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < list.size()-1; i++) {

            if (list.get(i) < list.get(i + 1)) {
                dec = false;
            }
            if (list.get(i) > list.get(i + 1)) {
                inc = false;
            }

        }
        return inc || dec;

    }

    public static ArrayList<Integer> isLonely(ArrayList<Integer> nums){
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1 ; i < nums.size() -1 ; i++){
            if( nums.get(i-1) < nums.get(i) && nums.get(i) +1 < nums.get(i +1)){
               list.add(nums.get(i));
            }
        }

        if(nums.size() == 1){
            list.add(nums.get(0));
        }
        if(nums.size() > 1){
            if(nums.get(0)+ 1 < nums.get(1)){
                list.add(nums.get(0));
            }
        }

        if(nums.get(nums.size()-2) + 1 < nums.get(nums.size()-1)){

            list.add(nums.get(nums.size()-1));
        }
        return list;
    }

    

    public static int  mostFrequent(ArrayList<Integer> arr , int key){
        int[] result = new int[1000];

        for(int i = 0 ; i < arr.size()-1 ; i++){
            if(arr.get(i) == key){
                result[arr.get(i +1) -1]++;
            }
        }    
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i =0 ; i < 1000; i++){
            if(result[i] > max){
                max = result[i];
                ans = i +1 ;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // ArrayList<Integer> nums = new ArrayList<>();
        // nums.add(6);
        // nums.add(2);
        // nums.add(3);
        // nums.add(9);
        // nums.add(4);

       // System.out.println(ismonotonic(list));


        // System.out.println(isLonely(nums));
        // System.out.println(nums.size());


        // ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(1);
        // arr.add(100);
        // arr.add(200);
        // arr.add(1);
        // arr.add(100);
        // int key = 1;
        // System.out.println(mostFrequent(arr, key));


        int arr[][] = new int[3][3];
        for(int i =0; i < arr.length; i++){
            int e = arr[0][i];
        }

    }
}
