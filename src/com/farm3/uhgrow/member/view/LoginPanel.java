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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.farm3.uhgrow.member.controller.MemberController;
import com.farm3.uhgrow.member.model.dto.LoginDTO;

public class LoginPanel extends JPanel {

	private JButton btnLogin;
	private JButton btnSignUp;
	private JButton btnFindIdPwd;
	private JButton btnInsertUser;
	private JPanel loginPanel;
	private int userNo;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private Font titleFont = new Font("나눔손글씨 펜", Font.BOLD, 80);

	// 로그인창 패널 
	public LoginPanel() {

		// loginPanel 필드에 선언 후 this로 패널의 인스턴스를 지정해줌 -> 아래의 changePanel에서 쓰일 예정 (oldPanel부분)
		loginPanel = this;


		this.setLayout(null);
		this.setSize(960,540);

		// backGroundLabel에 배경이미지 크기 지정
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		this.setVisible(true);

		// Uh Grow! 타이틀 
		JLabel titleLabel = new JLabel("Uh   Grow!");
		titleLabel.setLayout(null);
		titleLabel.setBounds(330, 50, 600, 150);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.white);
		


		// id, pwd 입력창
		JLabel idLabel = new JLabel("I   D   : ");
		idLabel.setLayout(null);
		idLabel.setBounds(300, 200, 100, 50);
		idLabel.setFont(font);
		idLabel.setForeground(Color.white);


		JTextField idField = new JTextField();
		idField.setLayout(null);
		idField.setBounds(400, 200, 300, 50);
		idField.setFont(font);



		JLabel pwdLabel = new JLabel("P  W  D  :  ");
		pwdLabel.setLayout(null);
		pwdLabel.setBounds(259, 270, 200, 50);
		pwdLabel.setFont(font);
		pwdLabel.setForeground(Color.white);


		JPasswordField pwdField = new JPasswordField();
		pwdField.setLayout(null);
		pwdField.setBounds(400, 270, 300, 50);
		pwdField.setFont(font);



		// id pwd찾기 창
		//		Image findIdPwdBackground = new ImageIcon("img/loginInterface/idpwd.png").getImage().getScaledInstance(245, 40, 0);
		//		JButton findIdPwdButton = new JButton(new ImageIcon(findIdPwdBackground));
		//		findIdPwdButton.setLayout(null);
		//		findIdPwdButton.setBounds(505,385,245,35);


		this.add(titleLabel);
		this.add(idLabel);
		this.add(idField);
		this.add(pwdLabel);
		this.add(pwdField);
		this.add(btnLogIn());
		this.add(btnSignUp());
		this.add(btnFindIdPwd());


		this.add(backGroundLabel);

		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 패널 변경해주는 부분 signUpPanel 인스턴스 생성 후 아래 changePanel 부분에 newPanel에 인스턴스를 넣어줘서 새로운 패널로 채워줌 changePanel 따라가보면 remove, add, repaint, revalidate 해주는거 확인 가능
				JPanel signUpPanel = new SignUpPanel();

				FrameManager.changePanel(loginPanel, signUpPanel);

			}
		});



		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String loginId = idField.getText().toString();
				String loginPwd = pwdField.getText().toString();

				// field에 작성한 id, pwd를 map에 담아서 Controller로 전달 

				MemberController memberController = new MemberController();
				LoginDTO loginResult = memberController.loginInfo(loginId);




				// 로그인 결과 리턴 받아서 가입된 정보 확인
				if(loginId.isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID를 입력하세요!", "로그인 오류!", 1);
				} else if(loginPwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요!.", "로그인 오류!", 1);
				} else if(loginResult == null) {
					JOptionPane.showMessageDialog(null, "입력하신 ID는 없는 ID입니다..", "로그인 오류!", 1);
				} else if(!loginResult.getUserPwd().equals(loginPwd)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "로그인 오류!", 1);
				} else if(loginResult.getDeleteYn() == 'Y'){
					JOptionPane.showMessageDialog(null, "정지된 계정입니다.", "로그인 오류!", 1);

				} else {
					userNo = loginResult.getUserNo();
					NewGameOrContinueGamePanel NewGameOrContinueGamePanel = new NewGameOrContinueGamePanel(userNo);


					FrameManager.changePanel(loginPanel, NewGameOrContinueGamePanel);
				}

			}
		});
		btnFindIdPwd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FindIdPwdPanel FindIdPwdPanel = new FindIdPwdPanel();

				FrameManager.changePanel(loginPanel, FindIdPwdPanel);
			}
		});

	}

	/*---------로그인창 버튼 ------------------*/
	public JButton btnLogIn() {
		Image loginBackground = new ImageIcon("img/loginInterface/login.png").getImage().getScaledInstance(540, 36, 0);
		btnLogin = new JButton("로 그 인");
		btnLogin.setLayout(null);
		btnLogin.setBounds(210,340,540,36);
		btnLogin.setFont(font);
		btnLogin.setForeground(Color.white);
		btnLogin.setBackground(Color.ORANGE);
		return btnLogin;
	}


	public JButton btnSignUp() {
		Image signUpBackground = new ImageIcon("img/loginInterface/signUp.png").getImage().getScaledInstance(245, 35, 0);
		btnSignUp = new JButton("회 원 가 입");
		btnSignUp.setLayout(null);
		btnSignUp.setBounds(210,385,245,35);
		btnSignUp.setFont(font);
		btnSignUp.setForeground(Color.white);
		btnSignUp.setBackground(Color.ORANGE);

		return btnSignUp;
	}

	/*------------아이디 찾기, 비밀번호 찾기 버튼 ---------------*/
	public JButton btnFindIdPwd() {
		Image btnFindIdPwdBackGround = new ImageIcon("img/loginInterface/idpwd.png").getImage().getScaledInstance(245, 35, 0);
		btnFindIdPwd = new JButton("I D / P W D 찾 기");
		btnFindIdPwd.setLayout(null);
		btnFindIdPwd.setBounds(505,385,245,35);
		btnFindIdPwd.setFont(font);
		btnFindIdPwd.setForeground(Color.white);
		btnFindIdPwd.setBackground(Color.ORANGE);

		return btnFindIdPwd;
	}
}
