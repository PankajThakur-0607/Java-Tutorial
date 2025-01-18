

import java.util.*;


public class StackA {
    
    // static class Stack{
    //     static ArrayList<Integer> list = new ArrayList<>();

    //     public static boolean isEmpty(){
    //         return list.size() == 0;
    //     }

    //     public static void push(int data){
    //         list.add(data);
    //     }

    //     public static int pop(){
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         int top = list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;
    //     }

    //     public static int peek(){
    //         return list.get(list.size()-1);
    //     }
    // }


    // static class Node{
    //     int data ;
    //     Node next;

    //     Node(int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static  class  Stack{
    //     static Node head = null;

    //     public static boolean isEmpty(){
    //         return head == null;
    //     }

    //     public static void push(int data){
    //         Node newNode = new Node(data);
    //         if(head == null){
    //             head = newNode;
    //             return;
    //         }

    //         newNode.next = head;
    //         head = newNode;
    //     }

    //     public static int pop(){
    //         if(isEmpty()){
    //             return -1;
    //         }

    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }

    //     public static int peek(){
    //         return head.data;
    //     }
    // }

    public static void pushAtBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseString(String s){
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            st.push(ch);
        }


        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    public static Stack<Integer> reverseStack_V1(Stack <Integer> st){
        Stack<Integer> st2 = new Stack<>();

        while (!st.isEmpty()) {
            st2.push(st.pop());
        }
        return st2;
    }
    public static void reverseStack_V2(Stack <Integer> st){
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        reverseStack_V2(st);
        pushAtBottom(st , top);

    }

    public static int[] stockSpan(int arr[]){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int span[] = new int[n];
        span[0] = 1;
        st.push(0);
        for(int i = 1 ; i < n ; i++){

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                span[i] = i + 1;
            }else{
                int prevhigh = i - st.peek();
                span[i] = prevhigh; 
            }
            st.push(i);
        }


        return span;
    }

    public static void printStack(Stack<Integer> st){
        while (!st.isEmpty() ) {
            System.out.println(st.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        // pushAtBottom(st, 4);  
        // reverseString("abcd");
        
        // reverseStack_V2(st);
        // printStack(st);

        int arr[] = {100,80,60,70, 60,85,100};
        int span[] = stockSpan(arr);
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }

    }
}
