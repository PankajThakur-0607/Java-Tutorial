package Principles.Interfaces;

public class Main {

    public static void main(String[] args) {
        // Car car = new Car();
        // car.acc();
        // car.start();
        // car.stop();

        // Media mediaCar = new Car();
        // mediaCar.stop(); // it call the engine
        // we can also seperate interfaces for this

        NiceCar car = new NiceCar();
        car.start();
        car.startMusic();
        car.stopMusic();
        car.upgradeEngine(new ElectricEngine());
        car.start();

    }
}
