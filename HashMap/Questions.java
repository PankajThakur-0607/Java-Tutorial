package HashMap;

import java.util.*;

import EXAMS.forEachLoop;
import LOOPS.star;

public class Questions {


    public static boolean isAnagrams(String s , String t){

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0; i< s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch, 0)+1);
        }

        for(int i = 0; i< t.length(); i++){
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) {
                     map.remove(ch);
                } else{
                    map.put(ch, map.get(ch) - 1);
                }
            } else{
                return false;
            }
        }
        return map.isEmpty();
    }


    public static int countDistinctElmt(int arr[]){

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i< arr.length; i++){
            set.add(arr[i]);
        }

        return set.size();
    }

    public static void unionIntersection(int arr1[] , int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        // Union
        for(int i=0 ; i< arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int i=0; i< arr2.length; i++){
            set.add(arr2[i]);
        }

        System.out.println("Union = " +  set.size());

        // Intersection
        set.clear();
        for(int i=0 ; i< arr1.length; i++){
            set.add(arr1[i]);
        }
        int count = 0;
        for(int i=0; i< arr2.length; i++){
            if (set.contains(arr2[i])) {
                count ++;
                set.remove(arr2[i]);
            }
        }

        System.out.println("Intersection = " + count);
    }


    public static void zeroSumSubarray(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
             //  (sum  ,   idx);

             int sum =0;
             int len = 0;
             for(int j = 0 ; j < arr.length ; j++){
                sum += arr[j];
                if (map.containsKey(sum)) {
                    len = Math.max(len,   j - map.get(sum));
                } else{
                    map.put(sum, j);
                }
             } 

             System.out.println("largest subarray with sumas 0 -> " + len);
    }

    public static String getStart( HashMap<String , String> tickets){  //O(n)

        HashMap<String , String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;  // Starting Point
            }
        }

        return null;
    }

    static class Node{
        int data;
        int hd ;
        Node left;
        Node right;
             public Node(int data){
                this.data = data;
                this.hd = Integer.MAX_VALUE;
                this.left = this.right = null;
             }
    }

    public static void kSubArraySum(int arr[] , int k){
            HashMap<Integer , Integer> map = new HashMap<>();

            map.put(0, 1);
            int sum = 0;
            int count = 0;

            for(int j =0 ; j < arr.length ; j++ ){
                sum += arr[j]; // sum(j)
                if (map.containsKey(sum - k)) {
                     count += map.get(sum - k);
                } 
                
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            System.out.println("The length of sum equal to k -> " + count);
    }



  static class Info{
    Node node ; 
    int hd;
      public Info(Node node , int hd){
        this.node = node;
        this.hd = hd;
      }
  }
     public static  ArrayList<Integer> bottomView(Node root){
     
        Queue<Info> q = new LinkedList<>();
        TreeMap<Integer , Integer> ts = new TreeMap<>();
       
        q.add(new Info(root, 0));
       

        while (!q.isEmpty()) { 
            Info curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            if (node.left!= null) {
                q.add(new Info(node.left, hd-1));
            }

            if (node.right != null) {
                q.add(new Info(node.right, hd +1));
            }

            ts.put(hd, node.data);
}

  ArrayList<Integer> ans = new ArrayList<>();

   for (int i : ts.values()) {
    ans.add(i);
   }
  
   return ans;
}



    public static  void inOrder(Node root){
      if (root == null) {
           return;
      }
       inOrder(root.left);
       System.out.print(root.data + " ");
       inOrder(root.right);
    }



    public static int[] twoSum(int arr[] , int k){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length ; i++){
                int diff = k - arr[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff) , i  };
            }
            map.put(arr[i], i);
           
        }

        return new int[]{};
    }


    public static String frequencySort (String str){
        HashMap<Character , Integer> map = new HashMap<>();

        for(int i=0 ; i< str.length() ; i++){
            char ch = str.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0) +1);
        }

        PriorityQueue<Map.Entry<Character ,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());


        for(Map.Entry<Character ,Integer> e : map.entrySet()){
            pq.add(e);
        }

        StringBuilder res = new StringBuilder();
        while (pq.size() != 0) {
            char ch = pq.remove().getKey();
            int val = map.get(ch);
            while (val != 0) {
                res.append(ch);
                val --;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        //         // Majortiy Element 
        //  int arr[]= {1,3};

        // for(int i = 0; i< arr.length ; i++){   //O(n)

        //         // if (map.containsKey(arr[i])) {
        //         //     map.put(arr[i], map.get(arr[i]) + 1);
        //         // }
        //         // else{
        //         //     map.put(arr[i], 1);
        //         // }

        //         // in 1 line how can we do this code
        //         map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        //     }

        // //    Set<Integer> keySet = map.keySet();
        //    for (Integer key : map.keySet()) {
        //         if (map.get(key) > arr.length / 3) {
        //             System.out.println(key);
        //         }
        //    }


        //    String s = "care";
        //    String t = "race ";
        //    System.out.println(isAnagrams(s, t));


        // // Count distinct element
         
        // int arr[] = {4,3,2,5,6,7,3,4,2,1};
        // System.out.println(countDistinctElmt(arr));
        

        // Union And Inetersection
            int arr1[] = {7,3,9,1};
            int arr2[] = {6,3,9,2,9,4};
            unionIntersection(arr1, arr2);

          
          // // Find Journey from tickets
            // HashMap<String , String> tickets = new HashMap<>();
            // tickets.put("Chennai", "Bengaluru");
            // tickets.put("Mumbai", "Delhi");
            // tickets.put("Goa", "Chennai");
            // tickets.put("Delhi", "Goa");

            // String start = getStart(tickets);
            // System.out.print(start);
            // for (String key : tickets.keySet()) {
            //      System.out.print(" -> " + tickets.get(start));
            //      start = tickets.get(start);
            // }


            // // larget subarray with sum 0 

        //     int arr[] = {15,-2,2,-8,1,7,10,23};
        //    zeroSumSubarray(arr);

           // // Subarray sum equal to k 

        //    int arr[] = {10,2,-2,-10};
        //         int k = -10;
        //         kSubArraySum(arr, k);

                

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.left.right = new Node(10);

        // System.out.println(bottomView(root));


    //     //  TWo Sum
    //     int arr[] = {2,7,15,6};
    //     int k = 21;
    //    int arr1[] = twoSum(arr, k);
    //    for (int i : arr1) {
    //       System.out.println(i);
    //    }
 
    // String str = "book";
    // System.out.println(frequencySort(str));

    
      





    }
}
