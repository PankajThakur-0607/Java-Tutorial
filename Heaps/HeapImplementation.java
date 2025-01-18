package Heaps;

import java.util.ArrayList;

public class HeapImplementation {
    

   static  class HeapOne {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);
            int child = arr.size()-1;
            int parent = (child - 1) / 2;
            
            // Min Heap
           while (arr.get(child) <  arr.get(parent)) {
                swap(child , parent , arr);
                child = parent;
                parent = (child - 1) / 2;

           }
        
        }

        public int peek(){
            return arr.get(0);
        }

        public  void heapify(int idx){
            int minIdx = idx ;
            int leftChild = 2 * idx + 1;
            int rightChild = 2 * idx + 2;

            if (leftChild < arr.size() && arr.get(leftChild) < arr.get(minIdx)) {
                minIdx = leftChild;
            }
            if (rightChild < arr.size() && arr.get(rightChild) < arr.get(minIdx)) {
                minIdx = rightChild;
            }

            if(minIdx != idx){
                swap(idx, minIdx, arr);
                heapify(minIdx);
            }

        }

        public int remove(){
            int data = arr.get(0);
            swap(0 , arr.size()-1 , arr);
            arr.remove(arr.size()-1);

            heapify(0);

            return data;
        }
        
        public void swap(int i , int j , ArrayList<Integer> arr){
           int temp = arr.get(i);
           arr.set(i, arr.get(j));
           arr.set(j, temp);
        }
        public boolean isEmpty(){
            return  arr.size() == 0;
        }
    }


    public static void main(String[] args) {
        HeapOne pq = new HeapOne();
        pq.add(1);
        pq.add(3);
        pq.add(2);
        pq.add(5);
        pq.add(6);
        pq.add(4);

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }


    }
}
