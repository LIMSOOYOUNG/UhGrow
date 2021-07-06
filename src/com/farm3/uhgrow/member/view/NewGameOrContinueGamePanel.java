package com.farm3.uhgrow.member.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.controller.MemberController;

public class NewGameOrContinueGamePanel extends JPanel {

	private JPanel NewGameOrContinueGamePanel;
	private int userNo;
	private Font titleFont = new Font("나눔손글씨 펜", Font.BOLD, 80);
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);


	public NewGameOrContinueGamePanel(int userNo) {
		this.userNo = userNo;

		NewGameOrContinueGamePanel = this;

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
		titleLabel.setForeground(Color.white);

		
		/* ---------- 새로하기, 이어하기 버튼   ------------*/
		Image newGameImg = new ImageIcon("img/loginInterface/newgame.png").getImage().getScaledInstance(300, 75, 0);
		JButton btnNewGame = new JButton("새 로 하 기");
		btnNewGame.setBounds(350, 200, 300, 75);
		btnNewGame.setFont(font);
		btnNewGame.setForeground(Color.white);
		btnNewGame.setBackground(Color.ORANGE);
		btnNewGame.setFont(font);
		btnNewGame.setForeground(Color.white);
		btnNewGame.setBackground(Color.ORANGE);
		
		Image continueGameImg = new ImageIcon("img/loginInterface/continue.png").getImage().getScaledInstance(300, 75, 0);
		JButton btnContinueGame = new JButton("이 어 하 기");
		btnContinueGame.setBounds(350, 300, 300, 75);
		btnContinueGame.setFont(font);
		btnContinueGame.setForeground(Color.white);
		btnContinueGame.setBackground(Color.ORANGE);
	

		
		this.add(btnContinueGame);
		this.add(btnNewGame);
		this.add(titleLabel);
		this.add(backGroundLabel);

		btnContinueGame.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {

				MemberController controller = new MemberController();
				
				String continueYn = controller.StartGameContinueYn(userNo);
				
				if(continueYn.equals("N")) {
					
					JOptionPane.showMessageDialog(null, "저장된 데이터가 없습니다. 새로하기를 이용해주세요.", "오류!", 1);

				} else {
					FarmPanel farmPanel = new FarmPanel(userNo);
					FrameManager.changePanel(NewGameOrContinueGamePanel, farmPanel);
				}
			}
		});
		btnNewGame.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				
				StartNewGameCheckPanel startNewGameCheckPanel = new StartNewGameCheckPanel(userNo);
				
				FrameManager.changePanel(NewGameOrContinueGamePanel, startNewGameCheckPanel);
			}
		});

	}
	
	
	

	
}

