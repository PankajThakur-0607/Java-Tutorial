package Principles.Inheritance;

public class Box {
    private double l;
    double h;
    double w;
    // double weight = 5;

    static void greeting(){
        System.out.println("hey , I am in Box Class . Greeting!");
    }

    Box() {
        super(); // to call the constructor of above class
        // here it os Object Class
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    public double getL(){
        return l;
    }
    // cube

    Box(double l, double w, double h) {
        System.out.println("parents constructor");
        this.l = l;
        this.h = w;
        this.w = h;
    }

    Box(Box other) {
        this.h = other.h;
        this.w = other.w;
        this.l = other.l;
    }

    void information() {
        System.out.println("runnnig the information");
    }

    public static void main(String[] args) {
        // greeting();
    }
}
