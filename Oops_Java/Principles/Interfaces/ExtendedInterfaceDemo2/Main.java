package Principles.Interfaces.ExtendedInterfaceDemo2;

class Main implements A, B {

    @Override
    public void greet() {
        System.out.println("greeting");
        Main main = new Main();

        A.greeting();
    }
}
