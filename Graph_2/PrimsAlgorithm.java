package Graph_2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

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

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static class Pair {

        int vertex;
        int cost;

        Pair(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    // O((V + E) log V) && O(2V)
    public static int primsAlgorithm(ArrayList<Edge> graph[], int src) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(src, 0));
        int minCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            System.out.println("vertex : " + curr.vertex + " " + "cost : " + curr.cost);
            if (!vis[curr.vertex]) {
                vis[curr.vertex] = true;
                minCost += curr.cost;
                for (Edge edge : graph[curr.vertex]) {
                    int neighbour = edge.dest;
                    int wt = edge.wt;
                    pq.offer(new Pair(neighbour, wt));
                }
            }

        }

        return minCost;
    }

    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Minimum Cost : " + primsAlgorithm(graph, 0));
    }
}
