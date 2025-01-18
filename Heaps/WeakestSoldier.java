
package  Heaps;

import java.util.PriorityQueue;


public class WeakestSoldier{

    static class Row implements Comparable<Row> {
        int soldiers ;
        int idx;
        int soldierInRow[];

        public Row(int soldiers , int idx , int soldierInRow[]){
            this.idx = idx ;
            this.soldiers = soldiers;
            this.soldierInRow = soldierInRow;
        }

        @Override
        public  int compareTo(Row r2){
            if (this.soldiers == r2.soldiers) {
                return  this.idx - r2.idx;
            }else{
                return this.soldiers - r2.soldiers;
            }
        }

    } 

    public static int[][] getSoldier(int army[][] , int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i = 0 ; i < army.length ; i++){
            int count = 0;
            for(int j = 0 ; j < army[0].length ; j++){
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i ,army[i] ));
        }

        int ans[][] = new int[k][army[0].length];
        for(int i = 0 ; i < k ; i++){
            Row r1 = pq.poll();
            ans[i] = r1.soldierInRow;
        }

        return  ans;
        
    }
    public static void main(String[] args) {
        
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,1,0},
                        {1,1,1,0}};
        int k = 2 ;
        int[][] ans = getSoldier(army, k);

        for (int[] an : ans) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(an[j] + " ");
            }
            System.out.println();
        }

    }
}