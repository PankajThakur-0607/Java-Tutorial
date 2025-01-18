package ARRAYS;

public class pairs {
    
    public static void print_pairs(int numbers[] ){ // O(n^2)
        int tp = 0;
       for (int i = 0; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length; j++) {
             System.out.print("(" + numbers[i] + "," + numbers[j] + ")");
             tp++;
        }
        System.out.println();
        
       }
       System.out.println("total pairs is: " + tp);


    }

    public static void main(String args []){
        int numbers[] = {2,4,6,8,10};
        print_pairs(numbers);
    }
}
