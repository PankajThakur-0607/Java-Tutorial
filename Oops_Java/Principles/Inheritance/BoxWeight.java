package Principles.Inheritance;

public class BoxWeight extends Box {

    double weight;

    BoxWeight() {
        weight = -1;
    }

    // @Override

    // static method cannot be overridden as it is not a part of object
    // static void greeting() {
    //     System.out.println("hey , I am in BoxWeight Class . Greeting!");
    // }

    BoxWeight(double l, double h, double w, double weight) {
        super(l, w, h); // what is this ?? in order to get the values of l , h , we have to call parent
                        // class constructor.
        // super is used to initialise the values present in parent class
        this.weight = weight;
        // System.out.println(super.weight);
    }

    public static void main(String[] args) {
        
    }

}
