
public class largest {
    public static int getLargest(int numbers[]) {
        int greatest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (greatest < numbers[i]) {
                greatest = numbers[i];
            }
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }
        System.out.println("Smallest number is :" + smallest);
        return greatest;
    }

    public static void main(String args[]) {
        int numbers[] = { 1, 2, 6, 3, 5 };

        System.out.println("Largest number is :" + getLargest(numbers));
    }
}
