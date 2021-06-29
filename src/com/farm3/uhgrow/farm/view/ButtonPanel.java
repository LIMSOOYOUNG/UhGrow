package com.farm3.uhgrow.farm.view;

import java.awt.Button;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	public ButtonPanel() {
		JButton btn = new JButton();
		JLabel jl = new JLabel("버튼");
		jl.add(btn);
		
		this.add(jl);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new javax.swing.ImageIcon("img/animal/Pizza.png").getImage(),150 , 150, 30, 30,this);
		

		this.repaint();
	}
}
