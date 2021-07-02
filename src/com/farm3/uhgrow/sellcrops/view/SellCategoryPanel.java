package com.farm3.uhgrow.sellcrops.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SellCategoryPanel extends JPanel{
	
	private JPanel sellCategoryPanel;
	
	
	public SellCategoryPanel() {
		
		sellCategoryPanel = this;
		
		this.setLayout(null);
		this.setSize(960, 540);
		
	/*배경화면 이미지 라벨*/
		Image imageBackGround = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel imageBackGroundLabel = new JLabel(new ImageIcon(imageBackGround));
		imageBackGroundLabel.setLocation(0, 0);
		imageBackGroundLabel.setSize(960, 565);
	
	/*상점창 이미지 라벨*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(705, 360, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(127, 90);
		storeBackGroundLabel.setSize(705, 360);
	
		/*구매버튼 이미지 라벨*/
		Image buyImage = new ImageIcon("img/store/buybutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(132, 95);
		buyButton.setSize(232, 60);
		
	
		/*판매버튼 이미지 라벨*/
		Image sellImage = new ImageIcon("img/store/sellButton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(364, 95);
		sellButton.setSize(232, 60);	
		
		/*그만두기버튼 이미지 라벨*/
		Image quitImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton quitButton = new JButton(new ImageIcon(quitImage));
		quitButton.setLocation(596, 95);
		quitButton.setSize(232, 60);	
		
		Image sellSeedImage = new ImageIcon("img/store/sellCategory/sellSeedButton.png").getImage().getScaledInstance(500, 32, 0);
		JButton sellSeedButton = new JButton(new ImageIcon(sellSeedImage));
		sellSeedButton.setLocation(140, 180);
		sellSeedButton.setSize(500, 32);
		
		Image sellCropImage = new ImageIcon("img/store/sellCategory/sellCropButton.png").getImage().getScaledInstance(500, 32, 0);
		JButton sellCropButton = new JButton(new ImageIcon(sellCropImage));
		sellCropButton.setLocation(140, 230);
		sellCropButton.setSize(500, 32);

		Image sellToolImage = new ImageIcon("img/store/sellCategory/sellToolButton.png").getImage().getScaledInstance(500, 32, 0);
		JButton sellToolButton = new JButton(new ImageIcon(sellToolImage));
		sellToolButton.setLocation(140, 280);
		sellToolButton.setSize(500, 32);
		
		Image sellCookImage = new ImageIcon("img/store/sellCategory/sellCookButton.png").getImage().getScaledInstance(500, 32, 0);
		JButton sellCookButton = new JButton(new ImageIcon(sellCookImage));
		sellSeedButton.setLocation(140, 330);
		sellSeedButton.setSize(500, 32);
		
		
		this.add(buyButton);
		this.add(sellButton);
		this.add(quitButton);
		this.add(sellSeedButton);
		this.add(sellCropButton);
		this.add(sellToolButton);
		this.add(sellCookButton);
		this.add(storeBackGroundLabel);
		this.add(imageBackGroundLabel);
		
		
	
	}

}
