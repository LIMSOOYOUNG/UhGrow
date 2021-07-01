package com.farm3.uhgrow.member.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.farm3.uhgrow.farm.view.MainFrame;
import com.farm3.uhgrow.member.controller.MemberController;
import com.farm3.uhgrow.member.model.dto.UserDTO;

public class LoginFrame extends JFrame {
	Font font = new Font("고딕체", Font.BOLD, 30);

	public LoginFrame() {
		loginPanel();
	}
	public void loginPanel() {
		this.setBounds(300, 200, 960, 565);
		this.setTitle("UhGrow");
		this.setLayout(null);

		// 패널 생성 
		JPanel backGroundPanel = new JPanel();
		JPanel loginPanel = new JPanel();
		

		// backGroundPanel위치 지정 후  BackGrountLabel(이미지) 삽입
		loginPanel.setLayout(null);
		loginPanel.setSize(960,540);
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		loginPanel.setVisible(true);



		// id, pwd 입력창
		JLabel idLabel = new JLabel("I   D   : ");
		idLabel.setLayout(null);
		idLabel.setBounds(300, 60, 100, 50);
		idLabel.setFont(font);

		JTextField idField = new JTextField();
		idField.setLayout(null);
		idField.setBounds(400, 60, 300, 50);
		idField.setFont(font);

		JLabel pwdLabel = new JLabel("P  W  D  :  ");
		pwdLabel.setLayout(null);
		pwdLabel.setBounds(259, 140, 200, 50);
		pwdLabel.setFont(font);

		JPasswordField pwdField = new JPasswordField();
		pwdField.setLayout(null);
		pwdField.setBounds(400, 140, 300, 50);
		pwdField.setFont(font);


		// 로그인창 
		Image loginBackground = new ImageIcon("img/loginInterface/login.png").getImage().getScaledInstance(480, 98, 0);
		JButton loginButton = new JButton(new ImageIcon(loginBackground));
		loginButton.setLayout(null);
		loginButton.setBounds(240,220,480,98);

		// 회원가입창
		Image signUpBackground = new ImageIcon("img/loginInterface/signUp.png").getImage().getScaledInstance(230, 72, 0);
		JButton signUpButton = new JButton(new ImageIcon(signUpBackground));
		signUpButton.setLayout(null);
		signUpButton.setBounds(240,340,230,72);

		// id pwd찾기 창
		Image findIdPwdBackground = new ImageIcon("img/loginInterface/idpwd.png").getImage().getScaledInstance(230, 72, 0);
		JButton findIdPwdButton = new JButton(new ImageIcon(findIdPwdBackground));
		findIdPwdButton.setLayout(null);
		findIdPwdButton.setBounds(490,340,230,72);


		loginPanel.add(idLabel);
		loginPanel.add(idField);
		loginPanel.add(pwdLabel);
		loginPanel.add(pwdField);
		loginPanel.add(loginButton);
		loginPanel.add(signUpButton);
		loginPanel.add(findIdPwdButton);


		loginPanel.add(backGroundLabel);
		this.add(loginPanel);

		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {String loginId = idField.getText().toString();
			String loginPwd = pwdField.getText().toString();
			Map<String, String> map = new HashMap<>();

			// field에 작성한 id, pwd를 map에 담아서 Controller로 전달 
			map.put("loginId", loginId);
			map.put("loginPwd", loginPwd);
			MemberController memberController = new MemberController();
			UserDTO loginResult = memberController.loginInfo(map);

			// 로그인 결과 리턴 받아서 가입된 정보 확인
			if(loginResult == null) {
				JOptionPane.showMessageDialog(null, "ID가 일치하지 않습니다.", "입력 오류!", 1);
			} else if(!loginResult.getUserPwd().equals(loginPwd)) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "입력 오류!", 1);
			} else {
				dispose();
				new MainFrame();// 초기화면 불러오기
			}

			}
		});
		signUpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				loginPanel.removeAll();
				loginPanel.setVisible(false);
				signUpPanel();

			}
		});

		findIdPwdButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void signUpPanel() {

		JPanel signUpPanel = new JPanel();

		signUpPanel.setLayout(null);
		signUpPanel.setSize(960,540);
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		
		Image signUpBackground = new ImageIcon("img/loginInterface/signUp.png").getImage().getScaledInstance(230, 72, 0);
		JButton signUpButton = new JButton(new ImageIcon(signUpBackground));
		signUpButton.setLayout(null);
		signUpButton.setBounds(240,340,230,72);
		
		
		Image backButtonBackground = new ImageIcon("img/loginInterface/back.png").getImage().getScaledInstance(230, 72, 0);
		JButton backButton = new JButton(new ImageIcon(backButtonBackground));
		backButton.setLayout(null);
		backButton.setBounds(490,340,230,72);
		
		JLabel idLabel = new JLabel("I   D   : ");
		idLabel.setLayout(null);
		idLabel.setBounds(300, 60, 100, 50);
		idLabel.setFont(font);

		JTextField idField = new JTextField();
		idField.setLayout(null);
		idField.setBounds(400, 60, 300, 50);
		idField.setFont(font);
		
		JLabel pwdLabel = new JLabel("P  W  D  :  ");
		pwdLabel.setLayout(null);
		pwdLabel.setBounds(259, 125, 200, 50);
		pwdLabel.setFont(font);

		JPasswordField pwdField = new JPasswordField();
		pwdField.setLayout(null);
		pwdField.setBounds(400, 125, 300, 50);
		pwdField.setFont(font);
		
		JLabel nameLabel = new JLabel("N A M E : ");
		nameLabel.setLayout(null);
		nameLabel.setBounds(259, 190, 200, 50);
		nameLabel.setFont(font);
		
		JTextField nameField = new JTextField();
		nameField.setLayout(null);
		nameField.setBounds(400, 190, 300, 50);
		nameField.setFont(font);
		
		JLabel mailLabel = new JLabel("E - MAIL: ");
		mailLabel.setLayout(null);
		mailLabel.setBounds(259, 255, 200, 50);
		mailLabel.setFont(font);
		
		JTextField mailField = new JTextField();
		mailField.setLayout(null);
		mailField.setBounds(400, 255, 300, 50);
		mailField.setFont(font);

		signUpPanel.add(idLabel);
		signUpPanel.add(idField);
		signUpPanel.add(pwdLabel);
		signUpPanel.add(pwdField);
		signUpPanel.add(nameLabel);
		signUpPanel.add(nameField);
		signUpPanel.add(mailLabel);
		signUpPanel.add(mailField);
		
		
		signUpPanel.add(backButton);
		signUpPanel.add(signUpButton);
		signUpPanel.add(backGroundLabel);
		
		this.add(signUpPanel);
		
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				signUpPanel.removeAll();
				signUpPanel.setVisible(false);
				loginPanel();


			}
		});
	}
}


