import java.util.Scanner;

class FestivalTransport {
    static int minFuelCost(int N, int P, int Q, int busCapacity, int shuttleCapacity) {
        int minFuel = Integer.MAX_VALUE;

        for (int buses = 0; buses <= (N / busCapacity) + 1; buses++) {
            int remainingPeople = N - (buses * busCapacity);
            if (remainingPeople < 0)
                remainingPeople = 0;

            int shuttles = (int) Math.ceil((double) remainingPeople / shuttleCapacity);
            int fuelUsed = (buses * P) + (shuttles * Q);

            minFuel = Math.min(minFuel, fuelUsed);
        }

        return minFuel;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total number of people (N): ");
        int N = scanner.nextInt();

        System.out.print("Enter fuel per bus (P): ");
        int P = scanner.nextInt();

        System.out.print("Enter fuel per shuttle (Q): ");
        int Q = scanner.nextInt();

        System.out.print("Enter bus capacity: ");
        int busCapacity = scanner.nextInt();

        System.out.print("Enter shuttle capacity: ");
        int shuttleCapacity = scanner.nextInt();

        int result = minFuelCost(N, P, Q, busCapacity, shuttleCapacity);
        System.out.println("Minimum fuel required: " + result);

        scanner.close();
    }
}
