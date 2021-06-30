package com.farm3.uhgrow.farm.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FarmPanel extends JPanel {
	private JLabel pizzaLabel;

	public FarmPanel() {
		this.setLayout(null);
		this.setSize(50,50);
		conversation();
	}

	public void conversation() {
		Image pizza = new ImageIcon("img/tomato/Pizza.png").getImage().getScaledInstance(50, 50, 0);
		ImageIcon pizzaicon = new ImageIcon(pizza);
		pizzaLabel = new JLabel(pizzaicon);
		pizzaLabel.setSize(50,50);
		this.add(pizzaLabel);
	}
}
