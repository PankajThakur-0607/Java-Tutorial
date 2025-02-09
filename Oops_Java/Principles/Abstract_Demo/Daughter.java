package Principles.Abstract_Demo;

public class Daughter extends Parent {
    
    public Daughter(int age) {
        super(age);
    }

    @Override
    public void partner() {
        System.out.println("I Love Iron Man");
    }

    @Override
    public void career() {
        System.out.println("I am going to be  HouseWife");
    }

    public static void main(String[] args) {

    }
}
