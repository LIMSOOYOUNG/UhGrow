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

public class PumpkinResultPanel extends JPanel{
	
private JPanel pumpkinResultPanel;
	
	private int userNo;
	
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 25);

	public PumpkinResultPanel(int userNo) {

		pumpkinResultPanel = this;
		
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

		/* -------- 씨앗 리스트 버튼 ---------- */

		JButton btnTomato = new JButton("토마토");
		btnTomato.setBounds(150, 170, 400, 40);
		btnTomato.setFont(listFont);
		btnTomato.setContentAreaFilled(false);

		JButton btnCorn = new JButton("옥수수");
		btnCorn.setBounds(150, 230, 400, 40);
		btnCorn.setFont(listFont);
		btnCorn.setContentAreaFilled(false);

		JButton btnGarlic = new JButton("마늘");
		btnGarlic.setBounds(150, 290, 400, 40);
		btnGarlic.setFont(listFont);
		btnGarlic.setContentAreaFilled(false);

		JButton btnPumpkin  = new JButton("호박");
		btnPumpkin.setBounds(150, 350, 400, 40);
		btnPumpkin.setFont(listFont);
		btnPumpkin.setContentAreaFilled(false);

		/*------------------- 구매확정 --------------------*/

		JLabel seedInPutLabel = new JLabel("<갯수 입력>");
		seedInPutLabel.setBounds(630, 165, 200, 40);
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
		this.add(btnBuy);
		this.add(btnCancel);
		this.add(btnBack);
		this.add(btnTomato);
		this.add(btnCorn);
		this.add(btnGarlic);
		this.add(btnPumpkin);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		buySeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String inputAmount = seedInputField.getText().toString();
				int buyAmount = Integer.parseInt(inputAmount);

				/* 유저의 토마토 수량, 현재 가지고 있는 코인 조회 */
				BuyController buyController = new BuyController();
				int totalPumpkinAmonut = 0;
				int pumpkinAmount = 0;
				int pumpkinPrice = 0;
				int updateUserPumpkinAmount = 0;
				int userCoin = 0;
				int getPrice = 0;
				int totalGetPrice = 0;


				List<BuyDTO> userPumpkinList = buyController.userTomatoList();

				for (BuyDTO pumpkinList : userPumpkinList) {
					pumpkinAmount = pumpkinList.getCropAmount();
					userCoin = pumpkinList.getCoin();
					pumpkinPrice = pumpkinList.getCropPrice();
				}

				/* 유저의 농작물과, 농작물 수량, 현재 가지고 있는 코인 조회 */

				if (buyAmount> 0 && buyAmount <= pumpkinAmount && pumpkinAmount != 0) {
					/* 농작물 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트 */
					updateUserPumpkinAmount = buyController.updatePumpkinCropAmount(buyAmount);

					getPrice = buyController.buyPumpkinGetCoin(buyAmount, pumpkinPrice);

					if(updateUserPumpkinAmount > 0 && getPrice > 0) {
						totalPumpkinAmonut = pumpkinAmount + buyAmount;
						totalGetPrice = userCoin - ((pumpkinPrice * buyAmount));					
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

				FrameManager.changePanel(pumpkinResultPanel, buySeedListPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(pumpkinResultPanel, FarmPanel);
				
			}
		});	
		
		
	}

}
