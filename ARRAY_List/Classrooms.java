package ARRAY_List;

import java.util.ArrayList;
import java.util.Collections;

import ARRAYS.Array;

public class Classrooms {

  public static void swap(ArrayList<Integer> list) {
    int temp = list.get(1);
    list.set(1, list.get(4));
    list.set(4, temp);

  }

  // public static int storeWater (ArrayList<Integer> height ){
  //   int maxWater = 0 ;  // O(n ^2)
  //   for(int i = 0 ; i < height.size() ; i++){
  //     for(int j = i +1 ; j < height.size() ; j++){
  //         int ht = Math.min(height.get(i) , height.get(j));
  //         int wdth = j - i ;
  //         int waterStore = ht * wdth;
  //         maxWater = Math.max(maxWater, waterStore);
  //     }
  //   }
  //   return maxWater;
  // }

      // 2 pointer approach 
  public static int storeWater (ArrayList <Integer> height){
      int maxWater = 0 ;
      int lp = 0; 
      int rp = height.size()-1 ;

      while (lp < rp) {
          // calculate water area
          int ht = Math.min(height.get(lp),height.get(rp));
          int width = rp - lp;
          int waterStored = ht * width;
          maxWater = Math.max(maxWater, waterStored);
          // update pointer 
          if (height.get(lp) < height.get(rp)) {
            lp++ ;
          } else{
            rp-- ;
          }
          
          
      }
      return maxWater;
  }


  public static boolean pairSum(ArrayList<Integer> list  , int target){

    for(int i = 0 ; i < list.size() ; i++){
      for(int j = i+1 ; j < list.size() ; j++){
        if (list.get(i) + list.get(j) == target) {
           return true ;
        }
      }
    }
    return false;
  }


  // 2 pointer approach 
  public static boolean pairSum1 (ArrayList <Integer> list , int target){

    int lp = 0 , rp = list.size()-1;
    while (lp != rp) {
       if (list.get(lp) + list.get(rp) == target) {
          return true;
       }

       if (list.get(lp) + list.get(rp) < target) {
          lp++ ;
       } else{
        rp -- ;
       }
    }
    return false;
  }

  public static boolean pairSum2(ArrayList<Integer> list , int target){
      int bp = -1 ;
      for(int i =0 ; i < list.size() ; i++){
        if (list.get(i) > list.get(i+1)) {
           bp = i;
           break;
        }
      }
        int lp = bp +1 ;
        int rp = bp ;
        int n = list.size();
      while (lp!= rp ) {
        if (list.get(lp) + list.get(rp) == target) {
            return true ;
        }
        if (list.get(lp) + list.get(rp) < target) {
          lp = (lp+1) % n ;
        } else{
          rp = (n + rp -1) % n;
        }
      }

      return false;
  }
  
  public static void main(String[] args) {
    // String | Boolean | Float | Integer
    // Classname objectName = new Classname();
    // ArrayList<Integer> list = new ArrayList<>();
    // ArrayList<String> list2 = new ArrayList<>();
    // ArrayList<Boolean> list3 = new ArrayList<>();

    // // Add element
    // list.add(1); // O(1)
    // list.add(2);
    // list.add(3);
    // list.add(4);
    // list.add(5);
    // System.out.println(list);

    // list.add(3, 5); // O(n)
    // System.out.println(list);

    // // Get element ---> O(1)
    // int element= list.get(3);
    // System.out.println(element);

    // // Delete O(n)
    // list.remove(2);
    // System.out.println(list);

    // // set elements O(n)
    // list.set(2, 10);
    // System.out.println(list);

    // // Contains Element O(n)
    // System.out.println(list.contains(26));
    // System.out.println(list.contains(2));

    // System.out.println(list.size());

    // // print the arrayList
    // for (int i = 0; i < list.size(); i++) {
    // System.out.print(list.get(i) + " ");
    // }

    // reverse of an array
    // for(int i = list.size()-1 ; i >= 0 ; i--){ // O(n)
    // System.out.print(list.get(i) + " ");
    // }

    // // Swap 2 Numbers
    // list.add(6); // O(1)
    // list.add(2);
    // list.add(9);
    // list.add(4);
    // list.add(1);

    // System.out.println(list);
    // // swap(list);
    // // System.out.println(list);
    // Collections.sort(list); // ascdending order
    // System.out.println(list);

    // Collections.sort(list , Collections.reverseOrder());
    // System.out.println(list);

    // Multi dimensional Array
    // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

    // ArrayList <Integer> list1 = new ArrayList<>();
    // list1.add(1) ; list1.add(2);
    // mainList.add(list1);

    // ArrayList <Integer> list2 = new ArrayList<>();
    // list2.add(3); list2.add(4);

    // mainList.add(list2);

    // for(int i = 0 ; i < mainList.size() ; i++){
    // ArrayList<Integer> currList = mainList.get(i);
    // for (int j = 0; j < currList.size(); j++) {
    // System.out.print(currList.get(j) + " ");
    // }
    // System.out.println();
    // }

    // System.out.println(mainList);

    // // multidimensional Array
    // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

    // ArrayList<Integer> list1 = new ArrayList<>();
    // ArrayList<Integer> list2 = new ArrayList<>();
    // ArrayList<Integer> list3 = new ArrayList<>();
    // for(int i = 1 ; i<= 5 ; i++){
    // list1.add(i*1);
    // list2.add(i*2);
    // list3.add(i*3);
    // }

    // mainList.add(list1);
    // mainList.add(list2);
    // mainList.add(list3);

    // list2.remove(3);
    // list2.remove(2);
    // mainList.remove(list3);

    // for(int i = 0 ; i < mainList.size() ; i++){
    // ArrayList<Integer> currList = mainList.get(i);
    // for(int j = 0 ; j < currList.size() ; j++){
    // System.out.print(currList.get(j) + " ");
    // }
    // System.out.println();
    // }

    // System.out.println(mainList);


    // container with most water 
    ArrayList<Integer> height = new ArrayList<>();
    // 1,8,6,2,5,4,8,3,7
    height.add(1);
    height.add(8);
    height.add(6);
    height.add(2);
    height.add(5);
    height.add(4);
    height.add(8);
    height.add(3);
    height.add(7);
    
    // System.out.println(storeWater(height));

    //     // pair Sum 
    // ArrayList <Integer> list = new ArrayList<>();
    // // 1,2,3,,4,5,6 
    // list.add(1);
    // list.add(2);
    // list.add(3);
    // list.add(4);
    // list.add(5);
    // list.add(6);
    // int target = 15;
    // System.out.print(pairSum1(list , target));
    

    ArrayList <Integer> list = new ArrayList<>();
    // 11,15,6,8,9,10  - Soretd & rotated 
    list.add(11);
    list.add(15);
    list.add(6);
    list.add(8);
    list.add(9);
    list.add(10);
    int target = 30; 
    System.out.println(pairSum2(list, target));


  }
}
