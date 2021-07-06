package com.farm3.uhgrow.buy.view;

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

import com.farm3.uhgrow.buy.controller.BuyController;
import com.farm3.uhgrow.buy.model.dto.BuyDTO;

public class BuyTomatoSeedPanel extends JPanel{
	
	private JPanel buyTomatoSeedPanel;

	public BuyTomatoSeedPanel() {

		Font font = new Font("맑은 고딕", Font.BOLD, 25);

		buyTomatoSeedPanel = this;

		this.setLayout(null);
		this.setSize(960, 540);

		/* ---------- 배경화면 라벨  ------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		this.setVisible(true);

		/* ---------- 상점창 구매한다, 판매한다, 그만두기 버튼   ------------*/
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

		/* ------- 상점 패널 ---------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		/* -------- 씨앗 리스트 버튼 ---------- */
		JButton tomatoSeedButton = new JButton("토마토");
		tomatoSeedButton.setLocation(70, 200);
		tomatoSeedButton.setSize(100, 25);

		JButton cornSeedButton = new JButton("옥수수");
		cornSeedButton.setLocation(70, 250);
		cornSeedButton.setSize(100, 25);

		JButton garlicSeedButton = new JButton("마늘");
		garlicSeedButton.setLocation(70, 300);
		garlicSeedButton.setSize(100, 25);

		JButton pumpkinSeedButton = new JButton("호박");
		pumpkinSeedButton.setLocation(70, 350);
		pumpkinSeedButton.setSize(100, 25);

		/*-------------- 씨앗구매 텍스트 ---------------*/

		JLabel seedBuyLabel = new JLabel("<씨앗 구매>");
		seedBuyLabel.setBounds(350, 180, 200, 25);
		seedBuyLabel.setFont(font);

		/*------------------- 구매확정 --------------------*/

		JLabel seedInPutLabel = new JLabel("<갯수 입력>");
		seedInPutLabel.setBounds(650, 180, 200, 25);
		seedInPutLabel.setFont(font);

		JTextField seedInputField = new JTextField();
		seedInputField.setBounds(650, 215, 140, 25);
		seedInputField.setLayout(null);
		seedInputField.setFont(font);

		JButton buySeedButton = new JButton("구매확정");
		buySeedButton.setLocation(670, 250);
		buySeedButton.setSize(100, 25);

//		this.add(buySeedButton);
//		this.add(seedInputField);
//		this.add(seedInPutLabel);
		this.add(seedBuyLabel);
		this.add(buyButton);
		this.add(sellButton);
		this.add(backButton);
		this.add(tomatoSeedButton);
		this.add(cornSeedButton);
		this.add(garlicSeedButton);
		this.add(pumpkinSeedButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

//		buySeedButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				String inputAmount = seedInputField.getText().toString();
//				int buyAmount = Integer.parseInt(inputAmount);
//
//				/* 유저의 토마토 수량, 현재 가지고 있는 코인 조회 */
//				BuyController buyController = new BuyController();
//				int totalTomatoAmonut = 0;
//				int tomatoAmount = 0;
//				int tomatoPrice = 0;
//				int updateUserTomatoAmount = 0;
//				int userCoin = 0;
//				int getPrice = 0;
//				int totalGetPrice = 0;
//
//
//				List<BuyDTO> userTomatoList = buyController.userTomatoList();
//
//				for (BuyDTO tomatoList : userTomatoList) {
//					tomatoAmount = tomatoList.getCropAmount();
//					userCoin = tomatoList.getCoin();
//					tomatoPrice = tomatoList.getCropPrice();
//				}
//
//				/* 유저의 농작물과, 농작물 수량, 현재 가지고 있는 코인 조회 */
//
//				if (buyAmount> 0 && buyAmount <= tomatoAmount && tomatoAmount != 0) {
//					/* 농작물 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트 */
//					updateUserTomatoAmount = buyController.updateUserToamtoAmount(buyAmount);
//
//					getPrice = buyController.buyTomatoGetCoin(buyAmount, tomatoPrice);
//
//					if(updateUserTomatoAmount > 0 && getPrice > 0) {
//						totalTomatoAmonut = tomatoAmount + buyAmount;
//						totalGetPrice = userCoin - ((tomatoPrice * buyAmount));					
//					}
//				} else {
//					System.out.println("구매할 수 있는 재화가 부족합니다");
//
//				}
//
//
//			}
//
//		});
		
		tomatoSeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel tomatoResultPanel = new TomatoResultPanel();

				FrameManager.changePanel(buyTomatoSeedPanel, tomatoResultPanel);

			}
		});
	}

}
