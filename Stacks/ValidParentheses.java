
import java.util.Stack;


public class ValidParentheses {
    
    public static boolean validParenthesis(String str){
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(st.isEmpty() || ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
                continue;
            }

            if (ch == ')') {
                if (st.peek() == '(') {
                    st.pop();
                }else{
                    return false;
                }
            }else if (ch == ']') {
                if (st.peek() == '[') {
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch == '}'){
                if (st.peek() == '{') {
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        return st.size() == 0;
        
    }

    public static void main(String[] args) {
            String str = "()[]]";
        System.out.println(validParenthesis(str));
    }
}
