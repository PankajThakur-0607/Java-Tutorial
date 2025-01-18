package InfixtoPostFix;

import java.util.*;

public class InfixToPrefix {
        // O(N + 2N + N)  && O(3N)
    public static int priority(char ch) {

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

    // O(N) && O(N)
    public static StringBuilder reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
       
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            // Swap '(' with ')' and vice versa
            if (ch == '(') {
                reversed.append(')');
            } else if (ch == ')') {
                reversed.append('(');
            } else {
                reversed.append(ch);
            }
        }

        return reversed;
    }

    // O(N) + O(N)
    public static String infixToPrefix(String str) {
        StringBuilder str2 = reverseString(str);
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            } else {
                if (ch == '^') {
                    if (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                        ans.append(st.pop());
                    }

                } else {
                    while (!st.isEmpty() && priority(ch) < priority(st.peek())) {
                        ans.append(st.pop());
                    }
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        str2 = reverseString(ans.toString());
        return str2.toString();

    }

    public static void main(String[] args) {
        String str = "(A+B)*C-D+F";

        System.out.println(infixToPrefix(str));
    }
}
