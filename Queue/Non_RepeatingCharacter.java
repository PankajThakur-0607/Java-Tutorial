import java.util.LinkedList;
import java.util.Queue;

public class Non_RepeatingCharacter {
    


    public static String printNonRepeatingChar(String str){
        StringBuilder ans = new StringBuilder("");

        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        int n = str.length();
        for(int i = 0 ; i < n ; i++ ){
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                ans.append('#');
            }else{
                ans.append(q.peek());
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        System.out.println(printNonRepeatingChar(str));
    }
}
