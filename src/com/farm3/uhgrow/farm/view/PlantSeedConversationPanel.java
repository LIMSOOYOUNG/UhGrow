package com.farm3.uhgrow.farm.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlantSeedConversationPanel extends JPanel {
	
	private JLabel seedText;
	private JLabel conversationLabel;
	private JLabel endButton;
	private JPanel plantSeedConversationPanel;


	public PlantSeedConversationPanel() {
		plantSeedConversationPanel = this;
		
		this.setLayout(null);
		this.setBounds(110, 400, 758, 120);
		this.setVisible(true);
		this.add(askText());
		this.add(conversation());

	}
	
	public JLabel askText() {
		seedText = new JLabel();
		seedText.setLayout(null);
		seedText.setLocation(20, 10);
		seedText.setSize(700, 100);
		seedText.setText("무슨씨앗을 심으시겠습니까?");
		Font font = new Font("utf-8", Font.BOLD, 30);
		seedText.setFont(font);
		return seedText;
	}
	
	public JLabel conversation() {

		Image imgConversation = new ImageIcon("img/대화창.png").getImage().getScaledInstance(758, 120, 0);
		conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setSize(758, 120);
		return conversationLabel;
	}
	


	public JLabel endButton() {
		Image imgEndButton = new ImageIcon("img/대화 화살표.png").getImage().getScaledInstance(45, 30, 0);
		endButton = new JLabel(new ImageIcon(imgEndButton));
		endButton.setSize(45, 30);
		endButton.setLocation(700, 80);
		return endButton;

	}

}
