
import java.util.*;

public class Array {
    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    private static int findForgottenNotesBruteForce(int[] notes, int forgottenAmount) {
        for (int i = 0; i < notes.length; i++) {
            int currentSum = 0;

            for (int j = i; j < notes.length; j++) {
                currentSum += notes[j];

                if (currentSum == forgottenAmount) {
                    return j - i + 1;
                } else if (currentSum > forgottenAmount) {
                    break;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Total money Customer has : ");
        int n = sc.nextInt();
        System.out.print("Total notes the laundry man has: ");
        int x = sc.nextInt();
        int arr[] = new int[x];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findForgottenNotesBruteForce(arr, n);

        System.out.print(result);
        sc.close();

    }
}
