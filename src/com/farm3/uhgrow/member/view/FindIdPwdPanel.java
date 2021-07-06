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

public class FindIdPwdPanel extends JPanel{
	private JPanel findIdPwdPanel;
	private int userNo;
	private JLabel backGroundLabel;
	private JButton btnFindId;
	private JButton btnFindPwd;
	private JButton btnBack;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 50);
	
	public FindIdPwdPanel() {
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
		
		btnFindId.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent m) {
				FindIdPanel findIdPanel = new FindIdPanel();
				
				FrameManager.changePanel(findIdPwdPanel, findIdPanel);
			}
		});
		btnFindPwd.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent m) {
				FindPwdPanel findPwdPanel = new FindPwdPanel();
				
				FrameManager.changePanel(findIdPwdPanel, findPwdPanel);
		
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
		
		btnFindId = new JButton("I D 찾 기");
		btnFindId.setBounds(350, 100, 300, 75);
		btnFindId.setFont(font);
		btnFindId.setForeground(Color.white);
		btnFindId.setBackground(Color.ORANGE);
		
		return btnFindId;	
	}
	public JButton btnFindPwd() {
		
		btnFindPwd = new JButton("P W D 찾 기");
		btnFindPwd.setBounds(350, 200, 300, 75);
		btnFindPwd.setFont(font);
		btnFindPwd.setForeground(Color.white);
		btnFindPwd.setBackground(Color.ORANGE);
		
		return btnFindPwd;	
	}
	public JButton btnBack() {
		
		btnBack = new JButton("뒤 로 가 기");
		btnBack.setBounds(350, 300, 300, 75);
		btnBack.setFont(font);
		btnBack.setForeground(Color.white);
		btnBack.setBackground(Color.ORANGE);
		
		return btnBack;	
	}

}
