package EasyLevelProblems;

public class BinarySearch {

    public static int search(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else
                end = mid - 1;
        }

        return -1;
    }

    // -----------------------------------------------------------------------------------------------------------
    public static int search_rec(int arr[], int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return search_rec(arr, target, start, mid - 1);
        }
        return search_rec(arr, target, mid + 1, end);
    }

    public static void main(String[] args) {
        int arr[] = { -1, 0, 3, 5, 9, 12 };
        int target = 5;
        System.out.println(search(arr, target));

        System.out.println(search_rec(arr, target, 0, arr.length - 1));

    }
}
