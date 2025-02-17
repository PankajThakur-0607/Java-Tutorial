public class LC_152_Maximum_Product_Subarr {

    public static int maxProduct(int arr[]) {
        int prefix = 1;
        int suffix = 1;

        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;

            prefix = prefix * arr[i];
            suffix = suffix * arr[n - i - 1];

            ans = Math.max(ans, Math.max(prefix, suffix));

        }

        return ans;
    }
    
    public static void main(String[] args) {
        int arr[] = { -2, 0, -1 };
        System.out.println(maxProduct(arr));
    }

}
