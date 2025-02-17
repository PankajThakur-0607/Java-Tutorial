package ARRAY_List;

import java.util.*;
import java.util.Collections;

public class practice_two {

    public static boolean monotonicArray(ArrayList<Integer> nums) {
        boolean dec = true;
        boolean inc = true;
        for (int i = 0; i < nums.size() - 1; i++) {

            if (nums.get(i) > nums.get(i + 1)) {
                inc = false;
            }
            if (nums.get(i) < nums.get(i + 1)) {
                dec = false;
            }
        }
        return inc || dec;
    }

    public static ArrayList<Integer> lonely(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.size() - 1; i++) {
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i));
            }
        }

        // Corner cases
        if (nums.size() == 1) {
            list.add(nums.get(0));
        }
        if (nums.size() > 1) {
            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }
        }
        if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
            list.add(nums.get(nums.size() - 1));
        }

        return list;
    }

    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        int result[] = new int[1000];

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
            }
        }

        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> beauList(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i += 2) {
            result.add(i);
        }

        for (int i = 2; i <= n; i += 2) {
            result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        // ArrayList <Integer> nums = new ArrayList<>();
        // nums.add(1);
        // nums.add(2);
        // nums.add(3);
        // nums.add(1);

        // System.out.println(monotonicArray(nums));

        // lonely
        // ArrayList <Integer> nums = new ArrayList<>();
        // nums.add(10);
        // nums.add(6);
        // nums.add(5);
        // nums.add(8);
        // nums.add(3);
        // nums.add(9);
        // System.out.println(lonely(nums));

        // ArrayList <Integer> nums = new ArrayList<>() ;
        // nums.add(1);
        // nums.add(100);
        // nums.add(200);
        // nums.add(1);
        // nums.add(100);
        // System.out.println(mostFrequent(nums, 1));

        // ArrayList<Integer> beauList = beauList(9);
        // System.out.println(beauList);

        int[] primitiveArray = { 1, 2, 3, 4, 5 };
        List<int[]> primitiveList = Arrays.asList(primitiveArray);
        System.out.println(primitiveList); // Prints: [[I@<hashcode>]

        Integer[] classArray = { 1, 2, 3 };
        List<Integer> classList = Arrays.asList(classArray);
        System.out.println(classList); // Prints: [1, 2, 3]

        // Iterate over each int[] array element in the list
        for (int[] array : primitiveList) {
            // Iterate over each integer in the array and print its value
            for (int value : array) {
                System.out.print(value + " ");
            }
        }

        System.out.println();

        // Iterate over each int[] array element in the list
        for (int i = 0; i < primitiveList.size(); i++) {
            // Get the current int[] array
            int array[] = primitiveList.get(i);

            // Iterate over each integer in the array and print its value
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
        }

    }
}
