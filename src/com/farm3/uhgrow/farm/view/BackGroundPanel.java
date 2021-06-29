package com.farm3.uhgrow.farm.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackGroundPanel extends JPanel {

	public BackGroundPanel() {
		init();
	}
	
	private void init() {

		this.setSize(960,540);
		
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540,0);
		JLabel imgLabel = new JLabel(new ImageIcon(background)); 	
		this.add(imgLabel);
		
		
	}
	
}
