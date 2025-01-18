  package Linked_List_2;

import java.util.HashMap;

public class LL_2 {
    
    static class Node {
        int data ;
        Node next;
    
    
        public  Node(int data){
            this.data= data;
            this.next = null;
        }
    
    
    }
    
    static Node head;
    static Node tail;
    static int size;


    // method to print the list data  // O(n)   
    public void printList(){  
        if (head == null) {
            System.out.println(" LL is Empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        // System.out.println("");
        System.out.println("null");
        System.out.println("The size of the List is : " + size);
    }

    // Method to add in the beginning  // O(1)  & O(1)
    public void addFirst(int key){  
        Node newNode = new Node(key);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        
        newNode.next = head;
        
        head = newNode;
        
    }
    
    // Method to add in the end  // O(1) & O(1)
    public void addLast(int key){  
        Node newNode = new Node(key);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        
        tail = newNode;
    }
    
    
    // Method to add at the given index
    public void add(int index , int key){
        Node newNode = new Node(key);
        size++;
        Node temp = head;  
        int currIdx = 0;
        // To search where we want to add the key
        while (currIdx < index-1) {
            temp = temp.next;
            currIdx++;
        }
        
        // Adding the node the the given idx
        newNode.next = temp.next;
        temp.next = newNode;

    }

    // Method to add in the beginning  // O(1)  & O(1)
    
    public int removeFirst(){
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MAX_VALUE;
        }else if (size == 1) {
            int val = head.data;
            head =  tail = null ;
            size = 0;
            return val;
        }  

        int val = head.data;
        head = head.next;
        size--;
        return val;
        
    }
    
    // Method to add in the beginning  // O(n)  & O(1)
    public int removeLast(){
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MAX_VALUE;
        }else if (size == 1) {
            int val = tail.data;
            head =  tail = null ;
            size = 0;
            return val;
        } 
        // prevTail : idx = size - 2;
        Node prevTail = head;
        // Loop to reach prevTailNode
        for (int idx = 0; idx < size - 2; idx++) {
            prevTail = prevTail.next;
        }

        // delete steps
        int val = tail.data;
        prevTail.next = null;
        tail = prevTail;
        size--;

        return val;
    }

    public int itrSearch(int key){  // O(n) & O(1)
        Node temp = head; 
        int idx = 0;

        while (temp != null) {
                if (temp.data == key) {
                    return idx;
                }
                temp = temp.next;
                idx++;
        }

        return -1;
    } 

    public int recSearch(Node node , int key, int index){ // O(n) & O(1)
        if (node == null) {
            return -1;
        }


        if (node.data == key) {
            return index;
        }

       return recSearch(node.next, key, index + 1);
    }

    public void reverseList(){  // O(n) & O(1)
        Node prev = null;
        Node curr = tail = head;
        Node next ;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void deleteNthNode(int n){ // O(n) & O(1)
        //Step 1 :  Calculate Size 
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n > sz) {
            System.out.println("please enter the correct Index");
            return;
        }
        if (sz == n) {
            head = head.next; // Edge case : If we want to delete first
            size--;
            return;
        }

        // step 2 : fint the prev node of the nth Node to delete

        int idx = n;
        Node prev = head;
        for (int i = 0; i < sz - idx - 1 ; i++) {
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
        size--;
        return;

    }

    // Hare and toroise Method to find Mid Node;
    // Slow Fast Approach

    public Node findMid(Node head){ // O(n / 2) = O(n) & O(1)
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
        }

        return slow;
    }



    // Check if LL is a palindrome palindrome 
    public boolean checkPalindrome(){ // O(n) & O(1)
        if (head == null || head.next == null) {
            return true;
        }

        // Find Mid;
         Node curr = findMid(head);
         Node prev = null;
         Node next;

         while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }

         Node left = head;
         Node right = prev; 
         while (right != null) {
                if (left.data != right.data) {
                    return false;
                }

                left = left.next;
                right = right.next;
         }

         return true;
    }


    public  boolean detectCycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


    public void removeCycle(){   // O(2 * N) + O(N)  && O(1)
        Node slow = head;
        Node fast = head;
        HashMap <Node , Integer> map = new HashMap<>();
        while (fast != null && fast.next != null) {
            map.put(fast, map.getOrDefault(fast, 0) + 1);
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;  
            }
        }

        slow = head;
        Node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        System.out.println(map);
        prev.next = null;
    }


    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
        }

        return slow;
    }

    public Node merge(Node head1 , Node head2){
        Node tempNode = new Node(-1);
        Node mergerLL = tempNode;
        while (head1 != null && head2 != null) {
                if (head1.data <= head2.data) {
                    tempNode.next = head1;
                    head1 = head1.next;
                    tempNode = tempNode.next;
                }else{
                    tempNode.next = head2;
                    head2 = head2.next;
                    tempNode = tempNode.next;
                }
        }

        while (head1 != null) {
            tempNode.next = head1;
            head1 = head1.next;
            tempNode = tempNode.next;
        }

        while (head2 != null) {
            tempNode.next = head2;
            head2 = head2.next;
            tempNode = tempNode.next;
        }

        return mergerLL.next;
    }


    public Node mergeSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        // Find Mid 
        Node mid = getMid(head);
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        // Left and right Half

        Node leftNode = mergeSort(leftHead);
        Node rightNode = mergeSort(rightHead);

        // Merge
        return merge(leftNode , rightNode);

    }
    public static void main(String[] args) {
        LL_2 ll = new LL_2();
        

        // // call to  add in beginning and end of the LL
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);

        // print call
        // ll.printList(); // 1-> 2-> 3-> 4-> null


        // call to add at the given index
        // ll.add(3, 5);
        // ll.printList();


        // call to delete first Node
        // ll.removeFirst();
        // ll.removeFirst();
        // ll.printList(); //3-> 4-> null

        // call to delete Last Node
        // ll.removeLast(); 
        // ll.removeLast();
        // ll.printList();  // 1-> 2-> null


        // // Iterarive call to search the index of key
        // System.out.println("The key is at index: " + ll.itrSearch(10));
        // // Recursive call to search the index of key
        // System.out.println("The key is at index: " + ll.recSearch(head, 10, 0));


        // // call to reverse a LL;
        // ll.reverseList();
        // ll.printList();

        // // call to remove from Nth Node
        // ll.deleteNthNode(5);
        // ll.printList();


        // // call to check if LL is Palindrome or not
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.printList();

        // System.out.println(ll.checkPalindrome());


        // Call to detect Cycle
        // head = new Node(3);
        // Node second = new Node(2);
        // Node third = new Node(0);
        // Node fourth = new Node(-4);
        // Node fifth = new Node(5);
        // Node sixth = new Node(6) ;

        // head.next = second;
        // second.next = third;
        // third.next = fourth;  
        // fourth.next = second;
        // fifth.next = sixth;
        // sixth.next = second;

        // System.out.println(ll.detectCycle());
        // ll.printList();
        // ll.removeCycle();
        // System.out.println(ll.detectCycle());
        // ll.printList();



        // Call to merge Sorted LinkedList

        ll.addLast(5);
        ll.addLast(9);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(4);

        ll.printList();

        ll.head = ll.mergeSort(ll.head);
        
        ll.printList();

        





    }
}


