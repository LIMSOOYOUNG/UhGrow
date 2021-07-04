package com.farm3.uhgrow.sellcrops.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.controller.sell.SellController;
import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

public class SellMainPanel extends JPanel {

	private JPanel sellmainPanel;

	public SellMainPanel() {

		sellmainPanel = this;

		this.setLayout(null);
		this.setSize(960, 540);

		/* 배경화면 이미지 라벨 */
		Image imageBackGround = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel imageBackGroundLabel = new JLabel(new ImageIcon(imageBackGround));
		imageBackGroundLabel.setLocation(0, 0);
		imageBackGroundLabel.setSize(960, 565);

		/* 상점창 이미지 라벨 */
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(705, 360, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(127, 90);
		storeBackGroundLabel.setSize(705, 360);

		/* 구매버튼 이미지 라벨 */
		Image buyImage = new ImageIcon("img/store/buybutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(132, 95);
		buyButton.setSize(232, 60);

		/* 판매버튼 이미지 라벨 */
		Image sellImage = new ImageIcon("img/store/sellButton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(364, 95);
		sellButton.setSize(232, 60);

		/* 그만두기버튼 이미지 라벨 */
		Image quitImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton quitButton = new JButton(new ImageIcon(quitImage));
		quitButton.setLocation(596, 95);
		quitButton.setSize(232, 60);
		
		Image imgStoreNPC = new ImageIcon("img/store/storeconversTion1.png").getImage().getScaledInstance(758, 120, 0);
		JLabel storeNPC = new JLabel(new ImageIcon(imgStoreNPC));
		storeNPC.setBounds(130, 410, 750, 100);
		
//		Font font = new Font("맑은고딕", Font.BOLD, 35);
//		JLabel textLabel = new JLabel("빨리 빨리 골라 뭐하러 왔는데? 어 ? ");
//		textLabel.setBounds(130, 410, 750, 100);
//		textLabel.setFont(font);
		
		
//		this.add(textLabel);
		this.add(storeNPC);
		this.add(buyButton);
		this.add(sellButton);
		this.add(quitButton);
		this.add(storeBackGroundLabel);
		this.add(imageBackGroundLabel);
		
	
		sellButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JPanel sellCategoryPanel = new SellCategoryPanel();
				
				
				SellController sellController = new SellController();
				
				int userCropAmount = 0;
				int updateUserCropAmount = 0;
				int userCoin = 0;
				int getCoin = 0;
				int totalGetPrice = 0;
				
				/* 유저의 농작물과, 농작물 수량, 현재 가지고 있는 코인 조회*/
				List<CropDTO> userCropList = sellController.userCropList(); 
				for(CropDTO cropList : userCropList) {
					System.out.println(cropList.getUserNo() + cropList.getCropId() + cropList.getCropAmount());
					userCropAmount = cropList.getCropAmount();
					userCoin = cropList.getCoin();
					userCropAmount = cropList.getCropAmount();
				}
					
				Scanner sc = new Scanner(System.in);
				System.out.print("판매 수량 입력");
				int sellAmount = sc.nextInt();
				
				if(sellAmount > 0 && sellAmount <= userCropAmount && userCropAmount != 0) {
					
					/* 농작물 판매 갯수와 현재 유저가 가지고 있는 작물 갯수 업데이트*/
					updateUserCropAmount = sellController.updateUserCropAmount(sellAmount);
					
					/* 농작물 판매해서 유저가 받아오는 총 금액*/
					totalGetPrice = sellController.totalGetCoin(sellAmount); 
					
					System.out.println(updateUserCropAmount);
					
					System.out.println(totalGetPrice);

					userCoin += totalGetPrice;
					
					System.out.println(userCoin);
					System.out.println("판매완료");
					
					FrameManager.changePanel(sellmainPanel, sellCategoryPanel);

				} else {
					System.out.println("판매할 수량이 부족합니다");
				}
				
			}
			
			
		});

		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
			
		});
	
	
	
	
	}

}
