package EasyLevelProblems;

public class FirstUpperCase {

    // O(N) && O(1)
    public static char findFirstUpperCase(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                return ch;
            }
        }
        return '\0';
    }

    // O(N) && O(1)
    public static int findFirstUpperCaseIndex(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                return i;
            }
        }
        return -1;
    }

    // -------------------------------------------------------------------------------
    // TC -> O(N) && Sc -> O(N)
    public static char findFirstUpperCase_rec(String str, int index) {
        if (index == str.length()) {
            return '\0';
        }

        if (Character.isUpperCase(str.charAt(index))) {
            return str.charAt(index);
        }
        return findFirstUpperCase_rec(str, index + 1);
    }

    // TC -> O(N) && Sc -> O(N)
    public static int findFirstUpperCaseIndex_rec(String str, int index) {
        if (index == str.length()) {
            return -1;
        }

        if (Character.isUpperCase(str.charAt(index))) {
            return index;
        }
        return findFirstUpperCaseIndex_rec(str, index + 1);
    }

    public static void main(String[] args) {
        String str = "geeksFoFrgeeKs";
        System.out.println(findFirstUpperCase(str));
        System.out.println(findFirstUpperCaseIndex(str));

        System.out.println(findFirstUpperCase_rec(str, 0));
        System.out.println(findFirstUpperCaseIndex_rec(str, 0));

    }
}
