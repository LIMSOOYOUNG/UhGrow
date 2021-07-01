package com.farm3.uhgrow.buy.view;

import java.awt.Image;
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

public class BuyFrameView extends JFrame {
	private boolean isTrue=false;
	private boolean isNpcTrue =true;
	public BuyFrameView() {
		
		this.setBounds(300, 200, 960, 565);
		this.setTitle("UhGrow");
		this.setLayout(null);
		playSound("sound/배경음악1.wav");
		
		JPanel backGroundPanel = new JPanel();
		JPanel storeBackGroundPanel = new JPanel();
//		-------------------------------------------------------------------------------------------------------------------------
		
		/* 구입한다 창 */
		
		JPanel storeButtonPanel = new JPanel();
		JPanel buySeedListPanel = new JPanel();
		JPanel buyToolListPanel = new JPanel();

		backGroundPanel.setLayout(null);
		backGroundPanel.setSize(960, 540);
		storeBackGroundPanel.setBounds(50, 40, 860, 400);
		storeButtonPanel.setLayout(null);
		storeButtonPanel.setBounds(100, 100, 590, 40);
		storeButtonPanel.setVisible(true);
		buySeedListPanel.setBounds(100, 180, 140, 34);
		buySeedListPanel.setVisible(true);
		buyToolListPanel.setBounds(100, 240, 140, 34);
		buyToolListPanel.setVisible(true);
		
		
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		
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
		backGroundPanel.add(backGroundLabel);
		
		this.add(storeButtonPanel);
		this.add(buySeedListPanel);
		this.add(buyToolListPanel);
		this.add(storeBackGroundPanel);
		this.add(backGroundPanel);
		
		
//		-------------------------------------------------------------------------------------------------------------------------
		
		JPanel storeBackGroundPanel2 = new JPanel();
		storeBackGroundPanel2.setLayout(null);
		storeBackGroundPanel2.setBounds(50, 40, 860, 400);
		storeBackGroundPanel2.setVisible(false);
		
		Image storeBackGround2 = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel2 = new JLabel(new ImageIcon(storeBackGround2));
		storeBackGroundLabel2.setLocation(0, 0);
		storeBackGroundLabel2.setSize(960, 540);
		
		Image buyImage2 = new ImageIcon("img/store/buybutton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel buyButtonLabel2 = new JLabel(new ImageIcon(buyImage2));
		buyButtonLabel.setLocation(1, 1);
		buyButtonLabel.setSize(200, 50);
		
		Image sellImage2 = new ImageIcon("img/store/sellButton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel sellButtonLabel2 = new JLabel(new ImageIcon(sellImage2));
		sellButtonLabel.setLocation(200, 1);
		sellButtonLabel.setSize(200, 50);
		
		Image quitImage2 = new ImageIcon("img/store/quitButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton quitButton2 = new JButton(new ImageIcon(quitImage2));
		quitButton.setLocation(395, 1);
		quitButton.setSize(200, 50);
		
		storeBackGroundPanel2.add(storeBackGroundLabel2);
		storeBackGroundPanel2.add(buyButtonLabel2);
		storeBackGroundPanel2.add(sellButtonLabel2);
		storeBackGroundPanel2.add(quitButton2);
		
		this.add(storeBackGroundPanel2);
		
//		-------------------------------------------------------------------------------------------------------------------------

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//		-------------------------------------------------------------------------------------------------------------------------
		
		/* 클릭 이벤트 창 */
		quitButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				storeBackGroundPanel.setVisible(false);
				buyToolListPanel.setVisible(false);
				buySeedListPanel.setVisible(false);
				storeButtonPanel.setVisible(false);
				storeButtonPanel.setVisible(false);
				storeButtonPanel.setVisible(false);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		seedListButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				storeBackGroundPanel2.setVisible(true);
				buyToolListPanel.setVisible(false);
				buySeedListPanel.setVisible(false);
				storeButtonPanel.setVisible(false);
				storeButtonPanel.setVisible(false);
				storeButtonPanel.setVisible(false);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		quitButton2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		
		
		
		
		
		

		
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

