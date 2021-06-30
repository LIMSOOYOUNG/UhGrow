package com.farm3.uhgrow.farm.view;

import java.awt.Dialog;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BackGroundPanel extends JPanel {

	private int w = 960;
	private int h = 540;
	private JLabel mainNpc;
	private JButton storeNpc;

	public BackGroundPanel() {
		init();
		
		
	}
	

	private void init() {
		

		mainNpc();
		storeNpc();
		background();
		
		mainNpc.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new subFrame();

			}
		});
	}

	public void background() {
		

	}

	public void mainNpc() {
		
		

	}

	public void storeNpc() {

	}

}
