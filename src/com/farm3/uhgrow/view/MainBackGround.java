package com.farm3.uhgrow.view;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainBackGround extends JFrame {
	public MainBackGround() {
		this.setBounds(300, 200, 960, 565);
		this.setLayout(null);

		this.add(new MainPanel());
		this.add(new CharacterPanel());
	
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
