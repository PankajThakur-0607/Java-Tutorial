import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // function to get the element from the pascal traingle

    static class GetPascalValues {

        public long getElm_V1(int row, int col) {
            int numerator = factorial(row);
            int denominator = factorial(col) * factorial(row - col);
            long nCr = numerator / denominator;
            return nCr;
        }

        // O(R)
        public long getElm_V2(int row, int col) {

            long result = 1;
            for (int i = 0; i < col; i++) {
                result = result * (row - i);
                result = result / (i + 1);
            }

            return result;
        }

        public List<Long> getRowInTriangle_V1(int row) {
            List<Long> ans = new ArrayList<>();
            for (int i = 0; i <= row; i++) {
                ans.add(getElm_V2(row, i));
            }

            return ans;
        }

        // O(N)
        public List<Long> getRowInTraingle_V2(int row) {
            List<Long> ans = new ArrayList<>();
            ans.add((long) 1);
            long result = 1;
            for (int i = 1; i < row; i++) {
                result = result * (row - i);
                result = result / i;
                ans.add(result);
            }

            return ans;
        }

        public List<List<Long>> printCompleteTiangle_V1(int rows) {
            List<List<Long>> ans = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                ans.add(new ArrayList<>());
            }

            // O(r * i * j) && O(n(n +1) / 2)
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j <= i; j++) {
                    ans.get(i).add(getElm_V2(i, j));
                }
            }

            return ans;
        }

        public List<List<Long>> printCompleteTiangle_V2(int rows) {
            List<List<Long>> ans = new ArrayList<>();

            // O(N * N)
            for (int i = 1; i <= rows; i++) {
                ans.add(new ArrayList<>(getRowInTraingle_V2(i)));
            }

            return ans;
        }

    }

    public static void main(String[] args) {

        int row = 4, col = 2;
        // System.out.println(factorial(6));

        GetPascalValues obj = new GetPascalValues();
        // System.out.println(obj.getElm_V1(row - 1, col - 1));
        // System.out.println(obj.getElm_V2(row - 1, col - 1));

        // System.out.println(obj.getRowInTriangle_V1(row - 1));
        System.out.println(obj.getRowInTraingle_V2(row));

        System.out.println(obj.printCompleteTiangle_V1(4));
        System.out.println(obj.printCompleteTiangle_V2(row));
    }
}
