package com.farm3.uhgrow.member.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.farm3.uhgrow.member.controller.MemberController;

public class FindPwdPanel extends JPanel{
	private FindPwdPanel findPwdPanel;
	private FindIdPwdPanel findIdPwdPanel = new FindIdPwdPanel();
	

	private MemberController memberController = new MemberController();

	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private Font titleFont = new Font("나눔손글씨 펜", Font.BOLD, 80);
	private JLabel titleLabel;
	private JLabel backGroundLabel;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel mailLabel;
	private JTextField idField;
	private JTextField nameField;
	private JTextField mailField;
	private JButton btnYes;
	private JButton btnBack;


	public FindPwdPanel() {
		findPwdPanel = this;
		this.setLayout(null);
		this.setSize(960, 540);


		this.add(btnBack());
		this.add(btnYes());
		this.add(mailField());
		this.add(nameField());
		this.add(idField());
		this.add(mailLabel());
		this.add(nameLabel());
		this.add(idLabel());
		this.add(titleLabel());
		this.add(backGroundLabel());

		btnYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent m) {
				String insertId = idField.getText();
				String insertName = nameField.getText();
				String insertMail = mailField.getText();

				Map<String, String> insertUserInfo = new HashMap<>();
				insertUserInfo.put("insertId", insertId);
				insertUserInfo.put("insertName", insertName);
				insertUserInfo.put("insertMail", insertMail);
				
				int result = memberController.findPwd(insertUserInfo);
				
				if(result > 0) {
					ChangePwdPanel changePwdPanel = new ChangePwdPanel(insertUserInfo);
					FrameManager.changePanel(findPwdPanel, changePwdPanel);
				} else {
					JOptionPane.showMessageDialog(null, "입력하신 정보와 일치하는 계정이 없습니다.", "비밀번호 찾기", 1);
				}
			}
		});
	

		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent m) {

				FrameManager.changePanel(findPwdPanel, findIdPwdPanel);
			}
		});
	}
	public JLabel titleLabel() {
		titleLabel = new JLabel("P W D 찾 기 ");
		titleLabel.setLayout(null);
		titleLabel.setBounds(330, 50, 600, 60);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.white);

		return titleLabel;
	}
	public JLabel backGroundLabel() {
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		return backGroundLabel;
	}
	public JLabel idLabel() {
		idLabel = new JLabel("아 이 디 ");
		idLabel.setLayout(null);
		idLabel.setBounds(350, 150, 200, 25);
		idLabel.setFont(font);
		idLabel.setForeground(Color.white);

		return idLabel;
	}
	public JLabel nameLabel() {
		nameLabel = new JLabel("이 름");
		nameLabel.setLayout(null);
		nameLabel.setBounds(350, 230, 200, 25);
		nameLabel.setFont(font);
		nameLabel.setForeground(Color.white);

		return nameLabel;
	}
	public JLabel mailLabel() {
		mailLabel = new JLabel("이 메 일 ");
		mailLabel.setLayout(null);
		mailLabel.setBounds(350, 310, 200, 25);
		mailLabel.setFont(font);
		mailLabel.setForeground(Color.white);

		return mailLabel;
	}
	public JTextField idField() {
		idField = new JTextField();
		idField.setLayout(null);
		idField.setBounds(350, 190, 300, 35);
		idField.setFont(font);
		return idField;

	}
	public JTextField nameField() {
		nameField = new JTextField();
		nameField.setLayout(null);
		nameField.setBounds(350, 270, 300, 35);
		nameField.setFont(font);
		return nameField;
	}
	public JTextField mailField() {
		mailField = new JTextField();
		mailField.setLayout(null);
		mailField.setBounds(350, 350, 300, 35);
		mailField.setFont(font);
		return mailField;
	}

	public JButton btnYes() {
		btnYes = new JButton("P W D 찾 기 ");
		btnYes.setBounds(340,400,140,33);
		btnYes.setFont(font);
		btnYes.setForeground(Color.white);
		btnYes.setBackground(Color.ORANGE);

		return btnYes;
	}
	public JButton btnBack() {
		btnBack = new JButton("뒤 로 가 기");
		btnBack.setBounds(510,400,140,33);
		btnBack.setFont(font);
		btnBack.setForeground(Color.white);
		btnBack.setBackground(Color.ORANGE);

		return btnBack;
	}



}
