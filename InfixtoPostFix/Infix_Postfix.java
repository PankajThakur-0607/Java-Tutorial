package InfixtoPostFix;
import java.util.*;
public class Infix_Postfix {
    

    // O(2*N) && O(2*N)
    public static int priority(char ch){
        switch (ch) {

            case '^':
            return 3;
            case '*':
            case '/':
            return 2;
            case '+':
            case '-':
            return 1;
            default: 
                return -1;
        }
    }


    public static String infixToPostFix(String str){
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length() ; i++){
            char ch = str.charAt(i);
            
            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            }else if(ch == '('){
                st.push(ch);
            }else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            }else{
                while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                        ans.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        String str = "(c+d)*(a+b)";
        System.out.println(infixToPostFix(str));
    }
}
