package EasyLevelProblems;

import java.util.ArrayList;

public class sumTriangle {

    static class GetTriangle_V1 {

        private  ArrayList<ArrayList<Integer>> getTriangle(int arr[]) {
            ArrayList<ArrayList<Integer>> allTriangleSum = new ArrayList<>();

            ArrayList<Integer> curr = new ArrayList<>();
            for (int idx : arr) {
                curr.add(idx);
            }
            allTriangleSum.add(curr);
            for (int i = 0; i < arr.length - 1; i++) {
                curr = new ArrayList<>();
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    arr[j] = arr[j] + arr[j + 1];
                    curr.add(arr[j]);
                }

                allTriangleSum.add(curr);
            }

            return allTriangleSum;
        }

    }

    static class GetTriangle_V2 {
        public static ArrayList<Integer> getTraingleReverse(int arr[]) {
            int n = arr.length;
            int[][] storeAllSum = new int[n][n];
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < storeAllSum.length; i++) {
                storeAllSum[n - 1][i] = arr[i];
            }

            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j < i + 1; j++) {
                    arr[j] = arr[j] + arr[j + 1];
                    storeAllSum[i][j] = arr[j];
                }
            }

            for (int i = 0; i < storeAllSum.length; i++) {
                for (int j = 0; j < storeAllSum.length; j++) {
                    if (storeAllSum[i][j] != 0) {
                        ans.add(storeAllSum[i][j]);
                    }
                }
            }
            return ans;
        }

    }

    static class GetTriangle_V3 {

        public static ArrayList<Integer> getTraingleReverse_V2(int arr[]) {
            int n = arr.length;
            ArrayList<ArrayList<Integer>> storeAllSum = new ArrayList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                storeAllSum.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                storeAllSum.get(n - 1).add(arr[i]);
            }

            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j < i + 1; j++) {
                    arr[j] = arr[j] + arr[j + 1];
                    storeAllSum.get(i).add(arr[j]);
                }
            }

            for (ArrayList<Integer> list : storeAllSum) {
                ans.addAll(list);
            }

            return ans;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        // System.out.println(getTriangle(arr));

        // GetTriangle_V1 getTriangle1 = new GetTriangle_V1();
        // System.out.println(getTriangle1.getTriangle(arr));
        
        System.out.println(GetTriangle_V2.getTraingleReverse(arr));
        // int arr2[] = { 1, 2, 3, 4 };
        // System.out.println(getTraingleReverse_V2(arr2));
    }
}
