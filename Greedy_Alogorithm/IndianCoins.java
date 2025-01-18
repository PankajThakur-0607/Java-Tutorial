package Greedy_Alogorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IndianCoins {
    
     

    public static List<Integer> indianCoins(int money){
        Integer[] currency = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int count = 0;
        Arrays.sort(currency, Comparator.reverseOrder());
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < currency.length; i++) {
            while(currency[i] <= money ){
                ans.add(currency[i]);
                money -= currency[i];
                count++;
            }
        }
        System.out.println("count is : " +  count);
        return ans;
    }

    public static void main(String[] args) {
          int money = 590 ; 
          List<Integer> ans = indianCoins(money);
          for (Integer integer : ans) {
                System.out.println(integer);
          }
    }
}
