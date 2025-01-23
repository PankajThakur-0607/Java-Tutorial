package EasyLevelProblems;

public class ReverseString {

    static class ReverseIterative {
        private String reverse_V1(String str) {
            StringBuilder sb = new StringBuilder(str);

            int i = 0;
            int j = str.length() - 1;
            while (i < j) {
                char ch = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, ch);
                i++;
                j--;
            }

            return sb.toString();
        }

        private static void reverse_V2(char ch[]) {
            int i = 0;
            int j = ch.length - 1;
            while (i < j) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }

        }
    }

    public class Reverse_Recursive {

        public String reverse_V1(String str, StringBuilder sb, int start, int end) {
            if (start >= end) {
                return sb.toString();
            }

            char ch = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, ch);
            return reverse_V1(str, sb, start + 1, end - 1);
        }

        public void reverse_V2(char[] ch, int start, int end) {
            if (start >= end) {
                return;
            }

            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;

            reverse_V2(ch, start + 1, end - 1);

        }
    }

    public static void main(String[] args) {
        String str = "Pankaj";
        System.out.println(str);

        // way 1
        ReverseIterative itr = new ReverseIterative();
        System.out.println(itr.reverse_V1(str));

        // way 2
        char[] charArray = { 'P', 'a', 'n', 'k', 'a', 'j' };
        ReverseIterative.reverse_V2(charArray);
        System.out.println(charArray);

        // Recursive Way
        // way 1

        ReverseString res = new ReverseString();
        ReverseString.Reverse_Recursive rec = res.new Reverse_Recursive();
        System.out.println(rec.reverse_V1(str, new StringBuilder(str), 0, str.length() - 1));

        // way 2
        char[] charArray2 = { 'P', 'a', 'n', 'k', 'a', 'j' };
        rec.reverse_V2(charArray2, 0, charArray2.length - 1);
        System.out.println(charArray2);

    }
}
