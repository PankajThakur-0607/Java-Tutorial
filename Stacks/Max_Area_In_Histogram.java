import java.util.Stack;
public class Max_Area_In_Histogram {
    
    public static int maxAreaInHistogram_V1(int arr[]){
        int n = arr.length;

        // Step 1 - calculate right Smallest elements;
        int rightSmallElement[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1 ; i>= 0 ; i--){
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                rightSmallElement[i] = n;
            }else{
                rightSmallElement[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();


        // Step -2 claculate the smallest next left element of a number;
        int leftSmallElement[] = new int[n];
        for(int i = 0; i < n ; i++){
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                leftSmallElement[i] = -1;
            }else{
                leftSmallElement[i] = st.peek();
            }
            st.push(i);
        }

        int area = 0;
        int maxArea = 0;
        // Step 3 - calculate max area of a particular index;
        for(int i = 0; i < n ; i++){
            area  = arr[i] * (rightSmallElement[i] - leftSmallElement[i] -1);
            maxArea = Math.max(maxArea , area);
        }

        return maxArea;
    }



    // O(N) + O(N)
    public static int maxAreaInHistogram_V2(int arr[]){

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for(int i = 0 ; i < n ; i++){
            
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                int height = arr[st.pop()];
                int pse = st.size() == 0 ? -1 : st.peek();
                int nse = i;
                maxArea = Math.max(maxArea, height * ( nse - pse - 1));
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            int height = arr[st.pop()];
            int pse = st.size() == 0 ? -1 : st.peek();
            int nse = n;
            maxArea = Math.max(maxArea, height * ( nse - pse - 1));
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int arr[] = {2,4};

        System.out.println(maxAreaInHistogram_V1(arr));
        System.out.println(maxAreaInHistogram_V2(arr));
    }
}
