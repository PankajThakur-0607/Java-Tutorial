package Principles.Interfaces;

public class ElectricEngine implements Engine {

	@Override
	public void acc() {
		System.out.println("electric engine accelerate ");
	}
    
	@Override
	public void start() {
        // Implementation of start method
        System.out.println("electric engine start ");
	}
    
	@Override
	public void stop() {
        // Implementation of stop method
        System.out.println("electric engine stop ");
	}
	
}
