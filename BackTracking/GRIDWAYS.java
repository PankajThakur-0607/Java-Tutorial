package BackTracking;

public class GRIDWAYS {
    
    public static int gridWays(int i , int j , int n , int m){
        // base case 
        if (i == n-1 || j == m-1) {
            return 1;
        } else if (i ==n || j == m) {
            return 0;
        }

      int w1 =  gridWays(i+1, j, n, m);
      int w2 = gridWays(i, j+1, n, m);
      return w1 + w2 ;
    }

    public static int Fact (int n ){
        // base case
        if (n == 0) {
            return 1;
        }
        //kaam
        return n * Fact(n-1);
    }

    public static int gridFact(int n ,int m){

      
        int Nf = Fact((n-1) + (m-1));
        int nm1 = Fact(n-1);
        int mm1 = Fact(m-1);

        return Nf/ (nm1*mm1);

    }
    
    public static void main(String[] args) {
        int n = 3 , m = 3;
        // System.out.println(gridWays(0, 0, n, m));
        System.out.println(gridWays(0, 0, n, m));
        
}
}
