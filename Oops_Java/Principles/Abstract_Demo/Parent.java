package Principles.Abstract_Demo;

public abstract class Parent { // we cannot use final keyword with abstract class because it wont be inherted by the child class and we cannot create the object of abstract class .
    final int age;  // can be final or not

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
