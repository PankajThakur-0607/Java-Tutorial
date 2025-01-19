

public class practice {

        public static void keyOccurance(int arr[] , int key , int i){
            //base
            if(i == arr.length ){
                return;
            }
            //kaam
             if(arr[i] == key){
                System.out.print(i + " ");
            }
         keyOccurance(arr, key, i + 1);
         
                }

            public static void printDigits(int n) {
                final String digit[]= {"zero" , "one" , "two" , "three" , "four" , "five", "six" , "seven" , "eight" , "nine"};

                // base
                if( n == 0){
                    return;
                }

                int lastDigit = n % 10;
                printDigits(n / 10);
                System.out.print(digit[lastDigit] + " ");
            }


            public static int lenght (String str){
                // base
                if( str.length()== 0){
                    return 0 ;
                }

                // kaam
                
                return lenght(str.substring(1)) +1 ;
            }

            public static int countSubstr(String str , int i , int j , int n){
                // base
                if(n == 1){
                    return 1;
                }
                if(n <= 0){
                    return 0;
                }

                
                // kaam

                int res = countSubstr(str, i + 1, j, n-1) + countSubstr(str, i , j -1, n -1) - countSubstr(str, i + 1, j -1, n -2); 

                if(str.charAt(i) == str.charAt(j)){
                    res++ ;
                }
                return res;
            }


    public static void main(String[] args) {
        // int arr[] = {3,2,4,5,6,2,7,2,2};
        // keyOccurance(arr, 2 , 0); 
       
      //  printDigits(2019);
      
      //System.out.println(lenght("hello"));
      String str = "abcab";
      int n = str.length();
      System.out.println(countSubstr(str, 0, n - 1, n ));
    }
}
