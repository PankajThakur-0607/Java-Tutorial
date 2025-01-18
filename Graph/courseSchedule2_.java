package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseSchedule2_ {
    


     public static void calcIndeg(ArrayList<Integer> graph[], int indeg[] , int V) {
        for (int i = 0; i < V; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                int e = graph[v].get(j);
                indeg[e]++;
            }

        }
    }

    public static int[] topSortBFS(ArrayList<Integer> graph[] , int V) {
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

        int course[] = new int[V];
        for(int i =0 ; i< V ; i++){
            course[i] = topo.get(i);
        }

       return course;

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        @SuppressWarnings ("unchecked")
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        for(int i = 0; i< adj.length ; i++){
             adj[i] = new ArrayList<>();
        }

        int m = prerequisites.length;
        for(int i = 0; i< m ; i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        
          return  topSortBFS(adj, numCourses);
        

    }
    


    public static void main(String[] args) {
        
        int[][] prerequisites = {{1,0}};
        int numCourses = 2 ;
        
        int[] arr =  findOrder(numCourses, prerequisites);
        for(int i = 0 ; i< arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        
        
    }
}
