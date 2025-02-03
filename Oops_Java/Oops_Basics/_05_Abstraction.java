package Oops_Basics;

public class _05_Abstraction {
    

    public static void main(String[] args) {
        // Horse h = new Horse();
        // h.eats();
        // h.walk();
        // System.out.println(h.color);

        // Chicken c = new Chicken();
        // c.eats();
        // c.walk();
        // System.out.println(c.color);

        // heairchy of Mustang 
        Mustang myH = new Mustang();
        System.out.println(myH.color);


         
    }
}


abstract class Animall{
    String color ;

    Animall(){
        color = "blue";
        System.out.println("Animall Constructor called");
    }

    void eats(){
        System.out.println("eats food");
    }

    abstract void walk();
}


class Chicken extends Horse{
    Chicken(){
        System.out.println("Chicken constructor called");
    }
    void changeColor(){
        color = "Green";
    }
    void walk(){
        System.out.println("walks on 2 legs ");
    }
}

class Horse extends Animall {
    Horse(){
        System.out.println("Horse constructor called");
    }
    void changeColor(){
        color = "yellow";
    }
    void walk(){
        System.out.println("walks on 4 leg");
    }
}


class Mustang extends Chicken{
    Mustang(){
        System.out.println("Mustang Constructor called");
    }
}




