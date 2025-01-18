
package Heaps;

import java.lang.classfile.components.ClassPrinter;
import java.util.*;

public class MergeKSortList {

    public static class ListNode {
        int val;
        ListNode next;
        @SuppressWarnings("unused")
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode mergeLists_V1(ListNode[] lists) {
        ArrayList<Integer> storeNode = new ArrayList<>();
        for (ListNode list : lists) {
            ListNode temp = list;
            while (temp != null) { 
                storeNode.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(storeNode);

        return convertList(storeNode);
         
    }

    public static ListNode convertList(ArrayList<Integer> arr){
        ListNode dummy = new ListNode(-1);
        ListNode currNode = dummy;

        for(int i = 0; i < arr.size() ; i++){
            currNode.next = new ListNode(arr.get(i));
            currNode = currNode.next;
        }

        return dummy.next;
    }
    // -------------------------------------------------------------------------------------------------------------------------

        public  static  ListNode mergeLists_V2(ListNode[] lists){
            if (lists == null || lists.length == 0) {
                return null; // Handle empty input
            }

             
            ListNode head = lists[0];
            for(int i = 0 ; i < lists.length ; i++){
                ListNode secondList = lists[i];
                head = merge2List(head , secondList);
            }

            return head;
        }

        public static ListNode merge2List(ListNode first , ListNode second){
            ListNode dummy = new ListNode(-1);
            ListNode currNode =  dummy;

            while(first!= null && second != null){
                if(first.val <= second.val){
                    currNode.next = first;
                    currNode = currNode.next;
                    first = first.next;
                }else{
                    currNode.next = second;
                    currNode = currNode.next;
                    second = second.next;
                }
            }

            if(first != null){
                currNode.next = first;
            }else{ 
                currNode.next = second;
            }

            return dummy.next;
        }
    //  ------------------------------------------------------------------------------------------------------------------------

    // O(N Log N) + O(M*N log M*N) && O(N) + O(N * M)
    public static ListNode mergeKLists_V3(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode currNode = dummy;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            currNode.next = temp;
            currNode = currNode.next;

            if (temp.next != null) {
                pq.add(temp.next);
            }

        }

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = { l1, l2, l3 };

        ListNode ans = mergeLists_V1(lists);
        printLinkedList(ans);
        System.out.println();

        ListNode ans2 = mergeLists_V2(lists);
        printLinkedList(ans2);
        System.out.println();



        ListNode ans3 = mergeKLists_V3(lists);
        printLinkedList(ans3);
        System.out.println();

    }
}