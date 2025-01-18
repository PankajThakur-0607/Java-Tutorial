import LOOPS.star;

public class QueueB {

    static class Queue {

        static int arr[];
        static int size;
        static int rear;
        static int front;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;

        }

        public static boolean isfull() {
            return (rear + 1) % size == front;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // add
        public static void add(int data) { // O(1)
            if (isfull()) {
                System.out.println("queue is full");
                return;
            }
            
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;

        }

        // remove
        public static int remove() { // O(n)
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int result = arr[front];
                // last elemnt delete  
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            return arr[front];
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        q.remove();
        q.add(5);
        // q.add(6);


        // System.out.println(q.remove());
        // System.out.println(q.remove());

        // System.out.println(q.remove());

        // stack -> 4 3 2 1
        // Queue --> 1 2 3 4
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
