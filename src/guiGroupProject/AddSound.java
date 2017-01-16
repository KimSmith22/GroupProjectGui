package guiGroupProject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class AddSound extends JFrame{
	JButton Play = new JButton("Play");
	JButton Loop = new JButton("Loop");
	JButton Stop = new JButton("Stop");
	
	URL url = AddSound.class.getResource("rev.mp3");
	AudioClip clip = Applet.newAudioClip(url);
	
	public AddSound(){
		super("AddingSound");
		setLayout(new FlowLayout());
		
		Play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				clip.play();
			}
		});
		Loop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				clip.loop();
			}
		});
		Stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				clip.stop();
			}
		});
		add(Play);
		add(Loop);
		add(Stop);
	}
	
	public static void main(String[] args){
		JFrame f = new AddSound();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(200,  200);
		f.setVisible(true);
	}

}
