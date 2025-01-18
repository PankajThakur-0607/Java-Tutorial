import java.util.Stack;

public class QueueUsing2Stack {

    static class Queue {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        boolean isEmpty() {
            return st1.size() == 0 && st2.size() == 0;
        }

        // Add
        void add(int data) {
            st1.push(data);
        }

        // pop O(N)
        int remove() {
            if (st2.isEmpty()) {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }
            if (st2.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return st2.pop();
        }

        // O(N)
        int peek() {
            if (st2.isEmpty()) {
                while (!st1.isEmpty()) {
                    st2.push(st1.peek());
                }
            }
            if (st2.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return st2.peek();
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        
        
    }
}
