
package com.farm3.uhgrow.member.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.farm3.uhgrow.member.controller.MemberController;
import com.farm3.uhgrow.member.model.dto.UserDTO;

public class LoginFrame extends JFrame {

	public LoginFrame() {
		this.setTitle("UhGrow");
		this.setLayout(null);
		this.setBounds(300, 200, 960, 565);
		playSound("sound/배경음악1.wav");
		
		this.add(new LoginPanel());
		

		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel loginPanel() {
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 60);
		// 패널 생성
		JPanel loginPanel = new JPanel();

		loginPanel.setLayout(null);
		loginPanel.setSize(960, 540);

		// backGroundLabel에 배경이미지 크기 지정
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		loginPanel.setVisible(true);

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

		// 로그인창
		Image loginBackground = new ImageIcon("img/loginInterface/login.png").getImage().getScaledInstance(540, 36, 0);
		JButton loginButton = new JButton(new ImageIcon(loginBackground));
		loginButton.setLayout(null);
		loginButton.setBounds(210, 340, 540, 36);

		// 회원가입창
		Image signUpBackground = new ImageIcon("img/loginInterface/signUp.png").getImage().getScaledInstance(245, 35,
				0);
		JButton signUpButton = new JButton(new ImageIcon(signUpBackground));
		signUpButton.setLayout(null);
		signUpButton.setBounds(210, 385, 245, 35);

		// id pwd찾기 창
		Image findIdPwdBackground = new ImageIcon("img/loginInterface/idpwd.png").getImage().getScaledInstance(245, 40,
				0);
		JButton findIdPwdButton = new JButton(new ImageIcon(findIdPwdBackground));
		findIdPwdButton.setLayout(null);
		findIdPwdButton.setBounds(505, 385, 245, 35);

		loginPanel.add(titleLabel);
		loginPanel.add(idLabel);
		loginPanel.add(idField);
		loginPanel.add(pwdLabel);
		loginPanel.add(pwdField);
		loginPanel.add(loginButton);
		loginPanel.add(signUpButton);
		loginPanel.add(findIdPwdButton);

		loginPanel.add(backGroundLabel);

		loginButton.addMouseListener(new MouseAdapter() {
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
				if (loginId.isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID를 입력하세요!", "로그인 오류!", 1);
				} else if (loginPwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요!.", "로그인 오류!", 1);
				} else if (loginResult == null) {
					JOptionPane.showMessageDialog(null, "입력하신 ID는 없는 ID입니다..", "로그인 오류!", 1);
				} else if (!loginResult.getUserPwd().equals(loginPwd)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "로그인 오류!", 1);
				} else {
					/*
					 * 로그인 시도 후 성공시 UserDTO 전달받음 전달 받은 후에 만약 arthority가 관리자인 경우 관리자 프레임 불러오고, 사용자인
					 * 경우 새로하기 or 이어하기 패널로 이동
					 */
//					dispose();
//					new MainFrame();// 초기화면 불러오기
				}

			}
		});
		this.add(loginPanel);
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
		return loginPanel;
	}

	public JPanel signUpPanel() {

		JPanel signUpPanel = new JPanel();
		Font font = new Font("고딕체", Font.BOLD, 25);

		signUpPanel.setLayout(null);
		signUpPanel.setSize(960, 540);
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);

		Image signUpBackground = new ImageIcon("img/loginInterface/signUp.png").getImage().getScaledInstance(245, 35,
				0);
		JButton signUpButton = new JButton(new ImageIcon(signUpBackground));
		signUpButton.setLayout(null);
		signUpButton.setBounds(210, 385, 245, 35);

		Image backButtonBackground = new ImageIcon("img/loginInterface/back.png").getImage().getScaledInstance(245, 35,
				0);
		JButton backButton = new JButton(new ImageIcon(backButtonBackground));
		backButton.setLayout(null);
		backButton.setBounds(505, 385, 245, 35);

		JLabel idLabel = new JLabel("아 이 디  : ");
		idLabel.setLayout(null);
		idLabel.setBounds(350, 60, 200, 25);
		idLabel.setFont(font);

		JTextField idField = new JTextField();
		idField.setLayout(null);
		idField.setBounds(350, 90, 300, 25);
		idField.setFont(font);

		JLabel pwdLabel = new JLabel("비밀번호:  ");
		pwdLabel.setLayout(null);
		pwdLabel.setBounds(350, 120, 200, 25);
		pwdLabel.setFont(font);

		JPasswordField pwdField = new JPasswordField();
		pwdField.setLayout(null);
		pwdField.setBounds(350, 150, 300, 25);
		pwdField.setFont(font);

		JLabel pwdLabel2 = new JLabel("비번 재확인  :  ");
		pwdLabel2.setLayout(null);
		pwdLabel2.setBounds(350, 180, 200, 25);
		pwdLabel2.setFont(font);

		JPasswordField pwdField2 = new JPasswordField();
		pwdField2.setLayout(null);
		pwdField2.setBounds(350, 210, 300, 25);
		pwdField2.setFont(font);

		JLabel nameLabel = new JLabel("이  름 : ");
		nameLabel.setLayout(null);
		nameLabel.setBounds(350, 240, 200, 25);
		nameLabel.setFont(font);

		JTextField nameField = new JTextField();
		nameField.setLayout(null);
		nameField.setBounds(350, 270, 300, 25);
		nameField.setFont(font);

		JLabel mailLabel = new JLabel("이메일: ");
		mailLabel.setLayout(null);
		mailLabel.setBounds(350, 300, 200, 25);
		mailLabel.setFont(font);

		JTextField mailField = new JTextField();
		mailField.setLayout(null);
		mailField.setBounds(350, 330, 300, 25);
		mailField.setFont(font);

		signUpPanel.add(idLabel);
		signUpPanel.add(idField);
		signUpPanel.add(pwdLabel);
		signUpPanel.add(pwdField);
		signUpPanel.add(pwdLabel2);
		signUpPanel.add(pwdField2);
		signUpPanel.add(nameLabel);
		signUpPanel.add(nameField);
		signUpPanel.add(mailLabel);
		signUpPanel.add(mailField);

		signUpPanel.add(backButton);
		signUpPanel.add(signUpButton);
		signUpPanel.add(backGroundLabel);

		this.add(signUpPanel);

		signUpButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String id = idField.getText();
				String pwd = pwdField.getText();
				String pwd2 = pwdField2.getText();
				String name = nameField.getText();
				String mail = mailField.getText().toLowerCase();

				Map<String, String> map = new HashMap<>();

				map.put("signUpId", id);
				map.put("signUpPwd", pwd);
				map.put("signUpName", name);
				map.put("signUpMail", mail);

				/* 이름의 유니코드가 한글의 범위인지 확인 후 한글 범위 밖이면 nameResult에 1을 저장 */
				int nameResult = 0;
				for (int i = 0; i < name.length(); i++) {
					if ((name.charAt(i) < (int) ('가')) || (name.charAt(i) > (int) ('힣'))) {
						nameResult = 1;
						System.out.println(nameResult);
					}
				}

				/* ---------------------- 가입시 입력한 값 공석일때 ------------------------ */
				if (id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID를 입력하세요!", "회원가입 오류!", 1);
					System.out.println("id 입력하셈");
				} else if (pwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요!", "회원가입 오류!", 1);
				} else if (pwd2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호확인을 입력하세요!", "회원가입 오류!", 1);
				} else if (name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요!", "회원가입 오류!", 1);
				} else if (mail.isEmpty()) {
					JOptionPane.showMessageDialog(null, "메일을 입력하세요!", "회원가입 오류!", 1);
					/* ---------------------- 가입시 입력한 값의 byte가 초과될때 ------------------------ */
				} else if (id.getBytes().length > 20) {
					JOptionPane.showMessageDialog(null, "ID가 너무 길어요!", "회원가입 오류!", 1);
				} else if (pwd.getBytes().length > 20) {
					JOptionPane.showMessageDialog(null, "비밀번호는 4글자 이상! 20자 미만!!", "회원가입 오류!", 1);
				} else if (pwd.getBytes().length < 3) {
					JOptionPane.showMessageDialog(null, "비밀번호는 4글자 이상! 20자 미만!!", "회원가입 오류!", 1);
				} else if (name.getBytes().length > 15) {
					JOptionPane.showMessageDialog(null, "이름이 너무 길어요!", "회원가입 오류!", 1);
				} else if (mail.getBytes().length > 30) {
					JOptionPane.showMessageDialog(null, "메일이 너무 길어요!", "회원가입 오류!", 1);

					/*----------------------위에서 name을 한글인지 비교해서 한글이 아닐때 nameResult에 1을 저장 -----------------*/
				} else if (nameResult == 1) {
					JOptionPane.showMessageDialog(null, "이름은 한글만 입력 가능합니다!", "회원가입 오류!", 1);

					/*
					 * ------------------------ 메일에 @ 빠졌는지, @뒤에 . 들어가있는지 확인
					 * ------------------------------
					 */
				} else if (mail.indexOf('@') == -1) {
					JOptionPane.showMessageDialog(null, "메일에 '@'와 '.' 이/가 들어가야합니다.", "회원가입 오류!", 1);
				} else if ((mail.substring(mail.indexOf('@'), mail.length()).indexOf('.')) == -1) {
					JOptionPane.showMessageDialog(null, "메일 '.'가 들어가야합니다.", "회원가입 오류!", 1);
					/* ------------------------- 비번이랑 비번 확인 비교 ------------------------------ */
				} else if (pwd.compareTo(pwd2) != 0) {
					JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호 확인 불일치!!", "회원가입 오류!", 1);
					// 입력한 값에 오류가 없을때 !! 회원가입이 가능!
				} else {

					/* 위 모든 조건을 만족하지 않을 시 회원가입이 가능한 정보이기 때문에 입력받은 값 map에 담아서 전달 */

					MemberController memberController = new MemberController();

					int signUpResult = memberController.signUpMember(map);

					if (signUpResult == 1) {
						// 성공 출력
						JOptionPane.showMessageDialog(null, "가입 성공!", "회원가입 오류!", 1);

						signUpPanel.removeAll();
						signUpPanel.setVisible(false);
						loginPanel();

					} else {
						// 실패 출력
						JOptionPane.showMessageDialog(null, "회원가입 실패! \n아이디 혹은 이메일 중복입니다.", "회원가입 오류!", 1);
					}

				}
			}
		});

		// 되돌아가기 버튼 클릭시 기존 패널 제거해주고 loginPanel 불러오기
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				signUpPanel.setVisible(false);
				signUpPanel.removeAll();
				loginPanel();
			}
		});
		return signUpPanel;

	}

	public static void playSound(String fn) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fn));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
