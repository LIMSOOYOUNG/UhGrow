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

import com.farm3.uhgrow.buy.view.BuyListPanel;
import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.store.MainStorePanel;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.controller.sell.SellController;
import com.farm3.uhgrow.sellcrops.view.sellCrop.SellCropListPanel;
import com.farm3.uhgrow.sellcrops.view.sellTool.SellToolListPanel;
import com.farm3.uhgrow.sellcrops.view.sellfood.SellFoodListPanel;
import com.farm3.uhgrow.sellcrops.view.sellseed.SellSeedListPanel;

public class SellCategoryPanel extends JPanel{
	
	private JPanel sellCategoryPanel;
	private SellController sellController;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;		
	
	public SellCategoryPanel(int userNo) {
		
		this.userNo = userNo;
		sellCategoryPanel = this;
		
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
		JButton btnSell = new JButton("판 매 하 기");
		btnSell.setBounds(132, 95, 232, 60);
		btnSell.setFont(font);
		btnSell.setContentAreaFilled(false);
		
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
		
		/* -------- 판매 목록 버튼 ---------- */
		/* 선택 버튼 4가지 (지울거임)*/
		JButton btnFirst = new JButton("씨앗 판매");
		btnFirst.setBounds(150, 170, 400, 40);
		btnFirst.setFont(listFont);
		btnFirst.setContentAreaFilled(false);
		
		JButton btnSecond = new JButton("농작물 판매");
		btnSecond.setBounds(150, 230, 400, 40);
		btnSecond.setFont(listFont);
		btnSecond.setContentAreaFilled(false);
		
		JButton btnThird = new JButton("농기구 판매");
		btnThird.setBounds(150, 290, 400, 40);
		btnThird.setFont(listFont);
		btnThird.setContentAreaFilled(false);
		
		JButton btnFourth  = new JButton("요리 판매");
		btnFourth.setBounds(150, 350, 400, 40);
		btnFourth.setFont(listFont);
		btnFourth.setContentAreaFilled(false);

		/* 재화 라벨*/
		
		/* ---------- 재화 보유 라벨 ------------*/
		Font f1 = new Font("Ink Free", Font.BOLD, 20);
		JTextArea userCoin = new JTextArea("COIN : " + transCoin);
		userCoin.setLocation(600, 200);
		userCoin.setSize(200, 28);
		userCoin.setOpaque(false);
		userCoin.setFont(f1);
		userCoin.setEditable(false);
		
		this.add(userCoin);
		/* ---------- 구매, 판매, 뒤로 버튼 패널에 추가 --------- */
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnCancel);
		this.add(btnBackGround);
		
		/* -----------선택 항목들 버튼 패널에 추가 (지울거임)---------------*/
		this.add(btnFirst);
		this.add(btnSecond);
		this.add(btnThird);
		this.add(btnFourth);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		/*씨앗 판매*/
		btnFirst.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel sellSeedListPanel = new SellSeedListPanel(userNo);
				
				FrameManager.changePanel(sellCategoryPanel, sellSeedListPanel);
			}
			
		});
		
		/*작물 판매*/
		btnSecond.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel sellCropListPanel = new SellCropListPanel(userNo);
				
				FrameManager.changePanel(sellCategoryPanel, sellCropListPanel);
				
				
			}
			
		});
		
		/*농기구 판매*/
		btnThird.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellToolListPanel = new SellToolListPanel(userNo);
				
				FrameManager.changePanel(sellCategoryPanel, sellToolListPanel);
				
				
			}
			
		});
		
		/*요리 판매*/
		btnFourth.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			
				JPanel sellFoodListPanel = new SellFoodListPanel(userNo);
				
				FrameManager.changePanel(sellCategoryPanel, sellFoodListPanel);
			}
			
		});
		
		
		/* ---------- 뒤로 가기 버튼 ----------------*/
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainStorePanel MainStorePanel = new MainStorePanel(userNo);
				
				FrameManager.changePanel(sellCategoryPanel, MainStorePanel);
				
			}
		});		
		/* ---------- 그만 두기 버튼 ----------------*/
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(sellCategoryPanel, FarmPanel);
				
			}
		});		
		
	}

}
