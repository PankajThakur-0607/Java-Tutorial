package Graph_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortUsingBFS {

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

    public static void calcIndeg(int indeg[], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            int curr = i;
            for (Edge edge : graph[curr]) {
                int neighbour = edge.dest;
                indeg[neighbour]++;
            }
        }
    }


    // O(V + E) + O(V + E) + O(V) && O(3V)
    public static List<Integer> topologicalSortBFS(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        calcIndeg(indeg, graph); // O(V + E)
        Queue<Integer> q = new LinkedList<>(); // O(V)

        // O(V)
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }


        // BFS   // O(V + E)
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (Edge edge : graph[curr]) {
                int neighbour = edge.dest;
                
                indeg[neighbour]--;
                if (indeg[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        List<Integer> ans = topologicalSortBFS(graph);
        System.out.println(ans);
    }
}
