package com.farm3.uhgrow.buy.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.member.view.FrameManager;

public class BuyStoreFrame extends JFrame{

	public BuyStoreFrame() { 

		this.setTitle("UhGrow");
		this.setLayout(null);
		this.setBounds(300, 200, 960, 565);

		this.add(new BuyListPanel());

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JPanel buyPanel() {

		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);


		JPanel buyPanel = new JPanel();
		buyPanel.setLayout(null);
		buyPanel.setSize(960,540);

		/* ---------- 배경화면 라벨  ------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		buyPanel.setVisible(true);

		/* ---------- 상첨창 배경  ------------*/
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(705, 360, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(127, 90);
		storeBackGroundLabel.setSize(705, 360);

		/* ---------- 상점창 구매한다, 판매한다, 그만두기 버튼   ------------*/
		Image buyImage = new ImageIcon("img/store/buybutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(132, 95);
		buyButton.setSize(232, 60);

		Image sellImage = new ImageIcon("img/store/sellbutton1.png").getImage().getScaledInstance(232, 60, 0);
		JButton sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(364, 95);
		sellButton.setSize(232, 60);

		Image backImage = new ImageIcon("img/store/storeback1.png").getImage().getScaledInstance(232, 60, 0);
		JButton backButton = new JButton(new ImageIcon(backImage));
		backButton.setLocation(596, 95);
		backButton.setSize(232, 60);

		/* ---------- 대화창, 대화창에 큰 상인 이미지 ------------*/
		Image imgConversation = new ImageIcon("img/store/storeconversation1.png").getImage().getScaledInstance(758, 120, 0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setBounds(100, 400, 760, 118);

		Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(90, 150, 0);
		JLabel storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setBounds(750, 350, 90, 150);

		/* ---------- 상인 대화내용  ------------*/
		Font font2 = new Font("맑은고딕", Font.BOLD, 35);
		JLabel textLabel = new JLabel("빨리 빨리 골라 뭐하러 왔는데? 어 ? ");
		textLabel.setBounds(130, 410, 750, 100);
		textLabel.setFont(font2);


		/* ---------- 위에서 만들어준 라벨, 버튼들 패널에 추가  ------------*/
		buyPanel.add(textLabel);
		buyPanel.add(storeNpc);
		buyPanel.add(conversationLabel);
		buyPanel.add(sellButton);
		buyPanel.add(backButton);
		buyPanel.add(buyButton);
		buyPanel.add(storeBackGroundLabel);
		buyPanel.add(backGroundLabel);

		this.add(buyPanel);
		/* ---------- buyList패널 상점 프레임에 추가 ------------*/

		buyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				JPanel blp = new BuyListPanel();

				FrameManager.changePanel(buyPanel, blp);


			}
		});

		return buyPanel;



	}



}
