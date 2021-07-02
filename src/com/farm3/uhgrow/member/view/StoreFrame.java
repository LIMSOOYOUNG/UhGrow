package com.farm3.uhgrow.member.view;

import java.awt.Font;
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

public class StoreFrame extends JFrame {
	public StoreFrame() { 

		this.setTitle("UhGrow");
		this.setLayout(null);
		this.setBounds(300, 200, 960, 565);
		
		playSound("sound/배경음악1.wav");
		
		buyPanel();
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JPanel buyPanel() {
		JPanel buyPanel = new JPanel();
		buyPanel.setLayout(null);
		buyPanel.setSize(960,540);
		
		/* ---------- 배경화면 라벨  ------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		buyPanel.setVisible(true);
		
		/* ---------- 상첨창 배경  ------------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(705, 360, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(127, 90);
		storeBackGroundLabel.setSize(705, 360);
		
		/* ---------- 상점창 구매한다, 판매한다, 그만두기 버튼   ------------*/
		Image buyImage = new ImageIcon("img/store/buybutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(132, 95);
		buyButton.setSize(232, 60);
		
		Image sellImage = new ImageIcon("img/store/sellbutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(364, 95);
		sellButton.setSize(232, 60);
		
		Image backImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton backButton = new JButton(new ImageIcon(backImage));
		backButton.setLocation(596, 95);
		backButton.setSize(232, 60);
		
		/* ---------- 대화창, 대화창에 큰 상인 이미지 ------------*/
		Image imgConversation = new ImageIcon("img/store/storeconversation1.png").getImage().getScaledInstance(758, 120, 0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setBounds(100, 400, 760, 118);
		
		Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(90, 150, 0);
		JLabel storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setBounds(750, 350, 90, 150);
		
		/* ---------- 상인 대화내용  ------------*/
		Font font = new Font("맑은고딕", Font.BOLD, 35);
		JLabel textLabel = new JLabel("빨리 빨리 골라 뭐하러 왔는데? 어 ? ");
		textLabel.setBounds(130, 410, 750, 100);
		textLabel.setFont(font);
		
		
		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가  ------------*/
		buyPanel.add(textLabel);
		buyPanel.add(storeNpc);
		buyPanel.add(conversationLabel);
		buyPanel.add(sellButton);
		buyPanel.add(backButton);
		buyPanel.add(buyButton);
		buyPanel.add(storeBackGroundLabel);
		buyPanel.add(backGroundLabel);
		
		/* ---------- buy패널 상점 프레임에 추가 ------------*/
		this.add(buyPanel);
		
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buyPanel.removeAll();
				buyPanel.setVisible(false);
			}
		});
		
		
		/* ---------- 호출시 buy패널 리턴으로 돌려줌  ------------*/
		return buyPanel;
		
	}
	
	public void buySeedList() {
	
			Font font = new Font("고딕체", Font.BOLD, 25);
	
			JPanel storeBackGroundPanel = new JPanel();
			JPanel storeButtonPanel = new JPanel();
			JPanel storeBuyTextPanel = new JPanel();
			JPanel tomatoSeedPanel = new JPanel();
			JPanel cornSeedPanel = new JPanel();
			JPanel garlicSeedPanel = new JPanel();
			JPanel pumpkinSeedPanel = new JPanel();
	
			storeBackGroundPanel.setBounds(50, 40, 860, 400);
			storeButtonPanel.setLayout(null);
			storeButtonPanel.setBounds(100, 100, 590, 40);
			storeButtonPanel.setVisible(true);
			storeBuyTextPanel.setBounds(350, 150, 100, 40);
			tomatoSeedPanel.setVisible(true);
			tomatoSeedPanel.setBounds(100, 200, 100, 40);
			cornSeedPanel.setVisible(true);
			cornSeedPanel.setBounds(100, 250, 100, 40);
			garlicSeedPanel.setVisible(true);
			garlicSeedPanel.setBounds(100, 300, 100, 40);
			pumpkinSeedPanel.setVisible(true);
			pumpkinSeedPanel.setBounds(100, 350, 100, 40);
	
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
	
			JLabel buyLabel = new JLabel("<씨앗 구매>");
			buyLabel.setLayout(null);
			buyLabel.setBounds(1, 1, 25, 25);
			buyLabel.setFont(font);
	
			JButton tomatoButton = new JButton("토마토");
			tomatoButton.setLocation(100, 500);
			tomatoButton.setSize(300, 50);
	
			JButton cornButton = new JButton("옥수수");
			cornButton.setLocation(100, 500);
			cornButton.setSize(300, 50);
	
			JButton garlicButton = new JButton("마늘");
			garlicButton.setLocation(100, 500);
			garlicButton.setSize(300, 50);
	
			JButton pumpkinButton = new JButton("호박");
			pumpkinButton.setLocation(100, 500);
			pumpkinButton.setSize(300, 50);
	
			storeButtonPanel.add(buyButtonLabel);
			storeButtonPanel.add(sellButtonLabel);
			storeButtonPanel.add(quitButton);
			tomatoSeedPanel.add(tomatoButton);
			cornSeedPanel.add(cornButton);
			garlicSeedPanel.add(garlicButton);
			pumpkinSeedPanel.add(pumpkinButton);
	
			storeBuyTextPanel.add(buyLabel);
	
			storeBackGroundPanel.add(storeBackGroundLabel);
	
			this.add(pumpkinSeedPanel);
			this.add(garlicSeedPanel);
			this.add(cornSeedPanel);
			this.add(tomatoSeedPanel);
			this.add(storeBuyTextPanel);
			this.add(storeButtonPanel);
			this.add(storeBackGroundPanel);
	
			quitButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					pumpkinSeedPanel.setVisible(false);
					pumpkinSeedPanel.removeAll();
					garlicSeedPanel.setVisible(false);
					garlicSeedPanel.removeAll();
					cornSeedPanel.setVisible(false);
					cornSeedPanel.removeAll();
					tomatoSeedPanel.setVisible(false);
					tomatoSeedPanel.removeAll();
					storeBuyTextPanel.setVisible(false);
					storeBuyTextPanel.removeAll();
					storeButtonPanel.setVisible(false);
					storeButtonPanel.removeAll();
					storeBackGroundPanel.setVisible(false);
					storeBackGroundPanel.removeAll();
				}
	
			});
			
			tomatoButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					buySeedCount();
				}
	
			});
			
			cornButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					buySeedCount();
				}
	
			});
			
			garlicButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					buySeedCount();
				}
	
			});
			
			pumpkinButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					buySeedCount();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

