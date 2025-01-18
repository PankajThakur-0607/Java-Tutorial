package Heaps;

import java.util.ArrayList;

public class Heaps1 {
    

    static class Student implements Comparable<Student> {
        String name ;
        int rank;

        Student(String name , int rank){
            this.name = name ;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
           return this.rank - s2.rank;
        }
    }

    static class Heap{
        ArrayList<Integer> arr =  new ArrayList<>();

        public void add(int data){ // O(logn)
            arr.add(data);
            int child = arr.size() - 1;
            int parent = (child - 1)/2;

            while (arr.get(child) < arr.get(parent)) {
                swap(child, parent, arr);
                child = parent ;
                parent = (child - 1) /2;
            }
        }

        public int peek(){
            return arr.get(0);
        }


        // min heap 
        private void heapify(int idx){
            int leftChild = 2 * idx + 1;
            int rightChild = 2 * idx + 2;
            int minIdx = idx;
           while (leftChild < arr.size() && arr.get(leftChild) < arr.get(minIdx)) {
            minIdx = leftChild;
           }
           while (rightChild < arr.size() && arr.get(rightChild) < arr.get(minIdx)) {
               minIdx = rightChild;
           }

            if (minIdx != idx) {
                swap(minIdx, idx, arr);
                heapify(minIdx);
            }

        }
        public int remove(){
            int data = arr.get(0);

            // swap first & last 
            swap(0, arr.size()-1, arr);

            // Remove last element
            arr.remove(arr.size()-1);

            // step 3 heapify  // O(logn)
            heapify(0);
            return data;
        }

        public void swap (int i , int j , ArrayList<Integer> arr){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }

        public boolean isEmpty(){
            return arr.size() == 0 ;
        }
    }



        

    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        // pq.add(new Student("pankaj", 2));
        // pq.add(new Student("Thakur", 6));
        // pq.add(new Student("Monika", 1));
        // pq.add(new Student("Singh", 3));
        
        // System.out.println(pq);
        // while (!pq.isEmpty()) {
        //     System.out.println(pq.poll().rank);
        // }

        Heap h = new Heap();
        h.add(3);
        h.add(8);
        h.add(5);
        h.add(2);

        while (!h.isEmpty()) {
            System.out.println(h.remove());
        }
    }
}
