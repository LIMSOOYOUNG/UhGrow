package com.farm3.uhgrow.buy.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.buy.view.buyTool.HoeResultPanel;
import com.farm3.uhgrow.buy.view.buyTool.PickaxeResultPanel;
import com.farm3.uhgrow.buy.view.buyTool.ShovelResultPanel;
import com.farm3.uhgrow.buy.view.buyTool.WateringCanResultPanel;
import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.view.FrameManager;

public class BuyToolListPanel extends JPanel{

	private JPanel buyToolListPanel;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;

	public BuyToolListPanel(int userNo) {
		buyToolListPanel = this;

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
		
		/* ---------- 상인 대화내용  ------------*/
		JLabel textLabel = new JLabel("빨리 빨리 팔아 !");
		textLabel.setBounds(130, 410, 750, 100);
		textLabel.setFont(font);

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

		/* -------- 농기구 리스트 버튼 ---------- */


		JButton btnPickaxe = new JButton("곡괭이");
		btnPickaxe.setBounds(150, 170, 400, 40);
		btnPickaxe.setFont(listFont);
		btnPickaxe.setContentAreaFilled(false);

		JButton btnShovel = new JButton("삽");
		btnShovel.setBounds(150, 230, 400, 40);
		btnShovel.setFont(listFont);
		btnShovel.setContentAreaFilled(false);

		JButton btnHoe = new JButton("호미");
		btnHoe.setBounds(150, 290, 400, 40);
		btnHoe.setFont(listFont);
		btnHoe.setContentAreaFilled(false);

		JButton btnWateringCan  = new JButton("물뿌리개");
		btnWateringCan.setBounds(150, 350, 400, 40);
		btnWateringCan.setFont(listFont);
		btnWateringCan.setContentAreaFilled(false);


		/*-------------- 농기구 구매 텍스트 ---------------*/

		JLabel toolBuyLabel = new JLabel("<농기구 구매>");
		toolBuyLabel.setBounds(600, 180, 200, 35);
		toolBuyLabel.setFont(font);



		/* ---------- 구매, 판매, 뒤로 버튼 패널에 추가 --------- */
		this.add(btnCancel);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		this.add(btnPickaxe);
		this.add(btnShovel);
		this.add(btnHoe);
		this.add(btnWateringCan);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		btnPickaxe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PickaxeResultPanel pickaxeResultPanel = new PickaxeResultPanel(userNo);

				FrameManager.changePanel(buyToolListPanel, pickaxeResultPanel);
			}
		});

		btnShovel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShovelResultPanel shovelResultPanel = new ShovelResultPanel(userNo);

				FrameManager.changePanel(buyToolListPanel, shovelResultPanel);

			}
		});

		btnHoe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameManager.changePanel(buyToolListPanel, new HoeResultPanel(userNo));

			}
		});

		btnWateringCan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WateringCanResultPanel wateringCanResultPanel = new WateringCanResultPanel(userNo);

				FrameManager.changePanel(buyToolListPanel, wateringCanResultPanel);

			}
		});
		
		/* ---------- 뒤록 가기 버튼 ----------------*/

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuyListPanel buyListPanel = new BuyListPanel(userNo);

				FrameManager.changePanel(buyToolListPanel, buyListPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(buyToolListPanel, FarmPanel);
				
			}
		});	
	}

}


