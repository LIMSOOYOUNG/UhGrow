package com.farm3.uhgrow.sellcrops.view.sellseed;

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


public class SellSeedListPanel extends JPanel {

	private JPanel sellSeedListPanel;
	private SellController sellController;
	
	public SellSeedListPanel() {
		
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);
		
		sellSeedListPanel = this;
		
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

		/* ------- 상점 패널 ---------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		/* -------- 씨앗 리스트 버튼 ---------- */
		JButton tomatoSeedButton = new JButton("토마토");
		tomatoSeedButton.setLocation(70, 200);
		tomatoSeedButton.setSize(100, 25);

		JButton cornSeedButton = new JButton("옥수수");
		cornSeedButton.setLocation(70, 250);
		cornSeedButton.setSize(100, 25);

		JButton garlicSeedButton = new JButton("마늘");
		garlicSeedButton.setLocation(70, 300);
		garlicSeedButton.setSize(100, 25);

		JButton pumpkinSeedButton = new JButton("호박");
		pumpkinSeedButton.setLocation(70, 350);
		pumpkinSeedButton.setSize(100, 25);

		/*-------------- 씨앗판매 텍스트 ---------------*/

		JLabel sellSeedLabel = new JLabel("<씨앗 판매>");
		sellSeedLabel.setBounds(410, 180, 200, 25);
		
		sellSeedLabel.setFont(font);
		
		
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
		this.add(sellSeedLabel);
		this.add(buyButton);
		this.add(sellButton);
		this.add(backButton);
		this.add(tomatoSeedButton);
		this.add(cornSeedButton);
		this.add(garlicSeedButton);
		this.add(pumpkinSeedButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);


		tomatoSeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				JPanel sellTomatoSeedPanel = new SellTomatoSeedPanel();
				
				FrameManager.changePanel(sellSeedListPanel, sellTomatoSeedPanel);
				
			}

		});

		cornSeedButton.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellCornSeedPanel = new SellCornSeedPanel();
				
				FrameManager.changePanel(sellSeedListPanel, sellCornSeedPanel);
				
			}
			
		});

		garlicSeedButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellGarlicSeedPanel = new SellGarlicSeedPanel();
				
				FrameManager.changePanel(sellSeedListPanel, sellGarlicSeedPanel);
				

			}
			
		});
		
		pumpkinSeedButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellPumpkinSeedPanel = new SellPumpkinSeedPanel();
				
				FrameManager.changePanel(sellSeedListPanel, sellPumpkinSeedPanel);
				
			}
			
		});
	
	}
	
}
