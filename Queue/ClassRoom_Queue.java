import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ClassRoom_Queue {
    

    public static void printNonrepeating(String str){   // TC -->  O(n) 
        int freq[] = new int[26];
        Queue <Character> q = new LinkedList<>();

        for(int i =0 ; i< str.length() ; i++){
           char  ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++ ; 
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1 ) {
                    q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else{
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void interLeave(Queue <Integer> q){

        Queue <Integer> firsthalf = new LinkedList<>();
        int size = q.size();
        for(int i = 0 ; i < size/2 ; i++){
            firsthalf.add(q.remove());
        }

        while (!firsthalf.isEmpty()) {
             q.add(firsthalf.remove());
             q.add(q.remove());
        }
       
    } 

    public static void reverse(Queue <Integer> q){

        Stack <Integer> s = new Stack<>();

        while (!q.isEmpty()) {
                s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

     

    public static void main(String[] args) {
        
            // first Non repeatings letter
        // String str = "cabcczb";
        // printNonrepeating(str);


        // Interleave 2 Halves of a queuew
        // Queue <Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);

        // interLeave(q);
        // // print Q
        // while (!q.isEmpty()) {
        //      System.out.print(q.remove() + " ");
        // }

            // Reverse a integer
         Queue <Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverse(q);
        // print reverse
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }


    }
}
