import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AjacencyList_To_matrix {

    public static int[][] createMatrix(int V, int edges[][]) {
        int matrix[][] = new int[V][V];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        for (int[] list : matrix) {
            System.out.println(Arrays.toString(list));
        }
        return matrix;
    }

    public static ArrayList<Integer>[] createList(int V, int edges[][]) {
        ArrayList<Integer> graph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for (ArrayList<Integer> arrayList : graph) {
            System.out.print(arrayList + " ");
        }
        System.out.println();

        return graph;
    }

    public static void matrixToAdjList(int V, int matrix[][]) {
        ArrayList<Integer> graph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }

        for (ArrayList<Integer> arrayList : graph) {
            System.out.print(arrayList + " ");
        }
    }

    public static void adjToMatrix(int V, ArrayList<Integer> adjList[]) {
        int matrix[][] = new int[V][V];

        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                matrix[i][adjList[i].get(j)] = 1;
            }
        }

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int V = 5, E = 7;
        int edges[][] = {
                { 0, 1 }, { 0, 4 }, { 4, 1 }, { 4, 3 }, { 1, 3 }, { 1, 2 }, { 3, 2 }
        };

        int matrix[][] = createMatrix(V, edges);
        System.out.println();
        ArrayList<Integer>[] list = createList(V, edges);
        System.out.println();
        // matrixToAdjList(V, matrix);

        System.out.println();
        adjToMatrix(V, list);
    }
}
