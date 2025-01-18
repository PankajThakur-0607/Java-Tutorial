package Strings;

import java.util.Arrays;

public class string_function {
    public static String substring(String str, int si, int ei) {
        String subStr = "";
        for (int i = si; i < ei; i++) {
            subStr += str.charAt(i);
        }
        return subStr;
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        StringBuilder newStr = new StringBuilder(""); // O(n)
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            newStr.append(str.charAt(i));
            if (count > 1) {
                newStr.append(count.toString());
            }

        }
        return newStr.toString();
    }

    public static String checkString(String str) {
        Integer count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        return count.toString();
    }

    public static void anagramString(String str , String str2){
            str = str.toLowerCase();
            str2 = str2.toLowerCase();
        // check if the length are equal
            if(str.length() == str2.length()){
            // convert string into char array
                char [] strcharArray = str.toCharArray();
                char[] str2charArray = str2.toCharArray();
                // sorting the characters in array
                Arrays.sort(strcharArray);
                Arrays.sort(str2charArray);

                boolean result = Arrays.equals(strcharArray, str2charArray);
            if(result){

                System.out.println("The Strings are Anagrams");
            }
            else{
                System.out.println("The Strings are not Anagrams");
            }
         }
         else{
            System.out.println("The Strings are not Anagrams");
         }
    }

    public static void main(String[] args) {
        // Substring
        // String str = "Hello World" ;
        // System.out.println(str.substring(0,5));
        // System.out.println(substring(str, 0, 5));

        // // largest of string
        // String fruits[] = {"apple" , "mango", "banana"};
        // String largest = fruits[0];
        // for(int i = 0; i < fruits.length; i++){
        // if(largest.compareTo(fruits[i]) < 0){ // TC = O(x n)
        // largest = fruits[i];
        // }
        // }
        // System.out.println(largest);

        // StringBuilder sb = new StringBuilder("");
        // for(char ch = 'a' ; ch< 'z' ; ch++){
        // sb.append(ch + " ");
        // } // TC -> O(26)
        // System.out.println(sb);

        // String str = "hii , My name is pankaj";
        // System.out.print(toUpperCase(str));

        // String str = "aaabbcccdd";
        // System.out.println(compress(str));

        // // Count how many times lowercase vowels occurred in a String entered by the
        // user
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the String: ");
        // String str = sc.nextLine();
        // System.out.println("Counts of vowels are: " + checkString(str)) ;

        String str = "raceee";
        String str2 = "care";
        anagramString(str, str2);

    }

}
