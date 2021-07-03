package com.farm3.uhgrow.member.view;

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

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.controller.MemberController;
import com.farm3.uhgrow.member.model.dto.UserDTO;
import com.farm3.uhgrow.member.store.BuyHouseAndCookPanel;
import com.farm3.uhgrow.member.store.MainStorePanel;

public class LoginPanel extends JPanel {

	private JButton btnLogin;
	private JButton btnSignUp;
	private JButton btnFindIdPwd;
	private JButton btnBack;
	private JButton btnInsertUser;
	private JPanel loginPanel;

// 로그인창 패널 
	public LoginPanel() {
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);
		
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


		// id, pwd 입력창
		JLabel idLabel = new JLabel("I   D   : ");
		idLabel.setLayout(null);
		idLabel.setBounds(300, 200, 100, 50);
		idLabel.setFont(font);

		JTextField idField = new JTextField();
		idField.setLayout(null);
		idField.setBounds(400, 200, 300, 50);
		idField.setFont(font);

		JLabel pwdLabel = new JLabel("P  W  D  :  ");
		pwdLabel.setLayout(null);
		pwdLabel.setBounds(259, 270, 200, 50);
		pwdLabel.setFont(font);

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
				Map<String, String> map = new HashMap<>();

				// field에 작성한 id, pwd를 map에 담아서 Controller로 전달 
				map.put("loginId", loginId);
				map.put("loginPwd", loginPwd);
				MemberController memberController = new MemberController();
				UserDTO loginResult = memberController.loginInfo(map);


				// 로그인 결과 리턴 받아서 가입된 정보 확인
				if(loginId.isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID를 입력하세요!", "로그인 오류!", 1);
				} else if(loginPwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요!.", "로그인 오류!", 1);
				} else if(loginResult == null) {
					JOptionPane.showMessageDialog(null, "입력하신 ID는 없는 ID입니다..", "로그인 오류!", 1);
				} else if(!loginResult.getUserPwd().equals(loginPwd)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "로그인 오류!", 1);
				} else {
					/* 로그인 시도 후 성공시 UserDTO 전달받음 
					 * 전달 받은 후에 만약 arthority가 관리자인 경우 관리자 프레임 불러오고, 사용자인 경우 새로하기 or 이어하기 패널로 이동*/
					//					dispose();
					//					new MainFrame();// 초기화면 불러오기
//					FarmPanel farmPanel = new FarmPanel();
//					FrameManager.changePanel(loginPanel, farmPanel);
					
					JPanel mainStorePanel = new MainStorePanel();
					JPanel hac = new BuyHouseAndCookPanel();
					
					FarmPanel farm = new FarmPanel();

					System.out.println(loginResult);
					FrameManager.changePanel(loginPanel, farm);
					
				}

			}
		});

	}

	


	/*---------로그인창 버튼 ------------------*/
	public JButton btnLogIn() {
		Image loginBackground = new ImageIcon("img/loginInterface/login.png").getImage().getScaledInstance(540, 36, 0);
		btnLogin = new JButton(new ImageIcon(loginBackground));
		btnLogin.setLayout(null);
		btnLogin.setBounds(210,340,540,36);
		return btnLogin;
	}


	public JButton btnSignUp() {
		Image signUpBackground = new ImageIcon("img/loginInterface/signUp.png").getImage().getScaledInstance(245, 35, 0);
		btnSignUp = new JButton(new ImageIcon(signUpBackground));
		btnSignUp.setLayout(null);
		btnSignUp.setBounds(210,385,245,35);

		return btnSignUp;
	}

	/*------------회원가입창 버튼---------------*/
	public JButton btnBack() {
		Image backButtonBackground = new ImageIcon("img/loginInterface/back.png").getImage().getScaledInstance(245, 35, 0);
		btnBack = new JButton(new ImageIcon(backButtonBackground));
		btnBack.setLayout(null);
		btnBack.setBounds(505,385,245,35);

		return btnBack;
	}

	public JButton btnInsertUser() {

		Image signUpBackground = new ImageIcon("img/loginInterface/signUp.png").getImage().getScaledInstance(245, 35, 0);
		btnInsertUser = new JButton(new ImageIcon(signUpBackground));
		btnInsertUser.setLayout(null);
		btnInsertUser.setBounds(210,385,245,35);
		return btnInsertUser;
	}


	

}
