package com.farm3.uhgrow.sellcrops.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SellCropPanel extends JFrame{
	
	JPanel sellCropList = new JPanel();
	JPanel mainImagePanel = new JPanel();
	JPanel storePanel = new JPanel();
	JLabel storeBackGroundLabel;
	JLabel imageBackGroundLabel;
	JButton buyButton;
	JButton sellButton;
	JButton quitButton;
	
	JButton tomatoButton;
	JButton cornButton;
	JButton galicButton;
	JButton pumpkinButton;
	Image imageBackGround;
	Image storeBackGround;
	Image buyImage;
	Image sellImage;
	Image quitImage;
	Image mainPageImage;
	
	
	
	public void sellBuyFrame() {
		
		
		this.setBounds(300, 200 ,960, 565);
		this.setLayout(null);
		this.add(sellBuyPanel());
		this.add(mainBackGround());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public JPanel sellBuyPanel() {
		storePanel.add(buyCropsButton());
		storePanel.add(sellCropsButton());
		storePanel.add(quitCropsButton());
		
		storePanel.setLayout(null);
		storePanel.setBounds(50, 40, 860, 400);
		return storePanel;
	}
	
	public JPanel mainBackGround() {
		storePanel.add(storeBackGround());
		mainImagePanel.add(imageBackGround());
		
		mainImagePanel.setLayout(null);
		mainImagePanel.setSize(960, 540);
		return mainImagePanel;
	}
	
	
	public JLabel imageBackGround() {
		imageBackGround = new ImageIcon("img/store/mainPageTest.png").getImage().getScaledInstance(960, 540, 0);
		imageBackGroundLabel = new JLabel(new ImageIcon(imageBackGround));
		imageBackGroundLabel.setLocation(0, 0);
		imageBackGroundLabel.setSize(960, 540);
		return imageBackGroundLabel;
	}
	
	
	public JLabel storeBackGround() {
		storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(860, 400);
		return storeBackGroundLabel;
	}
	
	public JButton buyCropsButton() {
		buyImage = new ImageIcon("img/store/buyButton.png").getImage().getScaledInstance(200, 50, 0);
		buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(50, 43);
		buyButton.setSize(200, 50);
		
		return buyButton;
	}
	
	public JButton sellCropsButton() {
		sellImage = new ImageIcon("img/store/sellButton.png").getImage().getScaledInstance(200, 50, 0);
		sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(276, 43);
		sellButton.setSize(200, 50);
		
		sellButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				JButton tomatoButton;
//				JButton cornButton;
//				JButton galicButton;
//				JButton pumpkinButton;
				
				tomatoButton = new JButton("토마토");
				
				cornButton = new JButton("옥수수");
			}
		});
		
		return sellButton;
	}
	
	public JButton quitCropsButton() {
		quitImage = new ImageIcon("img/store/quitButton.png").getImage().getScaledInstance(200, 50, 0);
		quitButton = new JButton(new ImageIcon(quitImage));
		quitButton.setLocation(505,43);
		quitButton.setSize(200,50);
		
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				buyButton.setVisible(false);
				sellButton.setVisible(false);
				quitButton.setVisible(false);
				
				mainPageImage = new ImageIcon("img/store/mainPageTest.png").getImage().getScaledInstance(960, 540, 0);
				imageBackGroundLabel.setIcon(new ImageIcon(mainPageImage));
				
			}
		});
		
		return quitButton;
		
	}
	
	
	
	
	
//	public JPanel sellBuyPanel() {
//		
//		storePanel.setLayout(null);
//		storePanel.setLocation(960, 540);
//	
//		storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(960, 540, 0);
//		storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
//		
//		storeBackGroundLabel.setLocation(0, 0);
//		storeBackGroundLabel.setSize(960, 540);
//		
//		buyImage = new ImageIcon("img/store/buybutton.png").getImage().getScaledInstance(200, 50, 0);
//		buyButton = new JButton(new ImageIcon(buyImage));
//		buyButton.setLocation(46, 43);
//		buyButton.setSize(200, 50);
//		
//		sellImage = new ImageIcon("img/store/sellButton.png").getImage().getScaledInstance(200, 50, 0);
//		sellButton = new JButton(new ImageIcon(sellImage));
//		sellButton.setLocation(276, 43);
//		sellButton.setSize(200, 50);
//		
//		quitImage = new ImageIcon("img/store/quitButton.png").getImage().getScaledInstance(200, 50, 0);
//		quitButton = new JButton(new ImageIcon(quitImage));
//		quitButton.setLocation(505, 43);
//		quitButton.setSize(200, 50);
//		
//
//
//		
//		buyButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			
//				
//			}
//		});
//		
//		sellButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}	
//		});
//		
//		
//		
//		quitButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				buyButton.setVisible(false);
//				sellButton.setVisible(false);
//				quitButton.setVisible(false);
//				
//				mainPageImage = new ImageIcon("img/store/mainPageTest.png").getImage().getScaledInstance(960, 540, 0);
//				storeBackGroundLabel.setIcon(new ImageIcon(mainPageImage));
//				
//				
//			}
//		});
//		
//		storePanel.add(buyButton);
//		storePanel.add(sellButton);
//		storePanel.add(quitButton);
//		storePanel.add(storeBackGroundLabel);
//		storePanel.setVisible(true);
//		
//		return storePanel;
//		
//		
//	}
	
	
	
//	public JPanel sellCropList() {
//		
//		sellCropList.setLayout(null);
//		sellCropList.setSize(960, 540);
//		
//		storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(960, 540, 0);
//		storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
//		
//		tomatoButton = new JButton("토마토");
//		tomatoButton.setLocation(292, 128);
//		tomatoButton.setSize(13, 13);
//		
//		
//		cornButton = new JButton("옥수수");
//		cornButton.setLocation(295, 222);
//		cornButton.setSize(13, 13);
//		
//		galicButton = new JButton("마늘");
//		galicButton.setLocation(298, 355);
//		galicButton.setSize(13, 13);
//		
//		pumpkinButton = new JButton("호박");
//		pumpkinButton.setLocation(300, 215);
//		pumpkinButton.setSize(13,13);
//		
//		tomatoButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		
//		
//		cornButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		
//		
//		galicButton.addActionListener(new ActionListener() {
//			
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		
//		pumpkinButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		
//		sellCropList.add(tomatoButton);
//		sellCropList.add(cornButton);
//		sellCropList.add(galicButton);
//		sellCropList.add(pumpkinButton);
//		sellCropList.add(storeBackGroundLabel);
//		sellCropList.setVisible(true);
//		
//		return sellCropList;
//		
//	}
	
	
}
