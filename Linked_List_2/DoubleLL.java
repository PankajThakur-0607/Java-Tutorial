package Linked_List_2;


public class DoubleLL {
    
 class ListNode{

        int data;
        ListNode next;
        ListNode prev;


        ListNode(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }


    public static ListNode head;
    public static ListNode tail;
    public static int size = 0;

     //add
     public void addFirst(int data){  //O(1)
        ListNode newNode = new ListNode(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head ;
        head.prev  = newNode;
        head = newNode;
     }

     public int removeFirst(){  //O(1)
        if(head == null){
            System.out.println("LL is empty");
            return -1;
        }

        if(size == 1){
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
     }

     public void addLast(int data){  //O(1)
        ListNode newNode = new ListNode(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
     }


     // RemoveLast;

     public int removeLast(){
        if(head == null){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = tail.data;
            tail = head =  null;
            size--;
            return val;
        }

        int val = tail.data;
        ListNode temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
        return val;
     }

     public void reverseDLL(){
        ListNode currNode = head;
        ListNode next ;
        ListNode prev = null;

        while (currNode != null) {
            next = currNode.next ;
            currNode.next = prev;
            currNode.prev = next;
            prev = currNode;
            currNode = next;
        }
        head = prev;
     }

     //Print
     public void printLL(){
        ListNode temp = head;
        while (temp!= null) {
            System.out.print(temp.data + "<-->");
            temp = temp.next;
        }
        System.out.println("null");
     }
    public static void main(String[] args) {
        
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);
        dll.printLL();
        dll.reverseDLL();
        dll.printLL();

    
    }
}
