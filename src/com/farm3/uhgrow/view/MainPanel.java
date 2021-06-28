package com.farm3.uhgrow.view;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.event.*;
import java.util.*;

public class MainPanel extends JPanel{
	

	public MainPanel(){
		this.setBounds(0,0,960,540);
		Image backGround = new ImageIcon("img/background1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(backGround));
		
		this.add(backGroundLabel);
	}
	
	
	 
}
