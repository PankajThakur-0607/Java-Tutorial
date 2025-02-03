package Packages.hellowa;

public class Main {

    public static void main(String[] args) {
        // Human pankaj = new Human(22, "Pankaj Thakur", "male", 10000, false);
        // Human Monika = new Human(22, "Monika Singh", "male", 10000, false);
        // Human arpit = new Human(22, "arpit", "male", 10000, false);

        // System.out.println(Human.population);
        // System.out.println(Human.population);
        // System.out.println(Human.population);

        // fun();

        Main fuun = new Main(); // here we have created a object so greeting method will not require to create another object  
        fuun.fun2(); 
    }


    
    // this is not dependent on Objects as it is static
    static void fun() {
        // greeting();      // you cant use this because it requires an instances
        // but the function you are using it in(fun function) does not depend on instances
        
        // you cannot access non static stuff without refreencing their instances in a static context
        
        // hence , here i am referencing it
        Main obj = new Main();
        obj.greeting();
        
    }
    
    void fun2(){
        greeting(); // we can also  have a non static method inside non static method as outer method will make object reference for both the methods
    }


    // we know that something that is not static belongs to objects
    void greeting() {
        // fun(); // we can have a static method in non static method
        System.out.println("hello This is awesome ");
    }
}
