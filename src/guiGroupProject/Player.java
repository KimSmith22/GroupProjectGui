package guiGroupProject;

public class Player {

	private String name;
	private int cash;
	private Car vehicle;
	
	
	public Player(String name, int cash, Car vehicle) {
		this.name = name;
		this.cash = cash;
		this.vehicle = vehicle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash += cash;
	}
	public void youLost(int cash){
		this.cash -= cash;
	}
	public Car getVehicle() {
		return vehicle;
	}
	public void setVehicle(Car vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
