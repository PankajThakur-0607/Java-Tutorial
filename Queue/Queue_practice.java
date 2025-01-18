
import java.util.*;

public class Queue_practice {

    public static int decToBin(int dec) {

        int bin = 0;
        int pow = 0;
        int myNum = dec;

        while (dec != 0) {
            int lastDigit = dec % 2;
            bin = bin + (lastDigit * (int) Math.pow(10, pow));
            dec = dec / 2;
            pow++;

        }
        // System.out.println("the bin num of: " + myNum + " is: " + bin);
        return bin;

    }

    public static void binNumbers(int num) {

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= num; i++) {

            q.add(decToBin(i));

        }

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }

    public static int minCostForRopes(int arr[], int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int result = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            result += first + second;
            pq.add(first + second);

        }

        return result;
    }

    static class Job {
        char jobID;
        int deadLine;
        int profit;

        public Job(char jobID, int deadLine, int profit) {
            this.deadLine = deadLine;
            this.profit = profit;
            this.jobID = jobID;
        }

    }

    public static void printSchedulingJobs(ArrayList<Job> arr) {
        Collections.sort(arr, (a, b) -> {
            return a.deadLine - b.deadLine;
        });

        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            return b.profit - a.profit;
        });
        int n = arr.size();
        for (int i = n - 1; i > -1; i--) {
            int slotAvailable;
            if (i == 0) {
                slotAvailable = arr.get(i).deadLine;
            } else {
                slotAvailable = arr.get(i).deadLine - arr.get(i - 1).deadLine;
            }

            pq.add(arr.get(i));

            while (pq.size() > 0 && slotAvailable > 0) {

                Job job = pq.remove();

                slotAvailable--;

                result.add(job);
            }

        }

        Collections.sort(result, (a, b) -> {
            return a.deadLine - b.deadLine;
        });
        int sum = 0;
        for (Job job : result) {
             sum  = sum + job.profit;
            
        }
        System.out.println(sum + " ");
    }

    public static void reverseKelemnt (Queue <Integer> q , int k ){

        Stack <Integer> s = new Stack<>();
        Queue <Integer> ans = new LinkedList<>();
        for (int i = 0; i < k ; i++) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
               ans.add(s.pop());
        }

        while (!q.isEmpty()) {
                ans.add(q.remove());
        }

        while (!ans.isEmpty()) {
              System.out.print(ans.remove() + " ");
        }

    }

    public static void maxSubAray(int arr[] , int k){  //O(n*k)
        
        for (int i = 0; i <= arr.length - k; i++) {
            int max = arr[i];
            for(int j = 1 ; j < k; j++){
                if (max < arr[i+j] ) {
                    max = arr[i+j];
                }
            }
            System.out.println(max);
        }
        
    }

    static void printMax(int arr[], int n, int k){  //O(n)
        Deque<Integer> Qi = new LinkedList<Integer>();
        int i;
        for (i = 0; i < k; ++i) {
        while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]){
             Qi.removeLast();
        }
        Qi.addLast(i);
        }

        for (; i < n; ++i) {
        System.out.print(arr[Qi.peek()] + " ");
        while ((!Qi.isEmpty()) && Qi.peek() <=  i - k){
        Qi.removeFirst();
        }
        while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]){
        Qi.removeLast();
        }
        Qi.addLast(i);
        }
        System.out.print(arr[Qi.peek()]);
        }

    public static void main(String[] args) {

        // // binNumbers(5);
        // int arr[] = {1,2,3};
        // System.out.println(minCostForRopes(arr, 1));


        // // JOb sequencing Algo
        // ArrayList<Job> arr = new ArrayList<>();
        // arr.add(new Job('a', 2, 100));
        // arr.add(new Job('b', 1, 19));
        // arr.add(new Job('c', 2, 27));
        // // arr.add(new Job('d', 1, 25));
        // // arr.add(new Job('e', 3, 15));
        // printSchedulingJobs(arr);

        // Queue <Integer> q = new LinkedList<>();
        // q.add(10);
        // q.add(20);
        // q.add(30);
        // q.add(40);
        // q.add(50);
        // q.add(60);
        // q.add(70);
        // q.add(80);
        // q.add(90);
        // q.add(100);
        // reverseKelemnt(q, 7);

     
    //    int[] arr= {2,1,3,7,6,7,5,2,6,7,6};
    //    maxSubAray(arr, 3);
    int arr[] = {12,1,78,90,57,89,56};
maxSubAray(arr, 3);
// printMax(arr, 9, 3);


        
    }
}
