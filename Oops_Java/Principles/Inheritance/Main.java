package Principles.Inheritance;

// import static Principles.Inheritance.Box.greeting;

public class Main {

    public static void main(String[] args) {
        // Box cube = new Box(4.4, 1.5, 1.5);
        Box box1 = new Box();
        System.out.println(box1.getL());
        // System.out.println("height is: " + cube.h + " \nwidth is : " + cube.w +
        // "\nlength is : " + cube.l);

        // BoxWeight box2 = new BoxWeight();
        // BoxWeight box3 = new BoxWeight(2.5, 1.5, 7.5, 45);
        // System.out.println(box2.h + " " + box2.weight);
        // System.out.println(box3.h + " " + box3.weight);

        // System.out.println(box1.weight); // parent cannot use child instances and
        // variables
        // System.out.println(box2.h); // child can take parent value

        // type of reference variable determine which method can be used by object
        // reference variable ...
        // here Box can only access h , w , l from the BoxWeight not the weight instance
        // variable ...

        // Box box4 = new BoxWeight(2, 3, 4, 5);
        // System.out.println(box4);

        // there are many variable in both parent and child classes
        // you are given access to variable that are in the ref type i.e BoxWeight
        // hence , you should access weight variable also
        // this also means that the variable you are trying to access should be
        // intialised
        // but here , when the obj itself is of type parent class , how will you call
        // the costructor of the child class .
        // this is why there is error

        // BoxWeight box5 = new Box();
        // System.out.println(box5);

        // BoxWeight box6 = new BoxWeight(1, 1, 1, 1);
        // System.out.println(box6);

        // Box.greeting();
        // greeting();

        // Box box = new BoxWeight();
        // box.greeting(); // you can inherit but you cannot override

    }
}
