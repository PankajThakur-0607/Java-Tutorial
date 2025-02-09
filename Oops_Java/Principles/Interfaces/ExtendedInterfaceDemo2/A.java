package Principles.Interfaces.ExtendedInterfaceDemo2;

interface A {

    // static interface methods should always have a body
    // call via tha interfaces
    static void greeting() {
        System.out.println("i am a static method");
    }

    default void fun() {
        System.out.println("i am default in A ");
    }
}
