import java.util.Arrays;

public class SieveOfEraosthenes {

    // Solution 1
    // Time Complexity: O(n * log(log(n)))
    // Space Complexity: O(n)
    public static boolean[] seiveOfEratoSthenes_V1(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {

            for (int j = 2 * i; j <= n; j += i) {

                isPrime[j] = false;
            }

        }
        return isPrime;
    }

    // Solution 1
    // Time Complexity: O(n * log(log(n)))
    // Space Complexity: O(n)
    public static boolean[] seiveOfEratoSthenes_V2(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {

            for (int j = 2 * i; j <= n; j += i) {

                isPrime[j] = false;
            }

        }
        return isPrime;
    }

    public static void main(String[] args) {
        boolean isPrime[] = seiveOfEratoSthenes_V1(20);

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.println(i + "  ");
            }

        }
        System.out.println();

        boolean isPrime2[] = seiveOfEratoSthenes_V2(20);
        for (int i = 0; i < isPrime2.length; i++) {
            if (isPrime2[i]) {
                System.out.println(i);
            }
        }
    }
}
