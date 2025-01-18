package Graph_2;

import java.util.ArrayList;


public class CycleDetection_DirectedGraph {
    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges to create a cyclic graph
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 3));

        // Adding edges to create an Acyclic graph
        // graph[0].add(new Edge(0, 1));
        // graph[1].add(new Edge(1, 2));
        // graph[2].add(new Edge(2, 3));
    }

    // O(V+E) && O(2V) + O(V+E) -- > recursive stack
    public static boolean detectCycleDFS(ArrayList<Edge> graph[]) {

        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleDFSUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleDFSUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {

        vis[curr] = true;
        stack[curr] = true;

        for (Edge edge : graph[curr]) {
            int neighbour = edge.dest;
            if (stack[neighbour]) {
                return true;
            }

            if (!vis[neighbour] && detectCycleDFSUtil(graph, neighbour, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }
    
    // it is Wrong we have to use toplogical sort 
    // public static boolean detectCycleBFS(ArrayList<Edge> graph[]) {
    //     boolean vis[] = new boolean[graph.length];
    //     boolean stack[] = new boolean[graph.length];
    //     for (int i = 0; i < graph.length; i++) {
    //         if (detectCycleBFSUtil(graph, i, vis, stack)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }


    // it is Wrong we have to use toplogical sort 
    // public static boolean detectCycleBFSUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(curr);
    //     vis[curr] = true;
    //     stack[curr] = true;

    //     while (!q.isEmpty()) {
    //         int currVertex = q.poll();

    //         for (Edge edge : graph[currVertex]) {
    //             int neighbour = edge.dest;
    //             if (stack[neighbour]) {
    //                 return true;
    //             }

    //             if (!vis[neighbour]) {
    //                 q.offer(neighbour);
    //                 stack[neighbour] = true;
    //                 vis[neighbour] = true;
    //             }
    //         }
    //         stack[currVertex] = false;
    //     }

    //     return false;
    // }

    public static void main(String[] args) {
        int vertices = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        createGraph(graph);
        System.out.println(detectCycleDFS(graph));
        // System.out.println(detectCycleBFS(graph));

    }
}
