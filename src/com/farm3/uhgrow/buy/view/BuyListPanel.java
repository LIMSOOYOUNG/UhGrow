package com.farm3.uhgrow.buy.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BuyListPanel extends JPanel{
	
	private JPanel buyListPanel;
	private JButton sellButton;
	private JButton buyButton;
	private JButton backButton;
	private JButton seedListButton;
	private JButton toolListButton;
	
	public BuyListPanel() {
		
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);
		
		buyListPanel = this;
		
		this.setLayout(null);
		this.setSize(960, 540);
		
		/* ---------- 배경화면 라벨  ------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		this.setVisible(true);
		
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
		
		/* ------- 상점 패널 ---------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);
		
		/* -------- 판매 목록 버튼 ---------- */
		Image seedListImage = new ImageIcon("img/store/seedList.png").getImage().getScaledInstance(100, 25, 0);
		JButton seedListButton = new JButton(new ImageIcon(seedListImage));
		seedListButton.setLocation(70, 150);
		seedListButton.setSize(200, 50);

		Image toolListImage = new ImageIcon("img/store/toolList.png").getImage().getScaledInstance(100, 25, 0);
		JButton toolListButton = new JButton(new ImageIcon(toolListImage));
		toolListButton.setLocation(70, 250);
		toolListButton.setSize(200, 50);
		
		this.add(buyButton);
		this.add(sellButton);
		this.add(backButton);
		this.add(seedListButton);
		this.add(toolListButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
	}

}
