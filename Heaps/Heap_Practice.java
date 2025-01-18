package Heaps;

import java.util.*;

public class Heap_Practice {

    public static ArrayList<Integer> kthLargestStream(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            if (pq.size() < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }

            if (pq.size() < k) {
                list.add(-1);
            } else {
                list.add(pq.peek());
            }
        }
        return list;
    }

    public static void nSlot(int arr[], int n) {

        Queue<Integer> q = new LinkedList<>();

        int time = 0;
        boolean isVisited[] = new boolean[n + 1];
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
            isVisited[arr[i]] = true;
        }

        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                int curr = q.remove();
                if ((curr - 1) >= 1 && !isVisited[curr - 1]) {
                    q.add(curr - 1);
                    isVisited[curr - 1] = true;

                }

                if ((curr + 1) <= n && !isVisited[curr + 1]) {
                    q.add(curr + 1);
                    isVisited[curr + 1] = true;
                }

            }
            time++;

        }

        System.out.println(time - 1);

    }

    public static int findMinCostPath(int grid[][]){
  int rows = grid.length;
  int cols = grid[0].length;

  PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
  pq.offer(new int[] {0,0,0}); // (cost , row , col)

  Set<String> visited = new HashSet<>();

  while ((!pq.isEmpty())) {
       int[] current = pq.poll();
       int cost = current[0];
       int row = current[1];
       int col = current[2];

       if (row == rows -1 && col == cols -1) {
         return cost;
       }

       String cellKey = row + "," + col;
       if (visited.contains(cellKey)) {
            continue;
       }
       visited.add(cellKey);

       int[][] directions = {{0,1} , {1,0} , {-1,0}, {0,-1}};
       for(int dir[] : directions){
        int newRow = row + dir[0];
        int newCol = col + dir[1];

        if (isValid(newRow , newCol , rows, cols) && !visited.contains(newRow + "," + newCol)) {
            int newCost = cost + grid[newRow][newCol];
            pq.offer(new int[] {newCost , newRow , newCol});
        }
    }
  }
  return -1 ;
    }

    private static boolean isValid (int row , int col , int rows , int cols){
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }



    public static int halfArray(ArrayList<Double> nums){
            double sum = 0;
            PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i< nums.size() ; i++){
             pq.add((double)nums.get(i));
            sum += nums.get(i);
           
        }

        double target = sum /2;
        int count = 0;

        while (sum > target) {
             
             double highest = pq.peek();
             pq.remove();
             sum -= highest;
             highest = highest/2;
             sum+= highest;
             pq.add((double)highest);
             count++; 
        }

       return count;


    }
    public static void main(String[] args) {
        // int k = 4;
        // int arr[] = {1,2,3,4,5,6};
        // ArrayList<Integer> res = kthLargestStream(arr, k);
        // for (int x : res) {
        // System.out.println(x);
        // }

        // int arr[] = {1,2,3,4,5};
        // nSlot(arr, 5);

        // int[][] grid = {
        //         { 31, 100, 65, 12, 18 },
        //         { 10, 13, 47, 157, 6 },
        //         { 100, 113, 174, 11, 33 },
        //         { 88, 124, 41, 20, 140 },
        //         { 99, 32, 111, 41, 20 }
        // };

        // int minCost = findMinCostPath(grid);
        // System.out.println("Minumun cost: " + minCost);

        ArrayList<Double> nums = new ArrayList<>();
        nums.add(3.0);
        // nums.add(5.0);
        nums.add(8.0);
        nums.add(20.0);

        System.out.println(halfArray(nums));


    }
}
