package Principles.Polymorphism;

public class Shapes {

    // with final we cannot override the code
     void area(){ // late binding as it is binded in run time 
        System.out.println("I am in shapes");
    }

    // final void area(){ // late binding as in compile time it is set as it wont be change so in run time the java doesnt have to worry about which method to call 
    //     System.out.println("I am in shapes");
    // }

}
