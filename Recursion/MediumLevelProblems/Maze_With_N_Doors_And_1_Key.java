package MediumLevelProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze_With_N_Doors_And_1_Key {

    public static boolean mazeWithNDoorsAnd1Key(ArrayList<ArrayList<Integer>> maze, int n) {

        return helper(maze, n, 0, 0, true);

    }

    private static boolean helper(ArrayList<ArrayList<Integer>> maze, int n, int startRow, int startCol, boolean key) {
        if (startRow >= n || startCol >= n) {
            return false;
        }

        if (maze.get(startRow).get(startCol) == 1 && !key) {
            return false ;
        }
        
        if (maze.get(startRow).get(startCol) == 1 && key) {
            key = false ;
        }
        if (startRow == n - 1 && startCol == n - 1) {
            return true;
        }
        

        boolean down = helper(maze, n, startRow + 1, startCol, key);
        boolean right = helper(maze, n, startRow, startCol + 1, key);

        return down || right;

    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        maze.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        maze.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        maze.add(new ArrayList<>(Arrays.asList(0, 1, 0)));

        System.out.println(mazeWithNDoorsAnd1Key(maze, n));
    }
}