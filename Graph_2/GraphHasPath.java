package Graph_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphHasPath {

    public static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        // graph[5].add(new Edge(5, 6, 1));

        // graph[6].add(new Edge(6, 5, 1));
    }

    // O(V + E) && O(2V)
    public static boolean hasPath_DFS(ArrayList<Edge> graph[], int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }

        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge curr = graph[src].get(i);
            if (!vis[curr.dest] && hasPath_DFS(graph, curr.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }

    // O(V + E) && O(2V)
    public static boolean hasPath_BFS(ArrayList<Edge> graph[], int src, int dest) {

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(src);
        vis[src] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == dest) {
                return true;
            }

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!vis[e.dest]) {
                    vis[e.dest] = true;
                    q.offer(e.dest);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(hasPath_DFS(graph, 0, 6, new boolean[V]));
        System.out.println(hasPath_BFS(graph, 0, 6));

    }
}
