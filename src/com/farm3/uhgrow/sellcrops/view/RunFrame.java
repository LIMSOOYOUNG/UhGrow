package com.farm3.uhgrow.sellcrops.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RunFrame {
	
	
	public static void main(String[] args) {
		

		JFrame jf = new JFrame();
		jf.setBounds(300, 200, 960, 540);
		
		JPanel storePanel = new JPanel();
		storePanel.setLayout(null);
		storePanel.setLocation(960, 540);
		
		
		
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(960, 540, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(960, 540);
		
		Image buyImage = new ImageIcon("img/store/buybutton.png").getImage().getScaledInstance(200, 50, 0);
		JButton buyButton = new JButton(new ImageIcon(buyImage));
		buyButton.setLocation(46, 43);
		buyButton.setSize(200, 50);
		
		Image sellImage = new ImageIcon("img/store/sellButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton sellButton = new JButton(new ImageIcon(sellImage));
		sellButton.setLocation(276, 43);
		sellButton.setSize(200, 50);
		
		Image quitImage = new ImageIcon("img/store/quitButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton quitButton = new JButton(new ImageIcon(quitImage));
		quitButton.setLocation(505, 43);
		quitButton.setSize(200, 50);
		

		storePanel.add(buyButton);
		storePanel.add(sellButton);
		storePanel.add(quitButton);
		storePanel.add(storeBackGroundLabel);

		
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("구매창 이동");
			}
		});
		
		sellButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				buyButton.setVisible(false);
				sellButton.setVisible(false);
				quitButton.setVisible(false);
				
				Image mainPageImage = new ImageIcon("img/store/mainPageTest.png").getImage().getScaledInstance(960, 540, 0);
				storeBackGroundLabel.setIcon(new ImageIcon(mainPageImage));
				
				
			}
		});
		
		jf.add(storePanel);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
