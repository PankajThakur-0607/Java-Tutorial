package Principles.Encapsulation;

import Principles.Access_Specifier.A;

public class SubClass extends A {
    public SubClass(int num, String name, int age) {
        super(num, name, age);
    }

    public static void main(String[] args) {

        // A doesnt know i have a child so here we cannot access protected variable from
        // SubClass
        // A sb = new SubClass(0, null, 0);
        // System.out.println(sb.age);

        // to access it we need to use the Reference class and Object creation class
        // samw
        SubClass obj = new SubClass(0, null, 0);
        System.out.println(obj.age); // we can access it
    }
}
