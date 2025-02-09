package Principles.Abstract_Demo;

public abstract class Parent {
    int age;

    Parent(int age) {
        this.age = age;
    }

    void greeting() {
        System.out.println("hello Sir ");
    }

    static void hello() {
        System.out.println("Heyyy");
    }

    abstract void partner();

    abstract void career();

    public static void main(String[] args) {

    }
}
