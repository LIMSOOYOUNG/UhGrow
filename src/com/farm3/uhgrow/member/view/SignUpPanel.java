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

public class SignUpPanel extends JPanel {

	
	private JPanel signUpPanel;
	private JButton btnBack;
	private JButton btnInsert;
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 25);
	
	public SignUpPanel () {
		signUpPanel = this;
		
		this.setLayout(null);
		this.setSize(960,540);
		
		/* ----------- backGroundLabel 에 배경 이미지 추가 --------------------*/
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);

		/* ------------회원가입 창에 회원가입 버튼 --------------*/
		btnInsert = new JButton("회 원 가 입");
		btnInsert.setLayout(null);
		btnInsert.setBounds(210,385,245,35);
		btnInsert.setFont(font);
		btnInsert.setForeground(Color.white);
		btnInsert.setBackground(Color.ORANGE);

		btnBack = new JButton("뒤 로 가 기");
		btnBack.setLayout(null);
		btnBack.setBounds(505,385,245,35);
		btnBack.setFont(font);
		btnBack.setForeground(Color.white);
		btnBack.setBackground(Color.ORANGE);
		
		JLabel idLabel = new JLabel("아 이 디  : ");
		idLabel.setLayout(null);
		idLabel.setBounds(350, 60, 200, 25);
		idLabel.setFont(font);
		idLabel.setForeground(Color.white);

		JTextField idField = new JTextField();
		idField.setLayout(null);
		idField.setBounds(350, 90, 300, 25);
		idField.setFont(font);

		JLabel pwdLabel = new JLabel("비밀번호:  ");
		pwdLabel.setLayout(null);
		pwdLabel.setBounds(350, 120, 200, 25);
		pwdLabel.setFont(font);
		pwdLabel.setForeground(Color.white);

		JPasswordField pwdField = new JPasswordField();
		pwdField.setLayout(null);
		pwdField.setBounds(350, 150, 300, 25);
		pwdField.setFont(font);

		JLabel pwdLabel2 = new JLabel("비번 재확인  :  ");
		pwdLabel2.setLayout(null);
		pwdLabel2.setBounds(350, 180, 200, 25);
		pwdLabel2.setFont(font);
		pwdLabel2.setForeground(Color.white);

		JPasswordField pwdField2 = new JPasswordField();
		pwdField2.setLayout(null);
		pwdField2.setBounds(350, 210, 300, 25);
		pwdField2.setFont(font);

		JLabel nameLabel = new JLabel("이  름 : ");
		nameLabel.setLayout(null);
		nameLabel.setBounds(350, 240, 200, 25);
		nameLabel.setFont(font);
		nameLabel.setForeground(Color.white);


		JTextField nameField = new JTextField();
		nameField.setLayout(null);
		nameField.setBounds(350, 270, 300, 25);
		nameField.setFont(font);

		JLabel mailLabel = new JLabel("이메일: ");
		mailLabel.setLayout(null);
		mailLabel.setBounds(350, 300, 200, 25);
		mailLabel.setFont(font);
		mailLabel.setForeground(Color.white);


		JTextField mailField = new JTextField();
		mailField.setLayout(null);
		mailField.setBounds(350, 330, 300, 25);
		mailField.setFont(font);
		mailField.setForeground(Color.white);

		// signUpPanel에 위에 생성한 버튼, 텍스트필드, 배경 추가
		this.add(idLabel);
		this.add(idField);
		this.add(pwdLabel);
		this.add(pwdField);
		this.add(pwdLabel2);
		this.add(pwdField2);
		this.add(nameLabel);
		this.add(nameField);
		this.add(mailLabel);
		this.add(mailField);

		this.add(btnBack);
		this.add(btnInsert);
		this.add(backGroundLabel);

		btnInsert.addMouseListener(new MouseAdapter() {

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
				
				
				/* 이름의 유니코드가 한글의 범위인지 확인 후 한글 범위 밖이면 nameResult에 1을 저장*/
				int nameResult = 0;
				for(int i = 0; i < name.length(); i++) {
					if ((name.charAt(i) < (int)('가')) || (name.charAt(i) > (int)('힣'))) {
						nameResult = 1;
						System.out.println(nameResult);
					}
				}

				/* ---------------------- 가입시 입력한 값 공석일때 ------------------------*/
				if(id.isEmpty()){
					JOptionPane.showMessageDialog(null, "ID를 입력하세요!", "회원가입 오류!", 1);
				} else if (pwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요!", "회원가입 오류!", 1);
				} else if (pwd2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호확인을 입력하세요!", "회원가입 오류!", 1);
				} else if (name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요!", "회원가입 오류!", 1);
				} else if (mail.isEmpty()) {
					JOptionPane.showMessageDialog(null, "메일을 입력하세요!", "회원가입 오류!", 1);
					/* ---------------------- 가입시 입력한 값의 byte가 초과될때  ------------------------*/
				} else if (id.getBytes().length > 20) {
					JOptionPane.showMessageDialog(null, "ID가 너무 길어요!", "회원가입 오류!", 1);
				} else if (pwd.getBytes().length > 20) {
					JOptionPane.showMessageDialog(null, "비밀번호는 4글자 이상! 20자 미만!!", "회원가입 오류!", 1);
				} else if (pwd.getBytes().length < 3) {
					JOptionPane.showMessageDialog(null, "비밀번호는 4글자 이상! 20자 미만!!", "회원가입 오류!", 1);
				}else if (name.getBytes().length > 15) {
					JOptionPane.showMessageDialog(null, "이름이 너무 길어요!", "회원가입 오류!", 1);
				} else if (mail.getBytes().length > 30) {
					JOptionPane.showMessageDialog(null, "메일이 너무 길어요!", "회원가입 오류!", 1);
					
					/*----------------------위에서 name을 한글인지 비교해서 한글이 아닐때 nameResult에 1을 저장 -----------------*/
				} else if (nameResult == 1) {
					JOptionPane.showMessageDialog(null, "이름은 한글만 입력 가능합니다!", "회원가입 오류!", 1);

					/* ------------------------ 메일에 @ 빠졌는지, @뒤에 . 들어가있는지 확인 ------------------------------*/
				} else if (mail.indexOf('@') == -1) {
					JOptionPane.showMessageDialog(null, "메일에 '@'와 '.' 이/가 들어가야합니다.", "회원가입 오류!", 1);
				} else if ((mail.substring(mail.indexOf('@') , mail.length()).indexOf('.')) == -1) {
					JOptionPane.showMessageDialog(null, "메일 '.'가 들어가야합니다.", "회원가입 오류!", 1);
					/* ------------------------- 비번이랑 비번 확인 비교 ------------------------------*/
				} else if (pwd.compareTo(pwd2) != 0) {
					JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호 확인 불일치!!", "회원가입 오류!", 1);
					// 입력한 값에 오류가 없을때 !! 회원가입이 가능! 
				} else {
					
					/* 위 모든 조건을 만족하지 않을 시 회원가입이 가능한 정보이기 때문에 입력받은 값 map에 담아서 전달*/
					
					MemberController memberController = new MemberController();
					
					int signUpResult = memberController.signUpMember(map);
					
					if(signUpResult == 1) {
						// 성공 출력 
						JOptionPane.showMessageDialog(null, "가입 성공!", "회원가입 오류!", 1);
						
					} else {
						// 실패 출력
						JOptionPane.showMessageDialog(null, "회원가입 실패! \n아이디 혹은 이메일 중복입니다.", "회원가입 오류!", 1);
					}
					
					
				}
			}

		});

		// 되돌아가기 버튼 클릭시 기존 패널 제거해주고 loginPanel 불러오기
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JPanel loginPanel = new LoginPanel();
				
				FrameManager.changePanel(signUpPanel, loginPanel);
				
			}
		});
		


	}
}

