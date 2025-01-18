import java.util.Stack;

public class L_85_MaximumRectangle {
    static int n, m;

    public static int[][] prefixSumMatrix(char matrix[][]) {
        int prefix[][] = new int[m][n];

        for (int col = 0; col < n; col++) {
            int sum = 0;
            for (int row = 0; row < m; row++) {
                sum += matrix[row][col] - '0';
                if (matrix[row][col] == '0') {
                    sum = 0;
                }
                prefix[row][col] = sum;
            }
        }

        return prefix;
    }

    public static int histogram(int[] height) {

        Stack<Integer> st = new Stack<>();
        int n = height.length;
        int maxArea = 0, currArea, nse, pse;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[st.peek()] > height[i]) {
                nse = i;
                int top = height[st.pop()];
                pse = st.isEmpty() ? -1 : st.peek();
                currArea = top * (nse - pse - 1);
                maxArea = Math.max(currArea, maxArea);
            }
            
            st.push(i);
        }
        
        while (!st.isEmpty()) {
            int top = height[st.pop()];
            nse = n ; 
            pse = st.isEmpty() ? -1 : st.peek();
            currArea = top * (nse - pse - 1);
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        char matrix[][] = { { '1', '1', '0', '1',},
                            { '1', '1', '0', '1',},
                            { '1', '1', '1', '1',},
                             };
        m = matrix.length;
        n = matrix[0].length;

        int prefix[][] = prefixSumMatrix(matrix);

        for (int[] idx : prefix) {
            for (int c : idx) {
                System.out.print(c + " ");
            }
            System.out.println();
        }


        System.out.println(histogram(prefix[2]));

    }
}
