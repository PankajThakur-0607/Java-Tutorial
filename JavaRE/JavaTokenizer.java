package JavaRE;

import java.util.Stack;
import java.util.StringTokenizer;
public class JavaTokenizer {
    
    public static int countTokens(String str){

        StringTokenizer st = new StringTokenizer(str);

        return st.countTokens();

    }

    public static void printTokens(String str1){
        StringTokenizer st = new StringTokenizer(str1 , "+-/*" , true);

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
            
        }
        StringTokenizer st1 = new StringTokenizer(str1 , "+-/*");

        while (st1.hasMoreTokens()) {
            System.out.println(st1.nextToken());
            
        }



    }

    public static String reverseWords(String s) {
        // We are creating a special tool called StringTokenizer.
        // This tool helps us to separate words in a sentence.
        StringTokenizer st = new StringTokenizer(s);

        // We are creating a special box to keep our words in the correct order.
        // We call this box "result".
        StringBuilder result = new StringBuilder();
        
        // We are going to do something for each word in our sentence.
        // We start by checking if there are more words left.
        while (st.hasMoreTokens()) {
            // We take one word from our sentence.
            String token = st.nextToken();
            System.out.println(token);
            // We put this word at the beginning of our result box.
            // But before that, we put a space so that words don't stick together.
            result.insert(0, token).insert(0, " ");
            // System.out.println(result);
        }

        // We check if there is anything inside our result box.
        // If there is something, we take out the first space we put at the beginning.
        // Then we give the result back to whoever asked for it.
        // If there is nothing inside our box, we give back an empty message.
        return result.length() > 0 ? result.substring(1) : "";
    }

    public static void main(String[] args) {
        
        // String str1 = "Hello Java World";

        // printTokens(str1);
        

        // String str = "Welcome to GeeksforGeeks I hope yOu Are doing well";
        // System.out.println(countTokens(str));

            // System.out.println(reverseWords(str1));


            StringBuilder str = new StringBuilder("the sky is blue");
            System.out.println(str.length());
          

             Stack <String> s = new Stack<>();
             
             s.push(str.toString());

             while (!s.isEmpty()) {
                    System.out.println(s.pop());
             }



        

        
    }
}
