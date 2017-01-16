package guiGroupProject;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightPanel extends JPanel {
	 TrafficLight light;
	private final int X = 60, Y = 50, WIDTH = 50, HEIGHT = 130;
	private final int DIAMETER = 30;
	private final int X_OFFSET = 10, Y_OFFSET = 10;

	public TrafficLightPanel() {
		light = new TrafficLight();
		JButton changeButton = new JButton("Change Light");
		changeButton.addActionListener(new ChangeListener());
		add(changeButton);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(180, 220));
		setVisible(true);
	}

	public TrafficLight getTrafficLight(){
		return light;
	}
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		// draws rectangle
		page.setColor(Color.LIGHT_GRAY);
		page.fillRect(X, Y, WIDTH, HEIGHT);
		if (light.indexOfLitBulb() == 0) {
			page.setColor(Color.RED);
		} else {
			page.setColor(Color.DARK_GRAY);
		}
		page.fillOval(X + X_OFFSET, Y + Y_OFFSET, DIAMETER, DIAMETER);

		if (light.indexOfLitBulb() == 1) {
			page.setColor(Color.YELLOW);
		} else {
			page.setColor(Color.DARK_GRAY);
		}
		page.fillOval(X + X_OFFSET, Y + DIAMETER + 2 * Y_OFFSET, DIAMETER, DIAMETER);

		if (light.indexOfLitBulb() == 2) {
			page.setColor(Color.GREEN);
		} else {
			page.setColor(Color.DARK_GRAY);
		}
		page.fillOval(X + X_OFFSET, Y + 2 * DIAMETER + 3 * Y_OFFSET, DIAMETER, DIAMETER);
	} // end method

	private class ChangeListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			light.nextState();
			repaint();
		}// end method
	}// end of internal class

}// end class
