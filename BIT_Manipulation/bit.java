package BIT_Manipulation;

public class bit {

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0){
            System.out.println("Even Numbers");
        }
        else{
            System.out.println("Odd Numbers");
        }
    }
    public static int getIth(int n , int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0){
            return 0;
        }
        else{
           return 1;
        }
    }
    public static int setIth(int n, int i) {
        int bitMask = 1<<i;
       return n | bitMask;
    }
    public static int clearIth(int n ,int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }
    public static int updateIth(int n , int i, int newBit){
        if(newBit == 0){
           return  clearIth(n, i);
        }
        else{
            return setIth(n, i);
        }
    }

    public static int clearIbits(int n , int i){
        int bitMask = ~0 << i;
        return n & bitMask;

    }
    public static int clearRangeBits(int n , int i , int j){
          int  a = (~0) <<j+1;
           int  b = (1 << i) -1;
           int bitMask = a | b;
           return n & bitMask;
    }
    public static boolean isPowerOfTwo(int n){
         return ( n &(n-1)) == 0;
          
    }
    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            if ( (n & 1) != 0){ // check LSB
                count ++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExpo(int a , int n){
        int ans = 1;
        while(n >0){
            if( (n & 1) != 0){
                ans = ans * a;
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }

        public static void swap(int x , int y){
           int  a = 3;
              int b =4;
          a = a^b;
          b = a^b;
          a = a^b;
            System.out.println(a + " " + b);
        }

        



    public static void main(String[] args) {
        // System.out.println(1 & 8);
        // System.out.println(5 | 6);
        // System.out.println(5 ^ 6);
        // System.out.println(~0);
        // System.out.println(5<<2);
        // System.out.println(6 >>1);
        // oddOrEven(4);
        // oddOrEven(5);
        // oddOrEven(21);



      // System.out.println(fastExpo(5 , 3));
       // swap(3, 4);

    //    int x = 0 ;
    //    System.out.println(-~x);

    // for(char ch = 'A' ; ch <= 'Z' ; ch++){
    //     System.out.println((char)(ch | ' '));
    // }

    System.out.println(6 ^ 7);
    System.out.println(3 << 3);
    System.out.println((float) (5 >> 2));



    }
}
