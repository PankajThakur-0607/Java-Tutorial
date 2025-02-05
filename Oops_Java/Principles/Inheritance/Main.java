package Principles.Inheritance;

public class Main {

    public static void main(String[] args) {
        Box cube = new Box(4.4, 1.5, 1.5);
        System.out.println("height is: " + cube.h + " \nwidth is : " + cube.w + "\nlength is : " + cube.l);

        BoxWeight box2 = new BoxWeight();
        BoxWeight box3 = new BoxWeight(2.5, 1.5, 7.5, 45);
        System.out.println(box2.h + " " + box2.weight);
        System.out.println(box3.h + " " + box3.weight);

    }
}
