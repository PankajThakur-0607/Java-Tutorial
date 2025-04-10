import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // Tc -> O(N) && Sc -> O(N)
    public static int factorial(int n) {
        if (n <= 1) {
            return n;
        }

        return n * factorial(n - 1);
    }

    // O(2*row) && O(row)
    public static int getElementValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1;

        }
        long numerator = factorial(row);
        long denominator = factorial(row - col) * factorial(col);
        long nCr = (numerator / denominator);
        return (int) nCr;
    }

    // O(col) && O(1)
    public static int getElementValue_V2(int row, int col) {
        int result = 1;

        for (int i = 0; i < col; i++) {
            result = result * (row - i);
            result = result / (i + 1);
        }

        return result;
    }

    // Function to print the Pascal's triangle

    // O(row ^ 2) && O(row)
    public static List<Integer> getPascalTriangleRow(int row) {
        List<Integer> pascalRow = new ArrayList<>();

        for (int i = 0; i <= row; i++) {
            pascalRow.add(getElementValue(row, i));
        }

        return pascalRow;
    }

    // O(row * col) && O(row)
    public static List<Integer> getPascalTriangleRow_V2(int row) {
        List<Integer> pascalRow = new ArrayList<>();

        for (int i = 0; i <= row; i++) {
            pascalRow.add(getElementValue_V2(row, i));
        }

        return pascalRow;
    }

    public static List<Integer> getPascalTriangleRow_V3(int row) {
        List<Integer> pascalRow = new ArrayList<>();
        int result = 1;
        pascalRow.add(1);
        for (int i = 1; i < row; i++) {
            result = result * (row - i);
            result = result / i;
            pascalRow.add(result);
        }

        return pascalRow;
    }

    // Function to print the Pascal's triangle

    // O(n^3) && O(row ^2)
    public static List<List<Integer>> getPascalTriangle(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pascalTriangle.add(new ArrayList<>(getPascalTriangleRow(i)));
        }

        return pascalTriangle;
    }

    // O(n * row * col) && O(row * col)
    public static List<List<Integer>> getPascalTriangle_V2(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pascalTriangle.add(new ArrayList<>(getPascalTriangleRow_V2(i)));
        }

        return pascalTriangle;
    }

    public static List<List<Integer>> getPascalTriangle_V3(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            pascalTriangle.add(new ArrayList<>(getPascalTriangleRow_V3(i)));
        }

        return pascalTriangle;
    }

    // O(N^2) && O(N^2)
    public static List<List<Integer>> getPascalTriangle_V4(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int R = 0; R < n; R++) {
            List<Integer> pascalRow = new ArrayList<>();

            for (int C = 0; C <= R; C++) {
                if (C == 0 || C == R) {
                    pascalRow.add(1);
                } else {
                    int val = pascalTriangle.get(R - 1).get(C) + pascalTriangle.get(R - 1).get(C - 1);
                    pascalRow.add(val);
                }
            }

            pascalTriangle.add(pascalRow);

        }

        return pascalTriangle;
    }

    public static void main(String[] args) {
        int row = 6;
        int col = 3;

        System.out.println("Value at row " + row + " and column " + col + " is: " +
        getElementValue(row - 1, col));

        // System.out.println(getPascalTriangleRow(row - 1));

        // System.out.println(getPascalTriangle(6));

        // System.out.println("---------------------");
        // System.out.println("Value at row " + row + " and column " + col + " is: " +
        // getElementValue_V2(row - 1, col));

        // System.out.println(getPascalTriangleRow_V2(row - 1));
        // System.out.println(getPascalTriangle_V2(6));

        // System.out.println("---------------------");
        // System.out.println("Value at row " + row + " and column " + col + " is: " +
        // getElementValue_V2(row - 1, col));
        // System.out.println(getPascalTriangleRow_V3(row - 1));
        // System.out.println(getPascalTriangle_V3(6));

        // System.out.println("---------------------");
        // System.out.println("Value at row " + row + " and column " + col + " is: " +
        // getElementValue_V2(row - 1, col));
        // System.out.println(getPascalTriangleRow_V3(row - 1));
        System.out.println(getPascalTriangle_V4(6));

    }
}