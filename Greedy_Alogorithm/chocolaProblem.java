package Greedy_Alogorithm;

import java.util.*;

public class chocolaProblem {

    public static int minCut(Integer horizontal[], Integer vertical[]) {
        int minCost = 0;
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        Arrays.sort(horizontal, (a, b) -> b - a);
        Arrays.sort(vertical, (a, b) -> b - a);

        while (h < horizontal.length && v < vertical.length) {
            if (horizontal[h] > vertical[v]) {
                minCost += vp * horizontal[h];
                hp++;
                h++;
            } else {
                minCost += hp * vertical[v];
                vp++;
                v++;
            }
        }

        while(h < horizontal.length){
            minCost += vp * horizontal[h];
            hp++;
            h++;
        }

        while (v < vertical.length) { 
            minCost += hp * vertical[v];
            vp++;
            v++;
        }

        return minCost;
    }

    public static void main(String[] args) {
        Integer horizontal[] = { 4, 1, 2 };
        Integer vertical[] = { 2, 1, 3, 1, 4 };

        System.out.println(minCut(horizontal, vertical));
    }

}
