package Principles.Abstract_Demo;

public class Main {

    public static void main(String[] args) {
        Son son = new Son(21);
        // son.age = 25;
        System.out.println(son.age);
        son.career();
        son.greeting();
        Parent daughter = new Daughter(32);
        daughter.career();
        daughter.greeting();

        // Parent mom = new Parent(); // we cannot create the object of abstract class
        // mom.career(); // we cannot call the abstract method of abstract class
        Parent.hello(); // we can call the static method of abstract class

        try {
            Parent p = new Son(21);
            p.career();
            p.greeting();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
