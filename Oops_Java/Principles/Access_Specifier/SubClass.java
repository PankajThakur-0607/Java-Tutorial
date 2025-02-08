package Principles.Access_Specifier;

public class SubClass extends A {

    public SubClass(int num, String name, int age) {
        super(num, name, age);
    }

    public static void main(String[] args) {
        SubClass obj = new SubClass(0, null, 0);
        System.out.println(obj.age);
        System.out.println(obj.name);

        System.out.println(obj instanceof Object);
    }
}
