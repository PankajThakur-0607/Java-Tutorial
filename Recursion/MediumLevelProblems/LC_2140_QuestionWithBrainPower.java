package MediumLevelProblems;

public class LC_2140_QuestionWithBrainPower {

    public static long helper(int questions[][], int n, int index) {
        if (index >= n) {
            return 0;
        }

        int currPoints = questions[index][0];
        int currBrainPower = questions[index][1];

        long pick = currPoints + helper(questions, n, index + currBrainPower + 1);
        long skip = helper(questions, n, index + 1);

        return Math.max(pick, skip);

    }

    public static long mostPoints(int[][] questions) {
        int n = questions.length;

        return helper(questions, n, 0);
    }

    public static void main(String[] args) {
        int[][] questions = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } };
        System.out.println(mostPoints(questions));
    }
}
