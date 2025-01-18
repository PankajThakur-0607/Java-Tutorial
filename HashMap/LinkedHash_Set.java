package HashMap;

import java.util.LinkedHashSet;

public class LinkedHash_Set {
    

    public static void main(String[] args) {
        
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        

        set.add(3);
        set.add(1);
        System.out.println(set);
        set.remove(3);
        set.add(1);
        set.add(5);
        System.out.println(set);

    }
}
