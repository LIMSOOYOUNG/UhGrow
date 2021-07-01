package com.farm3.uhgrow.farm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.farm3.uhgrow.farm.controller.FarmController;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;

public class MainFrame extends JFrame {
	private boolean isTrue = false;
	private boolean isNpcTrue = true;

	JPanel StoreMainPanel = new JPanel();
	JPanel backgroundPanel = new JPanel();
	JPanel plantSeedPanel = new JPanel();
	JLabel backGround;
	JLabel mainNpc;
	JLabel storeNpc;
	JLabel storeBackGroundLabel;
	JLabel conversationLabel;
	JLabel seedText;
	JLabel endButton;
	JLabel seedListLabel;
	List seedList;
	JButton[] fieldButton = new JButton[10];
	FarmController farmcontroller = new FarmController();

	private RetainCropDTO croplist;

	public MainFrame() {

		this.setBounds(300, 200, 960, 565);
		this.setTitle("UhGrow");
		this.setLayout(null);
		playSound("sound/배경음악1.wav");

		this.add(BackgroundPanel());

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	public JPanel PlantSeedPanel() {

		
		plantSeedPanel.setLayout(null);
		plantSeedPanel.setBounds(110, 400, 758, 120);
		plantSeedPanel.setVisible(isTrue);
		plantSeedPanel.add(askText());
		plantSeedPanel.add(conversation());

		return plantSeedPanel;
	}

	public JPanel BackgroundPanel() {

		fieldButton();
		backgroundPanel.setLayout(null);
		backgroundPanel.setSize(960, 540);
		backgroundPanel.add(storeNpc());
		backgroundPanel.add(mainNpc());
		backgroundPanel.add(PlantSeedPanel());
		for (int i = 0; i < 10; i++) {
			backgroundPanel.add(fieldButton[i]);
		}
		backgroundPanel.add(backGround());

		backgroundPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				isTrue = false;
				plantSeedPanel.setVisible(isTrue);
			}
		});
		return backgroundPanel;

	}

	public JButton[] fieldButton() {
		int x = 120;
		int y = 115;
		for (int i = 0; i < fieldButton.length; i++) {

			Image imgField = new ImageIcon("img/field.png").getImage().getScaledInstance(35, 30, 0);
			fieldButton[i] = new JButton(new ImageIcon(imgField));
			fieldButton[i].setSize(34, 30);
			fieldButton[i].setLocation(x, y);
			if (x < 256) {
				x += 34;
			} else if (x == 256) {
				x = 120;
				y = 180;
			} else {
				x += 34;
			}
			fieldButton[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					List seedlist = farmcontroller.selectSeed();
					if(isTrue) {
						
		
					}else {
						isTrue = true;
						plantSeedPanel.setVisible(isTrue);
						plantSeedPanel.add(seedList(seedlist));
						seedList(seedlist).setVisible(true);
					}
					
					
				}
			});

		}
		
		
		return fieldButton;
	}

	public JLabel store() {
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(800, 400,
				0);
		storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(800, 400);
		return storeBackGroundLabel;
	}

	public List seedList(List seedlist) {
		
		seedlist.setBounds(710, 200, 150, 200);
		return seedlist;

	}

	public JLabel askText() {
		seedText = new JLabel();
		seedText.setLayout(null);
		seedText.setLocation(20, 10);
		seedText.setSize(700, 100);
		seedText.setText("무슨씨앗을 심으시겠습니까?");
		Font font = new Font("utf-8", Font.BOLD, 30);
		seedText.setFont(font);
		return seedText;
	}

	public JLabel endButton() {
		Image imgEndButton = new ImageIcon("img/대화 화살표.png").getImage().getScaledInstance(45, 30, 0);
		endButton = new JLabel(new ImageIcon(imgEndButton));
		endButton.setSize(45, 30);
		endButton.setLocation(700, 80);
		return endButton;

	}

	public JLabel conversation() {

		Image imgConversation = new ImageIcon("img/대화창.png").getImage().getScaledInstance(758, 120, 0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setSize(758, 120);
		return conversationLabel;
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