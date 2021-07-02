package com.farm3.uhgrow.member.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameManager {

	private static JFrame frame = new LoginFrame();

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
	
	public static JFrame getInstance() {
		return frame;
	}
}


