package com.farm3.uhgrow.buy.view.buyTool;

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

public class ShovelResultPanel extends JPanel{
	
private JPanel shovelResultPanel;
	
	private int userNo;

	public ShovelResultPanel(int userNo) {

		Font font = new Font("맑은 고딕", Font.BOLD, 25);

		shovelResultPanel = this;
		
		this.userNo = userNo;

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
		this.add(buyButton); 
		this.add(sellButton);
		this.add(backButton);
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
