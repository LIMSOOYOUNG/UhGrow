package com.farm3.uhgrow.member.store;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BuyHouseAndCookPanel extends JPanel {

	private JPanel BuyHouseAndCookPanel;
	
	public BuyHouseAndCookPanel() {
		
		BuyHouseAndCookPanel = this;
		/* ---------- 집구매, 요리하기 가능한 상점 크기 지정 ----------------*/
		this.setLayout(null);
		this.setSize(960,540);
		
		/* ---------- 배경화면 라벨  ------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		
		/* ---------- 상첨창 배경  ------------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(705, 360, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(127, 90);
		storeBackGroundLabel.setSize(705, 360);

		/* ---------- 상점창 집 구매, 요리하기, 그만두기 버튼   ------------*/
		Image buyHouseImage = new ImageIcon("img/store/cookandbuyhouse/buyHouse.png").getImage().getScaledInstance(232, 60, 0);
		JButton btnBuyHouse = new JButton(new ImageIcon(buyHouseImage));
		btnBuyHouse.setLocation(132, 95);
		btnBuyHouse.setSize(232, 60);

		Image cookImage = new ImageIcon("img/store/cookandbuyhouse/cook.png").getImage().getScaledInstance(232, 60, 0);
		JButton btnCook = new JButton(new ImageIcon(cookImage));
		btnCook.setLocation(364, 95);
		btnCook.setSize(232, 60);

		Image backImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton btnBack = new JButton(new ImageIcon(backImage));
		btnBack.setLocation(596, 95);
		btnBack.setSize(232, 60);
		
		/* ---------- 대화창, 대화창에 큰 할머니 이미지 ------------*/
		Image imgConversation = new ImageIcon("img/store/storeconversation1.png").getImage().getScaledInstance(758, 120, 0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setBounds(100, 400, 760, 118);

		Image imgStoreNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(90, 150, 0);
		JLabel storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setBounds(750, 350, 90, 150);

		/* ---------- 할머니와 대화내용  ------------*/
		Font font = new Font("맑은고딕", Font.BOLD, 35);
		JLabel textLabel = new JLabel("무얼 하고 싶은게야... ");
		textLabel.setBounds(130, 410, 750, 100);
		textLabel.setFont(font);
		
		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가  ------------*/

		this.add(storeNpc);
		this.add(textLabel);
		this.add(conversationLabel);
		this.add(btnBack);
		this.add(btnCook);
		this.add(btnBuyHouse);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
	}
}
