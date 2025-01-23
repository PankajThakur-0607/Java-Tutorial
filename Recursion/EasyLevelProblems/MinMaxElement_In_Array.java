package EasyLevelProblems;

public class MinMaxElement_In_Array {

    public static void minMaxElement(int arr[]) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = 0;

        for (int i = 0; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
            maxValue = Math.max(maxValue, arr[i]);
        }

        System.out.println("minValue is : " + minValue);
        System.out.println("maxValue is : " + maxValue);
    }

    static int minValue = Integer.MAX_VALUE;
    static int maxValue = 0;
    public static void minMaxElement_Rec(int arr[], int start, int end) {

        // for (int i = 0; i < arr.length; i++) {
        // minValue = Math.min(minValue , arr[i]);
        // maxValue = Math.max(maxValue, arr[i]);
        // }

        // while (start < end) {
        //     minValue = Math.min(minValue, arr[start]);
        //     maxValue = Math.max(maxValue, arr[start]);
        //     start++;
        // }
        
        if (start >= end) {
            return;
        }
        minValue = Math.min(minValue, arr[start]);
        maxValue = Math.max(maxValue, arr[start]);
        minMaxElement_Rec(arr, start + 1, end);



    }
    
    public static void main(String[] args) {
        int arr[] = { 1, 4, 3, -5, -4, 8, 6 };
        // minMaxElement(arr);
        minMaxElement_Rec(arr, 0, arr.length);

        System.out.println("minValue is : " + minValue);
        System.out.println("maxValue is : " + maxValue);
    }
}
