package Principles.Polymorphism;

public class Main {

    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Shapes circle = new Circle();
        Shapes sq = new Square();
        circle.area();
    }
}
