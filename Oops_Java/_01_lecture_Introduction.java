import java.util.Arrays;

public class _01_lecture_Introduction {

    public static void main(String[] args) {

        // techer told you to make a datatype that stores 5 number

        // store 5 roll numbers
        // int[] numbers = new int[5];
        // // store 5 names
        // String names[] = new String[5];

        // data of 5 students ( roll no , name , marks )
        // int[] rno = new int[5];
        // String[] name = new String[5];
        // int[] marks = new int[5];

        Student[] panku = new Student[5];
        // System.out.println(Arrays.toString(student));

        // Students pankaj;
        // pankaj = new Students();
        // System.out.println(pankaj);

        // Student pankaj = new Student();
        // pankaj.name = "pankaj";
        // pankaj.rollNo = 24;
        // pankaj.marks = 81.25f;

        // System.out.println(pankaj.name);
        // System.out.println(pankaj.rollNo);
        // System.out.println(pankaj.marks);

        Student hello = new Student();
        // System.out.println(hello.name);
        // System.out.println(hello.rollNo);
        // System.out.println(hello.marks);

        // hello.greeting();
        // hello.changeName("pankaj");
        // hello.greeting();

        // Student newStudent = new Student(hello);
        // System.out.println(newStudent.name);
        // System.out.println(newStudent.rollNo);
        // System.out.println(newStudent.marks);

        // Student random = new Student();
        // System.out.println(random.name);

        // Wrapper class
        // int a = 10;
        // int b = 20;
        // Integer num = 45; // Integer class are object but cannot be changed they have
        // fibal dataype in it
        // Integer num2 = 50;
        // swap(num, num2);
        // System.out.println("a is : " + num + " b is : " + num2);

        // always initalise
        // final int BONUS = 2 ;
        // BONUS = 3;
        final A pak = new A("Singh");
        pak.name = "Moika";
        // System.out.println(pak.name);

        // pak = new A("thkaur");
        // System.out.println(pak.name);

        A obj = new A("sdfhjskh");
        System.out.println(obj);

        // for (int i = 0; i < 1000; i++) {
        // obj = new A("Random Numbber" + i);
        // }

    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

}

class A {
    final int num = 10;
    String name;

    A(String name) {
        // System.out.println("Object created ...");
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }

}

class Student {
    int rollNo;
    String name;
    float marks;

    void greeting() {
        System.out.println("Hello my Name is : " + this.name);
    }

    // Student() {
    // this.rollNo = 5;
    // this.name = "thakur";
    // this.marks = 41.5f;
    // }

    void changeName(String name) {
        this.name = name;
    }

    Student(Student other) {
        this.name = other.name;
        this.rollNo = other.rollNo;
        this.marks = other.marks;
    }

    Student(String name, int rollNo, float marks) {
        this.name = name;
        this.marks = marks;
        this.rollNo = rollNo;
    }

    Student() {
        this("Monika", 24, 10.5f);
    }

}
