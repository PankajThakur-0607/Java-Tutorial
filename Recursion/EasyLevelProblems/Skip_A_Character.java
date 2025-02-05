package EasyLevelProblems;

public class Skip_A_Character {

    // O(N) && O(N);
    public static void skipCharacter(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch2 = str.charAt(i);
            if (ch2 == ch) {
                continue;
            }
            sb.append(ch2);
        }

        System.out.println(sb);
    }

    public static void skipCharacter_rec(String str, char ch, int index, StringBuilder ans) {
        if (index == str.length()) {
            System.out.println(ans);
            return;
        }

        if (str.charAt(index) == ch) {
            skipCharacter_rec(str, ch, index + 1, ans);
        } else {
            skipCharacter_rec(str, ch, index + 1, ans.append(str.charAt(index)));
        }

    }

    public static String skipCharacter_rec_V2(String str, char ch, int index, StringBuilder ans) {
        if (index == str.length()) {
            return ans.toString();
        }

        if (str.charAt(index) == ch) {
            return skipCharacter_rec_V2(str, ch, index + 1, ans);
        }

        return skipCharacter_rec_V2(str, ch, index + 1, ans.append(str.charAt(index)));
    }

    public static void skipCharacter_rec_V3(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);

        if (ch == 'a') {
            skipCharacter_rec_V3(str.substring(1), ans);
        } else {
            skipCharacter_rec_V3(str.substring(1), ans + ch);
        }
    }

    public static String skipCharacter_rec_V4(String str) {
        if (str.length() == 0) {
            return "";
        }

        char ch = str.charAt(0);

        if (ch == 'a') {
            return skipCharacter_rec_V4(str.substring(1));
        } else {
            return ch + skipCharacter_rec_V4(str.substring(1));
        }
    }

    public static String skipApples(String str) {

        if (str.length() == 0) {
            return "";
        }

        if (str.startsWith("apple")) {
            return skipApples(str.substring(5));
        } else {
            return str.charAt(0) + skipApples(str.substring(1));
        }
    }

    public static String skipAppNotApple(String str) {

        if (str.length() == 0) {
            return "";
        }

        if (str.startsWith("app") && !str.startsWith("apple")) {
            return skipAppNotApple(str.substring(3));
        } else {
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }

    public static void main(String[] args) {
        String str = "acapplded";
        char ch = 'a';

        // skipCharacter(str, ch);
        // skipCharacter_rec(str, ch, 0, new StringBuilder());

        // skipCharacter_rec_V3(str, "");

        // System.out.println(skipCharacter_rec_V4(str));

        System.out.println(skipApples(str));
        System.out.println(skipAppNotApple(str));
    }
}
