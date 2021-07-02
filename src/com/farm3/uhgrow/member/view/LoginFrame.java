package com.farm3.uhgrow.member.view;

import javax.swing.JFrame;

public class LoginFrame extends JFrame {

	public LoginFrame() {
		this.setTitle("UhGrow");
		this.setLayout(null);
		this.setBounds(300, 200, 960, 565);
		
		this.add(new LoginPanel());
		
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


