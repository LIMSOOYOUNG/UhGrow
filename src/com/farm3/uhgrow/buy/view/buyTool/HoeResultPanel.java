package com.farm3.uhgrow.buy.view.buyTool;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.farm3.uhgrow.buy.controller.BuyController;
import com.farm3.uhgrow.buy.model.dto.BuyDTO;
import com.farm3.uhgrow.buy.view.BuyToolListPanel;
import com.farm3.uhgrow.farm.model.dto.RetainToolDTO;
import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.view.FrameManager;

public class HoeResultPanel extends JPanel{
	
	private BuyController buyController = new BuyController();

	private JPanel hoeResultPanel;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 30);
	private List<RetainToolDTO> retainToolList = new ArrayList<>();
	private int userNo;
	private int toolId = 3;
	private int shovelPrice;
	private int userCoin;
	private char toolYN;
	private int plusExp;
	private BuyDTO buyDTO = new BuyDTO();
	
	public HoeResultPanel(int userNo) {
		
		
		retainToolList = buyController.selectRetainToolList(userNo);
		if(retainToolList.size() <= 0) {
            buyController.createRetainToolList(userNo);
		}
		this.userNo = userNo;
		hoeResultPanel = this;
		shovelPrice = buyController.selectPrice(toolId);
		toolYN = buyController.istoolYN(userNo);
		plusExp = buyController.plusExp(toolId);
		buyDTO.setPlusExp(plusExp);
		buyDTO.setUserNo(userNo);
		buyDTO.setToolId(toolId);
		buyDTO.setToolPrice(shovelPrice);
		
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

		JButton buyToolButton = new JButton("구매확정");
		buyToolButton.setLocation(380, 250);
		buyToolButton.setSize(200, 50);
		
		JLabel hoePriceLabel = new JLabel("호미의 가격은 16만원 입니다!");
		hoePriceLabel.setBounds(280, 165, 700, 40);
		hoePriceLabel.setFont(font);
		
		this.add(hoePriceLabel);
		this.add(buyToolButton);
		this.add(btnBuy); 
		this.add(btnCancel);
		this.add(btnBack);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		buyToolButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(toolYN == 'Y') {
					JOptionPane.showMessageDialog(hoeResultPanel, "이미 보유중입니다.", "농기구 보유 여부!", 0);
				} else {
					
					int currentCoin = buyController.currentCoin(buyDTO);
					buyDTO.setCoin(currentCoin);
					
					if (currentCoin - shovelPrice < 0) {
						JOptionPane.showMessageDialog(null, "충분한 금액을 보유하고 있지 않습니다.", "재화 보유 여부!", 0);
					} else {
						JOptionPane.showMessageDialog(null, "농기구 구매에 성공하였습니다..", "농기구 구매 여부!", 0);
						
						buyController.updateCoinTool(buyDTO);
						
						FrameManager.changePanel(hoeResultPanel, new FarmPanel(userNo));
					}
					
					
				}
				
			}
		});
		/* ---------- 뒤로 가기 버튼 ----------------*/
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuyToolListPanel buyToolListPanel = new BuyToolListPanel(userNo);


				FrameManager.changePanel(hoeResultPanel, buyToolListPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(hoeResultPanel, FarmPanel);
				
			}
		});	


	}

}