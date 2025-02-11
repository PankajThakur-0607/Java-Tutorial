
package Generics;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunction {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arr.add(i + 1);
        }

        Consumer<Integer> fun = (item) -> System.out.println(item * 2);

        // arr.forEach((item) -> {
        // System.out.println(item * 2);
        // });

        // arr.forEach(fun);
        Operation sum = (a, b) -> a + b;
        Operation prod = (a, b) -> a * b;
        Operation sub = (a, b) -> a - b;

        LambdaFunction myCalculator = new LambdaFunction();

        System.out.println(myCalculator.operate(1, 2, sum));

    }

    private int operate(int a, int b, Operation op) {
        return op.operation(a, b);
    }

    public interface Operation {
        int operation(int a, int b);

    }
}
