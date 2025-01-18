package Graph_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class CycleDetectionInUnDirectedGraph {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }



    // O(V + E) && O(V + E) + O(V)
    public static boolean detectCycleDfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleDfsUtil(graph, i, vis , -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    // O(V + E) && O(V) + O(V) 
    public static boolean detectCycleDfsUtil(ArrayList<Edge> graph[] , int curr , boolean vis[] , int parent){

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size() ; i++) {
            Edge neighbour = graph[curr].get(i);

            // Case 1 : if not visited
            if (!vis[neighbour.dest]) {
                if (detectCycleDfsUtil(graph, neighbour.dest, vis, curr)) {
                    return true;
                }
            }
            // Case 2 if visited but not my parent
            else if(vis[neighbour.dest] && neighbour.dest != parent){
                return true;
            }
            //  Case 3 Do nothing wait and watch
        }

        return false;
    }

    public static boolean detectCycleBfs(ArrayList<Edge> graph[]){

        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleBfsUtil(graph, i, vis)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static boolean detectCycleBfsUtil(ArrayList<Edge> graph[] , int start , boolean vis[] ){
          
        Queue<Integer> q =  new LinkedList<>();
        q.add(start);
        vis[start] = true;

        int parent[] = new int[graph.length];
        Arrays.fill(parent, -1);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Edge edge : graph[curr]) {
                int neighbour = edge.dest;
                if (vis[neighbour] && neighbour != parent[curr]) {
                    return true;
                }

                if (!vis[neighbour]) {
                    q.offer(neighbour);
                    parent[neighbour] = curr;
                    vis[neighbour] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycleDfs(graph));
        System.out.println(detectCycleBfs(graph));
    }
}
