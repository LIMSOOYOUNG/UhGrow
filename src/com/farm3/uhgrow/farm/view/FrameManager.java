package com.farm3.uhgrow.farm.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameManager {
	
	private static JFrame frame = new MainFrame();
	
	public static JFrame getFrame() {
		return FrameManager.frame;
	}
	
	public static void initPanel(JFrame frame, JPanel panel) {
		if(FrameManager.frame == null) {
			FrameManager.frame = frame;
		}
		
		FrameManager.frame.add(panel);
		
		FrameManager.frame.setVisible(true);
		FrameManager.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void changePanel(JPanel oldPanel, JPanel newPanel) {
		frame.remove(oldPanel);
		frame.add(newPanel);
		frame.repaint();
		frame.revalidate();
	}
	
	public static void refresh() {
		frame.repaint();
		frame.revalidate();
	}
	
}
