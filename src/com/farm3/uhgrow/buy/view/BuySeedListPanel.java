package com.farm3.uhgrow.buy.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.buy.view.buySeed.CornResultPanel;
import com.farm3.uhgrow.buy.view.buySeed.GarlicResultPanel;
import com.farm3.uhgrow.buy.view.buySeed.PumpkinResultPanel;
import com.farm3.uhgrow.buy.view.buySeed.TomatoResultPanel;

public class BuySeedListPanel extends JPanel{
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 30);
	private JPanel buySeedListPanel;
	private int userNo;


	public BuySeedListPanel(int userNo) {


		buySeedListPanel = this;

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
		tomatoSeedButton.setLocation(170, 200);
		tomatoSeedButton.setSize(100, 25);

		JButton cornSeedButton = new JButton("옥수수");
		cornSeedButton.setLocation(170, 250);
		cornSeedButton.setSize(100, 25);

		JButton garlicSeedButton = new JButton("마늘");
		garlicSeedButton.setLocation(170, 300);
		garlicSeedButton.setSize(100, 25);

		JButton pumpkinSeedButton = new JButton("호박");
		pumpkinSeedButton.setLocation(170, 350);
		pumpkinSeedButton.setSize(100, 25);

		/*-------------- 씨앗구매 텍스트 ---------------*/

		JLabel seedBuyLabel = new JLabel("<씨앗 구매>");
		seedBuyLabel.setBounds(350, 180, 200, 25);
		seedBuyLabel.setFont(font);


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
