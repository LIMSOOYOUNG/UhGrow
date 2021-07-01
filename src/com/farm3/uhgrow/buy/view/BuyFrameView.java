package com.farm3.uhgrow.buy.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class BuyFrameView extends JFrame {
	
	
	public BuyFrameView() {

		this.setBounds(300, 200, 960, 565);
		this.setTitle("UhGrow");
		this.setLayout(null);
		playSound("sound/배경음악1.wav");
		
		BuyListPanel();
		buyToolList();
		
		JPanel backGroundPanel = new JPanel();
		
		backGroundPanel.setLayout(null);
		backGroundPanel.setSize(960, 540);
		
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		
		backGroundPanel.add(backGroundLabel);
		
		this.add(backGroundPanel);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}
	//		-------------------------------------------------------------------------------------------------------------------------

	/* 구입한다 창 */
	public void BuyListPanel() {
		
		JPanel storeBackGroundPanel = new JPanel();
		JPanel storeButtonPanel = new JPanel();
		JPanel buySeedListPanel = new JPanel();
		JPanel buyToolListPanel = new JPanel();

		
		storeBackGroundPanel.setBounds(50, 40, 860, 400);
		storeButtonPanel.setLayout(null);
		storeButtonPanel.setBounds(100, 100, 590, 40);
		storeButtonPanel.setVisible(true);
		buySeedListPanel.setBounds(100, 180, 140, 34);
		buySeedListPanel.setVisible(true);
		buyToolListPanel.setBounds(100, 240, 140, 34);
		buyToolListPanel.setVisible(true);


		

		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		Image buyImage = new ImageIcon("img/store/buybutton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel buyButtonLabel = new JLabel(new ImageIcon(buyImage));
		buyButtonLabel.setLocation(1, 1);
		buyButtonLabel.setSize(200, 50);

		Image sellImage = new ImageIcon("img/store/sellButton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel sellButtonLabel = new JLabel(new ImageIcon(sellImage));
		sellButtonLabel.setLocation(200, 1);
		sellButtonLabel.setSize(200, 50);

		Image quitImage = new ImageIcon("img/store/quitButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton quitButton = new JButton(new ImageIcon(quitImage));
		quitButton.setLocation(395, 1);
		quitButton.setSize(200, 50);

		Image seedListImage = new ImageIcon("img/store/seedList.png").getImage().getScaledInstance(100, 25, 0);
		JButton seedListButton = new JButton(new ImageIcon(seedListImage));
		seedListButton.setLocation(1, 1);
		seedListButton.setSize(100, 25);

		Image toolListImage = new ImageIcon("img/store/toolList.png").getImage().getScaledInstance(100, 25, 0);
		JButton toolListButton = new JButton(new ImageIcon(toolListImage));
		toolListButton.setLocation(1, 1);
		toolListButton.setSize(100, 25);


		storeButtonPanel.add(buyButtonLabel);
		storeButtonPanel.add(sellButtonLabel);
		storeButtonPanel.add(quitButton);
		buySeedListPanel.add(seedListButton);
		buyToolListPanel.add(toolListButton);
		storeBackGroundPanel.add(storeBackGroundLabel);
		

		this.add(storeButtonPanel);
		this.add(buySeedListPanel);
		this.add(buyToolListPanel);
		this.add(storeBackGroundPanel);
		
		
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buySeedListPanel.removeAll();
				buySeedListPanel.setVisible(false);
				buyToolListPanel.removeAll();
				buyToolListPanel.setVisible(false);
				storeButtonPanel.removeAll();
				storeButtonPanel.setVisible(false);
				storeBackGroundPanel.removeAll();
				storeBackGroundPanel.setVisible(false);
				buyToolList();
				
			}

			});

	}
//	-------------------------------------------------------------------------------------------------------------------------
	
	/* 농기구 목록 창 */
	public void buyToolList() {
		
		JPanel storeBackGroundPanel = new JPanel();
		JPanel storeButtonPanel = new JPanel();
		
		storeBackGroundPanel.setBounds(50, 40, 860, 400);
		storeButtonPanel.setLayout(null);
		storeButtonPanel.setBounds(100, 100, 590, 40);
		storeButtonPanel.setVisible(true);
		
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		Image buyImage = new ImageIcon("img/store/buybutton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel buyButtonLabel = new JLabel(new ImageIcon(buyImage));
		buyButtonLabel.setLocation(1, 1);
		buyButtonLabel.setSize(200, 50);

		Image sellImage = new ImageIcon("img/store/sellButton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel sellButtonLabel = new JLabel(new ImageIcon(sellImage));
		sellButtonLabel.setLocation(200, 1);
		sellButtonLabel.setSize(200, 50);

		Image quitImage = new ImageIcon("img/store/quitButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton quitButton = new JButton(new ImageIcon(quitImage));
		quitButton.setLocation(395, 1);
		quitButton.setSize(200, 50);
		
		storeButtonPanel.add(buyButtonLabel);
		storeButtonPanel.add(sellButtonLabel);
		storeButtonPanel.add(quitButton);
		storeBackGroundPanel.add(storeBackGroundLabel);
		
		this.add(storeButtonPanel);
		this.add(storeBackGroundPanel);
		
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			});

	}

		
	
	
	public static void playSound(String fn) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fn));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}

