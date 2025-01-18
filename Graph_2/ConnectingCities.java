package Graph_2;

import java.util.PriorityQueue;

public class ConnectingCities {

    static class Edge {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public static int connectingCity(int cities[][]) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean vis[] = new boolean[cities.length];
        pq.add(new Edge(0, 0));
        int finalCost = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (!vis[curr.vertex]) {
                vis[curr.vertex] = true;
                finalCost += curr.cost;
                for (int i = 0; i < cities[curr.vertex].length; i++) {
                    if (cities[curr.vertex][i] != 0) {
                        pq.offer(new Edge(i, cities[curr.vertex][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    public static void main(String[] args) {

        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        System.out.println(connectingCity(cities));
    }
}
