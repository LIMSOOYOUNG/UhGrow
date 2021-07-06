package com.farm3.uhgrow.sellcrops.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.controller.sell.SellController;

public class MainStorePanel extends JPanel {
	

	private JPanel sellmainPanel;
	private SellController sellController;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;

	public MainStorePanel(int userNo) {
		
		this.userNo= userNo;
		sellmainPanel = this;
		
		this.sellController = new SellController();

		this.setLayout(null);
		this.setSize(960, 540);

		this.sellController = new SellController();
		int havingCoin = sellController.selectCoin();
		String transCoin = "";
		transCoin = String.valueOf(havingCoin);
		
		/* ---------- 배경화면 라벨  ------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		this.setVisible(true);

		/* ---------- 상점창 구매한다, 판매한다, 그만두기 버튼   ------------*/
		Image buyImage = new ImageIcon("img/store/mainStore/buybutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(132, 95);
		buyButton.setSize(232, 60);

		Image sellImage = new ImageIcon("img/store/mainStore/sellbutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(364, 95);
		sellButton.setSize(232, 60);

		Image backImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton backButton = new JButton(new ImageIcon(backImage));
		backButton.setLocation(596, 95);
		backButton.setSize(232, 60);
		
		Image imgStoreNPC = new ImageIcon("img/store/storeconversTion1.png").getImage().getScaledInstance(758, 120, 0);
		JLabel storeNPC = new JLabel(new ImageIcon(imgStoreNPC));
		storeNPC.setBounds(130, 410, 750, 100);
		
		/* ------- 상점 패널 ---------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		Image success = new ImageIcon("img/store/sellCategory/successimage.png").getImage().getScaledInstance(300, 300, 0);
		JLabel successLabel = new JLabel(new ImageIcon(success));
		successLabel.setLocation(300, 130);
		successLabel.setSize(300, 300); 
		
		/* 재화 라벨*/
		
		/* ---------- 재화 보유 라벨 ------------*/
		Font f1 = new Font("Ink Free", Font.BOLD, 20);
		JTextArea userCoin = new JTextArea("COIN : " + transCoin);
		userCoin.setLocation(600, 400);
		userCoin.setSize(200, 28);
		userCoin.setOpaque(false);
		userCoin.setFont(f1);
		userCoin.setEditable(false);

		
		this.add(userCoin);
		this.add(buyButton);
		this.add(sellButton);
		this.add(backButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
//		this.add(textLabel);
//		this.add(storeNPC);
		
	
		sellButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellCategoryPanel = new SellCategoryPanel(userNo);
				
					FrameManager.changePanel(sellmainPanel, sellCategoryPanel);

			}
			
		});

		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
	
	}

}
