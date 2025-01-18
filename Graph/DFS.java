import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

    public static List<List<Integer>> adjList(int V, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    public static int[][] adjMatrix(int V, int edges[][]) {
        int[][] graph = new int[V][V];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        return graph;
    }

    public static List<Integer> dfs(List<List<Integer>> adjcencyList) {
        boolean vis[] = new boolean[adjcencyList.size()];
        List<Integer> ans = new ArrayList<>();
        dfsUtil(adjcencyList, adjcencyList.size(), vis, 0, ans);
        return ans;
    }

    public static void dfsUtil(List<List<Integer>> adjcencyList, int V, boolean vis[], int curr, List<Integer> ans) {
        vis[curr] = true;
        ans.add(curr);

        for (int neigh : adjcencyList.get(curr)) {
            if (!vis[neigh]) {
                dfsUtil(adjcencyList, V, vis, neigh, ans);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int edges[][] = {
                { 0, 2 }, { 0, 3 }, { 0, 1 }, { 2, 4 }
        };
        List<List<Integer>> adjcencyList = adjList(V, edges);
        System.out.println(adjcencyList);

        int[][] adjcencyMatrix = adjMatrix(V, edges);
        for (int[] list : adjcencyMatrix) {
            System.out.println(Arrays.toString(list));
        }
        System.out.println();
        List<Integer> ans = dfs(adjcencyList);
        System.out.println(ans);
    }
}
