package com.farm3.uhgrow.member.store;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.security.auth.login.FailedLoginException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.controller.MemberController;
import com.farm3.uhgrow.member.model.dto.BuyHouseDTO;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.store.cooking.view.CookingPanel;

public class BuyHousePanel extends JPanel {

	private JPanel buyHousePanel;
	private int userNo;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font btnFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	FarmPanel farmPanel;
	private JLabel textLabel;
	BuyHouseDTO buyHouseDTO;
	BuyHouseCheckPanel buyHouseCheckPanel;
	MemberController memberController = new MemberController();

	// 집구매, 요리하기 가능한 상점에서 집 구매 버튼 클릭시 나오는 화면
	public BuyHousePanel(int userNo) {
		farmPanel = new FarmPanel(userNo);
		
		this.userNo = userNo;
		buyHousePanel = this;
		/* ---------- 집구매, 요리하기 가능한 상점 크기 지정 ---------------- */
		this.setLayout(null);
		this.setSize(960, 540);

		/* ---------- 배경화면 라벨 ------------ */
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);

		/* ---------- 상첨창 배경 ------------ */
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(705, 360,
				0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(127, 90);
		storeBackGroundLabel.setSize(705, 360);

		/* ---------- 상점창 집 구매, 요리하기, 그만두기 버튼 ------------ */
		JButton btnBuyHouse = new JButton("집 구매");
		btnBuyHouse.setBounds(132, 95, 232, 60);
		btnBuyHouse.setFont(font);
		btnBuyHouse.setContentAreaFilled(false);
		btnBuyHouse.setFocusPainted(false);

		JButton btnBack = new JButton("그 만 두 기");
		btnBack.setBounds(596, 95, 232, 60);
		btnBack.setFont(font);
		btnBack.setContentAreaFilled(false);

		// 구매한다, 판매한다, 그만두기 버튼 뒷배경
		Image btnBackGroundImage = new ImageIcon("img/store/btnBackGround.png").getImage().getScaledInstance(696, 60,
				0);
		JLabel btnBackGround = new JLabel(new ImageIcon(btnBackGroundImage));
		btnBackGround.setBounds(132, 95, 696, 60);

		/* ---------- 대화창, 대화창에 큰 할머니 이미지 ------------ */
		Image imgConversation = new ImageIcon("img/store/storeconversation1.png").getImage().getScaledInstance(758, 120,
				0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setBounds(100, 400, 760, 118);

		Image imgStoreNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(90, 150, 0);
		JLabel storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setBounds(750, 350, 90, 150);

		/* ---------- 할머니와 대화내용 ------------ */
		textLabel = new JLabel("오호라 집을 구매하시겠다? ! 드디어?!!!");
		textLabel.setBounds(130, 390, 750, 100);
		textLabel.setFont(font);

		JButton btnYes = new JButton("넹!!");
		btnYes.setBounds(630, 480, 80, 30);
		btnYes.setFont(btnFont);
		btnYes.setBackground(Color.darkGray);
		btnYes.setForeground(Color.white);

		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가 ------------ */

		this.add(btnYes);
		this.add(storeNpc);
		this.add(textLabel);
		this.add(conversationLabel);
		this.add(btnBuyHouse);
		this.add(btnBack);
		this.add(btnBackGround);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FrameManager.changePanel(buyHousePanel, farmPanel);
			}
		});

		btnYes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				
				// userNo, coin, housePrice
				buyHouseDTO = memberController.buyHouse(userNo);
				buyHouseDTO.setUserNo(userNo);
				buyHouseCheckPanel = new BuyHouseCheckPanel(buyHouseDTO);
				FrameManager.changePanel(buyHousePanel, buyHouseCheckPanel);

			}
		});

	}
}
