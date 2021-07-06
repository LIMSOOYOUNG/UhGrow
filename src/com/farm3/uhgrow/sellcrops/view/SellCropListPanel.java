package com.farm3.uhgrow.sellcrops.view;

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

public class SellCropListPanel extends JPanel {

	private JPanel sellCropListPanel;
	private SellController sellController;
	private int userNo;
	
	public SellCropListPanel(int userNo) {

		this.userNo = userNo;
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);

		sellCropListPanel = this;

		this.setLayout(null);
		this.setSize(960, 540);
		
		this.sellController = new SellController();
		int havingCoin = sellController.selectCoin();
		String transCoin = "";
		transCoin = String.valueOf(havingCoin);

		/* ---------- 배경화면 라벨 ------------ */
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		this.setVisible(true);

		/* ---------- 상점창 구매한다, 판매한다, 그만두기 버튼 ------------ */
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

		/* ------- 상점 패널 --------- */
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		/* -------- 작물 리스트 버튼 ---------- */
		JButton tomatoCropButton = new JButton("토마토");
		tomatoCropButton.setLocation(70, 200);
		tomatoCropButton.setSize(100, 25);

		JButton cornCropButton = new JButton("옥수수");
		cornCropButton.setLocation(70, 250);
		cornCropButton.setSize(100, 25);

		JButton garlicCropButton = new JButton("마늘");
		garlicCropButton.setLocation(70, 300);
		garlicCropButton.setSize(100, 25);

		JButton pumpkinCropButton = new JButton("호박");
		pumpkinCropButton.setLocation(70, 350);
		pumpkinCropButton.setSize(100, 25);

		/*-------------- 작물판매 텍스트 ---------------*/

		JLabel sellCropLabel = new JLabel("<작물 판매>");
		sellCropLabel.setLocation(410, 180);
		sellCropLabel.setSize(200, 25);
		sellCropLabel.setFont(font);
		
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
		this.add(sellCropLabel);
		this.add(buyButton);
		this.add(sellButton);
		this.add(backButton);
		this.add(tomatoCropButton);
		this.add(cornCropButton);
		this.add(garlicCropButton);
		this.add(pumpkinCropButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		tomatoCropButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellTomatoAmountPanel = new SellTomatoAmountPanel();
				
				FrameManager.changePanel(sellCropListPanel, sellTomatoAmountPanel);
			}

		});

		cornCropButton.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellCornAmountPanel = new SellCornAmountPanel();
				
				FrameManager.changePanel(sellCropListPanel, sellCornAmountPanel);
				
			}
			
		});

		garlicCropButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellGarlicAmountPanel = new SellGarlicAmountPanel();
				
				FrameManager.changePanel(sellCropListPanel, sellGarlicAmountPanel);
			}
			
		});
		
		pumpkinCropButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellPumpkinAmountPanel = new SellPumpkinAmountPanel();
				
				FrameManager.changePanel(sellCropListPanel, sellPumpkinAmountPanel);
				
			}
			
		});
	
	}

}
