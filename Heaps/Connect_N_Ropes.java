
package Heaps;
import java.util.PriorityQueue;

public class Connect_N_Ropes {
    


    public static long connectRopes(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr){
            pq.add(num);
        }
        long sum = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            sum += first + second;
            pq.add(first + second);
        }

        return sum;
    } 
    public static void main(String[] args) {
        int arr[] = {4,3,2,6};
        System.out.println(connectRopes(arr));
    }
}
