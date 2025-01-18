
public class No_Of_NGEs {


    public static int[] countNGEs(int arr[] , int queries , int indices[] , int n){
        int ans[] = new int[queries];
        for(int i = 0; i < queries ; i++){
            int count = 0 ; 
            for(int idx = indices[i] ; idx < n ; idx++){
                if (arr[indices[i]] < arr[idx]) {
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
    }
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,1};
        int queries = 2 ; 
        int indices[] = {0,3};

        int ans[] = countNGEs(arr, queries, indices, arr.length);
        for (int j = 0; j < ans.length; j++) {
            System.out.println(ans[j]);
        }

    }
}