package com.farm3.uhgrow.farm.view;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.farm3.uhgrow.farm.controller.FarmController;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.member.view.FrameManager;

public class FarmPanel extends JPanel {
	private boolean isTrue = false;
	private boolean isNpcTrue = true;

	private JLabel seedText;
	private JLabel conversationLabel;
	private JLabel endButton;
	private JPanel farmPanel;
	private int i;
	private int fieldIndex;
	private RetainCropDTO cropDTO = new RetainCropDTO();
	private JButton[] selectButtons;
	JLabel backGround;
	JLabel mainNpc;
	JLabel storeNpc;
	JLabel storeBackGroundLabel;
	DefaultListModel defaultSeedList;
	List<RetainCropDTO> seedList;
	JList jSeedList;
	JLabel seedListLabel;
	JButton[] fieldButton = new JButton[10];
	FarmController farmcontroller = new FarmController();

	public FarmPanel() {
		farmPanel = this;

		fieldButton();

		this.setSize(960, 540);
		this.setLayout(null);

		this.add(askText());
		this.add(conversation());
		this.add(SeedList());
		this.add(storeNpc());
		this.add(mainNpc());
		this.setVisible(true);

		this.add(backGroundLabel());

	}

	public void fieldButton() {
		int x = 120;
		int y = 115;
		for (fieldIndex = 0; fieldIndex < fieldButton.length; fieldIndex++) {

			Image imgField = new ImageIcon("img/field.png").getImage().getScaledInstance(35, 30, 0);
			fieldButton[fieldIndex] = new JButton(new ImageIcon(imgField));
			fieldButton[fieldIndex].setSize(34, 30);
			fieldButton[fieldIndex].setLocation(x, y);
			if (x < 256) {
				x += 34;
			} else if (x == 256) {
				x = 120;
				y = 180;
			} else {
				x += 34;
			}
			this.add(fieldButton[fieldIndex]);
			fieldButton[fieldIndex].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					seedText.setVisible(true);
					conversationLabel.setVisible(true);
					jSeedList.setVisible(true);
					int x = 860;
					int y = 300;
					seedList = farmcontroller.selectSeed();
					if (seedList.size() > 0) {
						selectButtons = new JButton[seedList.size()];
						Image selectSeed = new ImageIcon("img/mngInterface/triangleButton.png").getImage()
								.getScaledInstance(20, 20, 0);

						defaultSeedList.removeAllElements();
						for (i = 0; i < seedList.size(); i++) {
							defaultSeedList.addElement(seedList.get(i).getCropName() + "씨앗	 "
									+ seedList.get(i).getCropAmount() + "개" + " " + ">");// 빈 모델
							// 리스트에
							// 값 대입
							selectButtons[i] = new JButton(new ImageIcon(selectSeed)); // 생성된 버튼에 이미지 삽입
							selectButtons[i].setLocation(x, y);
							selectButtons[i].setSize(24, 22); // 좌표와 크기 지정
							y += 34; // 버튼 세로 정렬을 위해 y축 값 증가
							farmPanel.add(selectButtons[i]); // 완성된 버튼 패널 추가

							selectButtons[i].addActionListener(new ActionListener() { // 버튼에 이벤트 추가
								private int index; // 버튼의 자체 인덱스를 저장하기 위해 변수 선언
								{
									this.index = i; // 자체 인덱스에 for문의 시작값 대입
								}

								@Override
								public void actionPerformed(ActionEvent e) {
									cropDTO.setCropId(seedList.get(index).getCropId());

									int result = farmcontroller.chooseInputSeed(cropDTO);
									if (result > 0) {
										FrameManager.refresh();
										switch (seedList.get(index).getCropId()) {
										case 1:
											JOptionPane.showMessageDialog(null,
											seedList.get(index).getCropName() + "씨앗을 심었습니다", "씨앗 심음 알림", 1);
											
											Image imgField = new ImageIcon("img/tomato/Tomato.png").getImage().getScaledInstance(35, 30, 0);
											System.out.println(fieldIndex);
											fieldButton[fieldIndex].setIcon(new ImageIcon(imgField));

											fieldButton[fieldIndex].setContentAreaFilled(false);
											seedText.setVisible(false);
											conversationLabel.setVisible(false);
											jSeedList.setVisible(false);
										
								
											
											break;
										case 2:

											break;
										case 3:

											break;
										case 4:

											break;

										default:
											break;
										}

									} else {
										JOptionPane.showMessageDialog(null, "씨앗심기를 실패하였습니다.", "씨앗 심음 알림", 1);
									}

								}
							});
						}
					} else {
						JOptionPane.showMessageDialog(null, "보유중인 씨앗이 없습니다.", "씨앗보유 여부", 1);
						seedText.setVisible(false);
						conversationLabel.setVisible(false);
						jSeedList.setVisible(false);
					}
				}
			});
		}
		fieldIndex=0;

	}

	public JLabel store() {
		Image storeBackGround = new ImageIcon("img/store/storeBackGround.png").getImage().getScaledInstance(800, 400,
				0);
		storeBackGroundLabel = new JLabel(new ImageIcon(storeBackGround));
		storeBackGroundLabel.setLocation(0, 0);
		storeBackGroundLabel.setSize(800, 400);
		return storeBackGroundLabel;
	}

	public JList SeedList() {
		defaultSeedList = new DefaultListModel();
		jSeedList = new JList(defaultSeedList);
		jSeedList.setBackground(Color.ORANGE);
		Font f2 = new Font("돋움", Font.BOLD, 20);
		jSeedList.setFont(f2);
		jSeedList.setLocation(675, 300);
		jSeedList.setSize(185, 100);
		jSeedList.setVisible(isTrue);
		jSeedList.isOpaque();
		return jSeedList;
	}

	public JLabel mainNpc() {
		Image imgMainNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(30, 50, 0);
		mainNpc = new JLabel(new ImageIcon(imgMainNpc));
		mainNpc.setLocation(570, 190);
		mainNpc.setSize(30, 50);
		return mainNpc;
	}

	public JLabel backGroundLabel() { // 회원가입
		Image imgbackground = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGround = new JLabel(new ImageIcon(imgbackground));
		backGround.setLocation(0, 0);
		backGround.setSize(960, 540);
		return backGround;
	}

	public JLabel storeNpc() {
		Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(30, 50, 0);
		storeNpc = new JLabel(new ImageIcon(imgStoreNpc));
		storeNpc.setLocation(750, 150);
		storeNpc.setSize(30, 50);

		return storeNpc;
	}

	public JLabel askText() {

		seedText = new JLabel();
		seedText.setLayout(null);
		seedText.setBounds(130, 410, 700, 100);
		seedText.setText("무슨씨앗을 심으시겠습니까?");
		Font font = new Font("utf-8", Font.BOLD, 30);
		seedText.setFont(font);

		seedText.setVisible(false);
		return seedText;
	}

	public JLabel conversation() {

		Image imgConversation = new ImageIcon("img/대화창.png").getImage().getScaledInstance(758, 120, 0);
		conversationLabel = new JLabel(new ImageIcon(imgConversation));
		conversationLabel.setBounds(110, 400, 758, 120);
		conversationLabel.setVisible(false);
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