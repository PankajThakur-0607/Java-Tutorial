package Principles.Interfaces;

public class PowerEngine implements Engine {

    @Override
    public void acc() {
        System.out.println("Power engine accelerard");
    }

    @Override
    public void start() {
        // Implementation of start method
        System.out.println("Power engine start");
    }

    @Override
    public void stop() {
        System.out.println("Power engine stop");
        // Implementation of stop method
    }

}
