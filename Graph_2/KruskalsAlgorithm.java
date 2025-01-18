package Graph_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class KruskalsAlgorithm {

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

    public static class sortByDist implements Comparator<Edge> {
        @Override
        public int compare(Edge e1, Edge e2) {
            return e1.wt - e2.wt;
        }

    }

    public static void createGraph(ArrayList<Edge> edges) {

        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(2, 3, 50));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(0, 2, 15));

    }

    static int n = 4;
    static int[] parent = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;

        } else if (rank[parB] < rank[parB]) {
            parent[parB] = parA;
        } else {
            parent[parA] = parB;
        }
    }

    public static int kruskalAlgo(ArrayList<Edge> edges, int V) {

        // Method 1
        Collections.sort(edges, new sortByDist());
        int count = 0;
        int minCost = 0;
        for (int i = 0; count < V - 1; i++) {
            Edge neigh = edges.get(i);
            int src = neigh.src;
            int dest = neigh.dest;

            int parA = find(src);
            int parB = find(dest);
            if (parA != parB) {
                union(parA, parB);
                minCost += neigh.wt;
                count++;
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        // for (Edge edge : edges) {
        // System.out.print(edge.wt + " ");
        // }
        // System.out.println();
        init();

        // // Method 2
        // Collections.sort(edges , new Comparator<Edge>() {
        // @Override
        // public int compare(Edge e1 , Edge e2){
        // return e2.wt - e1.wt;
        // }
        // });
        // for (Edge edge : edges) {
        // System.out.print(edge.wt + " ");
        // }
        init();

        int ans = kruskalAlgo(edges,V);
        System.out.println(ans);
    }
}
