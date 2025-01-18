package Linked_LIST;

public class LinkedList_Framework {

    public  class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;

    }

    public Node getIntersectionNode(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;

            }
            head2 = head2.next;
        }
        return null;
    }

    public void getMdeleteNnode(int M, int N) {
        Node curr = head;
        Node temp;
        int count;

        while (curr != null) {

            // For M Integers
            for (count = 1; count < M && curr != null; count++) {
                curr = curr.next;
            }

            if (curr == null) {
                return;
            }
            temp = curr.next;
            // For N integer to delete
            for (count = 1; count <= N && temp != null; count++) {
                Node temp2 = temp;
                temp = temp.next;
            }

            curr.next = temp;
            curr = temp;

        }
    }

    public void swappNodes(int x, int y) {
        if (x == y) {
            return;
        }

        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) {
            return;
        }

        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else{
            head = currX ;
        }

       Node temp = currX.next ;
        currX.next = currY.next ;
        currY.next = temp; 

    }

    public void oddEvenList(){
        Node curr = head ;
        Node end = head; 
        Node prev = null;

        while (end.next != null) {
            end = end.next ;
        }

        Node newEnd = end;

        while (curr.data % 2 != 0 && curr != null) {
           
                newEnd.next = curr;
                curr = curr.next ;
                newEnd.next.next = null;
                newEnd = newEnd.next;
             
            } 

            if (curr.data %2 == 0) {
                head = curr;
                while (curr != end ) {
                    if (curr.data %2 == 0) {
                        prev = curr ;
                        curr = curr.next ;
                    }
                    else {
                        prev.next = curr.next;
                        curr.next = null;
                        newEnd.next = curr;
                        newEnd = curr;
                        curr = prev.next;
                    }
                }
            }
             else {
                prev = curr; 
            }

            if (newEnd != end && end.data %2 != 0) {
                prev.next = end.next ;
                end.next = null;
                newEnd.next = end;
            }
        }


        public Node sortedMerge(Node a , Node b){
            Node result = null ;
            if(a == null ){
                return b ;
            } else if (b == null) {
                return a ;
            }

            if (a.data <= b.data) {
                result = a;
                result.next = sortedMerge(a.next, b);

            } else {
                result = b ;
                result.next = sortedMerge(a, b.next);
            }
            return result;
        }

    public Node mergeKList (Node arr[] , int last){
        while (last != 0) {
            int i = 0 , j = last;
            while (i < j) {
                arr[i] = sortedMerge(arr[i] , arr[j]);
                i++;
                j--;

            
            if (i >= j) {
                last  = j;
            }
        }
        
        }
        return arr[0];
    }


    

    public static void main(String[] args) {
        // LinkedList <Integer> ll = new LinkedList<>();

        // //add
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addFirst(0);
        // // 0-> 1-> 2
        // System.out.println(ll);
        // ll.removeLast();
        // ll.removeFirst() ;
        // System.out.println(ll);

        LinkedList_Framework Sll = new LinkedList_Framework();

        // // Question 1
        // Node head1 = new Node(10);
        // Node head2 = new Node(3);

        // Node newNode = new Node(6);
        // head2.next = newNode;

        // newNode = new Node(9);
        // head2.next.next = newNode;

        // newNode = new Node(15);
        // head1.next = newNode;
        // head2.next.next.next = newNode;

        // newNode = new Node(30);
        // head1.next.next = newNode;

        // head1.next.next.next = null;

        // // Sll.head = head2;

        // Node intersectionPoint = Sll.getIntersectionNode(head1, head2);

        // if (intersectionPoint == null) {
        // System.out.println("No Intersection Point");
        // } else{
        // System.out.println("The intersection point is: " + intersectionPoint.data);
        // }

        // Question 2
        Sll.addFirst(10);
        Sll.addFirst(9);
        Sll.addFirst(8);
        Sll.addFirst(7);
        Sll.addFirst(6);
        Sll.addFirst(5);
        Sll.addFirst(4);
        Sll.addFirst(3);
        Sll.addFirst(2);
        Sll.addFirst(1);

        Sll.getMdeleteNnode(3, 2);

        Sll.print();

        // Questions 3

        // Sll.addFirst(7);
        // Sll.addFirst(6);
        // Sll.addFirst(5);
        // Sll.addFirst(4);
        // Sll.addFirst(3);
        // Sll.addFirst(2);
        // Sll.addFirst(1);
        // Sll.print();

        // Sll.swappNodes(3, 6);
        // Sll.print();

        // Question 4 

        // Sll.addFirst(6);
        // Sll.addFirst(8);
        // Sll.addFirst(4);
        // Sll.addFirst(9);
        // Sll.addFirst(2);
        // Sll.addFirst(1);

        // Sll.oddEvenList();
        // Sll.print();



        // // Question 5
        // int k = 3 ; 
        // int n = 4 ;
        // Node arr[] = new Node[k];

        // arr[0] = new Node(1);
        // arr[0].next = new Node(3);
        // arr[0].next.next = new Node(5);
        // arr[0].next.next.next = new Node(7);

        // arr[1] = new Node(2);
        // arr[1].next = new Node(4);
        // arr[1].next.next = new Node(6);
        // arr[1].next.next.next = new Node(8);

        // arr[2] = new Node(0);
        // arr[2].next = new Node(9);
        // arr[2].next.next = new Node(10);
        // arr[2].next.next.next = new Node(11);

        //       Sll.head = Sll.mergeKList(arr, k-1);
        //       Sll.print();


    }
}
