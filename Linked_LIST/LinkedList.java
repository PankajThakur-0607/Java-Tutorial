package Linked_LIST;

public class LinkedList {
    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) { // O(1)

        // step -1 = create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 -- newNode next = head;
        newNode.next = head; // Link

        // step3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) { // O(1)
        // create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void print() { // O(n)
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        int i = 0;
        Node newNode = new Node(data);
        size++;
        Node temp = head;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // prev : i = size -2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // tail data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) {

        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) { // O(n)
        // basecase
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;

    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() { // O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthfromEnd(int n) {
        int sz = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next; // remove first
            return;
        }

        int i = 1;
        int toFind = sz - n;
        Node prev = head;
        while (i < toFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow; // slow is my mid node
    }

    public boolean checkpalindrome() {
        // basecase
        if (head == null || head.next == null) {
            return true;
        }

        // step-1 find mid
        Node midNode = findMid(head);
        // step -2 reverse 2nd half

        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // check left half and right half

        Node left = head;
        Node right = prev; // kyuki while loop end hone pr prev = right par hoga

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;

        }
        return true;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }

        }
        if (cycle == false) {
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null; // last NOde
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle --> last.next = null
        prev.next = null;
    }

    private Node getMid(Node head){
        Node slow = head ;
        Node fast = head.next;
        while (fast!= null && fast .next != null) {
            slow = slow.next ;
            fast = fast.next.next;
        }
        return slow ; // 
    }

    private Node merge (Node head1 , Node head2 ){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL ;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
             temp.next = head1;
             head1 = head1.next;
             temp = temp.next;
        }

        while (head2 != null) {
                temp.next = head2;
                head2 = head2.next ;
                temp = temp.next;
        }

        return mergeLL.next;
    }


    public Node mergeSort(Node head){   // O(nlog n)
        if (head == null || head.next == null) {
            return head ;
        }
        // find mid
        Node mid  = getMid(head);

        // left & right MS
            Node rightHead = mid.next;
            mid.next = null;
           Node newLeft= mergeSort(head);
           Node newRight = mergeSort(rightHead);
        // merge
        return merge(newLeft , newRight);
    }


    public void zigZag(){
        // find mid 

        Node slow = head;
        Node fast = head.next ;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse 2nd half 
        Node curr = mid;
        Node prev = null;
        Node next ;

        while (curr != null) {
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
        } 
        // alternate merge

        Node left = head; 
        Node right = prev;
        Node nextL , nextR ;

        while (left != null && right != null) {
            nextL = left.next ;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            right = nextR;
            left = nextL ;
        }

    }
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.addFirst(2);

        ll.addFirst(1);

        ll.addLast(4);

        ll.addLast(5);

        // ll.add(2, 3);
//  int removedVal = ll.removeFirst();
        // System.out.println("the removed element is: " + removedVal);
        ll.print(); // 1->2->3->4->5

        // // ll.removeFirst() ;
        // // ll.print();
        // // ll.removeLast();
        // // ll.print();
        // // System.out.println(size);

        // // System.out.println(ll.recSearch(3));
        // // System.out.println(ll.recSearch(10));

        // // ll.reverse();
        // // ll.print();
        // ll.deleteNthfromEnd(3);
        // ll.print();

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // System.out.println(ll.checkpalindrome());


        // check cycle & remove cycle

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // 1 -> 2 - > 3 -> 2
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // // merge Sort 
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);

        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();


        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // // ll.addLast(6);

        // ll.print(); 
        // ll.zigZag();
        // ll.print();


        // // Node  head1 = new Node(10);
        // Node  head2 = new Node(3);

        //   Node newNode = new Node(6);
        //   head2.next = newNode ;

        //   newNode = new Node(9);
        //   head2.next.next = newNode;

        //   newNode = new Node(15);
        // //   head1.next = newNode;
        //   head2.next.next.next = newNode;

        //   newNode = new Node(30);
        // //   head1.next.next = newNode;

        // //   head1.next.next.next = null;


        

        
          
        
    }
}