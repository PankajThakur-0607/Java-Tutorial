import java.util.*;

public class QueueA {
    
    // static class Queue {

        // static int arr[] ;
        // static int size;
        // static int rear ;
        // static int front;

        // Queue(int n){
        //     arr = new int[n];
        //     size = n;
        //     rear = -1;
        //     front = -1;
        // }
        
        // // isEmpty()
        // public static boolean isEmpty(){
        //     return rear == -1 && front == -1;
        // }

        // public static boolean isFull(){
        //     return (rear + 1) % size == front;
        // }

        // public static void add(int data){  // O(1)
        //     if(isFull()){
        //         System.out.println("Queue is Full");
        //         return;
        //     }

        //     if (front == -1) {
        //         front = 0;
        //     }
        //     rear = (rear + 1) % size;
        //     arr[rear] = data;

        // }

        // public static int remove(){  // O(1)
        //     if (isEmpty()) {
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     int temp = arr[front];
            
        //     if (rear == front) {
        //         rear = front = -1;
        //     }else{
        //         front = (front + 1) % size;
        //     }
        //     return temp;
        // }

        // public static int peek(){
        //     if (isEmpty()) {
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     return arr[front];
        // }




        // implementation using LinkedList

    //     public static boolean isEmpty(){
    //         return head == null;
    //     }

    //     public static void add(int data){
    //         Node newNode = new Node(data);
    //         size++;
    //         if (head == null) {
    //             head = tail =  newNode;
    //             return;
    //         }

    //         tail.next = newNode;
    //         tail = newNode;
    //     }

    //     public static int remove(){
    //         if (isEmpty()) {
    //             System.out.println("Queue is Empty");
    //             return -1;
    //         }
    //         if (size == 1) {
    //             int val = head.data;
    //             head = tail = null;
    //             size--;
    //             return val;
    //         }
    //         int val = head.data;
    //         size--;
    //         head = head.next;
    //         return val;
    //     }


    //     public static int peek(){
    //         if (isEmpty()) {
    //             System.out.println("Queue is Empty");
    //             return -1;
    //         }
    //         return head.data;
    //     }

    // }

    // static class Node {
    //     int data;
    //     Node next;
    //     Node (int data){
    //         this.data = data;
    //         this.next = null;
    //     }

    // }

    // static Node head;
    // static Node tail;
    // static int size; 

    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
       

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

        // System.out.println(q.peek()); 
    }
}
