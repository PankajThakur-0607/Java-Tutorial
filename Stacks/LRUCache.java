

import  java.util.*;


class LRUCache {

    static class ListNode {
        int key, val;
        ListNode next, prev;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = this.prev = null;
        }
    }
    static ListNode head = new ListNode(-1, -1);
    static ListNode tail = new ListNode(-1, -1);
    static int capacity;
    static Map<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // O(1)
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        ListNode node = map.get(key);
        remove(node);
        insert(node);
        return node.val;

    }

    // O(1)
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
        } else {
            if (map.size() == capacity) {
                ListNode node = tail.prev;
                map.remove(node.key);
                remove(node);
            }
            
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            insert(node);
        }
    }

    // O(1)
    public void insert(ListNode node) {
        ListNode nextHead = head.next;
        node.next = nextHead;
        nextHead.prev = node;
        head.next = node;
        node.prev = head;
    }

    // O(1)
    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }


    public static void main(String[] args) {

    }
}



