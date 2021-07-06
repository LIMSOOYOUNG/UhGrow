package com.farm3.uhgrow.buy.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.member.store.MainStorePanel;
import com.farm3.uhgrow.member.view.FrameManager;

public class BuyListPanel extends JPanel{

	private JPanel buyListPanel;
	private JButton sellButton;
	private JButton buyButton;
	private JButton backButton;
	private JButton seedListButton;
	private JButton toolListButton;
	private int userNo;
	
	public BuyListPanel(int userNo) {


		this.userNo = userNo;
		

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
		Image buyImage = new ImageIcon("img/store/mainStore/buybutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(132, 95);
		buyButton.setSize(232, 60);

		Image sellImage = new ImageIcon("img/store/mainStore/sellbutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(364, 95);
		sellButton.setSize(232, 60);

		Image backImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton btnBack = new JButton(new ImageIcon(backImage));
		btnBack.setLocation(596, 95);
		btnBack.setSize(232, 60);

		/* ------- 상점 패널 ---------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		/* -------- 판매 목록 버튼 ---------- */
		JButton seedListButton = new JButton("씨앗 구매");
		seedListButton.setLocation(70, 200);
		seedListButton.setSize(100, 25);

		JButton toolListButton = new JButton("농기구 구매");
		toolListButton.setLocation(70, 250);
		toolListButton.setSize(100, 25);

		this.add(buyButton);
		this.add(sellButton);
		this.add(btnBack);
		this.add(seedListButton);
		this.add(toolListButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		seedListButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel buyTomatoSeedPanel = new BuyTomatoSeedPanel();

				FrameManager.changePanel(buyListPanel, buyTomatoSeedPanel);

			}
		});

		toolListButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel buyToolListPanel = new BuyToolListPanel();

				FrameManager.changePanel(buyListPanel, buyToolListPanel);

			}
		});		
		btnBack.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				MainStorePanel mainStorePanel = new MainStorePanel(userNo);
				
				FrameManager.changePanel(buyListPanel, mainStorePanel);
			}
		});

		


	}



}
