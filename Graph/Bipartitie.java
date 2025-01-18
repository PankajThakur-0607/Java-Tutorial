
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartitie {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;

        }

    }
    // graph for bipartite
    // static void createGraph(ArrayList<Edge> graph[]) {
    // int n = graph.length;
    // for (int i = 0; i < n; i++) {
    // graph[i] = new ArrayList<>();
    // }

    // graph[0].add(new Edge(0, 1));
    // graph[0].add(new Edge(0, 2));

    // graph[1].add(new Edge(1, 0));
    // graph[1].add(new Edge(1, 3));

    // graph[2].add(new Edge(2, 0));
    // graph[2].add(new Edge(2, 4));

    // graph[3].add(new Edge(3, 1));
    // graph[3].add(new Edge(3, 4));

    // graph[4].add(new Edge(4, 2));
    // graph[4].add(new Edge(4, 3));

    // }

    // Cycle Graph for Directed Graph
    // graph 1
    // public static void createGraph(ArrayList <Edge> graph[]){

    // for(int i =0; i< graph.length; i++){
    // graph[i] = new ArrayList<>();
    // }

    // graph[0].add(new Edge(0, 1));
    // graph[0].add(new Edge(0, 2));

    // graph[1].add(new Edge(1, 3));

    // graph[2].add(new Edge(2, 3));

    // }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));

    }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {

        int cols[] = new int[graph.length];

        for (int i = 0; i < cols.length; i++) {
            cols[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (cols[i] == -1) {
                q.add(i);
                cols[i] = 0; // yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (cols[e.dest] == -1) {
                            int nextCol = cols[curr] == 0 ? 1 : 0;
                            cols[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (cols[e.dest] == cols[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {

        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest] == true) {
                return true;
            } else if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
            stack[e.dest] = false;
        }
        return false;

    }

    public static void main(String args[]) {

        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // System.out.println(isBipartite(graph));
        System.out.println(isCycle(graph));
    }
}
