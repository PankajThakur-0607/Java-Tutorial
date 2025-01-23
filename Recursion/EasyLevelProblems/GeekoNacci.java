package EasyLevelProblems;

import java.util.Scanner;

public class GeekoNacci {
    private static int geekoNaci(int a, int b, int c, int n) {
        if (n == 1)
            return a;
        if (n == 2)
            return b;
        if (n == 3)
            return c;

        return geekoNaci(a, b, c, n - 1) + geekoNaci(a, b, c, n - 2) + geekoNaci(a, b, c, n - 3);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Test Cases : ");
        int T = sc.nextInt();

        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int N = sc.nextInt();

            System.out.println("Answer is : " + geekoNaci(A, B, C, N));
        }
    }

}
