import java.util.ArrayList;
import java.util.Arrays;

public class GraphRepesentation {

    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

    }

    // Undirected Graph
    // Adjacency Matrix
    public static void adjacencyMatrix(int src, int dest, int matrix[][]) {
        matrix[src][dest] = 1;
        matrix[dest][src] = 1;
    }

    // edge representation
    public static void addEdges(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 3));
        edges.add(new Edge(1, 2, 4));
        edges.add(new Edge(2, 4, 5));
        edges.add(new Edge(2, 3, 3));
    }

    public static void main(String[] args) {
        int V = 5;
        int matrix[][] = new int[V][V];
        adjacencyMatrix(0, 3, matrix);
        adjacencyMatrix(0, 4, matrix);
        adjacencyMatrix(1, 2, matrix);
        adjacencyMatrix(3, 2, matrix);
        adjacencyMatrix(1, 3, matrix);
        adjacencyMatrix(1, 4, matrix);
        adjacencyMatrix(2, 4, matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        ArrayList<Edge> edges = new ArrayList<>();
        addEdges(edges);

        int adjMatrix[][] = new int[edges.size() + 1][edges.size() + 1];
        for (Edge edge : edges) {
            adjMatrix[edge.src][edge.dest] = edge.wt;
            adjMatrix[edge.dest][edge.src] = edge.wt;
        }

        for (int[] is : adjMatrix) {
            System.out.println(Arrays.toString(is));
        }
    }
}
