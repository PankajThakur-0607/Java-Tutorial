package Oops_Basics;

public class _03_Inheritance {
    


    public static void main(String[] args) {
        Mammal f1 = new Mammal();
        f1.name = "tuna";
        f1.swims();
        f1.eat();


        System.out.println(f1.name);


        Dog dobby = new Dog();
        System.out.println(dobby.legs(3));

        Bird parrot = new Bird();
        parrot.color = "green";
        parrot.canFly = true;

        System.out.println(parrot.canFly);

    }
}



class Animal{
    String color;
    String name;

    void eat(){
        System.out.println("eats");
    }

    void breathe(){
        System.out.println("lungs");
    }
}


class Mammal extends Animal{

    String name;

    void swims(){
        System.out.println("Yes");
    }

    int legs(int legs){
        return legs;
    }
}


// Multi Level Inheritance 

class Dog extends Mammal{
    String breed;
}


// Hybrid Inheritance 

class Bird extends Animal{

    boolean canFly;
}


