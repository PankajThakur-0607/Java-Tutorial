public class LC_91_Decode_Ways {

    public static int numDecodings(String s) {
        int n = s.length();
        return decodeWays(s, 0, n);
    }

    private static int decodeWays(String s, int index, int n) {
        if (index == n) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }

        int nextWays = decodeWays(s, index + 1, n);

        if (index + 1 < n && (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))) {
            nextWays += decodeWays(s, index + 2, n);
        }

        return nextWays;
    }

    public static void main(String[] args) {
        String str = "206";
        System.out.println(numDecodings(str));
    }
}
