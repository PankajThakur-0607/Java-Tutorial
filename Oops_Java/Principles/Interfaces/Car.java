package Principles.Interfaces;

public class Car implements Engine, Brake, Media {

    @Override
    public void brake() {
        System.out.println("i brake lika a normal car ");
    }

    @Override
    public void start() {
        System.out.println("i start Engine lika a normal car ");

    }

    @Override
    public void stop() {
        System.out.println("i stop Engine lika a normal car ");

    }

    @Override
    public void acc() {
        System.out.println("i accelerate lika a normal car ");

    }

}
