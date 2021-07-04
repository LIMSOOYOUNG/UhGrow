package com.farm3.uhgrow.sellcrops.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.farm3.uhgrow.sellcrops.controller.sell.SellController;
import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

public class SellTomatoAmountPanel extends JPanel{

	private JPanel sellTomatoAmountPanel;
	
	public SellTomatoAmountPanel() {
		
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);

		sellTomatoAmountPanel = this;

		this.setLayout(null);
		this.setSize(960, 540);

		/* ---------- 배경화면 라벨 ------------ */
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		this.setVisible(true);

		/* ---------- 상점창 구매한다, 판매한다, 그만두기 버튼 ------------ */
		Image buyImage = new ImageIcon("img/store/mainStore/buybutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(132, 95);
		buyButton.setSize(232, 60);

		Image sellImage = new ImageIcon("img/store/mainStore/sellbutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(364, 95);
		sellButton.setSize(232, 60);

		Image backImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton backButton = new JButton(new ImageIcon(backImage));
		backButton.setLocation(596, 95);
		backButton.setSize(232, 60);

		/* ------- 상점 패널 --------- */
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		/* -------- 작물 리스트 버튼 ---------- */
		JButton tomatoCropButton = new JButton("토마토");
		tomatoCropButton.setLocation(70, 200);
		tomatoCropButton.setSize(100, 25);

		JButton cornCropButton = new JButton("옥수수");
		cornCropButton.setLocation(70, 250);
		cornCropButton.setSize(100, 25);

		JButton garlicCropButton = new JButton("마늘");
		garlicCropButton.setLocation(70, 300);
		garlicCropButton.setSize(100, 25);

		JButton pumpkinCropButton = new JButton("호박");
		pumpkinCropButton.setLocation(70, 350);
		pumpkinCropButton.setSize(100, 25);
		
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
		
		this.add(confirmButton);
		this.add(inputAmountText);
		this.add(inputAmountLabel);
		this.add(buyButton);
		this.add(sellButton);
		this.add(backButton);
		this.add(tomatoCropButton);
		this.add(cornCropButton);
		this.add(garlicCropButton);
		this.add(pumpkinCropButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String inputAmount = inputAmountText.getText().toString();
				int sellAmount = Integer.parseInt(inputAmount);

				/* 유저의 토마토 수량, 현재 가지고 있는 코인 조회 */
				SellController sellController = new SellController();
				int totalTomatoAmonut = 0;
				int tomatoAmount = 0;
				int tomatoPrice = 0;
				int updateUserTomatoAmount = 0;
				int userCoin = 0;
				int getPrice = 0;
				int totalGetPrice = 0;
				
				
				List<CropDTO> userCropList = sellController.userCropList();
				
				for (CropDTO cropList : userCropList) {
					tomatoAmount = cropList.getCropAmount();
					userCoin = cropList.getCoin();
					tomatoPrice = cropList.getCropPrice();
				}
				
				/* 유저의 농작물과, 농작물 수량, 현재 가지고 있는 코인 조회 */
				
				if (sellAmount> 0 && sellAmount <= tomatoAmount && tomatoAmount != 0) {
					/* 농작물 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트 */
					updateUserTomatoAmount = sellController.updateUserToamtoAmount(sellAmount);
					
					getPrice = sellController.sellTomatoGetCoin(sellAmount);

					if(updateUserTomatoAmount > 0 && getPrice > 0) {
						totalTomatoAmonut = tomatoAmount - sellAmount;
						totalGetPrice = userCoin + ((tomatoPrice * sellAmount) / 10);					
					}
					
//					
					
					
					/* 농작물 판매해서 유저가 받아오는 총 금액 */
//					totalGetPrice = sellController.totalGetCoin(sellAmount);
//					System.out.println(updateUserCropAmount);
//					System.out.println(totalGetPrice);
//					userCoin += totalGetPrice;
//					System.out.println(userCoin);
//					System.out.println("판매완료");
				} else {
					System.out.println("판매할 수량이 부족합니다");
				}

				
			}
		
		
		});
	}
}
