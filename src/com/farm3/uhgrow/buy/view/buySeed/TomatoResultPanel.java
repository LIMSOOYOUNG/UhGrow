package com.farm3.uhgrow.buy.view.buySeed;

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
import com.farm3.uhgrow.buy.view.BuySeedListPanel;
import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.view.FrameManager;

public class TomatoResultPanel extends JPanel{

	private JPanel tomatoResultPanel;

	private int userNo;

	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);

	public TomatoResultPanel(int userNo) {


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

		/*------------------- 구매확정 --------------------*/

		JLabel seedInPutLabel = new JLabel("<갯수 입력>");
		seedInPutLabel.setBounds(390, 250, 200, 40);
		seedInPutLabel.setFont(font);

		JTextField seedInputField = new JTextField();
		seedInputField.setBounds(410, 300, 140, 25);
		seedInputField.setLayout(null);
		seedInputField.setFont(font);
		
		JButton buySeedButton = new JButton("구매확정");
		buySeedButton.setLocation(430, 335);
		buySeedButton.setSize(100, 25);

		JLabel tomatoPriceLabel = new JLabel("토마토 씨앗의 가격은 1천원 입니다!");
		tomatoPriceLabel.setBounds(230, 165, 700, 40);
		tomatoPriceLabel.setFont(font);

		this.add(tomatoPriceLabel);
		this.add(buySeedButton);
		this.add(seedInputField);
		this.add(seedInPutLabel);
		this.add(btnCancel);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		/* ---------- 구매 확정 버튼 ----------------*/

		
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
		/* ---------- 뒤로 가기 버튼 ----------------*/

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuySeedListPanel buySeedListPanel = new BuySeedListPanel(userNo);

				FrameManager.changePanel(tomatoResultPanel, buySeedListPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(tomatoResultPanel, FarmPanel);
				
			}
		});		


	}

}
