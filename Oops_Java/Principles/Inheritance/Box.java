package Principles.Inheritance;

public class Box {
     double l;
    double h;
    double w;

    Box() {
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    // cube

    Box(double l, double w, double h) {
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

    }
}
