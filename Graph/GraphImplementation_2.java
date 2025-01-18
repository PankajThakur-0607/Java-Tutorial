import java.util.ArrayList;

public class GraphImplementation_2 {

    public static void createGraph(int V, int edges[][], ArrayList<Integer> graph[]) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
    }

    public static void createGraph2(int V, int edges[][]) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // System.out.println(graph);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // System.out.println(graph);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // for (ArrayList<Integer> vertices : graph) {
        // System.out.print(vertices + " ");
        // }

        System.out.println(graph);
    }

    public static void main(String[] args) {

        int V = 5, E = 7;
        int edges[][] = {
                { 0, 1 }, { 0, 4 }, { 4, 1 }, { 4, 3 }, { 1, 3 }, { 1, 2 }, { 3, 2 }
        };

        ArrayList<Integer> graph[] = new ArrayList[V];
        createGraph(V, edges, graph);

        // for (ArrayList<Integer> vertices : graph) {
        // System.out.print(vertices + " ");
        // }

        System.out.println();
        createGraph2(V, edges);

    }
}
