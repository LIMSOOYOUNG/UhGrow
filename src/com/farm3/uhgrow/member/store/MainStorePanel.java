package com.farm3.uhgrow.member.store;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.buy.view.BuyListPanel;
import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.view.SellCategoryPanel;

public class MainStorePanel extends JPanel {

	private JPanel MainStorePanel;
	private int userNo;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 30);


	public MainStorePanel(int userNo) {
		this.userNo = userNo;
		MainStorePanel = this;
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
		JLabel textLabel = new JLabel("빨리 빨리 골라 뭐하러 왔는데? 어 ? ");
		textLabel.setBounds(130, 410, 750, 100);
		textLabel.setFont(font);
		
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
		
		

		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가  ------------*/

		this.add(textLabel);
		this.add(storeNpc);
		this.add(conversationLabel);
		/* ---------- 구매, 판매, 뒤로 버튼 패널에 추가 --------- */
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		/* -----------선택 항목들 버튼 패널에 추가 (지울거임)---------------*/
		this.add(btnFirst);
		this.add(btnSecond);
		this.add(btnThird);
		this.add(btnFourth);
		
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		btnBack.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				FarmPanel farmPanel = new FarmPanel(userNo);
				FrameManager.changePanel(MainStorePanel, farmPanel);
			}
		});
		btnBuy.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				BuyListPanel buyListPanel = new BuyListPanel(userNo);
				
				FrameManager.changePanel(MainStorePanel, buyListPanel);
			}
		});
		btnSell.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				SellCategoryPanel sellCategoryPanel = new SellCategoryPanel(userNo);
				
				FrameManager.changePanel(MainStorePanel, sellCategoryPanel);
			}
		});
	}
}
