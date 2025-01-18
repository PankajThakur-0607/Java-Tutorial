

import java.util.Random;

public class ShuffleArr {
    

    public static void randomize(int arr[]){
        int n = arr.length ;
        Random r = new Random();

        
        for(int i = n -1 ; i > 0 ; i--){

            int j = r.nextInt(i + 1);

            int temp = arr[i] ;
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
       
        int arr[] = {1,2,3,4,5,6,7,8};
        randomize(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
