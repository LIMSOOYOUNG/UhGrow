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

		this.setTitle("UhGrow");
		this.setLayout(null);
		this.setBounds(300, 200, 960, 565);
		
		playSound("sound/배경음악1.wav");

		BuyListPanel();
		//		buySeedList();
		//		buySeedCount();


		//		JPanel backGroundPanel = new JPanel();
		//
		//		backGroundPanel.setLayout(null);
		//		backGroundPanel.setSize(960, 540);
		//		backGroundPanel.setVisible(true);
		//
		//		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		//		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		//		backGroundLabel.setLocation(0, 0);
		//		backGroundLabel.setSize(960, 540);
		//
		//		backGroundPanel.add(backGroundLabel);
		//
		//		this.add(backGroundPanel);

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}
	//		-------------------------------------------------------------------------------------------------------------------------

	/* 구입한다 창 */
	public void BuyListPanel() {



		//		JPanel storeBackGroundPanel = new JPanel();
		//		JPanel storeButtonPanel = new JPanel();
		//		JPanel buySeedListPanel = new JPanel();
		//		JPanel buyToolListPanel = new JPanel();
		//
		//
		//		storeBackGroundPanel.setSize(960, 540);
		//		storeButtonPanel.setLayout(null);
		//		storeButtonPanel.setBounds(100, 100, 590, 40);
		//		storeButtonPanel.setVisible(true);
		//		buySeedListPanel.setBounds(100, 180, 140, 34);
		//		buySeedListPanel.setVisible(true);
		//		buyToolListPanel.setBounds(100, 240, 140, 34);
		//		buyToolListPanel.setVisible(true);

		JPanel BuyListPanel = new JPanel();

		BuyListPanel.setLayout(null);
		BuyListPanel.setSize(960,540);
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		BuyListPanel.setVisible(true);

		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		Image buyImage = new ImageIcon("img/store/buybutton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel buyButtonLabel = new JLabel(new ImageIcon(buyImage));
		buyButtonLabel.setLocation(200, 80);
		buyButtonLabel.setSize(200, 50);

		Image sellImage = new ImageIcon("img/store/sellButton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel sellButtonLabel = new JLabel(new ImageIcon(sellImage));
		sellButtonLabel.setLocation(400, 80);
		sellButtonLabel.setSize(200, 50);

		Image quitImage = new ImageIcon("img/store/quitButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton quitButton = new JButton(new ImageIcon(quitImage));
		quitButton.setLocation(600, 80);
		quitButton.setSize(200, 50);

		Image seedListImage = new ImageIcon("img/store/seedList.png").getImage().getScaledInstance(100, 25, 0);
		JButton seedListButton = new JButton(new ImageIcon(seedListImage));
		seedListButton.setLocation(70, 150);
		seedListButton.setSize(200, 50);

		Image toolListImage = new ImageIcon("img/store/toolList.png").getImage().getScaledInstance(100, 25, 0);
		JButton toolListButton = new JButton(new ImageIcon(toolListImage));
		toolListButton.setLocation(70, 250);
		toolListButton.setSize(200, 50);


		BuyListPanel.add(buyButtonLabel);
		BuyListPanel.add(sellButtonLabel);
		BuyListPanel.add(quitButton);
		BuyListPanel.add(seedListButton);
		BuyListPanel.add(toolListButton);
		BuyListPanel.add(storeBackGroundLabel);
		BuyListPanel.add(backGroundLabel);
		
		this.add(BuyListPanel);

		//		storeButtonPanel.add(buyButtonLabel);
		//		storeButtonPanel.add(sellButtonLabel);
		//		storeButtonPanel.add(quitButton);
		//		buySeedListPanel.add(seedListButton);
		//		buyToolListPanel.add(toolListButton);
		//		storeBackGroundPanel.add(storeBackGroundLabel);

		//		this.add(storeButtonPanel);
		//		this.add(buySeedListPanel);
		//		this.add(buyToolListPanel);
		//		this.add(storeBackGroundPanel);


		seedListButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//				buySeedListPanel.removeAll();
				//				buySeedListPanel.setVisible(false);
				//				buyToolListPanel.removeAll();
				//				buyToolListPanel.setVisible(false);
				//				storeButtonPanel.removeAll();
				//				storeButtonPanel.setVisible(false);
				//				storeBackGroundPanel.removeAll();
				//				storeBackGroundPanel.setVisible(false);
				//				buySeedList();

			}

		});

	}
	//	-------------------------------------------------------------------------------------------------------------------------

	/* 씨앗 목록 창 */
	//	public void buySeedList() {
	//
	//		Font font = new Font("고딕체", Font.BOLD, 25);
	//
	//		JPanel storeBackGroundPanel = new JPanel();
	//		JPanel storeButtonPanel = new JPanel();
	//		JPanel storeBuyTextPanel = new JPanel();
	//		JPanel tomatoSeedPanel = new JPanel();
	//		JPanel cornSeedPanel = new JPanel();
	//		JPanel garlicSeedPanel = new JPanel();
	//		JPanel pumpkinSeedPanel = new JPanel();
	//
	//		storeBackGroundPanel.setBounds(50, 40, 860, 400);
	//		storeButtonPanel.setLayout(null);
	//		storeButtonPanel.setBounds(100, 100, 590, 40);
	//		storeButtonPanel.setVisible(true);
	//		storeBuyTextPanel.setBounds(350, 150, 100, 40);
	//		tomatoSeedPanel.setVisible(true);
	//		tomatoSeedPanel.setBounds(100, 200, 100, 40);
	//		cornSeedPanel.setVisible(true);
	//		cornSeedPanel.setBounds(100, 250, 100, 40);
	//		garlicSeedPanel.setVisible(true);
	//		garlicSeedPanel.setBounds(100, 300, 100, 40);
	//		pumpkinSeedPanel.setVisible(true);
	//		pumpkinSeedPanel.setBounds(100, 350, 100, 40);
	//
	//		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
	//		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
	//		storeBackGroundLabel.setLocation(0, 0);
	//		storeBackGroundLabel.setSize(960, 540);
	//
	//		Image buyImage = new ImageIcon("img/store/buybutton.png").getImage().getScaledInstance(200, 50, 0);
	//		JLabel buyButtonLabel = new JLabel(new ImageIcon(buyImage));
	//		buyButtonLabel.setLocation(1, 1);
	//		buyButtonLabel.setSize(200, 50);
	//
	//		Image sellImage = new ImageIcon("img/store/sellButton.png").getImage().getScaledInstance(200, 50, 0);
	//		JLabel sellButtonLabel = new JLabel(new ImageIcon(sellImage));
	//		sellButtonLabel.setLocation(200, 1);
	//		sellButtonLabel.setSize(200, 50);
	//
	//		Image quitImage = new ImageIcon("img/store/quitButton.png").getImage().getScaledInstance(200, 50, 0);
	//		JButton quitButton = new JButton(new ImageIcon(quitImage));
	//		quitButton.setLocation(395, 1);
	//		quitButton.setSize(200, 50);
	//
	//		JLabel buyLabel = new JLabel("<씨앗 구매>");
	//		buyLabel.setLayout(null);
	//		buyLabel.setBounds(1, 1, 25, 25);
	//		buyLabel.setFont(font);
	//
	//		JButton tomatoButton = new JButton("토마토");
	//		tomatoButton.setLocation(100, 500);
	//		tomatoButton.setSize(300, 50);
	//
	//		JButton cornButton = new JButton("옥수수");
	//		cornButton.setLocation(100, 500);
	//		cornButton.setSize(300, 50);
	//
	//		JButton garlicButton = new JButton("마늘");
	//		garlicButton.setLocation(100, 500);
	//		garlicButton.setSize(300, 50);
	//
	//		JButton pumpkinButton = new JButton("호박");
	//		pumpkinButton.setLocation(100, 500);
	//		pumpkinButton.setSize(300, 50);
	//
	//		storeButtonPanel.add(buyButtonLabel);
	//		storeButtonPanel.add(sellButtonLabel);
	//		storeButtonPanel.add(quitButton);
	//		tomatoSeedPanel.add(tomatoButton);
	//		cornSeedPanel.add(cornButton);
	//		garlicSeedPanel.add(garlicButton);
	//		pumpkinSeedPanel.add(pumpkinButton);
	//
	//		storeBuyTextPanel.add(buyLabel);
	//
	//		storeBackGroundPanel.add(storeBackGroundLabel);
	//
	//		this.add(pumpkinSeedPanel);
	//		this.add(garlicSeedPanel);
	//		this.add(cornSeedPanel);
	//		this.add(tomatoSeedPanel);
	//		this.add(storeBuyTextPanel);
	//		this.add(storeButtonPanel);
	//		this.add(storeBackGroundPanel);
	//
	//		quitButton.addMouseListener(new MouseAdapter() {
	//			@Override
	//			public void mouseClicked(MouseEvent e) {
	//				pumpkinSeedPanel.setVisible(false);
	//				pumpkinSeedPanel.removeAll();
	//				garlicSeedPanel.setVisible(false);
	//				garlicSeedPanel.removeAll();
	//				cornSeedPanel.setVisible(false);
	//				cornSeedPanel.removeAll();
	//				tomatoSeedPanel.setVisible(false);
	//				tomatoSeedPanel.removeAll();
	//				storeBuyTextPanel.setVisible(false);
	//				storeBuyTextPanel.removeAll();
	//				storeButtonPanel.setVisible(false);
	//				storeButtonPanel.removeAll();
	//				storeBackGroundPanel.setVisible(false);
	//				storeBackGroundPanel.removeAll();
	//			}
	//
	//		});
	//		
	//		tomatoButton.addMouseListener(new MouseAdapter() {
	//			@Override
	//			public void mouseClicked(MouseEvent e) {
	//				buySeedCount();
	//			}
	//
	//		});
	//		
	//		cornButton.addMouseListener(new MouseAdapter() {
	//			@Override
	//			public void mouseClicked(MouseEvent e) {
	//				buySeedCount();
	//			}
	//
	//		});
	//		
	//		garlicButton.addMouseListener(new MouseAdapter() {
	//			@Override
	//			public void mouseClicked(MouseEvent e) {
	//				buySeedCount();
	//			}
	//
	//		});
	//		
	//		pumpkinButton.addMouseListener(new MouseAdapter() {
	//			@Override
	//			public void mouseClicked(MouseEvent e) {
	//				buySeedCount();
	//			}
	//
	//		});
	//
	//	}
	//
	//	//	-------------------------------------------------------------------------------------------------------------------------
	//
	//	/* 씨앗 구매 갯수 입력 */
	//	public void buySeedCount() {
	//
	//		Font font = new Font("고딕체", Font.BOLD, 25);
	//
	//		JPanel storeBackGroundPanel = new JPanel();
	//		JPanel storeButtonPanel = new JPanel();
	//		JPanel storeBuyTextPanel = new JPanel();
	//		JPanel tomatoSeedPanel = new JPanel();
	//		JPanel cornSeedPanel = new JPanel();
	//		JPanel garlicSeedPanel = new JPanel();
	//		JPanel pumpkinSeedPanel = new JPanel();
	//		JPanel inputSeedPanel = new JPanel();
	//
	//		storeBackGroundPanel.setBounds(50, 40, 860, 400);
	//		storeButtonPanel.setLayout(null);
	//		storeButtonPanel.setBounds(100, 100, 590, 40);
	//		storeButtonPanel.setVisible(true);
	//		storeBuyTextPanel.setBounds(350, 150, 100, 40);
	//		tomatoSeedPanel.setVisible(true);
	//		tomatoSeedPanel.setBounds(100, 200, 100, 40);
	//		cornSeedPanel.setVisible(true);
	//		cornSeedPanel.setBounds(100, 250, 100, 40);
	//		garlicSeedPanel.setVisible(true);
	//		garlicSeedPanel.setBounds(100, 300, 100, 40);
	//		pumpkinSeedPanel.setVisible(true);
	//		pumpkinSeedPanel.setBounds(100, 350, 100, 40);
	//		inputSeedPanel.setVisible(true);
	//		inputSeedPanel.setBounds(600, 100, 300, 300);
	//
	//		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
	//		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
	//		storeBackGroundLabel.setLocation(0, 0);
	//		storeBackGroundLabel.setSize(960, 540);
	//
	//		Image buyImage = new ImageIcon("img/store/buybutton.png").getImage().getScaledInstance(200, 50, 0);
	//		JLabel buyButtonLabel = new JLabel(new ImageIcon(buyImage));
	//		buyButtonLabel.setLocation(1, 1);
	//		buyButtonLabel.setSize(200, 50);
	//
	//		Image sellImage = new ImageIcon("img/store/sellButton.png").getImage().getScaledInstance(200, 50, 0);
	//		JLabel sellButtonLabel = new JLabel(new ImageIcon(sellImage));
	//		sellButtonLabel.setLocation(200, 1);
	//		sellButtonLabel.setSize(200, 50);
	//
	//		Image quitImage = new ImageIcon("img/store/quitButton.png").getImage().getScaledInstance(200, 50, 0);
	//		JButton quitButton = new JButton(new ImageIcon(quitImage));
	//		quitButton.setLocation(395, 1);
	//		quitButton.setSize(200, 50);
	//
	//		JLabel buyLabel = new JLabel("<씨앗 구매>");
	//		buyLabel.setLayout(null);
	//		buyLabel.setBounds(1, 1, 25, 25);
	//		buyLabel.setFont(font);
	//
	//		JButton tomatoButton = new JButton("토마토");
	//		tomatoButton.setLocation(100, 500);
	//		tomatoButton.setSize(300, 50);
	//
	//		JButton cornButton = new JButton("옥수수");
	//		cornButton.setLocation(100, 500);
	//		cornButton.setSize(300, 50);
	//
	//		JButton garlicButton = new JButton("마늘");
	//		garlicButton.setLocation(100, 500);
	//		garlicButton.setSize(300, 50);
	//
	//		JButton pumpkinButton = new JButton("호박");
	//		pumpkinButton.setLocation(100, 500);
	//		pumpkinButton.setSize(300, 50);
	//		
	//		JButton buySureButton = new JButton("구매확정");
	//		buySureButton.setLocation(100, 500);
	//		buySureButton.setSize(300, 80);
	//
	//		storeButtonPanel.add(buyButtonLabel);
	//		storeButtonPanel.add(sellButtonLabel);
	//		storeButtonPanel.add(quitButton);
	//		tomatoSeedPanel.add(tomatoButton);
	//		cornSeedPanel.add(cornButton);
	//		garlicSeedPanel.add(garlicButton);
	//		pumpkinSeedPanel.add(pumpkinButton);
	//		inputSeedPanel.add(buySureButton);
	//
	//		storeBuyTextPanel.add(buyLabel);
	//
	//		storeBackGroundPanel.add(storeBackGroundLabel);
	//
	//		this.add(inputSeedPanel);
	//		this.add(pumpkinSeedPanel);
	//		this.add(garlicSeedPanel);
	//		this.add(cornSeedPanel);
	//		this.add(tomatoSeedPanel);
	//		this.add(storeBuyTextPanel);
	//		this.add(storeButtonPanel);
	//		this.add(storeBackGroundPanel);
	//
	//		quitButton.addMouseListener(new MouseAdapter() {
	//			@Override
	//			public void mouseClicked(MouseEvent e) {
	//				
	//			}
	//
	//		});
	//
	//	}




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

