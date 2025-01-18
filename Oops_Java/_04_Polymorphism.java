package Oops_Java;

public class _04_Polymorphism {
    
// 2 types

// Run time PolyMorphism (dynamic ) ---> mehtod overriding -->  used in Inheritance
// compile time PolyMorphism(static) ---> method overloading


    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1.5f, 2.5f));
        System.out.println(calc.sum(1, 2, 3));

        Deer d = new Deer();
        d.eat(); 
    }
}

class Animal{


    void eat(){
        System.out.println("eats anything");
    }
}

class Deer extends Animal{

    void eat(){
        System.out.println("eats Grass");
    }
}
class Calculator{

    int sum (int a , int b ){
        return a + b ;
    }

    float sum (float a , float b){
        return a + b;
    }

    float sum(int a , int b , int c ){
        return a + b + c;
    }

}
