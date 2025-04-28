package MediumLevelProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_3286_Find_A_Safe_Walk_Through_A_Grid {

    static int M;
    static int N;
    static int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static boolean canReachLowerBottom(List<List<Integer>> grid, int R, int C, int health) {
        if (R < 0 || R == M || C < 0 || C == N || grid.get(R).get(C) == -1)
            return false;

        health -= grid.get(R).get(C);

        if (health <= 0) {
            return false;
        }

        if (R == M - 1 && C == N - 1) {
            return (health >= 1);
        }

        int cellValue = grid.get(R).get(C);
        grid.get(R).set(C, -1);

        for (int dir[] : directions) {
            int newR = R + dir[0];
            int newC = C + dir[1];
            if (canReachLowerBottom(grid, newR, newC, health))
                return true;
        }

        grid.get(R).set(C, cellValue);

        return false;
    }

    // O(4 ^ (M * N)) && O(M * N)
    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        M = grid.size();
        N = grid.get(0).size();

        return canReachLowerBottom(grid, 0, 0, health);
    }

    public static void main(String[] args) {

        List<List<Integer>> grid = new ArrayList<>(
                Arrays.asList(
                        java.util.Arrays.asList(0, 1, 1, 0, 0, 0),
                        java.util.Arrays.asList(1, 0, 1, 0, 0, 0),
                        java.util.Arrays.asList(0, 1, 1, 1, 0, 1),
                        java.util.Arrays.asList(0, 0, 1, 0, 1, 0)));

        int health = 3;
        System.out.println(findSafeWalk(grid, health));
    }
}
