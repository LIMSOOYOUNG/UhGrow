package com.farm3.uhgrow.sellcrops.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SellCropPanel {
	
	public void sellCropList() {
		
		
		JPanel sellCropList = new JPanel();
		
		sellCropList.setLayout(null);
		sellCropList.setSize(960, 540);
		
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(960, 540, 0);
		JLabel storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		
		JButton tomatoButton = new JButton("토마토");
		tomatoButton.setLocation(292, 128);
		tomatoButton.setSize(13, 13);
		
		
		JButton cornButton = new JButton("옥수수");
		cornButton.setLocation(295, 222);
		cornButton.setSize(13, 13);
		
		JButton galicButton = new JButton("마늘");
		galicButton.setLocation(298, 355);
		galicButton.setSize(13, 13);
		
		JButton pumpkinButton = new JButton("호박");
		pumpkinButton.setLocation(300, 215);
		pumpkinButton.setSize(13,13);
		
		tomatoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		cornButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		galicButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		pumpkinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		sellCropList.add(tomatoButton);
		sellCropList.add(cornButton);
		sellCropList.add(galicButton);
		sellCropList.add(pumpkinButton);
		sellCropList.add(storeBackGroundLabel);
		
		
		
	}
	
	
}
