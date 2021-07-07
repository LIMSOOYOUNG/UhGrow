package com.farm3.uhgrow.member.store;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.controller.MemberController;
import com.farm3.uhgrow.member.model.dto.BuyHouseDTO;
import com.farm3.uhgrow.member.view.FrameManager;

public class FailBuyHouse extends JPanel {

	private JPanel failBuyHouse;
	private int userNo;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font npcFont = new Font("나눔손글씨 펜", Font.BOLD, 40);



	public FailBuyHouse(BuyHouseDTO buyHouseDTO) {
		this.userNo = buyHouseDTO.getUserNo();
		failBuyHouse = this;
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
		JButton btnBuyHouse = new JButton("집 구매");
		btnBuyHouse.setBounds(132, 95, 232, 60);
		btnBuyHouse.setFont(font);
		btnBuyHouse.setContentAreaFilled(false);
		btnBuyHouse.setFocusPainted(false);
		btnBuyHouse.setBorderPainted(false);

	
		JButton btnBack = new JButton("그 만 두 기");
		btnBack.setBounds(596, 95, 232, 60);
		btnBack.setFont(font);
		btnBack.setContentAreaFilled(false);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);

		// 구매한다, 판매한다, 그만두기 버튼 뒷배경 
		Image btnBackGroundImage = new ImageIcon("img/store/btnBackGround.png").getImage().getScaledInstance(696, 60, 0);
		JLabel btnBackGround = new JLabel(new ImageIcon(btnBackGroundImage));
		btnBackGround.setBounds(132, 95,  696, 60);

		/* ---------- 대화창, 대화창에 큰 할머니 이미지 ------------*/
		Image imgConversation = new ImageIcon("img/store/storeconversation1.png").getImage().getScaledInstance(758, 120, 0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setBounds(100, 400, 760, 118);

		Image imgStoreNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(90, 150, 0);
		JLabel storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setBounds(750, 350, 90, 150);

		/* ---------- 할머니와 대화내용  ------------*/
		JLabel npcTextLabel = new JLabel("이런이런.. 그 돈으론 집을 살 수 없어... ");
		npcTextLabel.setBounds(120, 410, 750, 40);
		npcTextLabel.setFont(npcFont);
		
		JLabel npcTextLabel1 = new JLabel("집 가격은  " + buyHouseDTO.getHousePrice() +"원 이라네..");
		npcTextLabel1.setBounds(120, 460, 750, 40);
		npcTextLabel1.setFont(npcFont);

		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가  ------------*/

		this.add(storeNpc);
		this.add(npcTextLabel);
		this.add(npcTextLabel1);
		this.add(conversationLabel);
		this.add(btnBack);
		this.add(btnBuyHouse);
		this.add(btnBackGround);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		
		
		failBuyHouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				BuyHouseAndCookPanel buyHouseAndCookPanel = new BuyHouseAndCookPanel(userNo);
				
				FrameManager.changePanel(failBuyHouse, buyHouseAndCookPanel);
//				
//				FarmPanel farmPanel = new FarmPanel(userNo);
//				FrameManager.changePanel(failBuyHouse, farmPanel);
			}
		});
		
		
		
	}
}
