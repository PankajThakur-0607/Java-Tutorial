package MediumLevelProblems;

import java.util.ArrayList;
import java.util.List;

public class Subset_Duplicate {

    public static List<List<Integer>> subsetDuplicate_itr(int arr[]) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        int start = 0, end = 0;

        for (int i = 0; i < arr.length; i++) {

            start = 0;
            // if current and previous element is same then s = e + 1 ;

            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }

            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);

            }
        }
        return outer;
    }

    public static void subsetDuplicate_rec(int arr[], int index, List<Integer> curr) {
        if (index == arr.length) {
            System.out.print(curr);
            return;
        }

        curr.add(arr[index]);
        subsetDuplicate_rec(arr, index + 1, curr);
        curr.remove(curr.size() - 1);

        int start = index;
        while (index < arr.length && arr[start] == arr[index]) {
            index++;
        }

        subsetDuplicate_rec(arr, index, curr);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 23 };

        List<List<Integer>> ans = subsetDuplicate_itr(arr);
        System.out.println(ans);

        // Assume the array is sort
        int nums[] = { 1, 2, 3 };
        subsetDuplicate_rec(nums, 0, new ArrayList<>());

    }
}
