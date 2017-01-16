package guiGroupProject;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AddMuffler extends JFrame{
	JButton PlayM = new JButton("Play");
	JButton LoopM = new JButton("Loop");
	JButton StopM = new JButton("Stop");
	
	URL url = AddSound.class.getResource("muffler.mp3");
	AudioClip clip = Applet.newAudioClip(url);
	
	public AddMuffler(){
		super("AddingSound");
		setLayout(new FlowLayout());
		
		PlayM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				clip.play();
			}
		});
		LoopM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				clip.loop();
			}
		});
		StopM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				clip.stop();
			}
		});
		add(PlayM);
		add(LoopM);
		add(StopM);
	}
	
	public static void main(String[] args){
		JFrame f = new AddSound();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(200,  200);
		f.setVisible(true);
	}
}
