package Heaps;

import java.net.ProtocolFamily;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import ARRAYS.largest;
import Classes.inheritance;
import Heaps.PriorityQueue_PQ.Student.Heap;
import LOOPS.star;

public class PriorityQueue_PQ {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }

        static class Heap {
            ArrayList<Integer> arr = new ArrayList<>();

            public void add(int data) {
                // add at last index
                arr.add(data);

                int x = arr.size() - 1; // x is child index
                int par = (x - 1) / 2; // par is parent index

                while (arr.get(x) < arr.get(par)) { // O(logn)
                    int temp = arr.get(x);
                    arr.set(x, arr.get(par));
                    arr.set(par, temp);

                    x = par;
                    par = (x-1)/2;
                }
            }

            public int peek() {
                return arr.get(0);
            }

            private void heapify(int i) {

                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int minIdx = i;

                if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                    minIdx = left;
                }

                if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                    minIdx = right;
                }

                if (minIdx != i) {
                    // swap
                    int temp = arr.get(i);
                    arr.set(i, arr.get(minIdx));
                    arr.set(minIdx, temp);

                    heapify(minIdx);
                }

            }

            public int remove() {

                int data = arr.get(0);

                // step1 - swap first & last
                int temp = arr.get(0);
                arr.set(0,  arr.get(arr.size() - 1));
                arr.set(arr.size() - 1, temp);

                // step 2
                // remove lastDigit

                arr.remove(arr.size() - 1);


                // heapify
                heapify(0);
                return data;
            }


            public boolean isEmpty(){
                return arr.size() == 0;
            }
        }

    }


    static class Point implements Comparable<Point> {
    
        int x ; 
        int y ; 
        int distSq ;
        int idx ; 

        Point(int x , int y , int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override 
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
        
    }

    public static int connectNropes(int ropes[]){
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < ropes.length ; i++){
            pq.add(ropes[i]);
        }

        int cost =0;
        while (pq.size() > 1) {
             int min1 = pq.remove();
             int min2 = pq.remove();
             cost += min1 + min2;
             pq.add(min1 + min2);
        }

        return cost;
    }

    static class Row implements Comparable<Row> {
     int soldiers;
     int idx;

       public Row(int soldiers , int idx){
            this.soldiers = soldiers;
            this.idx = idx;

        }

        public int compareTo(Row r2){
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
        
    }

    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // pq.add(new Student("A", 4)); //O(logn)
        // pq.add(new Student("B", 5));
        // pq.add(new Student("C", 2));
        // pq.add(new Student("D", 12));
        // while (!pq.isEmpty()) {
        // System.out.println(pq.peek().name + "-> " + pq.peek().rank); //O(1)
        // pq.remove(); //O(logn)
        // }

        // Heap pq = new Heap();
        // pq.add(3);
        // pq.add(5);
        // pq.add(1);
        // pq.add(2);
        // while (!pq.isEmpty()) {
        //      System.out.println(pq.peek() );
        //      pq.remove();
        // }

   // Quesrtion 
   // Nearby cars in 2D plane
        // int pts[][] = {{3,3} , {5,-1} , {-2 , 4}};
        // int k = 2 ;

        // PriorityQueue <Point> pq = new PriorityQueue<>();
        // for(int i = 0; i < pts.length ; i++) {
        //      int distSq = pts[i][0]* pts[i][0] + pts[i][1]*pts[i][1];
        //   pq.add(new Point(pts[i][0], pts[i][1], distSq , i));
           
        // }

        // for(int i = 0; i< k ; i++){
        //     System.out.println("C" + pq.remove().idx);
        // }


        // int ropes[] = {4,3,2,6};
        // System.out.println(connectNropes(ropes));


        int army[][] = {{1,0,0,0},
                         {1,1,1,1},
                         {1,0,0,0},
                         {1,0,0,0}};
        int k = 2;
            PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i = 0 ; i < army.length; i++){
            int count = 0;
            for (int j = 0 ; j < army[0].length; j++){
                count +=  army[i][j] == 1 ? 1 : 0;
              }
              pq.add(new Row(count, i));
        }

        for(int i = 0; i < k ; i++){
            System.out.println("R" + pq.remove().idx);
        }

    }
}
