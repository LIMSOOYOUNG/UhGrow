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
import com.farm3.uhgrow.member.store.MainStorePanel;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.controller.sell.SellController;
import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;
import com.farm3.uhgrow.sellcrops.view.SellCategoryPanel;

public class SellTomatoSeedPanel extends JPanel {

	private JPanel sellTomatoSeedPanel;
	private SellController sellController;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private int userNo;
	
	public SellTomatoSeedPanel(int userNo) {
		this.userNo = userNo;
		sellTomatoSeedPanel = this;
		
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
		
		JLabel tomatoSeedPriceLabel = new JLabel("토마토씨앗의 판매가격은 100원 입니다!");
		tomatoSeedPriceLabel.setBounds(190, 165, 700, 40);
		tomatoSeedPriceLabel.setFont(font);

		/* 재화 라벨*/
		
		/* ---------- 재화 보유 라벨 ------------*/
		Font f1 = new Font("Ink Free", Font.BOLD, 20);
		JTextArea userCoin = new JTextArea("COIN : " + transCoin);
		userCoin.setLocation(600, 400);
		userCoin.setSize(200, 28);
		userCoin.setOpaque(false);
		userCoin.setFont(f1);
		userCoin.setEditable(false);		

		this.add(tomatoSeedPriceLabel);
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

				/* 유저의 토마토 수량, 현재 가지고 있는 코인 조회 */
				int tomatoSeedAmount = 0;
				int userCoin = 0;
				int tomatoSeedPrice = 0;
				int updateUserTomatoSeedAmount = 0;
				int getPrice = 0;
				int totalTomatoSeedAmonut = 0;
				int totalGetPrice = 0;
				
				SellController sellController = new SellController();
				
				List<CropDTO> userCropList = sellController.userTomatoSeed(userNo);
				
				for (CropDTO cropList : userCropList) {
					tomatoSeedAmount = cropList.getCropAmount();
					userCoin = cropList.getCoin();
					tomatoSeedPrice = cropList.getCropPrice();
				}
				
				/* 유저의 농작물과, 농작물 수량, 현재 가지고 있는 코인 조회 */
				
				if (sellAmount> 0 && sellAmount <= tomatoSeedAmount && tomatoSeedAmount != 0) {
					/* 농작물 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트 */
					updateUserTomatoSeedAmount = sellController.updateUserToamtoSeed(sellAmount, userNo);
					
					getPrice = sellController.sellTomatoSeedGetCoin(sellAmount, tomatoSeedPrice, userNo);

					if(updateUserTomatoSeedAmount > 0 && getPrice > 0) {
						totalTomatoSeedAmonut = tomatoSeedAmount - sellAmount;
						
						totalGetPrice = userCoin + ((tomatoSeedPrice * sellAmount) / 10);					
						
					
					}
				} else {
					
					SellCategoryPanel sellCategoryPanel = new SellCategoryPanel(userNo);
					FrameManager.changePanel(sellTomatoSeedPanel, sellCategoryPanel);
					
				
				}

				
			}
		
		
		});		
		
		/* ---------- 뒤록 가기 버튼 ----------------*/

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SellSeedListPanel sellSeedListPanel = new SellSeedListPanel(userNo);

				FrameManager.changePanel(sellTomatoSeedPanel, sellSeedListPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(sellTomatoSeedPanel, FarmPanel);
				
			}
		});	
		
	}
	
}
