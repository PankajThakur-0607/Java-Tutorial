package Graph_2;

import java.util.*;

public class CheapestFlight {

    static class Edge {

        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    public static class Info {
        int vertex;
        int cost;
        int stops;

        public Info(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }
    
    // O(2 * V+E) +  && O(3V)
    public static int cheapestFlight(int flights[][], int n, int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph); // O(V + E)
        int dist[] = new int[graph.length];  // O(V)
        Arrays.fill(dist, Integer.MAX_VALUE); // O(V)
        dist[src] = 0;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        // O(V + E)
        while (!q.isEmpty()) {
            Info curr = q.poll();

            if (curr.stops > k) {
                break;
            }

            for (Edge edge : graph[curr.vertex]) {
                int v = edge.dest;
                int wt = edge.wt;

                if (curr.cost + wt < dist[v]) {
                    dist[v] = curr.cost + wt;
                    q.offer(new Info(v, dist[v], curr.stops + 1));
                }

            }

        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { 
                            { 0, 1, 100 }, 
                            { 2, 0, 100 }, 
                            { 1, 3, 600 }, 
                            { 2, 3, 200 } };
        System.out.println(cheapestFlight(flights, n, 0, 3, 1));
    }
}
