package com.farm3.uhgrow.member.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.controller.MemberController;

public class StartNewGameCheckPanel extends JPanel {

	private JPanel StartNewGameCheckPanel;
	private int userNo;

	public StartNewGameCheckPanel(int userNo) {
		this.userNo = userNo;
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

		// 새로하기 확인 팝업창
		Image newGameBackground = new ImageIcon("img/loginInterface/newGameCheck.png").getImage().getScaledInstance(560, 280, 0);
		JLabel newGameBackgroundLabel = new JLabel(new ImageIcon(newGameBackground));
		newGameBackgroundLabel.setBounds(200, 150, 560, 280);
		// 예 아니요 버튼
		Image btnYesImage = new ImageIcon("img/loginInterface/btnYes.png").getImage().getScaledInstance(82, 44, 0);
		JButton btnYes = new JButton(new ImageIcon(btnYesImage));
		btnYes.setBounds(330, 320, 82, 44);

		Image btnNoImage = new ImageIcon("img/loginInterface/btnNo.png").getImage().getScaledInstance(82, 44, 0);
		JButton btnNo = new JButton(new ImageIcon(btnNoImage));
		btnNo.setBounds(540, 320, 82, 44);


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
				
				FarmPanel farmPanel = new FarmPanel();				
				FrameManager.changePanel(StartNewGameCheckPanel, farmPanel);

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
