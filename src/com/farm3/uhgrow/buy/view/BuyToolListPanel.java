package com.farm3.uhgrow.buy.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.buy.view.buyTool.HoeResultPanel;
import com.farm3.uhgrow.buy.view.buyTool.PickaxeResultPanel;
import com.farm3.uhgrow.buy.view.buyTool.ShovelResultPanel;
import com.farm3.uhgrow.buy.view.buyTool.WateringCanResultPanel;
import com.farm3.uhgrow.member.view.FrameManager;

public class BuyToolListPanel extends JPanel {

	private JPanel buyToolListPanel;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	private Font listFont = new Font("나눔손글씨 펜", Font.BOLD, 30);
	private int userNo;

	public BuyToolListPanel(int userNo) {

		buyToolListPanel = this;

		this.userNo = userNo;
		/* ---------- MainStorePanel 크기 지정 ---------------- */
		this.setLayout(null);
		this.setSize(960, 540);

		/* ---------- 배경화면 라벨 ------------ */
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setSize(960, 540);

		/* ---------- 상첨창 배경 ------------ */
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(705, 360,
				0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(127, 90);
		storeBackGroundLabel.setSize(705, 360);

		/* ---------- 상점창 구매한다, 판매한다, 그만두기 버튼 ------------ */
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
		Image btnBackGroundImage = new ImageIcon("img/store/btnBackGround.png").getImage().getScaledInstance(696, 60,
				0);
		JLabel btnBackGround = new JLabel(new ImageIcon(btnBackGroundImage));
		btnBackGround.setBounds(132, 95, 696, 60);

		/* -------- 농기구 리스트 버튼 ---------- */
		JButton pickaxeToolButton = new JButton("곡괭이");
		pickaxeToolButton.setLocation(170, 200);
		pickaxeToolButton.setSize(100, 25);

		JButton shovelToolButton = new JButton("삽");
		shovelToolButton.setLocation(170, 250);
		shovelToolButton.setSize(100, 25);

		JButton hoeToolButton = new JButton("호미");
		hoeToolButton.setLocation(170, 300);
		hoeToolButton.setSize(100, 25);

		JButton wateringCanToolButton = new JButton("물뿌리개");
		wateringCanToolButton.setLocation(170, 350);
		wateringCanToolButton.setSize(100, 25);

		/*-------------- 농기구 구매 텍스트 ---------------*/

		JLabel toolBuyLabel = new JLabel("<농기구 구매>");
		toolBuyLabel.setBounds(350, 180, 200, 25);
		toolBuyLabel.setFont(font);

		this.add(toolBuyLabel);
		/* ---------- 구매, 판매, 뒤로 버튼 패널에 추가 --------- */
		this.add(btnSell);
		this.add(btnBack);
		this.add(btnBuy);
		this.add(btnBackGround);
		this.add(pickaxeToolButton);
		this.add(shovelToolButton);
		this.add(hoeToolButton);
		this.add(wateringCanToolButton);
		this.add(storeBackGroundLabel);
		this.add(backGroundLabel);

		pickaxeToolButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PickaxeResultPanel pickaxeResultPanel = new PickaxeResultPanel(userNo);

				FrameManager.changePanel(buyToolListPanel, pickaxeResultPanel);
			}
		});

		shovelToolButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShovelResultPanel shovelResultPanel = new ShovelResultPanel(userNo);

				FrameManager.changePanel(buyToolListPanel, shovelResultPanel);

			}
		});

		hoeToolButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameManager.changePanel(buyToolListPanel, new HoeResultPanel(userNo));

			}
		});

		wateringCanToolButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WateringCanResultPanel wateringCanResultPanel = new WateringCanResultPanel(userNo);

				FrameManager.changePanel(buyToolListPanel, wateringCanResultPanel);

			}
		});
	}

}
