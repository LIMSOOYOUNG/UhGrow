package com.farm3.uhgrow.buy.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BuySeedListPanel extends JPanel{
	
	private JPanel buySeedListPanel;
	
	private int userNo;


	public BuySeedListPanel(int userNo) {

		Font font = new Font("맑은 고딕", Font.BOLD, 25);

		buySeedListPanel = this;
		
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

		
		tomatoSeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TomatoResultPanel tomatoResultPanel = new TomatoResultPanel(userNo);

				FrameManager.changePanel(buySeedListPanel, tomatoResultPanel);

			}
		});
		
		cornSeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CornResultPanel cornResultPanel = new CornResultPanel(userNo);

				FrameManager.changePanel(buySeedListPanel, cornResultPanel);

			}
		});
		
		garlicSeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GarlicResultPanel garlicResultPanel = new GarlicResultPanel(userNo);

				FrameManager.changePanel(buySeedListPanel, garlicResultPanel);

			}
		});
		
		pumpkinSeedButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PumpkinResultPanel pumpkinResultPanel = new PumpkinResultPanel(userNo);

				FrameManager.changePanel(buySeedListPanel, pumpkinResultPanel);

			}
		});
	}

}
