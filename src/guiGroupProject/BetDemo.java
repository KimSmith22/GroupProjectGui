package guiGroupProject;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;


public class BetDemo extends JFrame implements ActionListener{
	
	private  JPanel panel1;//north: image
	private JPanel panel2;//south: race button
	private JPanel panel3;//west: player 1
	private JPanel panel4;//east: player 2
	private JPanel panel5;//center: p1& p2 car images
	
	private JLabel messageLabel;//p1 message
	private JLabel messageLabel3;//p1 bank
	private JTextField bank1;//display p1 balance
	private JRadioButton mustang1;
	private JRadioButton challenger1;
	private JRadioButton corvette1;
	private JRadioButton porche1;
	private JRadioButton camaro1;
	private ButtonGroup radioButtonGroup1;
	
	private JLabel messageLabel2;//p2 message
	private JLabel messageLabel4;//p2 bank
	private JTextField bank2;//display p2 balance
	private JRadioButton mustang2;
	private JRadioButton challenger2;
	private JRadioButton corvette2;
	private JRadioButton porche2;
	private JRadioButton camaro2;
	private ButtonGroup radioButtonGroup2;
	
	private JButton fiveButton;
	private JButton tenButton;
	private JButton raceButton;
	private JButton againButton;
	//private JLabel messageLabel6;//placeholder
	
	private ImageIcon image1;
	private JLabel label1;
	private ImageIcon image2;
	private JLabel label2;
	private ImageIcon image3;
	private JLabel label3;
	private ImageDisplayP1 id;
	private TrafficLightPanel tlp;

	
	
	public BetDemo() {
		setSize(1100, 675);
		setTitle("FAST LANE RACING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		buildPanel();
		add(panel1, BorderLayout.NORTH);//header
		add(panel2, BorderLayout.SOUTH);//race button
		add(panel3, BorderLayout.WEST);//p1
		add(panel4, BorderLayout.EAST);//p2
 		add(panel5, BorderLayout.CENTER);//center
		fiveButton.addActionListener(this);
		tenButton.addActionListener(this);
		raceButton.addActionListener(this);
		againButton.addActionListener(this);
		this.dispose();
		setVisible(true);
		addMuffler();
		//addSound();//currently plays when program opens
	}

	public void addSound(){
		URL url = AddSound.class.getResource("vroom.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();
	}
	
	public void addMuffler(){
		URL url = AddMuffler.class.getResource("muffler.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();
	}

	public void buildPanel() {
		//north panel contents
		image1 = new ImageIcon(getClass().getResource("fast.png"));
		label1 = new JLabel(image1);
		
		
		//south panel contents
		fiveButton = new JButton("$5.00");
		fiveButton.setForeground(Color.WHITE);
		fiveButton.setBackground(Color.BLACK);
		tenButton = new JButton("$10.00");
		tenButton.setForeground(Color.WHITE);
		tenButton.setBackground(Color.BLACK);
		raceButton = new JButton("RACE");
		raceButton.setForeground(Color.WHITE);
		raceButton.setBackground(Color.BLACK);
		againButton = new JButton("NEW RACE");
		againButton.setForeground(Color.WHITE);
		againButton.setBackground(Color.BLACK);
				
				
		//west panel contents
		image2 = new ImageIcon(getClass().getResource("flag.png"));
		label2 = new JLabel(image2);
		messageLabel = new JLabel("Pick A Car");
		mustang1 = new JRadioButton("Mustang");
		challenger1 = new JRadioButton("Challenger");
		corvette1 = new JRadioButton("Corvette");
		porche1 = new JRadioButton("Porche");
		camaro1 = new JRadioButton("Camaro");
		messageLabel3 = new JLabel("Account Balance");
		bank1 = new JTextField(8);

		radioButtonGroup1 = new ButtonGroup();
		radioButtonGroup1.add(mustang1);
		radioButtonGroup1.add(challenger1);
		radioButtonGroup1.add(corvette1);
		radioButtonGroup1.add(porche1);
		radioButtonGroup1.add(camaro1);
		
		//center panel contents
		//id = new ImageDisplay();
		tlp = new TrafficLightPanel();
		//image array p2
		
		//east panel contents
		image3 = new ImageIcon(getClass().getResource("flag2.png"));
		label3 = new JLabel(image3);
		messageLabel2 = new JLabel("Pick A Car");
		mustang2 = new JRadioButton("Mustang");
		challenger2 = new JRadioButton("Challenger");
		corvette2 = new JRadioButton("Corvette");
		porche2 = new JRadioButton("Porche");
		camaro2 = new JRadioButton("Camaro");
		messageLabel4 = new JLabel("Account Balance");
		bank2 = new JTextField(8);
		
		radioButtonGroup2 = new ButtonGroup();
		radioButtonGroup2.add(mustang2);
		radioButtonGroup2.add(challenger2);
		radioButtonGroup2.add(corvette2);
		radioButtonGroup2.add(porche2);
		radioButtonGroup2.add(camaro2);
			



		panel1 = new JPanel();//header panel
		panel1.add(label1);
		
		
		panel2 = new JPanel();//footer panel
		panel2.setLayout(new GridLayout(2,2));
		panel2.add(fiveButton);
		panel2.add(tenButton);
		panel2.add(raceButton);
		panel2.add(againButton);
		
		
		panel3 = new JPanel();//player 1 panel
		panel3.setBorder(BorderFactory.createTitledBorder("Player 1"));
		panel3.setLayout(new GridLayout(9, 1));
		panel3.add(label2);
		panel3.add(messageLabel);
		panel3.add(mustang1);
		panel3.add(challenger1);
		panel3.add(corvette1);
		panel3.add(porche1);
		panel3.add(camaro1);
		panel3.add(messageLabel3);
		panel3.add(bank1);
		
		panel4 = new JPanel();//player 2 panel
		panel4.setBorder(BorderFactory.createTitledBorder("Player 2"));
		panel4.setLayout(new GridLayout(9, 1));		
		panel4.add(label3);
		panel4.add(messageLabel2);
		panel4.add(mustang2);
		panel4.add(challenger2);
		panel4.add(corvette2);
		panel4.add(porche2);
		panel4.add(camaro2);
		panel4.add(messageLabel4);
		panel4.add(bank2);
		
		panel5 = new JPanel();
		panel5.setLayout(new GridLayout(2,3));
		//
		panel5.add(tlp);
		//panel5.add(p2 image array);
		
	}
	

	public void trafficLight() throws InterruptedException{
		setVisible(true);
		Thread.sleep(2500);
		tlp.getTrafficLight().nextState();
		repaint();
		Thread.sleep(2500);
		tlp.getTrafficLight().nextState();
		repaint();
	}

	
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BetDemo f = new BetDemo();
		
	}
}

