package Graph_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphUsingBFS {

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

    // O(V + E) && O(2V)
    public static boolean isBipartiteBfs_V1(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isBipartiteBfsUtil_V1(graph, i, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isBipartiteBfsUtil_V1(ArrayList<Edge> graph[], int start, boolean vis[]) {

        Queue<Integer> q = new LinkedList<>();
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        q.add(start);
        color[0] = 0;
        vis[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Edge edge : graph[curr]) {
                int neighbour = edge.dest;

                if (vis[neighbour] && color[curr] == color[neighbour]) {
                    return false;
                }

                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    q.offer(neighbour);
                    color[neighbour] = color[curr] == 0 ? 1 : 0;
                }
            }

        }

        return true;
    }
    
    // O(V + E) && O(V)
    public static boolean isBipartiteBfs_V2(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1); // O(V)

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!isBipartiteBfsUtil_V2(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }


    public static boolean isBipartiteBfsUtil_V2(ArrayList<Edge> graph[], int start, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Edge edge : graph[curr]) {
                int neighbour = edge.dest;

                if (color[neighbour] == -1) {
                    q.offer(neighbour);
                    color[neighbour] = color[curr] == 0 ? 1 : 0;
                } else if (color[curr] == color[neighbour]) {
                    return false;
                }
            }

        }
        return true;
    }



    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(isBipartiteBfs_V1(graph));
        System.out.println(isBipartiteBfs_V2(graph));
    }
}
