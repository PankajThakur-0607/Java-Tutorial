package Greedy_Alogorithm;



import java.util.*;



public class Greedy_Practice {

    public static int stringPartition(String str, int n) {

        int l = 0, r = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'R') {
                r++;
            } else if (str.charAt(i) == 'L') {
                l++;
            }

            if (r == l) {
                ans++;
            }
        }
        return ans;
    }

    public static int kthLargestElemnt(int range[], int k) {
    int l = range[0];
    int r = range[1];

        if ((r & 1) >0) {
             int count = (int) Math.ceil((r-l + 1)/2);
            
            if (k > count) {
                return 0;
            } else{

                return (r - 2*k + 2);
            }
        } else{ 
            double count =  Math.ceil((r-l + 1)/2);
           


            if (k > count) {
                return 0;
            } else{
                return (r - 2*k + 1);
            }
            
        }
        
    }


	public static char[] lexo_small(int n, int k){
		char arr[] = new char[n];

        Arrays.fill(arr, 'a');
        for(int i = n-1 ; i >=0 ; i--){

            k = k -i ;
            if (k >= 0) {
                if (k >= 26) {
                    arr[i] = 'z';
                    k = k - 26;
                }

                else{
                    arr[i] = (char) (k + 97 - 1);
                    System.out.println(arr[i]);
                    k = k - arr[i] - 'a' + 1 ;
                }
            } else{
                break;
            }

            k = k+ i;
        }
        return arr;
	}


    public static int buyAndSellStock(int prices[]){

        int maxPrice = 0;
        int buyPrice = Integer.MAX_VALUE;
        for(int i = 0 ; i < prices.length ; i++){
           
           if (buyPrice < prices[i]) {
             int profit = prices[i] - buyPrice;
             maxPrice = Math.max(maxPrice, profit);
           }  else{
            buyPrice = prices[i];
           }


        }
        return maxPrice;
    }


    public static void main(String[] args) {

        // // Maximum Balanced String Partition
        // String str = "LRRRRLLRLLRL";
        // int n = str.length();
        // System.out.println(stringPartition(str, n));



// kth odd largest element
        int p[] = {-3 , 3};
        

        System.out.println(kthLargestElemnt(p , 1));

        // //Lexicographically smallest string of length N and sum K
        char ch[] = lexo_small(5, 42);
        System.out.println(ch);

        // int prices[] = {7,1,5,3,6,4};
        // System.out.println(buyAndSellStock(prices));





    

        


       

       

    }
}
