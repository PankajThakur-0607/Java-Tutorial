package Oops_Java;

public class _02_Constructur {
    
    public static void main(String[] args) {

         Student s1 = new Student();
        //  Student s2 = new Student("Pankaj Thakur");
        //  Student s3 = new Student(123);
        //  Student s4 = new Student("pankaj" , 123);
        // //  System.out.println(s2.name);
        // System.out.println(s4.name +" is of this Age: " +  s4.age);

        s1.name = "Pankaj" ;
        s1.age = 21;
        s1.password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 100;
        s1.marks[2] = 100;

        Student s2 = new Student(s1);  // Copy ho gya tha but fir bhi s2 . me change aa jaata h copy ke baad bhi 
        s2.password = "xyz";
        s1.marks[2] = 50;
            
        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(s1.marks[i]);
        }
    }
}




class Student{
    int age;
    String name;
    String password;
    int marks[];


    Student(){
        marks = new int[3];
        System.out.println("Constructur is called");
    }
    Student(String newName){
        marks = new int[3];
        this.name = newName;
    }

    Student(int newAge){
        marks = new int[3];
        this.age = newAge;
    }
    Student(String newName , int newAge){
        marks = new int[3];
        this.age = newAge;
        this.name = newName;
    }

    // // Shallow Copy Constructor
    // Student(Student s1){
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.age = s1.age;
    //     this.marks = s1.marks;
    // }

    // Deep Copy Constructor
    Student (Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.age = s1.age;

        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

}