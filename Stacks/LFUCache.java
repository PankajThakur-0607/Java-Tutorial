import java.util.*;

// import LFUCache.DLLNode.DoubleLinkedList;

public class LFUCache {
    
    static int capacity;
    static int currSize;
    static int minFreq;
    static Map<Integer, DLLNode> cache;
    static Map<Integer, DoubleLinkedList> freqMap;

    public LFUCache(int capacity) {
        LFUCache.capacity = capacity;
        LFUCache.currSize = 0;
        LFUCache.minFreq = 0;
        LFUCache.cache = new HashMap<>();
        LFUCache.freqMap = new HashMap<>();
    }

    static class DLLNode {
        int key;
        int val;
        int freq;
        DLLNode next, prev;

        DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }

    }

    static class DoubleLinkedList {
        int listSize;
        DLLNode head, tail;

        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(DLLNode currNode) {
            DLLNode nextNode = head.next;
            currNode.next = nextNode;
            currNode.prev = head;
            head.next = currNode;
            nextNode.prev = currNode;
            listSize++;
        }

        public void removeNode(DLLNode currNode) {
            DLLNode nextNode = currNode.next;
            DLLNode prevNode = currNode.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }

    public static int get(int key){
        if (!cache.containsKey(key)) {
            return -1;
        }

        DLLNode currNode = cache.get(key);
        updateNode(currNode);
        return currNode.val;
    }
    public static void put(int key , int value){
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            DLLNode currNode = cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        }else{
            currSize++;
            if (currSize > capacity) {
                DoubleLinkedList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }

            minFreq = 1 ;
            DLLNode newNode = new DLLNode(key, value);
            DoubleLinkedList currList = freqMap.getOrDefault(1, new DoubleLinkedList());
            currList.addNode(newNode);
            freqMap.put(1, currList);
            cache.put(key, newNode);
        }
    }

    
    public static void updateNode(DLLNode currNode){
        int currFreq = currNode.freq;
        DoubleLinkedList currList = freqMap.get(currFreq);
        currList.removeNode(currNode);
        if (currFreq == minFreq && currList.listSize == 0) {
            minFreq++;
        }
        currNode.freq++;
        DoubleLinkedList newList = freqMap.getOrDefault(currNode.freq, new DoubleLinkedList())
        newList.addNode(currNode);
        freqMap.put(currNode.freq, newList);
    }
    

}
