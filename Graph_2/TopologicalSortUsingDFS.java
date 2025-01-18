package Graph_2;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class TopologicalSortUsingDFS {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }

        // graph[0].add(new Edge(0, 3)); // only for print all path question

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

    }

    // O(V + E) && O(3V) + O(V + E)
    public static List<Integer> topologicalSortDFS(ArrayList<Edge> graph[]) {
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[graph.length];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSortDFSUtil(graph, i, vis, st);
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    public static void topologicalSortDFSUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> st) {
        vis[curr] = true;

        for (Edge edge : graph[curr]) {
            int neighbour = edge.dest;
            if (!vis[neighbour]) {
                topologicalSortDFSUtil(graph, neighbour, vis, st);
            }
        }
        st.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        List<Integer> ans = topologicalSortDFS(graph);
        System.out.println(ans);
    }
}
