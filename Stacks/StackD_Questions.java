
// import java.util.LinkedList;
import java.util.Stack;

import LOOPS.star;

import java.util.LinkedList;

import Linked_LIST.CircularLL.Node;

// import Linked_LIST.CircularLL.Node;
public class StackD_Questions {
    static class Node {
        Character data;
        Node next;

        public Node(Character data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // public boolean isPalindrome(Node head) {
    //     Stack<Character> s = new Stack<>();
    //     Node slow = head;
    //     boolean isPalindrome = true;
    //     while (slow != null) {
    //         s.push(slow.data);
    //         slow = slow.next;
    //     }

    //     while (head != null) {
    //         char ch = s.pop();
    //         if (head.data == ch) {
    //             isPalindrome = true;
    //         } else {
    //             isPalindrome = false;
    //             break;
    //         }
    //         head = head.next;
    //     }
    //     return isPalindrome;
    // }

    // public static String simplyfyPath (String str){
    //     Stack <String> s = new Stack<>();
    //     StringBuilder res = new StringBuilder();
    //     String p[] = str.split("/");

    //     for (int i = 0; i < p.length; i++) {
    //         if (!s.isEmpty() && p[i].equals("..")) {
    //             s.pop();
    //         } else if (!p[i].equals("") && !p[i].equals("..")&& !p[i].equals(".")) {
    //             s.push(p[i]);
    //         }
    //     }

    //     if (s.isEmpty()) {
    //         return "/";
    //     }

    //     while (!s.isEmpty()) {
    //         res.insert(0, s.pop()).insert(0, "/");
    //     }
    //     return res.toString();
    //  }

    public static String simplyfypath(String str){
        
        Stack <String> s = new Stack<>();
       
        String res = "";
        res += "/";
       for(int i = 0 ; i < str.length() ; i++){
         String dir = "";
        while (i < str.length() && str.charAt(i) == '/') {
                i++ ;
        }

        while (i < str.length() && str.charAt(i) != '/') {
                dir += str.charAt(i);
                i++ ;
        }

        if (dir.equals("..") == true) {
             if (!s.empty()) {
                s.pop();
             }
        } else if (dir.equals(".") == true) {
            continue;
        } else if (dir.length() != 0) {
            s.push(dir);
        }
    }
    
        Stack<String> s2 = new Stack<String>();
        while (!s.empty()) {
               s2.push(s.pop());
        }

        while (!s2.empty()) {
             if (s2.size() != 1) {
                res += (s2.pop() + "/");
             }
             else {
                res += s2.pop();
             }
        }
       
       return res;
    }


	



     public static int maxWater(int height[]){  // doubt 
      
            Stack<Integer> stack = new Stack<>();
            int n = height.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                while ((!stack.isEmpty()) && (height[stack.peek()] < height[i])) {
                    int pop_height = height[stack.peek()];
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int distance = i - stack.peek() - 1;
                    int min_height = Math.min(height[stack.peek()], height[i]) - pop_height;
                    ans += distance * min_height;
                }
                stack.push(i);
            }
            return ans;
        }


   
        public static boolean isPalindrome(Node head){
            Stack <Character> s  = new Stack<>();
            Node temp = head ;
            boolean isPalindrome = false;
            while (temp != null) {
                s.push(temp.data);
                temp = temp.next;
            }

            while (head != null) {
                     char ch = head.data;
                    if (ch == s.peek() ) {
                        isPalindrome = true;
                        s.pop();
                    } else {
                        isPalindrome = false ;
                    }
                    head = head.next;
            }

            return isPalindrome;
        }


        
        
     
    public static void main(String[] args) {
        // LinkedList<Character> ll = new LinkedList<>();
        // StackD_Questions sll = new StackD_Questions();

        // Node one = new Node('A');
        // one.next = new Node('B');
        // one.next.next = new Node('C');
        // one.next.next.next = new Node('B');
        // one.next.next.next.next = new Node('A');

        // System.out.println(isPalindrome(one));




        // Simplyfypath Code
        String str = "/a/./b/../../c/";
        System.out.println(simplyfypath(str));

        // Decoder of a string
        // String str = "3[a2[c]]";
        // System.out.println(decoder(str));

        // int height[] = {7,0,4,2,5,0,6,4,0,6};
        // System.out.println(trap(height));

    }
}


   

