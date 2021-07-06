package com.farm3.uhgrow.member.store;

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
		Image buyImage = new ImageIcon("img/store/mainstore/buybutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton btnBuy = new JButton(new ImageIcon(buyImage));
		btnBuy.setLocation(132, 95);
		btnBuy.setSize(232, 60);

		Image sellImage = new ImageIcon("img/store/mainstore/sellbutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton btnSell = new JButton(new ImageIcon(sellImage));
		btnSell.setLocation(364, 95);
		btnSell.setSize(232, 60);

		Image backImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton btnBack = new JButton(new ImageIcon(backImage));
		btnBack.setLocation(596, 95);
		btnBack.setSize(232, 60);


		/* ---------- 대화창, 대화창에 큰 상인 이미지 ------------*/
		Image imgConversation = new ImageIcon("img/store/storeconversation1.png").getImage().getScaledInstance(758, 120, 0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setBounds(100, 400, 760, 118);

		Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(90, 150, 0);
		JLabel storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setBounds(750, 350, 90, 150);

		/* ---------- 상인 대화내용  ------------*/
		Font font = new Font("맑은고딕", Font.BOLD, 35);
		JLabel textLabel = new JLabel("빨리 빨리 골라 뭐하러 왔는데? 어 ? ");
		textLabel.setBounds(130, 410, 750, 100);
		textLabel.setFont(font);


		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가  ------------*/


		this.add(textLabel);
		this.add(storeNpc);
		this.add(conversationLabel);
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);


		// 구매한다, 판매한다, 그만두기 버튼 클릭시 체인지 패널 만들어줘야한다.

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
