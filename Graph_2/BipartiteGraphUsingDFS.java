package Graph_2;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphUsingDFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;

        }

    }

    static void createGraph(ArrayList<Edge> graph[]) {
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Connected Components
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));

        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 4));

        // graph[3].add(new Edge(3, 1));
        // // graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 2));
        // // graph[4].add(new Edge(4, 3));

        // disconnected components:
        // Component 1
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        // Component 2
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 3));
        graph[3].add(new Edge(3, 5));

    }

    // O(V + E) && O(V) + O(V)
    public static boolean isBipartiteDFS(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!isBipartiteDFSUtil(graph, i, color, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartiteDFSUtil(ArrayList<Edge> graph[], int node, int color[], int currColor) {
        color[node] = currColor;

        for (Edge edge : graph[node]) {
            int neighbour = edge.dest;

            if (color[neighbour] == -1) {
                currColor = color[node] == 0 ? 1 : 0;
                if (!isBipartiteDFSUtil(graph, neighbour, color, currColor)) {
                    return false;
                }
            } else if (color[node] == color[neighbour]) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartiteDFS(graph));
    }
}
