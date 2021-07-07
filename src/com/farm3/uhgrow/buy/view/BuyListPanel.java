package com.farm3.uhgrow.buy.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.store.MainStorePanel;
import com.farm3.uhgrow.member.view.FrameManager;

public class BuyListPanel extends JPanel{

	private JPanel buyListPanel;
	
	private int userNo;
	
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);

	
	public BuyListPanel(int userNo) {
		

		buyListPanel = this;	
		
		this.userNo = userNo;

		/* ---------- MainStorePanel 크기 지정 ----------------*/
		this.setLayout(null);
		this.setSize(960,540);


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

		/* -------- 구매 목록 버튼 ---------- */
		JButton btnBuySeed = new JButton("씨앗 구매");
		btnBuySeed.setBounds(150, 170, 400, 40);
		btnBuySeed.setFont(listFont);
		btnBuySeed.setContentAreaFilled(false);
		
		JButton btnBuyTool = new JButton("농기구 구매");
		btnBuyTool.setBounds(150, 230, 400, 40);
		btnBuyTool.setFont(listFont);
		btnBuyTool.setContentAreaFilled(false);

		this.add(btnCancel);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		this.add(btnBuySeed);
		this.add(btnBuyTool);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		btnBuySeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuySeedListPanel buySeedListPanel = new BuySeedListPanel(userNo);

				FrameManager.changePanel(buyListPanel, buySeedListPanel);

			}
		});

		btnBuyTool.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuyToolListPanel buyToolListPanel = new BuyToolListPanel(userNo);

				FrameManager.changePanel(buyListPanel, buyToolListPanel);

			}
		});		
		
		/* ---------- 뒤로 가기 버튼 ----------------*/
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainStorePanel MainStorePanel = new MainStorePanel(userNo);
				
				FrameManager.changePanel(buyListPanel, MainStorePanel);
				
			}
		});		
		/* ---------- 그만 두기 버튼 ----------------*/
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(buyListPanel, FarmPanel);
				
			}
		});		

	}



}
