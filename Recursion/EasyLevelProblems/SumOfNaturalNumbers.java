
package EasyLevelProblems;

public class SumOfNaturalNumbers {

    public static int sumOfNaturalNum(int n, int index, int sum) {
        if (index > n) {
            return sum;
        }

        // sum += index ;
        return sumOfNaturalNum(n, index + 1, sum += index);
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println(sumOfNaturalNum(n, 1, 0));
    }
}
