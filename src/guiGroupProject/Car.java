package guiGroupProject;

public class Car {

	private String make;
	private String model;
	private double quarterMileTime;
	
	public Car(String make, String model){
		this.make = make;
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make){
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model){
		this.model = model;
	}
	
	public double getQuarterMileTime() {
		quarterMileTime =((Math.random() * 9) + 1);
		return quarterMileTime;
	}
	
	
}