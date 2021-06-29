package com.farm3.uhgrow.farm.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CharacterPanel extends JPanel {
	private int x = 400;
	private int y = 200;
	private int width = 30;
	private int height = 50;
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
			timer = new Timer(30, new ActionListener() { // 50ms���� �׼� �̺�Ʈ �߻�
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (!pressedKeys.isEmpty()) {
						Iterator<Integer> i = pressedKeys.iterator();
						int n = 0;
						while (i.hasNext()) {
							n = i.next();
							if (n == KeyEvent.VK_UP) {
								if (y > 0) {
									y -= 5;
								}
							} else if (n == KeyEvent.VK_DOWN) {
								if (y < 478) {
									y += 5;
								}
							} else if (n == KeyEvent.VK_LEFT) {
								if (x > 0) {
									x -= 5;
								}
							} else if (n == KeyEvent.VK_RIGHT) {
								if (x < 920) {
									x += 5;
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
		g.drawImage(new javax.swing.ImageIcon("img/interface/backGround1.png").getImage(), 0, 0, this);
		g.drawImage(new javax.swing.ImageIcon("img/interface/storeNPC.png").getImage(),750 , 170, 35, 50,this);
		g.drawImage(new javax.swing.ImageIcon("img/interface/mainNPC.png").getImage(),570 , 190, 35, 50,this);
		g.drawImage(new javax.swing.ImageIcon("img/pumpkin/Pumpkin_Stage_3.png").getImage(),120 , 100, 30, 40,this);
		g.drawImage(new javax.swing.ImageIcon("img/animal/Crow.png").getImage(),755 , 145, 30, 30,this);
		g.drawImage(character, x, y, width, height, this);

		this.repaint();

	}
	
	
}