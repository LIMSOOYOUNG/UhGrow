package com.farm3.uhgrow.member.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EndingPanel extends JPanel {

	public EndingPanel() {
		this.setLayout(null);
		this.setSize(960,540);
		/* ---------- 배경화면 라벨  ------------*/
		Image ending = new ImageIcon("img/ending.png").getImage().getScaledInstance(960, 540, 0);
		JLabel endingLabel = new JLabel(new ImageIcon(ending));
		endingLabel.setLocation(0, 0);
		endingLabel.setSize(960, 540);
		
		this.add(endingLabel);
		
		
		endingLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "게임을 이용해주셔서 감사합니다.","게임 엔딩",1);
				System.exit(0);
			}
		});

	}
}
