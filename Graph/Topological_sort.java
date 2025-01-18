
import java.util.*;


public class Topological_sort {

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

        // graph[0].add(new Edge(0, 3));  // only for print all path question

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

    }

    // O(V + E )   Topological Sort using DFS..
    public static void topSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }


    //    Topologiocal sort using BFS...
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[] , int V) {
        for (int i = 0; i < V; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }

        }
    }

    public static void topSortBFS(ArrayList<Edge> graph[] , int V) {
        int indeg[] = new int[V];
        calcIndeg(graph, indeg , V);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); // topological sort

            for (int i = 0; i < graph[curr].size(); i++) {
                  Edge e  = graph[curr].get(i);
                    indeg[e.dest]--;

                    if (indeg[e.dest] == 0) {
                        q.add(e.dest);
                   }
            }

            
        }

       System.out.println();

    }

    public static void printAllPath(ArrayList<Edge> graph[] , int src , int dest , String path ){
        if (src == dest) {
             System.out.println(path + dest);
        }

        for(int i = 0; i< graph[src].size(); i++){
            Edge e = graph[src].get(i);
             printAllPath(graph, e.dest, dest, path + src);
        }
        

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph);
        System.out.println();
        topSortBFS(graph , V);

        // print all path
        // printAllPath(graph, 5, 1, "");
    }
}
