package Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Kruskal_Algo {
    static class Edge implements Comparable<Edge>{
        int src; 
        int dest;
        int wt ;

            public Edge(int s , int d , int w){
                this.src = s;
                this.dest = d;
                this.wt = w;
            }

            @Override
            public int compareTo(Edge e2){
                return this.wt - e2.wt;
            }
    }

    public static void createGraph(ArrayList<Edge> edges){
        // edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4;  // vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for (int i = 0; i < par.length; i++) {
             par[i] = i ;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union (int a , int b){
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
             par[parB] = parA;
             rank[parA]++ ;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else{
            par[parB] = parA;
        }
    }

    public static int kruskalAlgo(ArrayList<Edge> edges , int V){

        init();
        Collections.sort(edges);
        int finalCost = 0;
        int count = 0;

        for(int i = 0; count < V-1 ; i++){
            Edge e = edges.get(i); 
            // (src , dest , wt)
            int parA = find(e.src);  // e.src  = a
            int parB = find(e.dest); // e.dest = b 

            if (parA != parB) {
                union(parA, parB);  // next time wapis se n aaye isliye union me add kr rhe h 
                finalCost += e.wt;
                count++ ;
            }
        }
        return finalCost;
        
    }

    public void helper(int [][] image , int sr , int sc , int color , boolean vis[][] , int orgCol){
        if (sr < 0 || sc < 0 || vis [sr][sc] || sr >= image.length || sc>= image[0].length || image[sr][sc]!= orgCol) {
              return;
        }
        vis[sr][sc] = true;

        //left
        helper(image, sr, sc-1, color, vis, orgCol);            
        // right
        helper(image, sr, sc+1, color, vis, orgCol);
        // up 
        helper(image, sr-1, sc, color, vis, orgCol);
        //down
        helper(image, sr +1, sc, color, vis, orgCol);

        image[sr][sc] = color;

    
    }

    public int[][] floodFill(int [][] image , int sr , int sc , int color){
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image , sr , sc, color, vis , image[sr][sc]);
        return image;
    }


    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges); 
        System.out.println(kruskalAlgo(edges, V));
        int floodFill[][] = 
       for(int i = 0; i< )
}
