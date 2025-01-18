package HashMap;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.TreeMap;

public class Linked_HashMap {
    

    public static void main(String[] args) {

       LinkedHashMap<String , Integer> lhm = new LinkedHashMap<>();
        lhm.put("Nepal", 10);
        lhm.put("India", 100);
        lhm.put("US", 50);
        lhm.put("China", 140);


        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Nepal", 10);
        hm.put("India", 100);
        hm.put("US", 50);
        hm.put("China", 140);


        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("Nepal", 10);
        tm.put("India", 100);
        tm.put("US", 50);
        tm.put("China", 140);
        tm.put("Indonesia", 200);



        System.out.println(lhm);
        System.out.println(hm);
        System.out.println(tm);

        
    }
}
