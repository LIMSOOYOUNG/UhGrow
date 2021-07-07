package com.farm3.uhgrow.member.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.farm.view.TutorialPanel;
import com.farm3.uhgrow.member.controller.MemberController;

public class StartNewGameCheckPanel extends JPanel {

	private JPanel StartNewGameCheckPanel;
	private int userNo;
	private Font titleFont = new Font("나눔손글씨 펜", Font.BOLD, 80);
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 30);


	public StartNewGameCheckPanel(int userNo) {
		this.userNo = userNo;

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
		titleLabel.setForeground(Color.white);
		
		JLabel checkNewGame1 = new JLabel("새로하기를 누르면 기존에 있던                     후");
		checkNewGame1.setLayout(null);
		checkNewGame1.setBounds(255, 150, 600, 150);
		checkNewGame1.setFont(font);
		checkNewGame1.setForeground(Color.white);
		
		JLabel checkNewGame2 = new JLabel("모든 데이터를 삭제");
		checkNewGame2.setLayout(null);
		checkNewGame2.setBounds(525, 150, 600, 150);
		checkNewGame2.setFont(font);
		checkNewGame2.setForeground(Color.red);
		
		JLabel checkNewGame3 = new JLabel("튜토리얼 부터 진행하게 됩니다. 새로하기를 하시겠습니까?");
		checkNewGame3.setLayout(null);
		checkNewGame3.setBounds(230, 190, 600, 150);
		checkNewGame3.setFont(font);
		checkNewGame3.setForeground(Color.white);
		
		// 새로하기 확인 팝업창
		Image newGameBackground = new ImageIcon("img/loginInterface/newGameCheck.png").getImage().getScaledInstance(560, 280, 0);
		JLabel newGameBackgroundLabel = new JLabel(new ImageIcon(newGameBackground));
		newGameBackgroundLabel.setBounds(200, 150, 560, 280);
		// 예 아니요 버튼
		JButton btnYes = new JButton("예");
		btnYes.setBounds(330, 320, 100, 44);
		btnYes.setFont(font);
		btnYes.setForeground(Color.white);
		btnYes.setBackground(Color.RED);

		JButton btnNo = new JButton("아니요");
		btnNo.setBounds(540, 320, 100, 44);
		btnNo.setFont(font);
		btnNo.setForeground(Color.white);
		btnNo.setBackground(Color.green);
	
		this.add(checkNewGame1);
		this.add(checkNewGame2);
		this.add(checkNewGame3);
		
		this.add(btnNo);
		this.add(btnYes);
		this.add(newGameBackgroundLabel);
		this.add(titleLabel);
		this.add(backGroundLabel);

		btnYes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MemberController memberController = new MemberController();
				memberController.startNewGameDataReset(userNo);
				
				// 새로하기 Yes클릭시 userNo 보내주고 toolList, farmCrop삭제 및 foodAmount, cropAmount 초기화
				TutorialPanel tutorialPanel = new TutorialPanel(userNo);			
				FrameManager.changePanel(StartNewGameCheckPanel, tutorialPanel);
			}
		});

		btnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				NewGameOrContinueGamePanel newGameOrContinueGamePanel = new NewGameOrContinueGamePanel(userNo);

				FrameManager.changePanel(StartNewGameCheckPanel, newGameOrContinueGamePanel);
			}
		});

	}
}
