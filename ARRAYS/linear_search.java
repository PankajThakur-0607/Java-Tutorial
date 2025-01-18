package ARRAYS;

public class linear_search {
    
public static int linearSearch(int numbers[] , int key){
        for(int i =0; i< numbers.length ; i++){

        if(key == numbers[i]){

        return i;
        }
    }
        return -1;
}

    public static void main(String [] args){

        int numbers[] = {2,4,6,8,10,12,14,16};
        int key = 25;
        int index = linearSearch(numbers, key);
        if(index == -1){
            System.out.println("KEY NOT FOUND");
        }
        else{
            System.out.println("key is at index: " + index);
        }
    }
}
