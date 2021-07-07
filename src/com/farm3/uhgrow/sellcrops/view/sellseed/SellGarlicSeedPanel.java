package com.farm3.uhgrow.sellcrops.view.sellseed;

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
import javax.swing.JTextField;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.controller.sell.SellController;
import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

public class SellGarlicSeedPanel extends JPanel {
	
	private JPanel sellGarlicSeedPanel;
	private SellController sellController;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;
	
	public SellGarlicSeedPanel(int userNo) {
		this.userNo = userNo;
		this.sellController = new SellController();
		
		this.setLayout(null);
		this.setSize(960, 540);
		
		sellGarlicSeedPanel = this;
	
		this.sellController = new SellController();
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
		JButton btnSell = new JButton("판 매 하 기");
		btnSell.setBounds(132, 95, 232, 60);
		btnSell.setFont(font);
		btnSell.setContentAreaFilled(false);
		
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
				
		/*------------------- 판매 확정 --------------------*/

		JLabel seedInPutLabel = new JLabel("<갯수 입력>");
		seedInPutLabel.setBounds(390, 250, 200, 40);
		seedInPutLabel.setFont(font);

		JTextField seedInputField = new JTextField();
		seedInputField.setBounds(410, 300, 140, 25);
		seedInputField.setLayout(null);
		seedInputField.setFont(font);
		
		JButton sellSeedButton = new JButton("판매확정");
		sellSeedButton.setLocation(430, 335);
		sellSeedButton.setSize(100, 25);
		
		JLabel garlicSeedPriceLabel = new JLabel("마늘씨앗의 판매가격은 300원 입니다!");
		garlicSeedPriceLabel.setBounds(190, 165, 700, 40);
		garlicSeedPriceLabel.setFont(font);

		/* 재화 라벨*/
		/* ---------- 재화 보유 라벨 ------------*/
		Font f1 = new Font("Ink Free", Font.BOLD, 20);
		JTextArea userCoin = new JTextArea("COIN : " + transCoin);
		userCoin.setLocation(600, 400);
		userCoin.setSize(200, 28);
		userCoin.setOpaque(false);
		userCoin.setFont(f1);
		userCoin.setEditable(false);		
		
		this.add(garlicSeedPriceLabel);
		this.add(userCoin);
		this.add(sellSeedButton);
		this.add(seedInputField);
		this.add(seedInPutLabel);
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnCancel);
		this.add(btnBackGround);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
		sellSeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String inputAmount = seedInputField.getText().toString();
				int sellAmount = Integer.parseInt(inputAmount);

				/* 유저의 옥수수씨앗 수량, 현재 가지고 있는 코인, 옥수수 가격 조회 조회 */
				int garlicSeedAmount = 0;
				int userCoin = 0;
				int garlicSeedPrice = 0;
				int updateUserGarlicSeedAmount = 0;
				int getPrice = 0;
				int totalGarlicSeedAmonut = 0;
				int totalGetPrice = 0;
				
				SellController sellController = new SellController();
				
				List<CropDTO> userCropList = sellController.userGarlicSeed(userNo);
				
				for (CropDTO cropList : userCropList) {
					garlicSeedAmount = cropList.getCropAmount();
					userCoin = cropList.getCoin();
					garlicSeedPrice = cropList.getCropPrice();
				}
				
				/* 유저의 농작물과, 농작물 수량, 현재 가지고 있는 코인 조회 */
				
				if (sellAmount> 0 && sellAmount <= garlicSeedAmount && garlicSeedAmount != 0) {
					/* 농작물 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트 */
					updateUserGarlicSeedAmount = sellController.updateUserGarlicSeed(sellAmount, userNo);
					
					getPrice = sellController.sellGarlicSeedGetCoin(sellAmount, garlicSeedPrice, userNo);

					if(updateUserGarlicSeedAmount > 0 && getPrice > 0) {
						totalGarlicSeedAmonut = garlicSeedAmount - sellAmount;
						
						totalGetPrice = userCoin + ((garlicSeedPrice * sellAmount) / 10);					
						
						System.out.println(totalGetPrice);
					}
				} else {
					System.out.println("판매할 수량이 부족합니다");
				}

				
			}
		
		
		});
		
		/* ---------- 뒤록 가기 버튼 ----------------*/

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SellSeedListPanel sellSeedListPanel = new SellSeedListPanel(userNo);

				FrameManager.changePanel(sellGarlicSeedPanel, sellSeedListPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(sellGarlicSeedPanel, FarmPanel);
				
			}
		});	
	}
	
	
}
