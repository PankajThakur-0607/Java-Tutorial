package LOOPS;

import javax.annotation.processing.SupportedSourceVersion;

public class Pattern {

    public static void hollow_rectangle(int totRows , int totCols){
        for(int i =1; i<= totRows ; i++ ){
            // inner loop
            for(int j=1 ; j<= totCols; j++ ){
                if(i == 1 || i == totRows || j ==1 || j== totCols){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void inverted_rotated_pyramid(int n){
        for(int i =1 ; i<=n ; i++){
            //spaces
            for(int j =1 ; j<= n-i ; j++){
                System.out.print(" ");
            }
            //stars
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }


    public static void inverted_half_pyramid_withNum(int n){
        for(int i =1 ; i <= n ; i++){
            for(int j =1; j<= (n-i)+1 ; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    public static void floyd_triangle(int n) {
        int count =1;
        for(int i=1 ; i<=n ; i++){
            for(int j =1; j <=i ; j++){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int n){
        for(int i =1 ; i<=n ; i++){
            for(int j =1; j<=i; j++){
                // even
                if((i+j) %2 == 0){
                    System.out.print("1" + " ");
                }
                else{
                    System.out.print("0" + " ");
                }
                
            }
            System.out.println();
        }
    }

    public static void butterfly(int n) {
        // 1st half
        for(int i =1 ; i<= n; i++){
            //star
            for(int j = 1 ; j<= i ; j++){
                System.out.print("*");
            }
            //spaces
            for(int j = 1; j <= (2 * (n-i)) ; j++){
                System.out.print(" ");
            }
            // stars
            for(int j =1 ; j<= i ; j++){
                System.out.print("*");
            }
            System.out.println();
           
        }
        // 2nd half
        for(int i =n ; i>= 1; i--){
            //star
            for(int j = 1 ; j<= i ; j++){
                System.out.print("*");
            }
            //spaces
            for(int j = 1; j <= (2 * (n-i)) ; j++){
                System.out.print(" ");
            }
            // stars
            for(int j =1 ; j<= i ; j++){
                System.out.print("*");
            }
            System.out.println();
            
        }
    }

    public static void solid_rhombus(int n){
            for(int i =1 ; i<=n ; i++){
                for(int j =1 ; j<= (n-i); j++){
                    System.out.print(" ");
                }           
                for(int j =1 ; j<= n; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
    }

    public static void hollow_rhombus(int n){
        for(int i =1 ; i<=n ; i++){
            //spaces
            for(int j =1 ; j<= (n-i); j++){
                System.out.print(" ");
            }
            // hollow rectangle
            for(int j =1; j<= n; j++){
                if(i == 1 || i == n || j== 1|| j==n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
    }
}

    public static void diamond(int n){
        //1st half
        for(int i =1 ; i<= n ; i++){
            //spaces
            for(int j =1 ; j<= n-i ; j++){
                System.out.print(" ");
            }
            //stars
            for(int j =1 ; j<= (2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //2nd half
        for(int i =n ; i>= 1; i--){
            //spaces
            for(int j =1 ; j<= n-i ; j++){
                System.out.print(" ");
            }
            //stars
            for(int j =1 ; j<= (2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    




    public static void main(String[] args) {
     //   hollow_rectangle(5, 4);
      // inverted_rotated_pyramid(7);
     // inverted_half_pyramid_withNum(5);
    //  floyd_triangle(5);
       // zero_one_triangle(5);
      // butterfly(5);
      //solid_rhombus(5);
     // hollow_rhombus(5);
    // diamond(3);

    }

    public static Pattern compile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compile'");
    }
}
