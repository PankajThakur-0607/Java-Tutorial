package Linked_LIST;

public class DoubleLL {
    
    public class Node{
        int data ;
        Node prev;
        Node next ;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;


    //add
    public void addFirst(int data){
        // Create New Node
        Node newNode = new Node(data);
        size++ ;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // initialise newNode head and prev
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void print(){
        Node temp = head;
        while (temp != null) {
             System.out.print(temp.data + "<->");
             temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst(){
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
             int val = head.data ;
             head = tail = null;
             size -- ;
             return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size -- ;
        return val;


    }

    public void addlast(int data){
        // create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return ;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public int removeLast(){
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null ;
            size -- ;
            return val;
        }

        Node temp = head;
        for(int i = 0; i < size-2 ; i++){
            temp = temp.next;
        }

        int val = temp.next.data;
        temp.next = null;
        size--;
        return val;
    }

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next ; 

        while (curr != null) {
            next = curr.next ;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        
    }


    
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addlast(4);
        dll.print();
        // System.out.println(dll.size);
        // dll.removeLast();
        // dll.print();
        // System.out.println(dll.size);

        // dll.removeFirst();
        // dll.print();
        // System.out.println(dll.size);
        dll.reverse();
        dll.print();



    }
}
