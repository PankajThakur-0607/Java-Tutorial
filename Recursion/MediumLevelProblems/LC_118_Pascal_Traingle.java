package MediumLevelProblems;

import java.util.ArrayList;
import java.util.List;

public class LC_118_Pascal_Traingle {

    public static List<Integer> getRow(int rows , int index ,List<Integer> temp) {
        if (index >= rows) {
            return temp;
        }
        int result = temp.get(index - 1);
        result = result * (rows - index);
        result = result / (index);
        temp.add(result);

        return getRow(rows, index + 1, temp);
    }

    // O(row * row) + O(rows ^ 2)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            ans.add(new ArrayList<>(getRow(i, 1, temp)));
        }

        return ans;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
