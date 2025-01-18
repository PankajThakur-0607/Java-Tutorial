package Heaps;

import java.awt.Paint;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MaxSumCombination {

    public static ArrayList<Integer> solve_V1(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Integer> allSums = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {

            for (int j = 0; j < B.size(); j++) {
                allSums.add(A.get(i) + B.get(j));
            }
        }


        allSums.sort(Collections.reverseOrder());
        ArrayList <Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < C ; i++){
            ans.add(allSums.get(i));
        }

        return ans;
    }

    public static ArrayList<Integer> solve_V2(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        // Sort both arrays in descending order
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());

        // Max heap to store the negative sum and indices
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));
        HashSet<String> visited = new HashSet<>(); // To track visited index pairs

        // Add the first combination (0, 0)
        maxHeap.add(new int[] { A.get(0) + B.get(0), 0, 0 });
        visited.add("0,0");

        ArrayList<Integer> result = new ArrayList<>();

        // Extract C combinations
        while (C > 0 && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int sum = current[0];
            int i = current[1];
            int j = current[2];

            // Add the maximum sum to result
            result.add(sum);
            C--;

            // Generate new pairs if within bounds
            if (i + 1 < A.size() && !visited.contains((i + 1) + "," + j)) {
                maxHeap.add(new int[] { A.get(i + 1) + B.get(j), i + 1, j });
                visited.add((i + 1) + "," + j);
            }

            if (j + 1 < B.size() && !visited.contains(i + "," + (j + 1))) {
                maxHeap.add(new int[] { A.get(i) + B.get(j + 1), i, j + 1 });
                visited.add(i + "," + (j + 1));
            }
        }

        return result;
    }


    static  class Pair{
        int idx1 ;
        int idx2 ;
        int sum;

        Pair(int idx1 , int idx2 , int sum){
            this.idx1 = idx1 ;
            this.idx2 = idx2;
            this.sum = sum;
        }
    }
    public static ArrayList<Integer> solve_V3(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        
        int size = A.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.sum - a.sum);
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        A.sort(Collections.reverseOrder());
        B.sort(Collections.reverseOrder());

        pq.add(new Pair(0, 0, A.get(0) + B.get(0)));
        set.add(0);


        while(C != 0){

            Pair p = pq.poll();
            int a = p.idx1;
            int b = p.idx2;
            int val = p.sum;
            ans.add(val);

            if(a + 1 < size && !set.contains((a + 1 )* size + b )){
                pq.add(new Pair(a + 1, b, A.get(a+1) + B.get(b)));
                set.add((a +1) * size + b);
            }

            if(b + 1 < size && !set.contains(a * size + (b + 1))){
                pq.add(new Pair(a, b + 1 , A.get(a) + B.get(b + 1)));
                set.add(a* size + (b + 1));
            }
            
            C--;
        }

        return  ans;
    }

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.add(3);
        A.add(2);

        B.add(1);
        B.add(4);

        int C = 2;

        
        ArrayList<Integer> ans = solve_V1(A, B, C);
        System.out.println(ans);

        ArrayList<Integer> ans2 = solve_V2(A, B, C);
        System.out.println(ans2);

        ArrayList<Integer> ans3 = solve_V2(A, B, C);
        System.out.println(ans3);

    


    }
}
