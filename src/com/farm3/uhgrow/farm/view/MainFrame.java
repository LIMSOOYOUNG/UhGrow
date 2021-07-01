package com.farm3.uhgrow.farm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
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
	JLabel fieldLabel;
	JLabel seedText;
	JLabel endButton;
	JLabel seedListLabel;
	List seedList;
	FarmController farmcontroller = new FarmController(); 

	
	private RetainCropDTO croplist;
	public MainFrame() {
		


		this.setBounds(300, 200, 960, 565);
		this.setTitle("UhGrow");
		this.setLayout(null);
		playSound("sound/배경음악1.wav");

		this.add(storePanel());
		this.add(BackgroundPanel());

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

	
	public JPanel storePanel() {
		StoreMainPanel.add(store());
		StoreMainPanel.setLayout(null);
		StoreMainPanel.setBounds(150, 100, 800, 400);
		StoreMainPanel.setVisible(isTrue);
		return StoreMainPanel;
	}
	public JPanel PlantSeedPanel() {	
		plantSeedPanel.setLayout(null);
		plantSeedPanel.setBounds(110, 400, 758, 120);
		plantSeedPanel.setVisible(isTrue);
		plantSeedPanel.add(seedText()); 
		plantSeedPanel.add(conversation());
		return plantSeedPanel;
	}
	public JPanel BackgroundPanel() {
		
		backgroundPanel.setLayout(null);
		backgroundPanel.setSize(960, 540);
		backgroundPanel.add(storeNpc());
		backgroundPanel.add(mainNpc());
		backgroundPanel.add(PlantSeedPanel());
		backgroundPanel.add(field());
		backgroundPanel.add(backGround());
		
		backgroundPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				isTrue = false;
				plantSeedPanel.setVisible(isTrue);
				seedListLabel.setVisible(isTrue);
				seedList.setVisible(isTrue);
			}
		});
		return backgroundPanel;
		
	}
	public JLabel field() {
		Image imgField = new ImageIcon("img/field.png").getImage().getScaledInstance(35, 30,0);
		fieldLabel = new JLabel(new ImageIcon(imgField));
		fieldLabel.setLocation(120, 120);
		fieldLabel.setSize(35,30);
		fieldLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
				List seedList = farmcontroller.selectSeed();
				backgroundPanel.add(seedList(seedList));
				if(isTrue) {

					isTrue = false;
					seedList.setVisible(isTrue);
					plantSeedPanel.setVisible(isTrue);
				}else {
					isTrue = true;

					seedList.setVisible(isTrue);
					plantSeedPanel.setVisible(isTrue);
				}
				
				
				
			}
	});
		return fieldLabel;
	}
	
	public JLabel store() {
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(800, 400,0);
		storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(800, 400);
		return storeBackGroundLabel;
	}
	
	public List seedList(List seedlist) {
		seedlist.setBounds(710,200,150,200);
		seedlist.setVisible(true);
		return seedlist;
		
	}
	
	public JLabel seedText() {
		seedText = new JLabel();
		seedText.setLayout(null);
		seedText.setLocation(20,10);
		seedText.setSize(700,100);
		seedText.setText("무슨씨앗을 심으시겠습니까?");
		Font font = new Font("utf-8", Font.BOLD, 30);
		seedText.setFont(font);
		return seedText;
	}
	
	public JLabel endButton() {
		Image imgEndButton = new ImageIcon("img/대화 화살표.png").getImage().getScaledInstance(45, 30,0);
		endButton = new JLabel(new ImageIcon(imgEndButton));
		endButton.setSize(45, 30);
		endButton.setLocation(700,80);
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