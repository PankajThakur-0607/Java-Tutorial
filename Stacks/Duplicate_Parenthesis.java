import java.util.Stack;



public class Duplicate_Parenthesis {
    

    public static boolean duplicateParentheses(String str){
        Stack<Character>  st = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(ch != ')'){
                st.push(ch);
            }else{
                int count = 0;
                while (st.peek() != '(' ) {
                    st.pop();
                    count++;
                }
                st.pop();
                if (count < 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b) + (c))";
        System.out.println(duplicateParentheses(str));

    }
}
