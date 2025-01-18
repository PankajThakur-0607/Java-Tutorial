
import java.util.*;



public class StackC_Frameworks {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder newStr = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            newStr.append(curr);
        }

        return newStr.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < span.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    public static void nextGreater(int arr[], int nxtGreater[], Stack<Integer> s) {
        // TC --> O(n)
        for (int i = arr.length - 1; i >= 0; i--) {
            // while

            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            // 2 if else
            if (s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }
            // 3 push in s
            s.push(i); // share the address not the elemnt value

            // Greater right
            // greater left
            // samllest left
            // smallest right
        }
    }

    public static boolean isValid(String str) {

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) { // O(n)
            char ch = str.charAt(i);
            // opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
            // closing 
                if ((ch == ')' && s.peek() == '(')
                        || (ch == '}' && s.peek() == '{')
                        || (ch == ']' && s.peek() == '[')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop(); // opening pair remove
                }

            } else {
                // opening
                s.push(ch);
            }
        }

        return false;
    }

    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();
        // Next Smaller Right
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsr[i] = arr.length; // right side me last elemnt length hoti h 
            } else {
                nsr[i] = s.peek() ;
            }

            s.push(i);

        }

        // Next Smaller left
             s = new Stack<>();
        for (int i = 0; i < arr.length - 1; i++) {

            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nsl[i] = -1; // left side me -1 hoti h value if array me value nhi h  
            } else {
                nsl[i] = s.peek() ;
            }

            s.push(i);

        }
         // Current Area  Width = j - i - 1 = nsr[i] - nsl[i];
        for(int i =0 ; i < arr.length ; i++){
            int heigth = arr[i];
            int width = nsr[i] - nsl[i] -1 ;

            int currArea = heigth * width ;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("Max Area is : " + maxArea);
    }

    public static void main(String[] args) {

        // Question 1
        // push at the bottom of the Stack
        Stack <Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom (s , 4);

        while (!s.isEmpty()) {
        System.out.println(s.pop());
        }

        // Question 2
        // Reverse a string using Stack
        // String str = "pankaj";
        // String result = reverseString(str);
        // System.out.println(result);

        // // question 3
        // // revesre a stack
        // Stack <Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // //3 , 2 1
        // reverseStack(s);
        // printStack(s); // 1,2,3

        // // Question 4 --> Stock Span Problem

        // int stocks[] = {100 , 80 , 60, 70, 60 , 85, 100};
        // int span[] = new int[stocks.length];

        // stockSpan(stocks , span);
        // for(int i = 0 ; i < span.length ; i ++){
        // System.out.println(span[i] + " ");
        // }

        // //Questuon 5
        // // Next Greatest Element

        // int arr[] = {5,6,2,8,3,7};
        // Stack <Integer> s = new Stack<>();
        // int nxtGreater[] = new int[arr.length];
        // nextGreater(arr, nxtGreater, s);
        // for (int i = 0; i < nxtGreater.length; i++) {
        // System.out.print(nxtGreater[i] + " ");
        // }

        // // Question 6
        // // Valid Parenthesis
        // String str = "(({})[]))";
        // System.out.println(isValid(str));

        // // Question 7
        // // Duplicate parenthesis

        // String str1 = "((a+b))";
        // String str2 = "(a + b)";

        // System.out.println(isDuplicate(str1 ));

        // Question 8
        // Max area in Histogram

        // int arr[] = { 2, 4 }; // heigths in histogram
        // maxArea(arr);

    }
}
