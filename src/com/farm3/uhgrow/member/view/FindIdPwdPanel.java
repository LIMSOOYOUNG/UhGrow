package com.farm3.uhgrow.member.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FindIdPwdPanel extends JPanel{
	private JPanel findIdPwdPanel;
	private int userNo;
	private Font font = new Font("맑은 고딕", Font.BOLD, 25);
	private JLabel backGroundLabel;
	private JButton btnFindId;
	private JButton btnFindPwd;
	private JButton btnBack;
	
	public FindIdPwdPanel(int userNo) {
		this.userNo = userNo;
		findIdPwdPanel = this;
		
		this.setLayout(null);
		this.setSize(960,540);
		
		this.add(btnBack());
		this.add(btnFindPwd());
		this.add(btnFindId());
		this.add(backGroundLabel());

		
		btnBack.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent m) {
				
				LoginPanel loginPanel = new LoginPanel();
				
				FrameManager.changePanel(findIdPwdPanel, loginPanel);
			}
		});
	}
	

	public JLabel backGroundLabel() {
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		return backGroundLabel;
	}
	public JButton btnFindId() {
		
		Image findIdImg = new ImageIcon("img/loginInterface/findId.png").getImage().getScaledInstance(300, 75, 0);
		btnFindId = new JButton(new ImageIcon(findIdImg));
		btnFindId.setBounds(350, 100, 300, 75);
		
		return btnFindId;	
	}
	public JButton btnFindPwd() {
		
		Image findIdImg = new ImageIcon("img/loginInterface/findPwd.png").getImage().getScaledInstance(300, 75, 0);
		btnFindPwd = new JButton(new ImageIcon(findIdImg));
		btnFindPwd.setBounds(350, 200, 300, 75);
		
		return btnFindPwd;	
	}
	public JButton btnBack() {
		
		Image findIdImg = new ImageIcon("img/loginInterface/BackButton.png").getImage().getScaledInstance(300, 75, 0);
		btnBack = new JButton(new ImageIcon(findIdImg));
		btnBack.setBounds(350, 300, 300, 75);
		
		return btnBack;	
	}

}
