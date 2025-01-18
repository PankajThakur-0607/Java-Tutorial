package Greedy_Alogorithm;

import java.lang.classfile.components.ClassPrinter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class LRU_withPageFault {

    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.prev = this.next = null;
        }
    }

    public static int pageFaults_V1(int pages[], int n, int capacity) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int pageFault = 0;

        for (int page : pages) {

            if (!set.contains(page)) {
                pageFault++;
                // set.add(page);
                if (set.size() == capacity) {
                    Iterator<Integer> it = set.iterator();
                    it.next();
                    it.remove();
                }
            } else {
                set.remove(page);
            }

            set.add(page);
        }

        return pageFault;
    }

    public static int pageFault_V2(int pages[], int n, int capacity) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode tail = new ListNode(-1);
        ListNode head = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
        int pageFault = 0;
        for (int page : pages) {
            if (!map.containsKey(page)) {
                pageFault++;

                if (map.size() == capacity) {
                    ListNode getFirstNode = head.next;
                    map.remove(getFirstNode.val);
                    removeNode(getFirstNode);
                }

                ListNode newNode = new ListNode(page);
                map.put(page, newNode);
                addLast(newNode, tail);
            } else {
                ListNode getNode = map.get(page);
                removeNode(getNode);
                addLast(getNode, tail);
            }
        }
        return pageFault;
    }

    public static void addLast(ListNode node, ListNode tail) {
        ListNode prevNode = tail.prev;
        node.prev = prevNode;
        prevNode.next = node;
        node.next = tail;
        tail.prev = node;
    }

    public static void removeNode(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = node.next;
        nextNode.prev = prevNode;
    }

    public static void main(String[] args) {
        int[] pages = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3 };
        int N = pages.length;
        int C = 3; // Capacity of memory

        int result = pageFaults_V1(pages, N, C);
        System.out.println("Number of page faults: " + result);

        int result2 = pageFault_V2(pages, N, C);
        System.out.println("Number of page faults: " + result2);

    }
}
