package Principles.Inheritance;

class Multilevel_Inheritance {

    int legs;

    Multilevel_Inheritance() {
        System.out.println(" Default ineritance constructor called");
        legs = -1;
    }

    Multilevel_Inheritance(int legs) {
        System.out.println("Multilevel_Inheritance constructor called ");
        this.legs = legs;
    }

    public static class Animal extends Multilevel_Inheritance {
        String type;
        String eats;

        Animal() {
            System.out.println("Default Animal Called");
            type = "Harbivorous";
            eats = "plants";
        }

        Animal(int legs, String type, String eats) {
            super(legs);
            System.out.println(" Animal Called");
            this.type = type;
            this.eats = eats;
        }

        void getType() {
            System.out.println("The animal is :" + type);
        }

    }

    public static class Dog extends Animal {

        Dog() {
            System.out.println("Default Dog called");
        }

        Dog(int legs, String type, String eats) {
            super(legs, type, eats);
            System.out.println(" Dog called");
        }

        void eats() {
            System.out.println("Food he eats is : " + eats);
        }
    }

    static class Cat extends Animal {
        Cat(String type, int legs, String eats) {
            super(legs, type, eats);
        }

    }

    public static void main(String[] args) {
        // Dog bullDog = new Dog();
        // bullDog.eats();

        Dog wolf = new Dog(4, "carnivorus", "Flesh");
        wolf.eats();

        Cat meow = new Cat("omnivorous", 4, "both flesh and milk");
        meow.getType();
    }
}
