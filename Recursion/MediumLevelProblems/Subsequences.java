package MediumLevelProblems;

import java.util.ArrayList;

public class Subsequences {

    // TC --> O(2^n) && O(n) --> for all the below Solutions

    public static void subSequence(String str, int index, String ans) {
        if (index == str.length()) {
            System.out.println(ans);
            return;
        }

        subSequence(str, index + 1, ans + str.charAt(index));

        subSequence(str, index + 1, ans);
    }

    public static void subSequence_V2(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subSequence_V2(p, up.substring(1));
        subSequence_V2(p + ch, up.substring(1));
    }

    public static ArrayList<String> subSequence_V3(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> take = subSequence_V3(p + ch, up.substring(1));
        ArrayList<String> skip = subSequence_V3(p, up.substring(1));

        take.addAll(skip);
        return take;
    }

    public static void main(String[] args) {
        String str = "ab";
        // subSequence(str, 0, "");

        // subSequence_V2("", str);

        System.out.println(subSequence_V3("", str));
    }
}
