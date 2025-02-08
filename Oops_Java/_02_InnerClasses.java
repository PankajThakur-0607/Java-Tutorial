
// outer class cannot be static as it is not dependent on any other class
import Principles.Access_Specifier.A;
public class _02_InnerClasses {

    static class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }

        // @Override
        // public String toString() {
        // return name;
        // }
    }

    public static void main(String[] args) {
        Test a = new Test("Pankaj");
        Test b = new Test("Thakur");

        System.out.println(a.name);
        System.out.println(b.name);

        Test c = new Test("Monika");
        System.out.println(c);

        A obj = new A(25, "pankaj");
        obj.setNum(26);
        System.out.println(obj.getNum());
    }
}
