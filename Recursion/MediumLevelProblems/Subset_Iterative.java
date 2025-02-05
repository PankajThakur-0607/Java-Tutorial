package MediumLevelProblems;

import java.util.ArrayList;
import java.util.List;

public class Subset_Iterative {


    // O(N * 2 ^ N) && O(n * 2^n);
    public static List<List<Integer>> subset_itr(int arr[]) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();

            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        List<List<Integer>> ans = subset_itr(arr);
        System.out.println(ans);

    }
}
