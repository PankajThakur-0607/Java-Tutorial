package Packages.hellowa;

class Human {

    int age;
    String name;
    String gender;
    int salary;
    boolean isMarried;
    static long population;

    static void message(){
        System.out.println("Hellow World");
        // System.out.println(this.age); // cannot use this in static method as they are indepentendent from object and this is use to get the current context of an object 
    }

    // Constructor to initialize the fields
    public Human(int age, String name, String gender, int salary, boolean isMarried) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.isMarried = isMarried;
        Human.population += 1;
    }

    public static void main(String[] args) {
        Human.message();
    }
}
