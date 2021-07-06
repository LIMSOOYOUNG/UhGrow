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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.farm3.uhgrow.member.controller.MemberController;

public class ChangePwdPanel extends JPanel{

	private ChangePwdPanel changePwdPanel;
	private FindPwdPanel findPwdPanel = new FindPwdPanel();
	private LoginPanel loginPanel = new LoginPanel();
	


	private MemberController memberController = new MemberController();
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private Font titleFont = new Font("나눔손글씨 펜", Font.BOLD, 80);
	private JLabel titleLabel;
	private JLabel backGroundLabel;
	private JLabel pwdLabel;
	private JLabel pwdCheckLabel;
	private JPasswordField pwdField;
	private JPasswordField pwdCheckField;
	private JButton btnYes;
	private JButton btnBack;
	
	public ChangePwdPanel(Map<String, String> insertUserInfo) {
		changePwdPanel = this;
		this.setLayout(null);
		this.setSize(960, 540);

		this.add(btnBack());
		this.add(btnYes());
		this.add(pwdCheckField());
		this.add(pwdField());
		this.add(pwdCheckLabel());
		this.add(pwdLabel());
		this.add(titleLabel());
		this.add(backGroundLabel());


		btnYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent m) {
				String userId = insertUserInfo.get("insertId");
				String userName = insertUserInfo.get("insertName");
				String userMail = insertUserInfo.get("insertMail");
				String insertPwd = pwdField.getText();
				String insertPwd2 = pwdCheckField.getText();


				Map<String, String> insertUserInfoForChangePwd = new HashMap<>();
				insertUserInfoForChangePwd.put("insertPwd", insertPwd);
				insertUserInfoForChangePwd.put("userId", userId);
				insertUserInfoForChangePwd.put("userName", userName);
				insertUserInfoForChangePwd.put("userMail", userMail);

				int result = memberController.changePwd(insertUserInfoForChangePwd);

				if (insertPwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요!", "비밀번호 변경 오류!", 1);
					
				} else if(insertPwd2.isEmpty()){
					JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력하세요!", "비밀번호 변경 오류!", 1);

				} else if(!insertPwd.equals(insertPwd2)){
					JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호 확인 불일치!!", "비밀번호 변경 오류!", 1);	
					
				} else if(insertPwd.getBytes().length > 20 || insertPwd.getBytes().length < 4) {
					JOptionPane.showMessageDialog(null, "비밀번호는 4글자 이상! 20자 미만!!", "비밀번호 변경 오류!", 1);

				} else {
					if(result > 0) {
						JOptionPane.showMessageDialog(null, "비밀번호 변경 성공!", "비밀번호 변경 오류!", 1);
						FrameManager.changePanel(changePwdPanel, loginPanel);
					} else {
						System.out.println("기존 비밀번호와 중복");
					}
				}
				
			}
		});

		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent m) {
				FrameManager.changePanel(changePwdPanel, findPwdPanel);
			}
		});

	}
	public JLabel titleLabel() {
		titleLabel = new JLabel("P W D 변 경 ");
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
	public JLabel pwdLabel() {
		pwdLabel = new JLabel("비 밀 번 호");
		pwdLabel.setLayout(null);
		pwdLabel.setBounds(350, 150, 200, 25);
		pwdLabel.setFont(font);
		pwdLabel.setForeground(Color.white);
		

		return pwdLabel;
	}
	public JLabel pwdCheckLabel() {
		pwdCheckLabel = new JLabel("비 밀 번 호 확 인");
		pwdCheckLabel.setLayout(null);
		pwdCheckLabel.setBounds(350, 230, 200, 25);
		pwdCheckLabel.setFont(font);
		pwdCheckLabel.setForeground(Color.white);

		return pwdCheckLabel;
	}
	public JTextField pwdField() {
		pwdField = new JPasswordField();
		pwdField.setLayout(null);
		pwdField.setBounds(350, 190, 300, 35);
		pwdField.setFont(font);
		return pwdField;

	}
	public JTextField pwdCheckField() {
		pwdCheckField = new JPasswordField();
		pwdCheckField.setLayout(null);
		pwdCheckField.setBounds(350, 270, 300, 35);
		pwdCheckField.setFont(font);
		return pwdCheckField;
	}
	public JButton btnYes() {
		btnYes = new JButton("P W D 변 경");
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
