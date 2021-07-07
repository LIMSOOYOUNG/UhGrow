package com.farm3.uhgrow.sellcrops.view.sellfood;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.controller.sell.SellFoodController;
import com.farm3.uhgrow.sellcrops.view.SellCategoryPanel;

public class SellFoodListPanel extends JPanel {
	
	private JPanel sellFoodListPanel;
	private SellFoodController sellFoodController;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;
	
	public SellFoodListPanel(int userNo) {
		this.userNo = userNo;
		sellFoodListPanel = this;
		
		this.setLayout(null);
		this.setSize(960, 540);
		
		this.sellFoodController = new SellFoodController();
		int havingCoin = sellFoodController.selectCoin(userNo);
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
		JButton btnBuy = new JButton("판 매 하 기 ");
		btnBuy.setBounds(132, 95, 232, 60);
		btnBuy.setFont(font);
		btnBuy.setContentAreaFilled(false);

		JButton btnCancel = new JButton("뒤 로 가 기");
		btnCancel.setBounds(364, 95, 232, 60);
		btnCancel.setFont(font);
		btnCancel.setContentAreaFilled(false);

		JButton btnBack = new JButton("그 만 두 기");
		btnBack.setBounds(596, 95, 232, 60);
		btnBack.setFont(font);
		btnBack.setContentAreaFilled(false);
		
		// 구매한다, 판매한다, 그만두기 버튼 뒷배경 
		Image btnBackGroundImage = new ImageIcon("img/store/btnBackGround.png").getImage().getScaledInstance(696, 60, 0);
		JLabel btnBackGround = new JLabel(new ImageIcon(btnBackGroundImage));
		btnBackGround.setBounds(132, 95,  696, 60);
								

		/* -------- 작물 리스트 버튼 ---------- */
		JButton tomatoPizzaButton = new JButton("토마토피자");
		tomatoPizzaButton.setBounds(150, 170, 400, 40);
		tomatoPizzaButton.setFont(listFont);
		tomatoPizzaButton.setContentAreaFilled(false);

		JButton cornTortillaButton = new JButton("옥수수또띠아");
		cornTortillaButton.setBounds(150, 230, 400, 40);
		cornTortillaButton.setFont(listFont);
		cornTortillaButton.setContentAreaFilled(false);

		JButton garlicJuiceButton = new JButton("마늘즙");
		garlicJuiceButton.setBounds(150, 290, 400, 40);
		garlicJuiceButton.setFont(listFont);
		garlicJuiceButton.setContentAreaFilled(false);

		JButton pumpkinSoupButton = new JButton("호박죽");
		pumpkinSoupButton.setBounds(150, 350, 400, 40);
		pumpkinSoupButton.setFont(listFont);
		pumpkinSoupButton.setContentAreaFilled(false);
		
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

		this.add(userCoin);

		/* ---------- 구매, 판매, 뒤로 버튼 패널에 추가 --------- */
		this.add(btnCancel);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		
		/* 유저 음식  판매 버튼*/

		this.add(tomatoPizzaButton);
		this.add(cornTortillaButton);
		this.add(garlicJuiceButton);
		this.add(pumpkinSoupButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		 tomatoPizzaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellTomatoPizzaPanel = new SellTomatoPizzaPanel(userNo);
				
				FrameManager.changePanel(sellFoodListPanel, sellTomatoPizzaPanel);
			}

		});

		cornTortillaButton.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellCornTortillaPanel = new SellCornTortillaPanel(userNo);
				
				FrameManager.changePanel(sellFoodListPanel, sellCornTortillaPanel);
				
			}
			
		});

		garlicJuiceButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellGarlicJuicePanel = new SellGarlicJuicePanel(userNo);
				
				FrameManager.changePanel(sellFoodListPanel, sellGarlicJuicePanel);
			}
			
		});
		
		pumpkinSoupButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellpumpkinSoupPanel = new SellPumpkinSoupPanel(userNo);
				
				FrameManager.changePanel(sellFoodListPanel, sellpumpkinSoupPanel);
				
			}
			
		});
		
		/* ---------- 뒤록 가기 버튼 ----------------*/

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SellCategoryPanel sellCategoryPanel = new SellCategoryPanel(userNo);

				FrameManager.changePanel(sellFoodListPanel, sellCategoryPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(sellFoodListPanel, FarmPanel);
				
			}
		});	
		
	}	
	
}
