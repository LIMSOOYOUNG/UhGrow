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

import com.farm3.uhgrow.buy.view.BuyListPanel;
import com.farm3.uhgrow.member.store.MainStorePanel;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.controller.sell.SellController;


public class SellSeedListPanel extends JPanel {

	private JPanel sellSeedListPanel;
	private SellController sellController;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;
	
	public SellSeedListPanel(int userNo) {
		
		this.userNo = userNo;
		sellSeedListPanel = this;
		
		this.setLayout(null);
		this.setSize(960, 540);
		
		this.sellController = new SellController();
		int havingCoin = sellController.selectCoin(userNo);
		String transCoin = "";
		transCoin = String.valueOf(havingCoin);

		/* ---------- 배경화면 라벨  ------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setSize(960, 540);

		/* ---------- 상첨창 배경  ------------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(705, 360, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(127, 90);
		storeBackGroundLabel.setSize(705, 360);
		 
		/* ---------- 상점창 구매한다, 판매한다, 그만두기 버튼   ------------*/
		JButton btnBuy = new JButton("구 매 하 기 ");
		btnBuy.setBounds(132, 95, 232, 60);
		btnBuy.setFont(font);
		btnBuy.setContentAreaFilled(false);

		JButton btnSell = new JButton("판 매 하 기");
		btnSell.setBounds(364, 95, 232, 60);
		btnSell.setFont(font);
		btnSell.setContentAreaFilled(false);

		JButton btnBack = new JButton("그 만 두 기");
		btnBack.setBounds(596, 95, 232, 60);
		btnBack.setFont(font);
		btnBack.setContentAreaFilled(false);
		
		// 구매한다, 판매한다, 그만두기 버튼 뒷배경 
		Image btnBackGroundImage = new ImageIcon("img/store/btnBackGround.png").getImage().getScaledInstance(696, 60, 0);
		JLabel btnBackGround = new JLabel(new ImageIcon(btnBackGroundImage));
		btnBackGround.setBounds(132, 95,  696, 60);
				
		/* ---------- 대화창, 대화창에 큰 상인 이미지 ------------*/
		Image imgConversation = new ImageIcon("img/store/storeconversation1.png").getImage().getScaledInstance(758, 120, 0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setBounds(100, 400, 760, 118);		
		
		Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(90, 150, 0);
		JLabel storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setBounds(750, 350, 90, 150);
		
		/* ---------- 상인 대화내용  ------------*/
		JLabel textLabel = new JLabel("빨리 빨리 팔아 !");
		textLabel.setBounds(130, 410, 750, 100);
		textLabel.setFont(font);

		/* -------- 씨앗 리스트 버튼 ---------- */
		JButton tomatoSeedButton = new JButton("토마토 씨앗");
		tomatoSeedButton.setBounds(150, 170, 400, 40);
		tomatoSeedButton.setFont(listFont);
		tomatoSeedButton.setContentAreaFilled(false);

		JButton cornSeedButton = new JButton("옥수수 씨앗");
		cornSeedButton.setBounds(150, 230, 400, 40);
		cornSeedButton.setFont(listFont);
		cornSeedButton.setContentAreaFilled(false);
		
		JButton garlicSeedButton = new JButton("마늘 씨앗");
		garlicSeedButton.setBounds(150, 290, 400, 40);
		garlicSeedButton.setFont(listFont);
		garlicSeedButton.setContentAreaFilled(false);

		JButton pumpkinSeedButton = new JButton("호박 씨앗");
		pumpkinSeedButton.setBounds(150, 350, 400, 40);
		pumpkinSeedButton.setFont(listFont);
		pumpkinSeedButton.setContentAreaFilled(false);
		
		/* 재화 라벨*/
		
		/* ---------- 재화 보유 라벨 ------------*/
		Font f1 = new Font("Ink Free", Font.BOLD, 20);
		JTextArea userCoin = new JTextArea("COIN : " + transCoin);
		userCoin.setLocation(600, 200);
		userCoin.setSize(200, 28);
		userCoin.setOpaque(false);
		userCoin.setFont(f1);
		userCoin.setEditable(false);		
		
	
		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가  ------------*/

		this.add(textLabel);
		this.add(storeNpc);
		this.add(conversationLabel);
		this.add(userCoin);

		/* ---------- 구매, 판매, 뒤로 버튼 패널에 추가 --------- */
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		
		/* 유저 씨앗  판매 버튼*/
		this.add(tomatoSeedButton);
		this.add(cornSeedButton);
		this.add(garlicSeedButton);
		this.add(pumpkinSeedButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		/*토마토 씨앗 버튼*/
		tomatoSeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				JPanel sellTomatoSeedPanel = new SellTomatoSeedPanel(userNo);
				
				FrameManager.changePanel(sellSeedListPanel, sellTomatoSeedPanel);
				
			}

		});

		/*옥수수 씨앗 버튼*/
		cornSeedButton.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellCornSeedPanel = new SellCornSeedPanel(userNo);
				
				FrameManager.changePanel(sellSeedListPanel, sellCornSeedPanel);
				
			}
			
		});

		/*마늘씨앗 버튼*/
		garlicSeedButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellGarlicSeedPanel = new SellGarlicSeedPanel(userNo);
				
				FrameManager.changePanel(sellSeedListPanel, sellGarlicSeedPanel);
				

			}
			
		});
		
		/*호박 씨앗버튼*/
		pumpkinSeedButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellPumpkinSeedPanel = new SellPumpkinSeedPanel(userNo);
				
				FrameManager.changePanel(sellSeedListPanel, sellPumpkinSeedPanel);
				
			}
			
		});
		
		/* 구매 패널로 가기*/
		btnBuy.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				BuyListPanel buyListPanel = new BuyListPanel(userNo);
				
				FrameManager.changePanel(sellSeedListPanel, buyListPanel);
			}
		});
		
		/* 메인화면으로 넘어가기*/
		btnBack.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				MainStorePanel mainStorePanel = new MainStorePanel(userNo);
				
				FrameManager.changePanel(sellSeedListPanel, mainStorePanel);
			}
		});
		
	}
	
}
