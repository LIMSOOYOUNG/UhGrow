package com.farm3.uhgrow.farm.view;

import java.awt.Dialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BackGroundPanel extends JPanel {

	private int w = 960;
	private int h = 540;
	private JButton mainNpc;
	private JButton storeNpc;
	private JButton pizzaPanel;

	public BackGroundPanel() {
		init();
	}

	private void init() {
		this.setLayout(null);
		this.setSize(w, h);


		conversation();
		mainNpc();
		storeNpc();
		background();

		mainNpc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				pizzaPanel.setVisible(true);

			}
		});

	}

	private void conversation() {
		Image pizza = new ImageIcon("img/tomato/Pizza.png").getImage().getScaledInstance(50, 50, 0);
		ImageIcon pizzaicon = new ImageIcon(pizza);
		pizzaPanel = new JButton(pizzaicon);
		pizzaPanel.setBounds(300, 300, 50, 50);
		this.add(pizzaPanel);
		
		pizzaPanel.setVisible(false);
	}

	public void background() {
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel imgLabel = new JLabel(new ImageIcon(background));
		imgLabel.setLocation(0, 0);
		imgLabel.setSize(960, 540);
		this.add(imgLabel);

	}

	public void mainNpc() {
		Image imgMainNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(30, 50, 0);
		ImageIcon imgMainNpcIcon = new ImageIcon(imgMainNpc);
		mainNpc = new JButton(imgMainNpcIcon);
		mainNpc.setLocation(570, 190);
		mainNpc.setSize(30, 50);

		this.add(mainNpc);

	}

	public void storeNpc() {

		Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(30, 50, 0);
		ImageIcon imgStoreNpcIcon = new ImageIcon(imgStoreNpc);
		storeNpc = new JButton(imgStoreNpcIcon);
		storeNpc.setLocation(750, 150);
		storeNpc.setSize(30, 50);

		this.add(storeNpc);

	}

}
