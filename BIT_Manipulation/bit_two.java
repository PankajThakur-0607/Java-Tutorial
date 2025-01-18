package BIT_Manipulation;

public class bit_two {

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("even Number");
        } else {
            System.out.println("Odd number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {

            return 1;
        }

    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if (newBit == 0) {
        // return clearIthBit(n, i);
        // } else{;
        // return setIthBit(n, i)
        // }

        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;

    }

    public static int clearIBits(int n , int i) {
        int bitMask = (~0) << i;
        return n & bitMask;
    }
    public static int clearRangeBits(int n , int i , int j){
        int a = (~0)<< (j+1) ;
        int b =  (1 << i)-1 ;
        int bitMask = a|b ;
        return n & bitMask;
    }

    public static boolean isPowerof2(int n ){
        return (n & (n-1)) == 0;
    }

    public static int  countSetBits(int n){
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) { // check LSB
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a , int n){
        int ans = 1 ;
        while (n > 0) {
            if ((n & 1) != 0) { // check LSB
                ans = ans * a;
            }
            a = a*a;
            n = n >>1;
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(5 & 6);
        System.out.println(5 | 6);
        //  System.out.println(6^6);
        System.out.println(-(~6));
        // System.out.println(1 << 4);
        // System.out.println(6 >> 1);
        // System.out.println(7>>2);

        // int n = 8;
        // oddOrEven(n);
        // System.out.println(setIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 0));
        // System.out.println(clearIBits(15, 2));
        // System.out.println(clearRangeBits(10, 2, 4));
        // System.out.println(isPowerof2(9)); 
        // System.out.println(countSetBits(15));
        // System.out.println(fastExpo(5,3));

        // int x = 4, y = 5;
        //  x = x ^ y ;
        //  y = x ^ y ;
        //  x = x ^ y ;
        // System.out.println("x is: " + x + "\n" + "y is: " + y);

        // int x = 6;
        // System.out.println(-~x);

        for(char ch = 'A' ; ch <= 'Z' ; ch++){
            System.out.print((char) (ch|' '));
        }



    }
}
