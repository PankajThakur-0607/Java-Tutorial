package InfixtoPostFix;

import java.util.Stack;

public class PrefixToPostFix {
    

    public static String prefixToPostFix(String str){
        Stack <String> st = new Stack<>();
        for(int i = str.length()-1 ; i >= 0 ; i--){
            char ch = str.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch) );
            }else{
                String t1 = st.pop();
                String t2 = st.pop();
                String s = t1 + t2 + ch;
                st.push(s);
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        
        String str = "/-AB*+DEF";
        System.out.println(prefixToPostFix(str));
    }
}
