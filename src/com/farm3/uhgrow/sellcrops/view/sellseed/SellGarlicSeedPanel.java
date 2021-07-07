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
		JLabel inputAmountLabel = new JLabel("갯수 입력");
		inputAmountLabel.setBounds(650, 180, 200, 25);
		inputAmountLabel.setFont(font);
		
		JTextField inputAmountText = new JTextField();
		inputAmountText.setBounds(650, 215, 140, 25);
		inputAmountText.setLayout(null);
		inputAmountText.setFont(font);
		
		
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
		this.add(inputAmountText);
		this.add(inputAmountLabel);
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String inputAmount = inputAmountText.getText().toString();
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
	}
	
	
}
