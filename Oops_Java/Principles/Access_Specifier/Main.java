package Principles.Access_Specifier;

public class Main {

    public static void main(String[] args) {
        A obj = new A(10, "Pankaj", 21);

        // need to do 2 things
        // 1. access the data members
        // 2. modify the data members

        // System.out.println(obj.name);
        // System.out.println(obj.num);
        // obj.setNum(25);
        // System.out.println(obj.getNum());

        System.out.println(obj.age);
    }
}
