package Principles.Inheritance;

public class BoxWeight extends Box {

    double weight;

    BoxWeight() {
        weight = -1;
    }

    BoxWeight(double l, double h, double w, double weight) {
        super(l, w, h); // what is this ?? in order to get the values of l , h , we have to call parent class constructor.
        // super is used to initialise the values present in parent class
        this.weight = weight;
    }

}
