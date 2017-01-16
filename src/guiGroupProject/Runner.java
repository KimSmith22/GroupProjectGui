package guiGroupProject;

import java.awt.*;

import javax.swing.*;

public class Runner {

	public static void main(String[] args) {
		/*
		Bulb b1 = new Bulb(false, Color.RED, "red");
		System.out.println(b1);
		b1.turnOn();
		System.out.println(b1.toString());
		
		TrafficLight light = new TrafficLight();
		light.nextState();
		light.nextState();
		System.out.println(light.getLights()[0]);
		System.out.println(light.getLights()[1]);
		System.out.println(light.getLights()[2]);
		System.out.println();
		System.out.println(light.toString());
		*/
		
		JFrame f = new JFrame("Traffic Light");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(new TrafficLightPanel());
		
		/*
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(180, 220));
		f.getContentPane().add(panel);
		JLabel label1 = new JLabel("Traffic Light");
		panel.add(label1);
		f.getContentPane().add(panel);
		*/
		
		f.pack();
		f.setVisible(true);
	}

}
