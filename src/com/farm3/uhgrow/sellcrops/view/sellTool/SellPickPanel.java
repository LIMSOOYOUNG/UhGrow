package com.farm3.uhgrow.sellcrops.view.sellTool;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.farm3.uhgrow.buy.view.FrameManager;
import com.farm3.uhgrow.member.store.MainStorePanel;
import com.farm3.uhgrow.sellcrops.controller.sell.SellController;
import com.farm3.uhgrow.sellcrops.controller.sell.SellToolController;
import com.farm3.uhgrow.sellcrops.model.dto.ToolDTO;

public class SellPickPanel extends JPanel{
	
	private JPanel sellPickPanel;
	private SellToolController sellToolController; 
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo; 
	
	public SellPickPanel(int userNo) {
		this.userNo = userNo;
		sellPickPanel = this;
		
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
				
		/* 갯수 입력하는 텍스트필드와 라벨 */
		
		
		JButton confirmButton = new JButton("판매확정");
		confirmButton.setLocation(670, 250);
		confirmButton.setSize(100, 25);

		/* 재화 라벨*/
		
		/* ---------- 재화 보유 라벨 ------------*/
		Font f1 = new Font("Ink Free", Font.BOLD, 20);
		JTextArea userCoin = new JTextArea("COIN : " + transCoin);
		userCoin.setLocation(600, 400);
		userCoin.setSize(200, 28);
		userCoin.setOpaque(false);
		userCoin.setFont(f1);
		userCoin.setEditable(false);		

		this.add(userCoin);
		this.add(confirmButton);
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
	
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				/* 유저의 토마토 수량, 현재 가지고 있는 코인 조회 */
				String toolName = "";
				int userCoin = 0;
				int pickPrice = 0;
				int updateUserPick = 0;
				int getPrice = 0;
				int totalGetPrice = 0;
				
				
				List<ToolDTO> userToolList = sellToolController.userPick(userNo);
				
				for (ToolDTO toolList : userToolList) {
					toolName = toolList.getToolName();
					userCoin = toolList.getCoin();
					pickPrice = toolList.getToolPrice();
				}
				
				if (toolName !=null) {
				} else {
					MainStorePanel mainStorePanel = new MainStorePanel(userNo);
					FrameManager.changePanel(sellPickPanel, mainStorePanel);
					
				}

			}
		
		});	
	
	}

	

}
