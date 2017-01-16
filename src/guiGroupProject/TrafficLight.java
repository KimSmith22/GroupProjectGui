package guiGroupProject;

import java.awt.Color;

public class TrafficLight {

	private Bulb[] lights;
	
	public TrafficLight(){
		lights = new Bulb[3];
		lights[0] = new Bulb(true, Color.RED, "red");
		lights[1] = new Bulb(false, Color.YELLOW, "yellow");
		lights[2] = new Bulb(false, Color.GREEN, "green");
	}
	
	public Bulb[] getLights(){
		return lights;
	}
	public void setLights(Bulb[] lights){
		this.lights = lights;
	}
	
	public void nextState(){
		if(lights[0].isOn()){
			lights[0].turnOff();
			lights[1].turnOn();
		}
		else if(lights[1].isOn()){
			lights[1].turnOff();
			lights[2].turnOn();
		}//end if/else
	}//end method
	
	public String toString(){
		String result = "";
		for(int i = 0; i < lights.length; i++){
			result += "Bulb " + (i + 1) + " is " + lights[i].getColorName() +
			" and " + lights[i].toString().toLowerCase() + "\n";	
		}//end loop
		return result;
	}//end toString

	public int indexOfLitBulb() {
		int i = 0;
		while (i < lights.length && lights[i].isOff()){
			i++;
		}
		return i;
	}//end indexOfBulb method
	
}//end class
