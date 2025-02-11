package Generics;

import java.util.Arrays;

public class Cloning {

    static class Human implements Cloneable {
        int age;
        String name;
        int arr[];

        Human(int age, String name) {
            this.age = age;
            this.name = name;
            this.arr = new int[] { 3, 4, 5, 6, 9 };
        }

        Human(Human other) {
            this.age = other.age;
            this.name = other.name;
            this.arr = other.arr;
        }

        // @Override
        // protected Object clone() throws CloneNotSupportedException {
        // // this is shallow copy
        // return super.clone();
        // }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            Human twin = (Human) super.clone(); // this is actually shallow copy

            // this is deep copy
            twin.arr = new int[twin.arr.length];

            for (int i = 0; i < twin.arr.length; i++) {
                twin.arr[i] = this.arr[i];
            }

            return twin;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Human pankaj = new Human(25, "Pankaj");
        // Human thakur = new Human(pankaj); // copy but at diffrent address
        Human twin = (Human) pankaj.clone();
        System.out.println(twin.name + " " + twin.age);
        System.out.println(Arrays.toString(twin.arr));

        twin.arr[0] = 24;
        System.out.println(Arrays.toString(twin.arr));
        System.out.println(Arrays.toString(pankaj.arr));

    }
}
