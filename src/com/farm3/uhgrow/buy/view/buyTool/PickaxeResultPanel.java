package com.farm3.uhgrow.buy.view.buyTool;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class PickaxeResultPanel extends JPanel{

	private JPanel pickaxeResultPanel;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 30);
	private int userNo;

	public PickaxeResultPanel(int userNo) {


		pickaxeResultPanel = this;

		/* ---------- MainStorePanel 크기 지정 ----------------*/
		this.setLayout(null);
		this.setSize(960,540);


		/* ---------- 배경화면 라벨  ------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		this.setVisible(true);

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

		/* ------- 상점 패널 ---------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(860, 440, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);

		/* -------- 농기구 리스트 버튼 ---------- */
		JButton pickaxeToolButton = new JButton("곡괭이");
		pickaxeToolButton.setLocation(70, 200);
		pickaxeToolButton.setSize(100, 25);

		JButton shovelToolButton = new JButton("삽");
		shovelToolButton.setLocation(70, 250);
		shovelToolButton.setSize(100, 25);

		JButton hoeToolButton = new JButton("호미");
		hoeToolButton.setLocation(70, 300);
		hoeToolButton.setSize(100, 25);

		JButton wateringCanToolButton = new JButton("물뿌리개");
		wateringCanToolButton.setLocation(70, 350);
		wateringCanToolButton.setSize(100, 25);

		/*-------------- 농기구 구매 텍스트 ---------------*/

		JLabel toolBuyLabel = new JLabel("<농기구 구매>");
		toolBuyLabel.setBounds(350, 180, 200, 25);
		toolBuyLabel.setFont(font);

		/*------------------- 구매확정 --------------------*/

		JLabel toolInPutLabel = new JLabel("<갯수 입력>");
		toolInPutLabel.setBounds(650, 180, 200, 25);
		toolInPutLabel.setFont(font);

		JTextField toolInputField = new JTextField();
		toolInputField.setBounds(650, 215, 140, 25);
		toolInputField.setLayout(null);
		toolInputField.setFont(font);

		JButton buyToolButton = new JButton("구매확정");
		buyToolButton.setLocation(670, 250);
		buyToolButton.setSize(100, 25);

		this.add(buyToolButton);
		this.add(toolInputField);
		this.add(toolInPutLabel);
		this.add(toolBuyLabel);
		this.add(btnBuy); 
		this.add(btnSell);
		this.add(btnBack);
		this.add(pickaxeToolButton);
		this.add(shovelToolButton);
		this.add(hoeToolButton);
		this.add(wateringCanToolButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		buyToolButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//				String inputAmount = seedInputField.getText().toString();
				//				int buyAmount = Integer.parseInt(inputAmount);
				//
				//				/* 유저의 토마토 수량, 현재 가지고 있는 코인 조회 */
				//				BuyController buyController = new BuyController();
				//				int totalCornAmonut = 0;
				//				int cornAmount = 0;
				//				int cornPrice = 0;
				//				int updateUserCornAmount = 0;
				//				int userCoin = 0;
				//				int getPrice = 0;
				//				int totalGetPrice = 0;
				//
				//
				//				List<BuyDTO> userCornList = buyController.userCornList();
				//
				//				for (BuyDTO cornList : userCornList) {
				//					cornAmount = cornList.getCropAmount();
				//					userCoin = cornList.getCoin();
				//					cornPrice = cornList.getCropPrice();
				//				}
				//
				//				/* 유저의 농작물과, 농작물 수량, 현재 가지고 있는 코인 조회 */
				//
				//				if (buyAmount> 0 && buyAmount <= cornAmount && cornAmount != 0) {
				//					/* 농작물 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트 */
				//					updateUserCornAmount = buyController.updateCornCropAmount(buyAmount);
				//
				//					getPrice = buyController.buyCornGetCoin(buyAmount, cornPrice);
				//
				//					if(updateUserCornAmount > 0 && getPrice > 0) {
				//						totalCornAmonut = cornAmount + buyAmount;
				//						totalGetPrice = userCoin - ((cornPrice * buyAmount));					
				//					}
				//				} else {
				//					System.out.println("구매할 수 있는 재화가 부족합니다");
				//
				//				}


			}

		});


	}

}
