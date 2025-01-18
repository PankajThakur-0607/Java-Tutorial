
import java.util.*;;
public class nextGreaterElement {
    

    public static int[] nextGreaterEle(int arr[]){

        int n  = arr.length;
        int nxtGreater[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        nxtGreater[n-1] = -1;
        
        for(int i = n - 2 ; i >= 0 ; i--){

            while (!st.isEmpty() && arr[i] > arr[st.peek()]  ) {
                    st.pop();
            }
            if(st.isEmpty()){
                nxtGreater[i] = -1;
            }else{
                nxtGreater[i] = arr[st.peek()];
            }

            st.push(i);
 
        }

        return nxtGreater;
    }
    public static void main(String[] args) {
        
        int arr[] = {1,3,2,4};
        int nextGreater[] = nextGreaterEle(arr);
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }

    }
}
