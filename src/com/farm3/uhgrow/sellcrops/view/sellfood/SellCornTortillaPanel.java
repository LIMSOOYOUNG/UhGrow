package com.farm3.uhgrow.sellcrops.view.sellfood;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.controller.sell.SellController;
import com.farm3.uhgrow.sellcrops.controller.sell.SellFoodController;
import com.farm3.uhgrow.sellcrops.model.dto.FoodDTO;
import com.farm3.uhgrow.sellcrops.view.SellCategoryPanel;
import com.farm3.uhgrow.sellcrops.view.sellCrop.SellCropListPanel;

public class SellCornTortillaPanel extends JPanel {
	
	private JPanel sellCornTortillaPanel;
	private SellFoodController sellFoodController;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;
	
	
	public SellCornTortillaPanel(int userNo) {
		this.userNo = userNo;
		sellCornTortillaPanel = this;
		
		this.setLayout(null);
		this.setSize(960, 540);
		
		this.sellFoodController = new SellFoodController();
		int havingCoin = sellFoodController.selectCoin(userNo);
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

		JLabel foodInPutLabel = new JLabel("<갯수 입력>");
		foodInPutLabel.setBounds(390, 250, 200, 40);
		foodInPutLabel.setFont(font);

		JTextField foodInputField = new JTextField();
		foodInputField.setBounds(410, 300, 140, 25);
		foodInputField.setLayout(null);
		foodInputField.setFont(font);
		
		JButton sellFoodButton = new JButton("판매확정");
		sellFoodButton.setLocation(430, 335);
		sellFoodButton.setSize(100, 25);
		
		JLabel cornTortillaPriceLabel = new JLabel("옥수수또띠아의 판매가격은 15000원 입니다!");
		cornTortillaPriceLabel.setBounds(190, 165, 700, 40);
		cornTortillaPriceLabel.setFont(font);

		/* 재화 라벨*/
		
		/* ---------- 재화 보유 라벨 ------------*/
		Font f1 = new Font("Ink Free", Font.BOLD, 20);
		JTextArea userCoin = new JTextArea("COIN : " + transCoin);
		userCoin.setLocation(600, 400);
		userCoin.setSize(200, 28);
		userCoin.setOpaque(false);
		userCoin.setFont(f1);
		userCoin.setEditable(false);		

		this.add(cornTortillaPriceLabel);
		this.add(userCoin);
		this.add(sellFoodButton);
		this.add(foodInputField);
		this.add(foodInPutLabel);
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnCancel);
		this.add(btnBackGround);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
		sellFoodButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String inputAmount = foodInputField.getText().toString();
				int sellAmount = Integer.parseInt(inputAmount);

				/* 유저의 옥수수또띠아 수량, 현재 가지고 있는 코인 조회 */
				int cornTortillaAmount = 0;
				int userCoin = 0;
				int cornTortillaPrice = 0;
				int updateUserCornTortillaAmount = 0;
				int getPrice = 0;
				int totalCornTortillaAmonut = 0;
				int totalGetPrice = 0;
				
				SellController sellController = new SellController();
				
				List<FoodDTO> userFoodList = sellFoodController.userCornTotilla(userNo);
				
				for (FoodDTO foodList : userFoodList) {
					cornTortillaAmount = foodList.getFoodAmount();
					userCoin = foodList.getCoin();
					cornTortillaPrice = foodList.getFoodPrice();
				}
				
				
				if (sellAmount> 0 && sellAmount <= cornTortillaAmount && cornTortillaAmount != 0) {
					/* 음식 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트 *//* 음식판매후 코인 받기*/
					updateUserCornTortillaAmount = sellFoodController.updateUserCornTotillaAmount(sellAmount, userNo);
					/* 음식판매후 코인 받기*/
					getPrice = sellFoodController.sellCornTotillaGetCoin(sellAmount, cornTortillaPrice, userNo);

					if(updateUserCornTortillaAmount > 0 && getPrice > 0) {
						totalCornTortillaAmonut = cornTortillaAmount - sellAmount;
						
						totalGetPrice = userCoin + ((cornTortillaPrice * sellAmount) / 10);					
					
					}
					JOptionPane.showMessageDialog(null, "또띠아 판매가 완료되었습니다.","요리 판매 창" , 1);
					FrameManager.changePanel(sellCornTortillaPanel, new FarmPanel(userNo));
				} else {
					
					SellCategoryPanel sellCategoryPanel = new SellCategoryPanel(userNo);
					
				
				}

				
			}
		
		
		});
		
		/* ---------- 뒤록 가기 버튼 ----------------*/

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SellFoodListPanel sellFoodListPanel = new SellFoodListPanel(userNo);

				FrameManager.changePanel(sellCornTortillaPanel, sellFoodListPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(sellCornTortillaPanel, FarmPanel);
				
			}
		});	
		
	}
	
}
