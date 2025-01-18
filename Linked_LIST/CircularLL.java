package Linked_LIST;

public class CircularLL {
    
public class Node{
    public int data ;
    Node next ;
    public Node(int data){
        this.data = data ;
    }


}

public static Node head; 
public static Node tail;
public static int size ;

public Node addToEmpty(int data){
    if (head != null) {
        return tail;
    }

    Node newNode = new Node(data);
    head = newNode;
    newNode.next = tail;
    return tail;
}

public Node addFirst(int data){
    if (head == null) {
        return addToEmpty(data);
} 

    Node newNode = new Node(data);
    newNode.next = head.next ;
    tail.next = newNode;
    return tail;
}

    public static void main(String[] args) {
        CircularLL Cll = new CircularLL();
        Node tail = null;
        
    }
}
