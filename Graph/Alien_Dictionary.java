
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Alien_Dictionary {


     //    Topologiocal sort using BFS...
    public static void calcIndeg(ArrayList<Integer> graph[], int indeg[] , int V) {
        for (int i = 0; i < V; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                int e = graph[v].get(j);
                indeg[e]++;
            }

        }
    }

    public static List<Integer> topSortBFS(ArrayList<Integer> graph[] , int V) {
        int indeg[] = new int[V];
        calcIndeg(graph, indeg , V);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
           topo.add(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                  int e  = graph[curr].get(i);
                    indeg[e]--;

                    if (indeg[e] == 0) {
                        q.add(e);
                   }
            }

            
        }

       return topo;

    }
    
    public static String alienDict(String dict[] , int N , int K){
        @SuppressWarnings("unchecked")
        ArrayList<Integer> adj[] = new ArrayList[K];

        for(int i =0; i< K ; i++){
           adj[i] = new ArrayList<>();
        }

        for(int i =0; i< N-1 ; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(), s2.length());
            for(int j =0; j< len ; j++){
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj[s1.charAt(j) -'a'].add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topSortBFS(adj, K);

        String ans = "";
        for(int it : topo){
            ans = ans + (char)(it + (int) ('a'));
        }

        return ans;
    }



    public static void main(String[] args) {
        int N = 5 ;
        int K = 4; 
        String dict[] = {"baa" , "abcd" , "abca" , "cab" , "cad"};
        System.out.println(alienDict(dict, N, K));
    }
}
