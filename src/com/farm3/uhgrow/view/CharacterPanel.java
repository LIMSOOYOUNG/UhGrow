package com.farm3.uhgrow.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.Timer;

public class CharacterPanel extends JPanel {
	private int x = 150, y = 250;
	private Image character;

	public CharacterPanel() {
		this.setBounds(0, 0, 960, 540);

		this.setFocusable(true);
		character = Toolkit.getDefaultToolkit().getImage("img/mainCharacter/mainCharacter_front (1).png");

		addKeyListener(new KeyHandler());

	}

	public class KeyHandler implements KeyListener {

		HashSet<Integer> pressedKeys = new HashSet<Integer>();
		Timer timer;

		public KeyHandler() {
			timer = new Timer(50, new ActionListener() { // 50ms���� �׼� �̺�Ʈ �߻�
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (!pressedKeys.isEmpty()) {
						Iterator<Integer> i = pressedKeys.iterator();
						int n = 0;
						while (i.hasNext()) {
							n = i.next();
							if (n == KeyEvent.VK_UP) {
								if (y > 0) {
									y -= 8;
								}
							} else if (n == KeyEvent.VK_DOWN) {
								if (y < 478) {
									y += 8;
								}
							} else if (n == KeyEvent.VK_LEFT) {
								if (x > 0) {
									x -= 8;
								}
							} else if (n == KeyEvent.VK_RIGHT) {
								if (x < 920) {
									x += 8;
								}
							}
							repaint();
						}
					} else {
						timer.stop();
					}
				}
			});
		}

		@Override
		public void keyPressed(KeyEvent keyEvent) {
			// �߻��� Ű�ڵ带 HsshSet�� �����Ѵ�
			int keyCode = keyEvent.getKeyCode();
			pressedKeys.add(keyCode);
			if (!timer.isRunning())
				timer.start();
		}

		@Override
		public void keyReleased(KeyEvent keyEvent) {
			// HashSet���� Ű�ڵ带 �����Ѵ�
			int keyCode = keyEvent.getKeyCode();
			pressedKeys.remove(keyCode);
		}

		@Override
		public void keyTyped(KeyEvent keyEvent) {
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new javax.swing.ImageIcon("img/backGround1.png").getImage(), 0, 0, this);
		g.drawImage(new javax.swing.ImageIcon("img/storeNPC.png").getImage(),750 , 170, 35, 50,this);
		g.drawImage(new javax.swing.ImageIcon("img/mainNPC.png").getImage(),570 , 190, 35, 50,this);
		g.drawImage(new javax.swing.ImageIcon("img/pumpkin/Pumpkin.png").getImage(),150 , 150, 20, 20,this);
		g.drawImage(character, x, y, 30, 50, this);

		this.repaint();

	}
}
