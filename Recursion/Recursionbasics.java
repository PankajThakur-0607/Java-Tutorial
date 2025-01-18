package Recursion;

public class Recursionbasics {

   public static void printDec(int n) {
      if (n == 1) {
         System.out.println(n);
         return;
      }
      System.out.print(n + " ");
      printDec(n - 1);
   }

   public static void printInc(int n) {

      if (n == 1) {
         System.out.print(n + " ");
         return;
      }
      printInc(n - 1);
      System.out.print(n + " ");
   }

   public static int fact(int n) {
      if (n == 0) {
         return 1;
      }
      int fnm1 = fact(n - 1);
      int fn = n * fact(n - 1);
      return fn;
   }

   public static int calcSum(int n) {
      if (n == 1) {
         return 1;
      }
      int snm1 = calcSum(n - 1);
      int sn = n + snm1;
      return sn;

   }

   public static int fibonacci(int n) {
      if (n == 0 || n == 1) {
         return n;
      }
      int fnm1 = fibonacci(n - 1);
      int fnm2 = fibonacci(n - 2);
      int fn = fnm1 + fnm2;
      return fn;

   }

   public static boolean isSorted(int arr[], int i) {
      if (i == arr.length - 1) {
         return true;
      }
      if (arr[i] > arr[i + 1]) {
         return false;
      }
      isSorted(arr, i + 1);
      return isSorted(arr, i + 1);
   }

   public static int firstOccurance(int arr[], int key, int i) {
      if (i == arr.length) {
         return -1;
      }

      if (arr[i] == key) {
         return i;
      }
      int x = firstOccurance(arr, key, i + 1);
      return x;

   }

   public static int lastOccurance(int arr[], int key, int i) {
      if (i == arr.length) {
         return -1;
      }
      int isfound = lastOccurance(arr, key, i + 1);
      if (isfound == -1 && arr[i] == key) {
         return i;
      }
      return isfound;
   }

   public static int power(int x, int n) {
      if (n == 0) {
         return 1;
      }
      int xnm1 = power(x, n - 1);
      int xn = x * xnm1;
      return xn;
   }

   public static int optimizedPower(int a, int n) {
      if (n == 0) {
         return 1;
      }
      int halfpower = optimizedPower(a, n / 2);
      int halfpowerSq = halfpower * halfpower;

      // n is odd
      if (n % 2 != 0) {
         halfpowerSq = a * halfpowerSq;
      }
      return halfpowerSq;
   }

   public static int tilingProblem(int n) { // 2 x n (floor size)

      if (n == 0 || n == 1) {
         return 1;
      }
      // kaam
      // vertical choice
      // int fnm1 = tilingProblem(n-1);

      // //horizontal choice
      // int fnm2 = tilingProblem(n -2);

      // int totalWays = fnm1 + fnm2;

      // return totalWays;
      return tilingProblem(n - 1) + tilingProblem(n - 2);
   }

   public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
      if (idx == str.length()) {
         System.out.println(newStr);
         return;
      }
      char currChar = str.charAt(idx);
      if (map[currChar - 'a'] == true) {
         // duplicate
         removeDuplicates(str, idx + 1, newStr, map);
      } else {
         map[currChar - 'a'] = true;
         removeDuplicates(str, idx + 1, newStr.append(currChar), map);
      }
   }

   public static int friendsPairing(int n) {
      if (n == 2 || n == 1) {
         return n;
      }

      // // choice
      // // single
      // int fnm1 = friendsPairing(n-1);

      // // pair
      // int fnm2 = friendsPairing(n-2);
      // int pairWays = (n-1) * fnm2;
      // int totWays = fnm1 + pairWays;
      // return totWays ;
      return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
   }

   public static void printBinStrings(int n, int lastPlace, String str) {
      // base
      if (n == 0) {
         System.out.println(str);
         return;
      }
      // kaam
      printBinStrings(n - 1, 0, str + "0");
      if (lastPlace == 0) {
         printBinStrings(n - 1, 1, str + "1");
      }
   }

   public static void main(String[] args) {
      // int n = 10;
      // printDec(n);
      // System.out.println(fibonacci(25));

      int arr[] = { 3, 2, 4, 5, 6, 2, 7, 5, 2 };
      // //System.out.println(isSorted(arr, 0));
      System.out.println(firstOccurance(arr, 5, 0));

      // System.out.println(power(2, 4));
      // System.out.println(optimizedPower(2, 10));
      // System.out.println(tilingProblem(3));

      // String str = "appnacollege";
      // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

      // System.out.println(friendsPairing(3));
      // printBinStrings(3, 0, "");

   }
}