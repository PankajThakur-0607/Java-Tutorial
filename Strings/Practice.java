package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Practice {
    
    public static void main(String[] args) {
        // String str1 = "Pankaj";
        // char[] arr = {'p' , 'a' , 'n' ,  'k' , 'a' , 'j'};
        // String str2 = new String("Pankaj");

        // System.out.println(str1);
        // System.out.println(str2);

        // System.out.println(str1.equals(str2));
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]);
        // }
        
        // System.out.println();
        // String s = str1;
        // str1 = str1.concat(" thakur");
        // System.out.println(str1);
        // System.out.println(s);


        // Tokenizer 

        // String str = "hello Pankaj";

        // StringTokenizer st1 = new StringTokenizer(str , " ");

        // while (st1.hasMoreTokens()) {
        //     System.out.println(st1.nextToken());
        // }

        // StringTokenizer st2 = new StringTokenizer("JAVA : PYTHON : C++ " , " :");
       
        // System.out.println(st2.countTokens());
        // while (st2.hasMoreTokens()) {
        //     System.out.println(st2.nextToken());
        // }
        // System.out.println(st2.countTokens());
        // System.out.println();
        
        // StringTokenizer st3 = new StringTokenizer("JAVA PYTHON :  C " , ":+*" , true);
        
        // while (st3.hasMoreTokens()) {
        //     System.out.println(st3.nextToken());
        // }


        HashMap<Character , Integer> map = new HashMap<>();

        map.put('a', 1);
        map.put('b', 1);
        map.put('c', 1);
        map.put('d', 1);
        map.put('e', 1);
        map.put('a', 1);

        map.replace('b', 25);
        
        // System.out.println(map);
        // System.out.println(map.entrySet());
        // System.out.println(map.keySet());
        // System.out.println(map.values());
        // System.out.println();

         Set<Map.Entry<Character,Integer>> s = map.entrySet();
          
        //  System.out.println(s);

        //  map.forEach(
            // (key , value) -> System.out.println(key + "->" +   value));

            for (Map.Entry<Character,Integer> entry : map.entrySet()) {
                entry.setValue(5);
                System.out.println(entry);
            }



    }
}
