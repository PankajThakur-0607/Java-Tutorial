
 import java.util.Random;
class One_Short {

    public static void printNum(int n ){
        if (n == 6) {
            return ;  
        }

        System.out.println(n);
        printNum(n+1);
    }

  
    public static void main(String[] args) {
        
        // int n = 1 ; 
        // printNum(n);  // n = 5 

        Random rand = new Random();
        long num = rand.nextLong(1000000000000000L , 9999999999999999L);
        System.out.println(num);
       
        int oddSum = 0;
        int evenSum = 0;
        boolean isEven = false;

        while(num > 0) {

            long last_digit = num % 10 ;
            
            if (isEven) {
                evenSum += last_digit ;
                isEven = false;
            } else{
              oddSum += last_digit * 2 ;
                isEven = true ;
            }
            num /= 10 ;
        }

        int totalSum = oddSum + evenSum ;
        System.out.println(totalSum);

        if (totalSum % 10 ==0) {
            System.out.println("It is Valid");
        }else{
            System.out.println("It is not Valid");
        }
        


    
    }

}
