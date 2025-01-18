 

public class Armstrong {
   
    public static void main (String [] args){

        int n = 371 , originalNumber , r,result = 0;
        originalNumber = n;
        while(originalNumber != 0)
        {
            r = originalNumber%10;
            result += Math.pow(r, 3);
            originalNumber /= 10;

        }
        if(result == n){
            System.out.println("It is a Armstrong numbers");
        }
        else{
            System.out.println(" It is not a Armstrong numbers");
        }

        boolean flag = false;
        if (){
            System.out.println("flag is false");
        }else{
            System.out.println("flag is true");
        }
       
    }
    
}
