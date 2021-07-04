package com.farm3.uhgrow.sellcrops.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.member.view.FrameManager;

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
	
	
		/*구매버튼 이미지 라벨*/
		Image buyImage = new ImageIcon("img/store/mainStore/buybutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(132, 95);
		buyButton.setSize(232, 60);
		
	
		/*판매버튼 이미지 라벨*/
		Image sellImage = new ImageIcon("img/store/mainStore/sellbutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(364, 95);
		sellButton.setSize(232, 60);	
		
		/*그만두기버튼 이미지 라벨*/
		Image quitImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton quitButton = new JButton(new ImageIcon(quitImage));
		quitButton.setLocation(596, 95);
		quitButton.setSize(232, 60);
		
		/* ------- 상점 패널 ---------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);
		
		/* -------- 판매 목록 버튼 ---------- */
		JButton seedListButton = new JButton("씨앗 판매");
		seedListButton.setLocation(70, 200);
		seedListButton.setSize(100, 25);

		JButton cropListButton = new JButton("농작물 판매");
		cropListButton.setLocation(70, 250);
		cropListButton.setSize(100, 25);
		
		JButton toolListButton = new JButton("농기구 판매");
		toolListButton.setLocation(70, 300);
		toolListButton.setSize(100, 25);
		
		JButton cookListButton = new JButton("요리 판매");
		cookListButton.setLocation(70, 350);
		cookListButton.setSize(100, 25);
		
		this.add(buyButton);
		this.add(sellButton);
		this.add(quitButton);
		this.add(seedListButton);
		this.add(cropListButton);
		this.add(toolListButton);
		this.add(cookListButton);
		this.add(storeBackGroundLabel);
		this.add(imageBackGroundLabel);
		
		seedListButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		
		cropListButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel sellCropListPanel = new SellCropListPanel();
				
				FrameManager.changePanel(sellCategoryPanel, sellCropListPanel);
				
				
			}
			
		});
		
		toolListButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 
			}
			
		});
		
		cookListButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		
		
	
	}

}
