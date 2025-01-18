package Graph_2;

import java.util.ArrayList;

public class BellManFordAlgorithm {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    static void createGraph2(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));
    }

    public static void bellManFordAlgorithm_V1(ArrayList<Edge> graph[], int V, int src) {
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // V - 1 times

        // O(V*E)
        for (int i = 0; i < V - 1; i++) {
            // Edges ; // O(E)
            for (ArrayList<Edge> Edges : graph) {

                for (Edge neighbour : Edges) {
                    int u = neighbour.src;
                    int v = neighbour.dest;
                    int wt = neighbour.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }

                }
            }

        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void bellManFordAlgorithm_V2(ArrayList<Edge> graph, int V, int src) {
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // V - 1 times

        // O(V*E)
        for (int i = 0; i < V - 1; i++) {
            // Edges ; // O(E)
            for (Edge neighbour : graph) {
                int u = neighbour.src;
                int v = neighbour.dest;
                int wt = neighbour.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellManFordAlgorithm_V1(graph, V, 0);

        ArrayList<Edge> edges = new ArrayList<>();
        createGraph2(edges);
        System.out.println();
        bellManFordAlgorithm_V2(edges, V, 0);

    }
}
