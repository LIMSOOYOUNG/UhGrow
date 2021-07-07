package com.farm3.uhgrow.sellcrops.view.sellTool;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.controller.sell.SellController;
import com.farm3.uhgrow.sellcrops.controller.sell.SellToolController;

public class SellToolListPanel extends JPanel {
	
	private JPanel sellToolListPanel;
	private SellToolController sellToolController;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;
	
	public SellToolListPanel(int userNo) {
		
		this.userNo = userNo;
		sellToolListPanel = this;
		
		this.setLayout(null);
		this.setSize(960, 540);
		this.sellToolController = new SellToolController();
		
		SellController sellController = new SellController();
		
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
		JLabel textLabel = new JLabel("빨리 빨리 팔아 !");
		textLabel.setBounds(130, 410, 750, 100);
		textLabel.setFont(font);

		/* -------- 농기구 리스트 버튼 ---------- */
		JButton pickButton = new JButton("곡괭이");
		pickButton.setBounds(150, 170, 400, 40);
		pickButton.setFont(listFont);
		pickButton.setContentAreaFilled(false);

		JButton shovelButton = new JButton("삽");
		shovelButton.setBounds(150, 230, 400, 40);
		shovelButton.setFont(listFont);
		shovelButton.setContentAreaFilled(false);
		
		JButton hoeButton = new JButton("호미");
		hoeButton.setBounds(150, 290, 400, 40);
		hoeButton.setFont(listFont);
		hoeButton.setContentAreaFilled(false);

		JButton wateringCanButton = new JButton("물뿌리개");
		wateringCanButton.setBounds(150, 350, 400, 40);
		wateringCanButton.setFont(listFont);
		wateringCanButton.setContentAreaFilled(false);
		
		/* 재화 라벨*/
		
		/* ---------- 재화 보유 라벨 ------------*/
		Font f1 = new Font("Ink Free", Font.BOLD, 20);
		JTextArea userCoin = new JTextArea("COIN : " + transCoin);
		userCoin.setLocation(600, 200);
		userCoin.setSize(200, 28);
		userCoin.setOpaque(false);
		userCoin.setFont(f1);
		userCoin.setEditable(false);
		
		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가  ------------*/

		this.add(textLabel);
		this.add(storeNpc);
		this.add(conversationLabel);
		this.add(userCoin);

		/* ---------- 구매, 판매, 뒤로 버튼 패널에 추가 --------- */
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		
		/* 유저 씨앗  판매 버튼*/
		this.add(pickButton);
		this.add(shovelButton);
		this.add(hoeButton);
		this.add(wateringCanButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
		/*곡괭이 버튼*/
		pickButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellPickPanel = new SellPickPanel(userNo);
				
				FrameManager.changePanel(sellToolListPanel, sellPickPanel);
				
			}

		});
		/*삽 버튼*/
		shovelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		/*호미 버튼*/
		
		hoeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		/*곡괭이 버튼*/
		pickButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		
		
	}
	
	
}
