package com.farm3.uhgrow.member.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameManager {

	private static JFrame frame = new MainFrame();
//	private static JFrame frame = new StoreFrame();

	public static void changePanel(JPanel oldPanel, JPanel newPanel) {
		frame.remove(oldPanel);
		frame.add(newPanel);
		frame.repaint();
		frame.revalidate();
	}
	
	public static void addPanel(JPanel oldPanel,JPanel newPanel) {
		frame.removeAll();
		frame.add(newPanel);
		frame.add(oldPanel);
		frame.repaint();
		frame.revalidate();
	}
	
	public static void removePanel(JPanel oldPanel) {
		frame.remove(oldPanel);
		frame.repaint();
		frame.revalidate();
	}

	public static void refresh() {
		frame.revalidate();
		frame.repaint();
	}
	
	public static void panelRefresh(JPanel panel) {
		panel.revalidate();
		panel.repaint();
	}
	public static JFrame getInstance() {
		return frame;
	}
	
}


