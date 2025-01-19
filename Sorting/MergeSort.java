package Sorting;

public class MergeSort {

    public static void divide(int nums[], int si, int ei) {

        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        divide(nums, si, mid);
        divide(nums, mid + 1, ei);
        conquer(nums, si, mid, ei);

    }

    public static void conquer(int nums[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= ei) {
            temp[k++] = nums[j++];
        }

        for (int idx1 = 0, idx2 = si; idx1 < temp.length; idx1++, idx2++) {
            nums[idx2] = temp[idx1];
        }
    }

    public static void main(String[] args) {
        int nums[] = { 6, 3, 9, 5, 2, 8 };
        int n = nums.length;
        divide(nums, 0, n - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
