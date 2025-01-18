import java.util.*;

public class DequeA {
    class Stack{
        Deque<Integer> dq = new LinkedList<>();

        boolean isEmpty(){
            return dq.isEmpty();
        }
        void push(int data){
            dq.offerFirst(data);
        }

        int pop(){
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            return  dq.pollFirst();
        }

        int peek(){
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            return dq.peekFirst();
        }
    }


    static class Queue {
        Deque<Integer> dq = new LinkedList<>();

        boolean isEmpty(){
            return dq.isEmpty();
        }

        void add(int data){
            dq.addLast(data);
        }

        int remove(){
            if (isEmpty()) {
                return -1;
            }
            
            return dq.pollFirst();
        }
        
        int peek(){
            if (isEmpty()) {
                return -1;
            }
            return dq.peekFirst();
        }
        
    }
    public static void main(String[] args){
        DequeA deque =  new DequeA();
        DequeA.Stack st = deque.new Stack();
        st.push(1);
        st.push(2);
        st.push(3);

    while (!st.isEmpty()) {
        System.out.println(st.pop());
    }


    Queue q = new Queue();
    q.add(1);
    q.add(2);
    q.add(3);
    
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());


    }
}
