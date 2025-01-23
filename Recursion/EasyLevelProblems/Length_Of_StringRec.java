package EasyLevelProblems;

public class Length_Of_StringRec {

    public static int calcLength_V1(String str) {
        return str.length();
    }

    public static int calcLength_V2(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
        }
        return count;
    }

    public static int calcLength_V3(String str, int index) {
        if (index == str.length()) {
            return index;
        }

        return calcLength_V3(str, index + 1);
    }

    public static void main(String[] args) {
        String str = "pankaj";
        System.out.println(calcLength_V1(str));
        System.out.println(calcLength_V2(str));
        System.out.println(calcLength_V3(str, 0));

    }
}
