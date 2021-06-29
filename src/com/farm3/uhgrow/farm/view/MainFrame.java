package com.farm3.uhgrow.farm.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MainFrame extends JFrame {
	public MainFrame() {
		
		this.setBounds(300, 200, 960, 575);
		this.setTitle("UhGrow");
		this.setLayout(null);
		
		Image imgMainNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(30, 50,0);
		ImageIcon imgMainNpcIcon = new ImageIcon(imgMainNpc);
		
		Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(30, 50,0);
		ImageIcon imgStoreNpcIcon = new ImageIcon(imgStoreNpc);
		
		JButton mainNpc = new JButton(imgMainNpcIcon);
		mainNpc.setLocation(570,190);
		mainNpc.setSize(30,50);
		
		JButton storeNpc = new JButton(imgStoreNpcIcon);
		storeNpc.setLocation(750,150);
		storeNpc.setSize(30,50);
		this.add(mainNpc);
		this.add(storeNpc);
		
		playSound("sound/배경음악1.wav");
		FrameManager.initPanel(this, new BackGroundPanel());

	}

	public static void playSound(String fn) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fn));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}