package HashMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;



public class Hashset {

    public static void main(String[] args) {
        // HashSet<Integer> set = new HashSet<>();

        // set.add(1);
        // set.add(2);
        // set.add(4);
        // set.add(1);
        // set.add(2);

        // System.out.println(set);

        // // remove O(1)
        // // set.remove(2);

        // // contains O(1)
        // // if (set.contains(2)) {
        // // System.out.println("Setc contains 2");
        // // }
        // // if (set.contains(3)) {
        // // System.out.println("Setc contains 3");
        // // }

        // System.out.println(set.size());
        // // set.clear();
        // // System.out.println(set.size());

        // System.out.println(set.isEmpty());
   

        HashSet<String> cities = new HashSet<>();

        cities.add("Mumbai");
        cities.add("Benguluru");
        cities.add(("Noida"));
        cities.add("Pune");
        cities.add("Gurgaon");

        System.out.println(cities);

        // Iterator it = cities.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        // System.out.println();

        // for (String city : cities) {
        //     System.out.println(city);
        // }


        LinkedHashSet<String> lhh = new LinkedHashSet<>();  //O(1)
        lhh.add("Mumbai");
        lhh.add("Benguluru");
        lhh.add(("Noida"));
        lhh.add("Pune");
        lhh.add("Gurgaon");
        

        System.out.println(lhh);


        TreeSet<String> ts = new TreeSet<>();   //O(logn)
        ts.add("Mumbai");
        ts.add("Benguluru");
        ts.add(("Noida"));
        ts.add("Pune");
        ts.add("Gurgaon");
        System.out.println(ts);

    }

}
