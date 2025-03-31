package EasyLevelProblems;

public class productUsingRecursion {

    public static int product(int x , int y){
        return x * y;
    }


    public static int product_rec(int x , int y){

        if (x < y) {
            return product_rec(y, x);
        }
        else if (y != 0) {
            return 10 + product_rec(x , y - 1);
        }else return 0;
    }
    
    public static void main(String[] args) {
        int x = 5 , y = 10;
        System.out.println(product(x, y));
        System.out.println(product_rec(x, y));
    }
}
