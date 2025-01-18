package HashMap;
 import java.util.*;
public class Classroom_map {
    

    public static void main(String[] args) {
    
        HashMap<String , Integer> hm = new HashMap<>(); 


        // // insertion - O(1)
        // hm.put("India", 100);
        // hm.put("Nepal", 230);
        // hm.put("US" , 156);
        // hm.put("Indonesia" , 157);
        // hm.put("Bihar" , 113);
        // hm.put("Bhutan" , 189);


        // System.out.println(hm);

        // // Get - O(1)

        // int population = hm.get("India");
        // System.out.println(population);
        // System.out.println(hm.get("Indonesia"));

        // // Contains key - O(1)
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("Indonesia"));


        // // Remove - O(1)
        //  System.out.println(hm.remove("Nepal"));
        //  System.out.println(hm);
        //  System.out.println(hm.remove("Indonesia"));

        // // Size 
        // System.out.println(hm.size());
        // // clear 
        // hm.clear();

        //  // Is Empty
        // System.out.println(hm.isEmpty());


        // // Iterate
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for(String k : keys){
        //     System.out.println("key = " + k +   ", value = " + hm.get(k) );
        // }
        

        HashMap<String , Integer> map = new HashMap<>();
        map.put("a", 10000);
        map.put("b", 55000);
        map.put("c", 44300);
        map.put("e", 21);

      Integer r1 =  map.putIfAbsent("e", 14234);
        // r1 = map.putIfAbsent("e", null);

        System.out.println(r1);

        System.out.println(map);
 

 
          


    }
}
