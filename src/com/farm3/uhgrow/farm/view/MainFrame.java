package com.farm3.uhgrow.farm.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public MainFrame() {

		this.setBounds(300, 200, 960, 565);
		this.setTitle("UhGrow");
		this.setLayout(null);
		playSound("sound/배경음악1.wav");

		JPanel backGroundPanel = new JPanel();
		JPanel newPanel = new JPanel();
		
		backGroundPanel.setLayout(null);
		backGroundPanel.setSize(960,540);
		newPanel.setLayout(null);
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		
		
		
		Image imgMainNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(30, 50, 0);
		ImageIcon imgMainNpcIcon = new ImageIcon(imgMainNpc);
		JLabel mainNpcLabel = new JLabel(imgMainNpcIcon);
		mainNpcLabel.setLocation(570, 190);
		mainNpcLabel.setSize(30, 50);
		

		Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(30, 50, 0);
		ImageIcon imgStoreNpcIcon = new ImageIcon(imgStoreNpc);
		JLabel storeNpc = new JLabel(imgStoreNpcIcon);
		storeNpc.setLocation(750, 150);
		storeNpc.setSize(30, 50);


		
		

		

		
		
		storeNpc.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Image pizza = new ImageIcon("img/tomato/Pizza.png").getImage().getScaledInstance(50, 50, 0);
				ImageIcon pizzaicon = new ImageIcon(pizza);
				JLabel pizzaLabel = new JLabel(pizzaicon);
				pizzaLabel.setLocation(100, 100);
				pizzaLabel.setSize(50,50);
				System.out.println("출력");
				newPanel.add(pizzaLabel);				
			}
		});
		backGroundPanel.add(storeNpc);
		backGroundPanel.add(mainNpcLabel);
		backGroundPanel.add(backGroundLabel);

		this.add(backGroundPanel);

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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