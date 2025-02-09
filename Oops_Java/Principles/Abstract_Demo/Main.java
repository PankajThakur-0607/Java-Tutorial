package Principles.Abstract_Demo;

public class Main {

    public static void main(String[] args) {
        Son son = new Son(21);
        son.career();
        son.greeting();
        Parent daughter = new Daughter(32);
        daughter.career();

        // Parent mom = new Parent();
        Parent.hello();
        
        
    }
}
