package com.farm3.uhgrow.member.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.farm3.uhgrow.member.controller.MemberController;
import com.farm3.uhgrow.member.model.dto.FindIdPwdDTO;

public class FindIdPanel extends JPanel{
	private MemberController memberController = new MemberController();
	private FindIdPwdPanel findIdPwdPanel = new FindIdPwdPanel();
	

	private JPanel findIdPanel;
	private JTextField inputName;
	private JTextField inputMail;
	private JLabel nameLabel;
	private JLabel mailLabel;
	private JButton btnYes;
	private JButton btnBack;
	private JLabel findIdTitleText;
	private JLabel resultFindIdLabel;
	private TextField resultFindIdTextField;
	private FindIdPwdDTO findIdPwdDTO;
	
	private Font font = new Font("나눔손글씨 펜", Font.BOLD, 25);
	private Font titleFont = new Font("나눔손글씨 펜", Font.BOLD, 80);



	public FindIdPanel() {

		findIdPanel = this;

		this.setLayout(null);
		this.setSize(960,540);
		// 아이디 찾기 title
		findIdTitleText = new JLabel("아이디 찾기");
		findIdTitleText.setLayout(null);
		findIdTitleText.setBounds(370, 60, 600, 80);
		findIdTitleText.setFont(titleFont);
		findIdTitleText.setForeground(Color.white);

		nameLabel = new JLabel("이 름");
		nameLabel.setLayout(null);
		nameLabel.setBounds(350, 150, 200, 25);
		nameLabel.setFont(font);
		nameLabel.setForeground(Color.white);

		inputName = new JTextField();
		inputName.setBounds(350, 180, 300, 35);
		inputName.setFont(font);

		mailLabel = new JLabel("이 메 일");
		mailLabel.setLayout(null);
		mailLabel.setBounds(350, 230, 200, 25);
		mailLabel.setFont(font);
		mailLabel.setForeground(Color.white);


		inputMail = new JTextField();
		inputMail.setBounds(350, 260, 300, 35);
		inputMail.setFont(font);

		// MVC 패턴으로 DB에서 값을 불러온 후 ID 출력할 textField
		resultFindIdTextField = new TextField();
		resultFindIdTextField.setBounds(400, 340, 220, 35);
		resultFindIdTextField.setFont(font);
		resultFindIdTextField.setEditable(false);
		//		resultFindIdTextField.setText("");


		this.add(resultFindIdTextField);
		this.add(resultFindIdLabel());
		this.add(findIdTitleText);
		this.add(btnBack());
		this.add(btnYes());
		this.add(mailLabel);
		this.add(nameLabel);
		this.add(inputMail);
		this.add(inputName);
		this.add(backGroundLabel());

		btnYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				
				String fieldName = inputName.getText();
				String fieldMail = inputMail.getText();
				FindIdPwdDTO findIdResult = memberController.findId(fieldName, fieldMail);
				
				if(findIdResult.getUserId() == null) {
					JOptionPane.showMessageDialog(null, "입력하신 정보와 일치하는 계정이 없습니다.", "아이디 찾기 오류!", 1);

				} else {
					
					String userId = findIdResult.getUserId();
					resultFindIdTextField.setText(userId);
				}
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent m) {
				
				FrameManager.changePanel(findIdPanel, findIdPwdPanel);
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

	// 타이틀에 이미지 따와서 넣는게 좋을듯 


	public JButton btnYes() {
		Image btnYesImage = new ImageIcon("img/loginInterface/findId.png").getImage().getScaledInstance(140, 33, 0);
		btnYes = new JButton("I D 찾 기 ");
		btnYes.setBounds(340,400,140,33);
		btnYes.setFont(font);
		btnYes.setForeground(Color.white);
		btnYes.setBackground(Color.ORANGE);

		return btnYes;
	}
	public JButton btnBack() {
		Image btnYesImage = new ImageIcon("img/loginInterface/backButton.png").getImage().getScaledInstance(140, 33, 0);
		btnBack = new JButton("뒤 로 가 기");
		btnBack.setBounds(510,400,140,33);
		btnBack.setFont(font);
		btnBack.setForeground(Color.white);
		btnBack.setBackground(Color.ORANGE);

		return btnBack;
	}
	public JLabel resultFindIdLabel() {
		resultFindIdLabel = new JLabel("귀하의 ID는                                  입니다.");
		resultFindIdLabel.setBounds(300, 340, 500, 35);
		resultFindIdLabel.setFont(font);
		resultFindIdLabel.setForeground(Color.white);


		return resultFindIdLabel;
	}




}
