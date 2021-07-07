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
import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.view.FrameManager;

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

		/*-------------- 씨앗구매 텍스트 ---------------*/

		JLabel seedBuyLabel = new JLabel("<씨앗 구매>");
		seedBuyLabel.setBounds(600, 180, 200, 35);
		seedBuyLabel.setFont(font);


		this.add(seedBuyLabel);
		this.add(btnCancel);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		this.add(btnTomato);
		this.add(btnCorn);
		this.add(btnGarlic);
		this.add(btnPumpkin);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);
		
		

		btnTomato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TomatoResultPanel tomatoResultPanel = new TomatoResultPanel(userNo);

				FrameManager.changePanel(buySeedListPanel, tomatoResultPanel);

			}
		});

		btnCorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CornResultPanel cornResultPanel = new CornResultPanel(userNo);

				FrameManager.changePanel(buySeedListPanel, cornResultPanel);

			}
		});

		btnGarlic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GarlicResultPanel garlicResultPanel = new GarlicResultPanel(userNo);

				FrameManager.changePanel(buySeedListPanel, garlicResultPanel);

			}
		});

		btnPumpkin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PumpkinResultPanel pumpkinResultPanel = new PumpkinResultPanel(userNo);

				FrameManager.changePanel(buySeedListPanel, pumpkinResultPanel);

			}
		});
		
		/* ---------- 뒤록 가기 버튼 ----------------*/

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuyListPanel buyListPanel = new BuyListPanel(userNo);

				FrameManager.changePanel(buySeedListPanel, buyListPanel);

			}
		});
		
		/* ---------- 그만 두기 버튼 ----------------*/
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FarmPanel FarmPanel = new FarmPanel(userNo);
				
				FrameManager.changePanel(buySeedListPanel, FarmPanel);
				
			}
		});		
	}

}
