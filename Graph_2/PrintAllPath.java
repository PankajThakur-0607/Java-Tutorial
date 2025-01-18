package Graph_2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PrintAllPath {

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

        graph[0].add(new Edge(0, 3)); // only for print all path question

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

    }

    public static void getAllPath_V1(ArrayList<Edge> graph[], int src, int dest, List<List<Integer>> allPath,
            List<Integer> currPath) {
        // Add the current node to the path
        currPath.add(src);

        // If source is the destination, add the current path to all paths
        if (src == dest) {
            allPath.add(new ArrayList<>(currPath));
        } else {

            // Explore all neighbors of the current node
            for (Edge edge : graph[src]) {
                int neighbour = edge.dest;
                getAllPath_V1(graph, neighbour, dest, allPath, currPath);
            }
        }

        currPath.remove(currPath.size() - 1);
    }

    public static List<List<Integer>> printAllPath_V1(ArrayList<Edge> graph[], int src, int dest) {
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        getAllPath_V1(graph, src, dest, allPath, currPath);

        return allPath;
    }

    public static void getAllPath_V2(ArrayList<Edge> graph[], int src, int dest, List<List<Integer>> allPath,
            List<Integer> currPath) {

        // If source is the destination, add the current path to all paths
        if (src == dest) {
            allPath.add(new ArrayList<>(currPath));
            return;
        }

        // Explore all neighbors of the current node
        for (Edge edge : graph[src]) {
            int neighbour = edge.dest;
            // Add the current node to the path
            currPath.add(src);
            getAllPath_V1(graph, neighbour, dest, allPath, currPath);
            currPath.remove(currPath.size() - 1);
        }

    }

    public static List<List<Integer>> printAllPath_V2(ArrayList<Edge> graph[], int src, int dest) {
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        getAllPath_V2(graph, src, dest, allPath, currPath);

        return allPath;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        List<List<Integer>> ans = printAllPath_V1(graph, 5, 1);
        System.out.println(ans);

        System.out.println();
        List<List<Integer>> ans2 = printAllPath_V2(graph, 5, 1);
        System.out.println(ans2);

    }
}
