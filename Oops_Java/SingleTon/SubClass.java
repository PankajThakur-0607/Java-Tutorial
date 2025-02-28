package SingleTon;

import Principles.Access_Specifier.*;;

public class SubClass extends A {

    public SubClass(int num, String name, int age) {
        super(num, name, age);
    }

    public static void main(String[] args) {
        SubClass obj = new SubClass(0, "pankaj", 0);
        System.out.println(obj.age);
        
        // A obj2 = new A(10, "Pankaj", 21);
        // System.out.println(obj2.age);
    }
}
