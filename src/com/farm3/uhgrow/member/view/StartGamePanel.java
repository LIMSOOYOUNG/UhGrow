package com.farm3.uhgrow.member.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartGamePanel extends JPanel {

	private JPanel StartGamePanel;

	public StartGamePanel() {
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);

		StartGamePanel = this;

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
		
		/* ---------- 새로하기, 이어하기 버튼   ------------*/
		Image newGameImg = new ImageIcon("img/loginInterface/newgame.png").getImage().getScaledInstance(300, 75, 0);
		JButton btnNewGame = new JButton(new ImageIcon(newGameImg));
		btnNewGame.setBounds(350, 200, 300, 75);
		
		Image continueGameImg = new ImageIcon("img/loginInterface/continue.png").getImage().getScaledInstance(300, 75, 0);
		JButton btnContinueGame = new JButton(new ImageIcon(continueGameImg));
		btnContinueGame.setBounds(350, 300, 300, 75);
		
	
		
		
		this.add(btnContinueGame);
		this.add(btnNewGame);
		this.add(titleLabel);
		this.add(backGroundLabel);
	}
}
