package com.farm3.uhgrow.member.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpPanel extends JFrame {


	LoginPanel lp = new LoginPanel();

	public JPanel signUpPanel () {

		JPanel signUpPanel = new JPanel();
		Font font = new Font("고딕체", Font.BOLD, 25);

		signUpPanel.setLayout(null);
		signUpPanel.setSize(960,540);
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);

		Image signUpBackground = new ImageIcon("img/loginInterface/signUp.png").getImage().getScaledInstance(230, 72, 0);
		JButton signUpButton = new JButton(new ImageIcon(signUpBackground));
		signUpButton.setLayout(null);
		signUpButton.setBounds(240,370,230,72);


		Image backButtonBackground = new ImageIcon("img/loginInterface/back.png").getImage().getScaledInstance(230, 72, 0);
		JButton backButton = new JButton(new ImageIcon(backButtonBackground));
		backButton.setLayout(null);
		backButton.setBounds(490,370,230,72);

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

		/* 1. 비밀번호와 비밀번호 확인 입력값 일치 불일치 확인
		 * 2. 일치시 데이터값 map에 담아서 넘겨줌
		 * 3. 데이터값 불러와서 dto에 담긴 데이터값과 
		 * 		입력받은 데이터의 값을 확인 후 
		 * 			1. id 중복시 id중복 입력 
		 * 			2. 이메일 중복시 중복 출 */
		signUpButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String id = idField.getText();
				String pwd = pwdField.getText();
				String pwd2 = pwdField2.getText();
				String name = nameField.getText();
				String mail = mailField.getText().toLowerCase();
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
					System.out.println("id 입력하셈");
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
					JOptionPane.showMessageDialog(null, "비밀번호가 너무 길어요!", "회원가입 오류!", 1);
				} else if (name.getBytes().length > 15) {
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

					signUpPanel.removeAll();
					signUpPanel.setVisible(false);
					lp.loginPanel();

				}
			}
		});

		// 되돌아가기 버튼 클릭시 기존 패널 제거해주고 loginPanel 불러오기
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				signUpPanel.setVisible(false);
				signUpPanel.removeAll();
				lp.loginPanel();
			}
		});
		return signUpPanel;


	}
}

