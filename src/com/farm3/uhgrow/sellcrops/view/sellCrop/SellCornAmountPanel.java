package com.farm3.uhgrow.sellcrops.view.sellCrop;

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
import com.farm3.uhgrow.sellcrops.view.SellCategoryPanel;

public class SellCornAmountPanel extends JPanel {

	private JPanel sellCornAmountPanel;
	private SellController sellController;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;

	public SellCornAmountPanel(int userNo) {
		this.userNo = userNo;
		sellCornAmountPanel = this;

		this.setLayout(null);
		this.setSize(960, 540);
		
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

		JLabel cropInPutLabel = new JLabel("<갯수 입력>");
		cropInPutLabel.setBounds(390, 250, 200, 40);
		cropInPutLabel.setFont(font);

		JTextField cropInputField = new JTextField();
		cropInputField.setBounds(410, 300, 140, 25);
		cropInputField.setLayout(null);
		cropInputField.setFont(font);
		
		JButton sellCropButton = new JButton("판매확정");
		sellCropButton.setLocation(430, 335);
		sellCropButton.setSize(100, 25);
		
		JLabel cornPriceLabel = new JLabel("옥수수의 판매가격은 300원 입니다!");
		cornPriceLabel.setBounds(230, 165, 700, 40);
		cornPriceLabel.setFont(font);

		/* 재화 라벨*/
		/* ---------- 재화 보유 라벨 ------------*/
		Font f1 = new Font("Ink Free", Font.BOLD, 20);
		JTextArea userCoin = new JTextArea("COIN : " + transCoin);
		userCoin.setLocation(600, 400);
		userCoin.setSize(200, 28);
		userCoin.setOpaque(false);
		userCoin.setFont(f1);
		userCoin.setEditable(false);		
		
		this.add(cornPriceLabel);
		this.add(userCoin);
		this.add(sellCropButton);
		this.add(cropInputField);
		this.add(cropInPutLabel);
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnCancel);
		this.add(btnBackGround);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
		sellCropButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/* 유저의 토마토 수량, 현재 가지고 있는 코인 조회 */
				int cornAmount = 0;
				int userCoin = 0;
				int cornPrice = 0;
				int updateUserCornAmount = 0;
				int getPrice = 0;
				int totalCornAmonut = 0;
				int totalGetPrice = 0;
				
				/* 텍스트 필드에서 입력한 판매 수량*/
				String inputAmount = cropInputField.getText().toString();
				int sellAmount = Integer.parseInt(inputAmount);

				
				SellController sellController = new SellController();
				
				List<CropDTO> userCornList = sellController.userCornList(userNo);
				
				for (CropDTO cropList : userCornList) {
					cornAmount = cropList.getCropAmount();
					userCoin = cropList.getCoin();
					cornPrice = cropList.getCropPrice();
				}
				
				/* 유저의 농작물과, 농작물 수량, 현재 가지고 있는 코인 조회 */
				if (sellAmount > 0 && sellAmount <= cornAmount && cornAmount != 0) {
					/* 농작물 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트 */
					updateUserCornAmount = sellController.updateUserCornAmount(sellAmount, userNo);
					/* 유저가 옥수수를 팔고 난 후의 총 코인 업데이트*/
					getPrice = sellController.sellCornGetCoin(sellAmount, cornPrice, userNo);

					if(updateUserCornAmount > 0 && getPrice > 0) {
						totalCornAmonut = cornAmount - sellAmount;
						totalGetPrice = userCoin + ((cornPrice * sellAmount) / 10);					
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
				SellCropListPanel sellCropListPanel = new SellCropListPanel(userNo);

				FrameManager.changePanel(sellCornAmountPanel, sellCropListPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(sellCornAmountPanel, FarmPanel);
				
			}
		});	
	}
}