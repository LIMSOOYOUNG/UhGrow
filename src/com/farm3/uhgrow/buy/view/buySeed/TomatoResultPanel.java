package com.farm3.uhgrow.buy.view.buySeed;

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
import javax.swing.JTextField;

import com.farm3.uhgrow.buy.controller.BuyController;
import com.farm3.uhgrow.buy.model.dto.BuyDTO;

public class TomatoResultPanel extends JPanel{
	
	private JPanel tomatoResultPanel;
	
	private int userNo;

	public TomatoResultPanel(int userNo) {

		Font font = new Font("맑은 고딕", Font.BOLD, 25);

		tomatoResultPanel = this;
		
		this.userNo = userNo;
		/* ---------- MainStorePanel 크기 지정 ----------------*/
		this.setLayout(null);
		this.setSize(960,540);


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

		this.add(buySeedButton);
		this.add(seedInputField);
		this.add(seedInPutLabel);
		this.add(seedBuyLabel);
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		this.add(tomatoSeedButton);
		this.add(cornSeedButton);
		this.add(garlicSeedButton);
		this.add(pumpkinSeedButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		buySeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String inputAmount = seedInputField.getText().toString();
				int buyAmount = Integer.parseInt(inputAmount);

				/* 유저의 토마토 수량, 현재 가지고 있는 코인 조회 */
				BuyController buyController = new BuyController();
				int totalTomatoAmonut = 0;
				int tomatoAmount = 0;
				int tomatoPrice = 0;
				int updateUserTomatoAmount = 0;
				int userCoin = 0;
				int getPrice = 0;
				int totalGetPrice = 0;


				List<BuyDTO> userTomatoList = buyController.userTomatoList();

				for (BuyDTO tomatoList : userTomatoList) {
					tomatoAmount = tomatoList.getCropAmount();
					userCoin = tomatoList.getCoin();
					tomatoPrice = tomatoList.getCropPrice();
				}

				/* 유저의 농작물과, 농작물 수량, 현재 가지고 있는 코인 조회 */

				if (buyAmount> 0 && buyAmount <= tomatoAmount && tomatoAmount != 0) {
					/* 농작물 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트 */
					updateUserTomatoAmount = buyController.updateTomatoCropAmount(buyAmount);

					getPrice = buyController.buyTomatoGetCoin(buyAmount, tomatoPrice);

					if(updateUserTomatoAmount > 0 && getPrice > 0) {
						totalTomatoAmonut = tomatoAmount + buyAmount;
						totalGetPrice = userCoin - ((tomatoPrice * buyAmount));	
					}
				} else {
					System.out.println("구매할 수 있는 재화가 부족합니다");

				}


			}

		});
		
		
	}

}
