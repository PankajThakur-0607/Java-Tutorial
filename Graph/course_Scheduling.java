package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ARRAYS.Array;

public class course_Scheduling {


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

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // from a adj
    
        @SuppressWarnings("unchecked")
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        for(int i = 0; i< adj.length ; i++){
             adj[i] = new ArrayList<>();
        }

        int m = prerequisites.length;
        for(int i = 0; i< m ; i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        
        List<Integer> topo = topSortBFS(adj, numCourses);
      if (topo.size() == numCourses) {
           return true;
      }


      return false ;
        

    }

    public static void main(String[] args) {

        int[][] prerequisites = {{1,0}};
        int numCourses = 2 ;

       System.out.println( canFinish(numCourses, prerequisites));


    }
}
