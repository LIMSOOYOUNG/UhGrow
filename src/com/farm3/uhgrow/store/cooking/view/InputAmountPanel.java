package com.farm3.uhgrow.store.cooking.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.store.cooking.controller.CookingController;

public class InputAmountPanel {
	private static final Font Font = null;
	private JPanel inputAmountPanel;
	private int userNo;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFond = new Font("나눔손글씨 펜", Font.BOLD, 30);
	private JButton btnCooking;
	private CookingController cookingController;



	public InputAmountPanel(int userNo) {
		this.userNo = userNo;
		this.cookingController = new CookingController();
		inputAmountPanel = this;
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

		JButton btnCook = new JButton("요 리 하 기");
		btnCook.setBounds(364, 95, 232, 60);
		btnCook.setFont(font);
		btnCook.setContentAreaFilled(false);

		JButton btnBack = new JButton("그 만 두 기");
		btnBack.setBounds(596, 95, 232, 60);
		btnBack.setFont(font);
		btnBack.setContentAreaFilled(false);

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
		JLabel textLabel = new JLabel("뭔 요리를 한다고 그래 !");
		textLabel.setBounds(130, 410, 750, 100);
		textLabel.setFont(font);
		
		JButton btnFirst = new JButton("토마토 피자");
		btnFirst.setBounds(150, 170, 400, 40);
		btnFirst.setFont(listFond);
		btnFirst.setContentAreaFilled(false);
		
		JButton btnSecond = new JButton("옥수수 또띠아");
		btnSecond.setBounds(150, 230, 400, 40);
		btnSecond.setFont(listFond);
		btnSecond.setContentAreaFilled(false);
		
		JButton btnThird = new JButton("마늘즙");
		btnThird.setBounds(150, 290, 400, 40);
		btnThird.setFont(listFond);
		btnThird.setContentAreaFilled(false);
		
		JButton btnFourth  = new JButton("호박죽");
		btnFourth.setBounds(150, 350, 400, 40);
		btnFourth.setFont(listFond);
		btnFourth.setContentAreaFilled(false);

		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가  ------------*/
		JTextField inputAmount = new JTextField();
		inputAmount.setLocation(400, 300);
		inputAmount.setSize(100, 20);
		this.add(inputAmount);

		this.add(storeNpc);
		this.add(textLabel);
		this.add(conversationLabel);
		
		this.add(btnBack);
		this.add(btnCook);
		this.add(btnBuyHouse);
		this.add(btnBackGround);
		
		this.add(btnFirst);
		this.add(btnSecond);
		this.add(btnThird);
		this.add(btnFourth);
		
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
		

		// 집 구매, 요리하기, 그만두기 클릭시 체인지 패널 userNo 전달인자로 넘겨주면서 받아줘야한다.

}
