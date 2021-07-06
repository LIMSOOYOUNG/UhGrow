package com.farm3.uhgrow.farm.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.farm3.uhgrow.farm.controller.FarmController;
import com.farm3.uhgrow.farm.model.dto.FarmCropDTO;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.dto.UserInfoDTO;
import com.farm3.uhgrow.member.store.BuyHouseAndCookPanel;
import com.farm3.uhgrow.member.store.MainStorePanel;
import com.farm3.uhgrow.member.view.FrameManager;

public class TutorialPanel extends JPanel {
	private int userNo;
	private int i;
	private FarmCropDTO farmCropDTO = new FarmCropDTO();
	private JLabel tomato;
	private JLabel tomatoSeed;
	private TutorialPanel tutorialPanel;
	private FarmPanel farmPanel;
	private Font font = new Font("굴림체", Font.BOLD, 30);
	private Font font1 = new Font("굵은 고딕", Font.BOLD, 50);
	private JLabel[] btnNextStory = new JLabel[8];
	private JButton btnRock;
	private JButton btnRock1;
	private JButton btnRock2;
	private JButton btnRock3;
	private int CrashRock1Exp = 3;
	private int CrashRock2Exp = 5;
	private int CrashRock3Exp = 7;
	private int CrashRock4Exp = 9;
	private int crashExp = 1;
	private FarmController farmController = new FarmController();

	public TutorialPanel(int userNo) {
		this.userNo = userNo;
		tutorialPanel = this;
		this.setLayout(null);
		this.setSize(960, 540);

		rockButton();
		rockButton2();
		rockButton3();
		rockButton4();
		farmCropDTO.setUserNo(this.userNo);

		firstTutorialPanel();

	}

	public void firstTutorialPanel() {
		JLabel[] textLabel = new JLabel[6];

		rockButton();
		rockButton();
		JLabel firstTextLabel = new JLabel("부모님의 사업이 망하고..");
		firstTextLabel.setBounds(120, 50, 680, 100);
		firstTextLabel.setFont(font);
		firstTextLabel.setVisible(true);
		this.add(firstTextLabel);

		textLabel[0] = new JLabel("난 아무것도 가진것이 없었다.");
		textLabel[0].setBounds(120, 100, 680, 100);
		textLabel[0].setFont(font);
		textLabel[0].setVisible(false);
		this.add(textLabel[0]);

		textLabel[1] = new JLabel("나는 이대로 가만히 있을 수 없었다.");
		textLabel[1].setBounds(120, 200, 680, 100);
		textLabel[1].setFont(font);
		textLabel[1].setVisible(false);
		this.add(textLabel[1]);

		textLabel[2] = new JLabel("우리 가족을 위해서..");
		textLabel[2].setBounds(120, 250, 680, 100);
		textLabel[2].setFont(font);
		textLabel[2].setVisible(false);
		this.add(textLabel[2]);

		textLabel[3] = new JLabel("집을 사기 위해 돈을 버리라!");
		textLabel[3].setBounds(120, 300, 680, 100);
		textLabel[3].setFont(font);
		textLabel[3].setVisible(false);
		this.add(textLabel[3]);

		textLabel[4] = new JLabel("그래서 난...");
		textLabel[4].setBounds(120, 350, 680, 100);
		textLabel[4].setFont(font);
		textLabel[4].setVisible(false);
		this.add(textLabel[4]);

		textLabel[5] = new JLabel("귀농을 선택했다!");
		textLabel[5].setBounds(120, 400, 680, 100);
		textLabel[5].setFont(font1);
		textLabel[5].setForeground(Color.green);
		textLabel[5].setVisible(false);
		this.add(textLabel[5]);

		Image imgbtnNextStory = new ImageIcon("img/btnNext.png").getImage().getScaledInstance(40, 30, 0);
		for (int i = 0; i < 7; i++) {
			btnNextStory[i] = new JLabel(new ImageIcon(imgbtnNextStory));
			btnNextStory[i].setBounds(680, 450, 40, 30);
			btnNextStory[i].setVisible(false);

			this.add(btnNextStory[i]);
		}
		btnNextStory[7] = new JLabel(new ImageIcon(imgbtnNextStory));
		btnNextStory[7].setBounds(680, 470, 40, 30);
		btnNextStory[7].setVisible(false);
		this.add(btnNextStory[7]);

		JLabel tutorialLabel = new JLabel("밭을 먼저 가는게 좋을게야..");
		tutorialLabel.setBounds(120, 400, 680, 100);
		tutorialLabel.setFont(font);
		tutorialLabel.setVisible(false);
		this.add(tutorialLabel);

		Image imgMainCharacter = new ImageIcon("img/mainCharacter/mainCharacter_front (1).png").getImage()
				.getScaledInstance(90, 150, 0);
		JLabel mainCharacter = new JLabel(new ImageIcon(imgMainCharacter));
		mainCharacter.setBounds(750, 340, 90, 150);
		this.add(mainCharacter);

		Image imgStory = new ImageIcon("img/store/storeconversation1.png").getImage().getScaledInstance(790, 450, 0);
		JLabel storyLabel = new JLabel(new ImageIcon(imgStory));
		storyLabel.setBounds(100, 60, 790, 440);
		this.add(storyLabel);

		Image imgStoreNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(90, 150, 0);
		JLabel storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setBounds(750, 350, 90, 150);
		storeNpc.setVisible(false);
		this.add(storeNpc);

		Image imgConversation = new ImageIcon("img/store/storeconversation1.png").getImage().getScaledInstance(758, 120,
				0);
		JLabel conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setBounds(100, 400, 760, 118);
		conversationLabel.setVisible(false);
		this.add(conversationLabel);

		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);
		this.setVisible(true);
		this.add(backGroundLabel);

		btnNextStory[0].setVisible(true);
		btnNextStory[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textLabel[0].setVisible(true);
				btnNextStory[0].setVisible(false);
				btnNextStory[1].setVisible(true);
			}
		});

		btnNextStory[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textLabel[1].setVisible(true);
				btnNextStory[1].setVisible(false);
				btnNextStory[2].setVisible(true);
			}
		});
		btnNextStory[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textLabel[2].setVisible(true);
				btnNextStory[2].setVisible(false);
				btnNextStory[3].setVisible(true);
			}
		});
		btnNextStory[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textLabel[3].setVisible(true);
				btnNextStory[3].setVisible(false);
				btnNextStory[4].setVisible(true);
			}
		});
		btnNextStory[4].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textLabel[4].setVisible(true);
				btnNextStory[4].setVisible(false);
				btnNextStory[5].setVisible(true);
			}
		});
		btnNextStory[5].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textLabel[5].setVisible(true);
				btnNextStory[5].setVisible(false);
				btnNextStory[6].setVisible(true);
			}
		});
		btnNextStory[6].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < 6; i++) {
					firstTextLabel.setVisible(false);
					textLabel[i].setVisible(false);
					btnNextStory[i].setVisible(false);
					storyLabel.setVisible(false);
					mainCharacter.setVisible(false);
					btnNextStory[6].setVisible(false);
					btnNextStory[7].setVisible(true);
					conversationLabel.setVisible(true);
					storeNpc.setVisible(true);
					tutorialLabel.setVisible(true);
				}
			}
		});
		btnNextStory[7].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < 6; i++) {

					btnNextStory[7].setVisible(false);
					conversationLabel.setVisible(false);
					storeNpc.setVisible(false);
					tutorialLabel.setVisible(false);
					btnRock.setVisible(true);
				}
			}
		});
	}

	public void rockButton() {
		int x = 120;
		int y = 110;
		Image imgRock = new ImageIcon("img/btnRock.png").getImage().getScaledInstance(40, 40, 0);
		btnRock = new JButton(new ImageIcon(imgRock));
		btnRock.setSize(40, 40);
		btnRock.setLocation(x, y);
		btnRock.setVisible(false);

		this.add(btnRock);

		btnRock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CrashRock1Exp -= crashExp;
				if (CrashRock1Exp == 0) {
					btnRock.setVisible(false);
					btnRock1.setVisible(true);

				}
			}
		});
	}

	public void rockButton2() {
		int x = 180;
		int y = 110;
		Image imgRock = new ImageIcon("img/btnRock.png").getImage().getScaledInstance(40, 40, 0);
		btnRock1 = new JButton(new ImageIcon(imgRock));
		btnRock1.setSize(40, 40);
		btnRock1.setLocation(x, y);
		btnRock1.setVisible(false);

		this.add(btnRock1);

		btnRock1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CrashRock2Exp -= crashExp;
				if (CrashRock2Exp == 0) {
					btnRock1.setVisible(false);
					btnRock2.setVisible(true);
				}
			}
		});
	}

	public void rockButton3() {
		int x = 220;
		int y = 110;
		Image imgRock = new ImageIcon("img/btnRock.png").getImage().getScaledInstance(40, 40, 0);
		btnRock2 = new JButton(new ImageIcon(imgRock));
		btnRock2.setSize(40, 40);
		btnRock2.setLocation(x, y);
		btnRock2.setVisible(false);

		this.add(btnRock2);

		btnRock2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CrashRock3Exp -= crashExp;
				if (CrashRock3Exp == 0) {
					btnRock2.setVisible(false);
					btnRock3.setVisible(true);
				}
			}
		});
	}

	public void rockButton4() {
		int x = 160;
		int y = 175;
		Image imgRock = new ImageIcon("img/btnRock.png").getImage().getScaledInstance(40, 40, 0);
		btnRock3 = new JButton(new ImageIcon(imgRock));
		btnRock3.setSize(40, 40);
		btnRock3.setLocation(x, y);
		btnRock3.setVisible(false);

		this.add(btnRock3);

		btnRock3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CrashRock4Exp -= crashExp;
				if (CrashRock4Exp == 0) {
					btnRock3.setVisible(false);
					int result = farmController.updateContinueYN(userNo);
					if (result > 0) {
						farmPanel = new FarmPanel(userNo);
						FrameManager.changePanel(tutorialPanel,farmPanel);
						
					}
				}
			}
		});
		
	}

}
