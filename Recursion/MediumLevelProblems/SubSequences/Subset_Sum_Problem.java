package MediumLevelProblems.SubSequences;

public class Subset_Sum_Problem {

    // O(2 ^ N) && O(N) where N = arr.length
    public static Boolean isSubsetSum(int arr[], int sum) {
        return isPossible(arr, sum, 0);
    }

    private static Boolean isPossible(int[] arr, int sum, int index) {
        if (sum == 0) {
            return true;
        }

        if (index == arr.length) {
            return false;
        }

        boolean currPick = isPossible(arr, (sum >= arr[index]) ? sum - arr[index] : sum, index + 1);

        boolean currSkip = isPossible(arr, sum, index + 1);

        return currPick || currSkip;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 30;

        System.out.println(isSubsetSum(arr, sum));
    }
}
