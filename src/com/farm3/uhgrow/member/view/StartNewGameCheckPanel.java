package com.farm3.uhgrow.member.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartNewGameCheckPanel extends JPanel {

	private JPanel StartNewGameCheckPanel;
	
	public StartNewGameCheckPanel() {
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);

		StartNewGameCheckPanel = this;

		this.setLayout(null);
		this.setSize(960,540);

		/* ---------- 배경화면 라벨  ------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setSize(960, 540);
		
		// Uh Grow! 타이틀 
		JLabel titleLabel = new JLabel("Uh   Grow!");
		titleLabel.setLayout(null);
		titleLabel.setBounds(330, 50, 600, 150);
		titleLabel.setFont(titleFont);
		
		// 새로하기 확인 팝업창 배경 

		
		this.add(titleLabel);
		this.add(backGroundLabel);

		
		
	}
}
