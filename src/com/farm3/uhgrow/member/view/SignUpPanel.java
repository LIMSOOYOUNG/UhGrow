package com.farm3.uhgrow.member.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignUpPanel extends JFrame {



	public SignUpPanel () {
		// 패널 생성 
		JPanel backGroundPanel = new JPanel();
		JPanel loginPanel = new JPanel();
		Font font = new Font(null, Font.BOLD, 30);

		// backGroundPanel위치 지정 후  BackGrountLabel(이미지) 삽입
		loginPanel.setLayout(null);
		loginPanel.setSize(960,540);
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		loginPanel.setVisible(true);

	}
}
