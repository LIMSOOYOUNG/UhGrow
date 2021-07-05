package com.farm3.uhgrow.member.view;

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
import com.farm3.uhgrow.member.model.dto.StartGameDTO;

public class NewGameOrContinueGamePanel extends JPanel {

	private JPanel NewGameOrContinueGamePanel;
	private int userNo;

	public NewGameOrContinueGamePanel(int userNo) {
		this.userNo = userNo;
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);

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

		btnContinueGame.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {

				MemberController controller = new MemberController();
				
				String continueYn = controller.StartGameContinueYn(userNo);
				
				if(continueYn.equals("N")) {
					
					JOptionPane.showMessageDialog(null, "저장된 데이터가 없습니다. 새로하기를 이용해주세요.", "오류!", 1);

				} else {
					// 이어하기 완료 ~ 패널 변경, 패널 변경시마다 userNo 매개변수로 전달해주면서 패널체인지 해줘야할듯
//					FarmPanel farmPanel = new FarmPanel(userNo);
//					FrameManager.changePanel(NewGameOrContinueGamePanel, farmPanel);
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

