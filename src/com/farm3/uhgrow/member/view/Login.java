package com.farm3.uhgrow.member.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

		public void signUpPanel() {

			JPanel signUpPanel = new JPanel();

			signUpPanel.setLayout(null);
			signUpPanel.setSize(960,540);
			Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
			JLabel backGroundLabel = new JLabel(new ImageIcon(background));
			backGroundLabel.setLocation(0, 0);
			backGroundLabel.setSize(960, 540);
			
			Image findIdPwdBackground = new ImageIcon("img/loginInterface/idpwd.png").getImage().getScaledInstance(230, 72, 0);
			JButton findIdPwdButton = new JButton(new ImageIcon(findIdPwdBackground));
			findIdPwdButton.setLayout(null);
			findIdPwdButton.setBounds(490,340,230,72);

			signUpPanel.add(findIdPwdButton);
			signUpPanel.add(backGroundLabel);
			
			this.add(signUpPanel);
		
		}
}


