package com.farm3.uhgrow.view;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainBackGround extends JFrame {
	public MainBackGround() {
		this.setBounds(300, 200, 960, 575);
		
		this.add(new MainPanel());
	


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
