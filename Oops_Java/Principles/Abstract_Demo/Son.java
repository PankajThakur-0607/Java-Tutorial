package Principles.Abstract_Demo;

public class Son extends Parent {

    Son(int age) {
        super(age);
    }

    @Override
    public void partner() {
        System.out.println("I Love Anime");
    }

    @Override
    public void career() {
        System.out.println("I am going to be  Doctor");
    }

    public static void main(String[] args) {
        
    }
}
