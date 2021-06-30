package com.farm3.uhgrow.farm.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private boolean isTrue = false;
	private boolean isNpcTrue = true;

	JPanel StoreMainPanel = new JPanel();
	JPanel backgroundPanel = new JPanel();
	JPanel conversationPanel = new JPanel();
	JPanel storePanel = new JPanel();
	JLabel backGround;
	JLabel mainNpc;
	JLabel storeNpc;

	public MainFrame() {

		this.setBounds(300, 200, 960, 565);
		this.setTitle("UhGrow");
		this.setLayout(null);
		playSound("sound/배경음악1.wav");

		storePanel.setLayout(null);
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(800, 400,0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(800, 400);

		

		conversationPanel.setLayout(null);
		conversationPanel.setBounds(110, 400, 758, 120);

		Image imgConversation = new ImageIcon("img/대화창.png").getImage().getScaledInstance(758, 120, 0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setSize(758, 120);
		conversationPanel.setVisible(isTrue);
		conversationPanel.add(conversationLabel);

		backgroundPanel.setLayout(null);
		backgroundPanel.setSize(960, 540);
		backgroundPanel.add(storeNpc());
		backgroundPanel.add(mainNpc());
		backgroundPanel.add(conversationPanel);
		backgroundPanel.add(backGround());

		StoreMainPanel.add(storeBackGroundLabel);
		StoreMainPanel.setLayout(null);
		StoreMainPanel.setBounds(150, 100, 800, 400);
		StoreMainPanel.setVisible(isTrue);

		this.add(StoreMainPanel);
		this.add(backgroundPanel);

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JLabel mainNpc() {
		Image imgMainNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(30, 50, 0);
		mainNpc = new JLabel(new ImageIcon(imgMainNpc));
		mainNpc.setLocation(570, 190);
		mainNpc.setSize(30, 50);
		return mainNpc;
	}
	public JLabel backGround() {
		Image imgbackground = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGround = new JLabel(new ImageIcon(imgbackground));
		backGround.setLocation(0, 0);
		backGround.setSize(960, 540);
		return backGround;
	}

	public JLabel storeNpc() {
		Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(30, 50, 0);
		storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setLocation(750, 150);
		storeNpc.setSize(30, 50);

		storeNpc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isTrue=true;
				StoreMainPanel.setVisible(isTrue);
			}
	});
		return storeNpc;
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