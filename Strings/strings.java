package Strings;

import java.util.*;

public class strings {
    public static void printLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            int n = str.length();
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            // North
            if (dir == 'N') {
                y++;
            }
            // South
            else if (dir == 'S') {
                y--;
            }
            // East
            else if (dir == 'E') {
                x++;
            }
            // West
            else {
                x--;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);

    }

    public static void main(String[] args) {

        // char arr[] = { 'a' , 'b' , 'c', 'd'};
        // String str = "abcd";
        // String str2 = new String("xyz@#1234");

        // Strings are IMMUTABLE
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(name);
        String fullName = "Pankaj Thakur";
        System.out.println(fullName.length());

        // concatenation
        // String firstName = "Pankaj";
        // String lastName = "Thakur";
        // String fullName = firstName +" " + lastName;
        // System.out.println(fullName);
        // System.out.println(fullName.charAt(5));

        // printLetters(fullName);

        // String str = "pankaj";
        // System.out.println(isPalindrome(str));

        // String path = "WNEENESENNN";
        // System.out.println(getShortestPath(path));

        // String s1 = "Tony";
        // String s2 = "Tony";
        // String s3 = new String("Tony");
        // if(s1 == s2 ){
        //     System.out.println("strings aree equal");
        // }
        // else{
        //     System.out.println("strings aree not equal"); 
        // }

        // if(s1 == s3 ){
        //     System.out.println("strings aree equal");
        // }
        // else{
        //     System.out.println("strings aree not equal"); 
        // }
        // if(s1.equals(s3)){
        //     System.out.println("strings aree equal");
        // }
        // else{
        //     System.out.println("strings aree not equal"); 
        // }
            String str = "hit";
            for (int i = 0; i < str.length(); i++) {
                
                for(char ch = 'a' ; ch<= 'c' ; ch++){
                    char repl[] = str.toCharArray();
                      repl[i] = ch ; 
                    String word  = new String(repl);

                    System.out.println(word);
                    
                }
                
            }
       
        }
    }


