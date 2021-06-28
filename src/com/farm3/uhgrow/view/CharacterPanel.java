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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class CharacterPanel extends JPanel {
	private int x = 100, y = 100;
	private Image character;

	public CharacterPanel() {
		
		this.setFocusable(true);
		character = Toolkit.getDefaultToolkit().getImage("img/mainCharacter/mainCharacter_front (1).png").getScaledInstance(100, 30, 0);
		
		addKeyListener(new KeyHandler());
	}

	public class KeyHandler implements KeyListener {

		/**
		 * keyPressed()���� �߻��� Ű�ڵ带 �Ʒ��� HashSet�� �����ϸ� Ÿ�̸� �̺�Ʈ �ڵ鷯���� Ű�ڵ带
		 * Ȯ���Ͽ� ȭ���� �����ϴ� �ڵ带 �����Ѵ� ���⼭ �÷��� �߿��� Set�� ������ ������ Ű�ڵ尡
		 * �ߺ��Ǿ� �����ϴ� ���� ���� Ű�� �� �� HashSet���� �ش� Ű�ڵ带 �Ѱ��� �������ָ� ���
		 * �̺�Ʈ ȿ���� ���ŵǹǷ� �̺�Ʈ�� ��� �����ϴ� ȿ���� �� �� �ִ�
		 */
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
									y -= 10;
								}
							} else if (n == KeyEvent.VK_DOWN) {
								if (y < 491) {
									y += 10;
								}
							} else if (n == KeyEvent.VK_LEFT) {
								if (x > 0) {
									x -= 10;
								}
							} else if (n == KeyEvent.VK_RIGHT) {
								if (x < 910) {
									x += 10;
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
		g.drawImage(character, x, y, 40, 40, this);

		this.repaint();

	}
}
