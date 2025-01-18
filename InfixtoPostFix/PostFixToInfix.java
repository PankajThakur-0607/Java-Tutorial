package InfixtoPostFix;

import java.util.*;
public class PostFixToInfix {

    // O(N) && O(2Nc)
    public static String postFixToInfix(String str){
        Stack<String> st = new Stack<>();
        for(int i = 0; i < str.length() ; i++){
            char ch = str.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            }else{
                String t1 = st.pop();
                String t2 = st.pop();
                String s = "(" + t2 + ch + t1 + ")";
                st.push(s);
            }
        }

        return st.pop();
    }
    public static void main(String[] args) {
        String str = "AB-DE+F*/";
        System.out.println(postFixToInfix(str));

    }
}
