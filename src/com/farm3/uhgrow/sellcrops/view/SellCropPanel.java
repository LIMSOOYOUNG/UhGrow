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
	
	JPanel mainPanel = new JPanel();
	
	JPanel sellListPanel = new JPanel();
	JPanel mainImagePanel = new JPanel();
	JPanel storePanel = new JPanel();
	JLabel storeBackGroundLabel;
	JLabel imageBackGroundLabel;
	JButton buyButton;
	JButton sellButton;
	JButton quitButton;
	
	JButton sellSeedButton;
	JButton sellCropButton;
	JButton sellToolBUtton;
	JButton sellFoodButton;
	
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
		
		
		this.add(mainPanel());
		this.add(sellBuyPanel());
//		this.add(SellPanel());
//		this.add(mainBackGround());
	
//		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public JPanel mainPanel() {
		
		mainPanel.add(buyCropsButton());
		mainPanel.add(sellCropsButton());
		mainPanel.add(quitCropsButton());
		mainPanel.add(storeBackGround());
		mainPanel.add(imageBackGround());
		
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0 ,960, 565);
		
		
		return mainPanel;
		
	}
	
	
	public JPanel sellBuyPanel() {
		
		sellListPanel.add(sellCropsButton());
		sellListPanel.add(storeBackGround());
		sellListPanel.add(imageBackGround());
		
		sellListPanel.setLayout(null);
		sellListPanel.setBounds(0, 0, 960, 565);
	
		return sellListPanel;
	}
	
	public JPanel mainBackGround() {
		storePanel.add(storeBackGround());
		mainImagePanel.add(imageBackGround());
		
		mainImagePanel.setLayout(null);
		mainImagePanel.setSize(960, 540);
		return mainImagePanel;
	}
	
	
	public JLabel imageBackGround() {
		imageBackGround = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		imageBackGroundLabel = new JLabel(new ImageIcon(imageBackGround));
		imageBackGroundLabel.setLocation(0, 0);
		imageBackGroundLabel.setSize(960, 565);
		return imageBackGroundLabel;
	}
	
	
	public JLabel storeBackGround() {
		storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(705, 360, 0);
		storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(127, 90);
		storeBackGroundLabel.setSize(705, 360);
		return storeBackGroundLabel;
	}
	
	public JButton buyCropsButton() {
		buyImage = new ImageIcon("img/store/buyButton.png").getImage().getScaledInstance(200, 50, 0);
		buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(50, 43);
		buyButton.setSize(200, 50);
		
		return buyButton;
	}
	
	public JButton sellSeedButton() {
		sellSeedButton = new JButton("씨앗");
		sellSeedButton.setLocation(0, 0);
		sellSeedButton.setSize(20, 20);
		
		return sellSeedButton;
	}
	
	public JButton sellCropsButton() {
		sellImage = new ImageIcon("img/store/sellButton1.png").getImage().getScaledInstance(232, 60, 0);
		sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(364, 95);
		sellButton.setSize(232, 60);	
		
		sellButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainPanel.setVisible(false);
				sellListPanel.setVisible(true);
				
			}
		});
		
		return sellButton;
	}	
	
	public JButton quitCropsButton() {
		quitImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(200, 50, 0);
		quitButton = new JButton(new ImageIcon(quitImage));
		quitButton.setLocation(596, 95);
		quitButton.setSize(232, 60);
		
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				buyButton.setVisible(false);
				sellButton.setVisible(false);
				quitButton.setVisible(false);
				storeBackGroundLabel.setVisible(false);
				
				mainPageImage = new ImageIcon("img/store/mainPageTest.png").getImage().getScaledInstance(960, 540, 0);
				imageBackGroundLabel.setIcon(new ImageIcon(mainPageImage));
				
			}
		});
		
		return quitButton;
		
	}
		
//		public void actionListener( ) {
//			sellButton.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					
//					removeAll();
//				}
//				
//				
//			});
//		}
	
		

		
		
//		public void actionListener() {
//		      btnBack.addMouseListener(new MouseAdapter() {
//		         @Override
//		         public void mouseClicked(MouseEvent e) {
//
//		            removeAll();
//		         }
//		      });
//		      
//		      btnInsertUser.addMouseListener(new MouseAdapter() {
//		         @Override
//		         public void mouseClicked(MouseEvent e) {
//		            // TODO Auto-generated method stub
//		            removeAll();
//		            
////		            sp.signUpPanel;
//		            //this.removeAll();
//		            //this.setVisible(false);
//		            //sp.signUpPanel();
//
//		         }
//		      });
//		   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
