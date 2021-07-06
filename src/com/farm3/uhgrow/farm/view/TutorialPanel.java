package com.farm3.uhgrow.farm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.farm3.uhgrow.farm.controller.FarmController;
import com.farm3.uhgrow.farm.model.dto.FarmCropDTO;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.dto.UserInfoDTO;
import com.farm3.uhgrow.member.store.BuyHouseAndCookPanel;
import com.farm3.uhgrow.member.store.MainStorePanel;
import com.farm3.uhgrow.member.view.FrameManager;
import com.farm3.uhgrow.sellcrops.view.SellMainPanel;

public class TutorialPanel extends JPanel{
		private int userNo;
		private int fieldNo;
		private JLabel seedText;
		private JLabel conversationLabel;
		private JLabel endButton;
		private JPanel farmPanel;
		private int i;
		
		private JButton[] selectButtons;
		private int fieldIndex;
		private int[] farmArray;
		private JLabel backGround;
		private JLabel mainNpc;
		private JLabel storeNpc;
		private JLabel tomato;
		private JLabel tomatoSeed;
		
		private JTextArea tomatoSeedAmount;
		private JTextArea tomatoAmount;
		private JTextArea cornSeedAmount;
		private JTextArea cornAmount;
		private JTextArea garlicSeedAmount;
		private JTextArea garlicAmount;
		private JTextArea pumpkinSeedAmount;
		private JTextArea pumpkinAmount;
		private JButton btnStoreNpc;
		private JButton btnMainNpc;
		private JButton btnGoBack;
		private DefaultListModel defaultSeedList;
		private List<RetainCropDTO> inventoryCropList;
		private List<RetainCropDTO> retainCropList;
		private List<RetainCropDTO> retainAllList;
		private JList jSeedList;
		private JLabel seedListLabel;
		private JButton[] fieldButton = new JButton[10];
		private int createCrop;
		private JLabel[] inventoryLabel = new JLabel[13];
		private int farmExp = 0;
		private int[] tomatoSumExp = new int[10];
		private int[] cornSumExp = new int[10];
		private int[] garlicSumExp = new int[10];
		private int[] pumpkinSumExp = new int[10];
		private Font font = new Font("amountfont", Font.BOLD | Font.ITALIC, 10);

		public TutorialPanel(int userNo) {
			
			this.userNo = userNo;
			farmPanel = this;
			farmCropDTO.setUserNo(this.userNo);
			farmcontroller.resetFarmList(userNo);
			farmExp = farmcontroller.selectFarmExp(this.userNo);
			retainAllList = farmcontroller.selectAllCrop(farmCropDTO);
			
			if ( retainAllList == null) {
				createCrop = farmcontroller.createCrop(this.userNo);
			}
			fieldButton();

			this.setSize(960, 540);
			this.setLayout(null);
			this.add(btnGoBack());
			this.add(askText());
			this.add(conversation());
			this.add(SeedList());
			toolLabel();
			inventoryLabel();
			this.add(btnStoreNpc());
			this.add(storeNpc());
			this.add(btnMainNpc());
			this.add(mainNpc());
			this.setVisible(true);

			this.add(backGroundLabel());

		}

		

		public void inventoryLabel() {

			inventoryCropList = farmcontroller.inventoryCrop(userNo);
//				inventoryToolList = 
			System.out.println(inventoryCropList);
			for (int i = 0; i < inventoryCropList.size(); i++) {
				switch (inventoryCropList.get(i).getCropId()) {
				case 1:
					Image imgTomato = new ImageIcon("img/tomato/Tomato.png").getImage().getScaledInstance(25, 25, 0);
					tomato = new JLabel(new ImageIcon(imgTomato));
					tomato.setLocation(420, 500);
					tomato.setSize(25, 25);
					tomato.setVisible(true);
					tomatoAmount = new JTextArea(String.valueOf(inventoryCropList.get(i).getCropAmount()));
					tomatoAmount.setBounds(436, 490, 15, 15);
					tomatoAmount.setOpaque(false);
					tomatoAmount.setFont(font);

					farmPanel.add(tomatoAmount);
					farmPanel.add(tomato);
					break;
				case 2:
					Image imgCorn = new ImageIcon("img/corn/Corn.png").getImage().getScaledInstance(25, 25, 0);
					corn = new JLabel(new ImageIcon(imgCorn));
					corn.setLocation(452, 498);
					corn.setSize(25, 25);
					corn.setVisible(true);
					cornAmount = new JTextArea(String.valueOf(inventoryCropList.get(i).getCropAmount()));
					cornAmount.setBounds(468, 490, 15, 15);
					cornAmount.setOpaque(false);
					cornAmount.setFont(font);

					farmPanel.add(cornAmount);
					farmPanel.add(corn);
					break;
				case 3:
					Image imgGarlic = new ImageIcon("img/garlic/Garlic.png").getImage().getScaledInstance(25, 25, 0);
					garlic = new JLabel(new ImageIcon(imgGarlic));
					garlic.setLocation(484, 500);
					garlic.setSize(25, 25);
					garlic.setVisible(true);
					garlicAmount = new JTextArea(String.valueOf(inventoryCropList.get(i).getCropAmount()));
					garlicAmount.setBounds(500, 490, 15, 15);
					garlicAmount.setOpaque(false);
					garlicAmount.setFont(font);

					farmPanel.add(garlicAmount);
					farmPanel.add(garlic);
					break;
				case 4:
					Image imgPumpkin = new ImageIcon("img/pumpkin/Pumpkin.png").getImage().getScaledInstance(25, 25, 0);
					pumpkin = new JLabel(new ImageIcon(imgPumpkin));
					pumpkin.setLocation(516, 498);
					pumpkin.setSize(25, 25);
					pumpkin.setVisible(true);
					pumpkinAmount = new JTextArea(String.valueOf(inventoryCropList.get(i).getCropAmount()));
					pumpkinAmount.setBounds(532, 490, 15, 15);
					pumpkinAmount.setOpaque(false);
					pumpkinAmount.setFont(font);

					farmPanel.add(pumpkinAmount);
					farmPanel.add(pumpkin);
					break;
				case 5:
					Image imgTomatoSeed = new ImageIcon("img/tomato/Tomato_Seeds.png").getImage().getScaledInstance(25, 25,
							0);
					tomatoSeed = new JLabel(new ImageIcon(imgTomatoSeed));
					tomatoSeed.setLocation(292, 500);
					tomatoSeed.setSize(25, 25);
					tomatoSeed.setVisible(true);
					tomatoSeedAmount = new JTextArea(String.valueOf(inventoryCropList.get(i).getCropAmount()));
					tomatoSeedAmount.setBounds(308, 490, 15, 15);
					tomatoSeedAmount.setOpaque(false);
					tomatoSeedAmount.setFont(font);

					farmPanel.add(tomatoSeedAmount);
					farmPanel.add(tomatoSeed);
					break;
				case 6:
					Image imgCornSeed = new ImageIcon("img/corn/Corn_Seeds.png").getImage().getScaledInstance(25, 25, 0);
					cornSeed = new JLabel(new ImageIcon(imgCornSeed));
					cornSeed.setLocation(323, 500);
					cornSeed.setSize(25, 25);
					cornSeed.setVisible(true);
					cornSeedAmount = new JTextArea(String.valueOf(inventoryCropList.get(i).getCropAmount()));
					cornSeedAmount.setBounds(339, 490, 15, 15);
					cornSeedAmount.setOpaque(false);
					cornSeedAmount.setFont(font);

					farmPanel.add(cornSeedAmount);
					farmPanel.add(cornSeed);
					break;
				case 7:
					Image imgGarlicSeed = new ImageIcon("img/garlic/Garlic_Seeds.png").getImage().getScaledInstance(25, 25,
							0);
					garlicSeed = new JLabel(new ImageIcon(imgGarlicSeed));
					garlicSeed.setLocation(356, 500);
					garlicSeed.setSize(25, 25);
					garlicSeed.setVisible(true);
					garlicSeedAmount = new JTextArea(String.valueOf(inventoryCropList.get(i).getCropAmount()));
					garlicSeedAmount.setBounds(372, 490, 15, 15);
					garlicSeedAmount.setOpaque(false);
					garlicSeedAmount.setFont(font);

					farmPanel.add(garlicSeedAmount);
					farmPanel.add(garlicSeed);
					break;
				case 8:
					Image imgPumpkinSeed = new ImageIcon("img/pumpkin/Pumpkin_Seeds.png").getImage().getScaledInstance(25,
							25, 0);
					pumpkinSeed = new JLabel(new ImageIcon(imgPumpkinSeed));
					pumpkinSeed.setLocation(388, 500);
					pumpkinSeed.setSize(25, 25);
					pumpkinSeed.setVisible(true);
					pumpkinSeedAmount = new JTextArea(String.valueOf(inventoryCropList.get(i).getCropAmount()));
					pumpkinSeedAmount.setBounds(404, 490, 15, 15);
					pumpkinSeedAmount.setOpaque(false);
					pumpkinSeedAmount.setFont(font);

					farmPanel.add(pumpkinSeedAmount);
					farmPanel.add(pumpkinSeed);
					break;

				default:
					break;
				}
			}

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
			}
			/* 버튼 인덱스에 따라서 누를때 발생하는 이벤트 */
			fieldButton[0].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					FrameManager.panelRefresh(farmPanel);
					/*--------------버튼 값이 있을경우-------------*/
					int fieldArrIndex = 0; // 누른 배열의 인덱스 값
					switch (fieldArr[fieldArrIndex]) {
					case 5:
						tomatoSumExp[fieldArrIndex] += farmExp;
						if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_1.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_2.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_3.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_4.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/tomato/Tomato.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 1);
						}
						break;
					case 6:
						cornSumExp[fieldArrIndex] += farmExp;
						if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage_2.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage_3.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage_4.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/corn/Corn.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 2);
						}
						break;
					case 7:
						garlicSumExp[fieldArrIndex] += farmExp;
						if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_1.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_2.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_3.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_4.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/garlic/garlic.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 3);
						}
						break;
					case 8:
						pumpkinSumExp[fieldArrIndex] += farmExp;
						if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_1.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_2.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_3.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_4.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 4);
						}
						break;
					case 0:
						conversationSetVisible(true);
						int x = 860;
						int y = 300;
						retainCropList = farmcontroller.selectSeed(farmCropDTO);
						if (retainCropList != null) {
							selectButtons = new JButton[retainCropList.size()];
							Image selectSeed = new ImageIcon("img/mngInterface/triangleButton.png").getImage()
									.getScaledInstance(25, 25, 0);

							defaultSeedList.removeAllElements();
							for (i = 0; i < retainCropList.size(); i++) {
								defaultSeedList.addElement(retainCropList.get(i).getCropName() + ""
										+ retainCropList.get(i).getCropAmount() + "개" + " " + ">");// 빈 모델

								selectButtons[i] = new JButton(new ImageIcon(selectSeed)); // 생성된 버튼에 이미지 삽입
								selectButtons[i].setLocation(x, y);
								selectButtons[i].setSize(20, 20); // 좌표와 크기 지정
								y += 25; // 버튼 세로 정렬을 위해 y축 값 증가
								selectButtons[i].setVisible(true);
								farmPanel.add(selectButtons[i]); // 완성된 버튼 패널 추가
								FrameManager.refresh();
								selectButtons[i].addActionListener(new ActionListener() { // 버튼에 이벤트 추가
									private int index; // 버튼의 자체 인덱스를 저장하기 위해 변수 선언
									{
										this.index = i; // 자체 인덱스에 for문의 시작값 대입
									}

									@Override
									public void actionPerformed(ActionEvent e) {
										retainCropDTO.setCropId(retainCropList.get(index).getCropId());
										System.out.println(retainCropList.get(index).getCropId());
										int result = farmcontroller.chooseInputSeed(retainCropDTO);
										int imgindex = 0;
										FarmController farmController = new FarmController();
										if (result > 0) {
											switch (retainCropList.get(index).getCropId()) {
											case 5:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/tomato/Tomato_Stage_1.png");
												new FarmCropDTO(1, userNo, retainCropList.get(index).getCropId(), 200);
												farmController.fieldInputSeed(farmCropDTO);
												fieldArr[imgindex] = 5;
												tomatoSumExp[imgindex] = 0;

												break;
											case 6:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/corn/Corn_Stage.png");
												new FarmCropDTO(1, userNo, retainCropList.get(index).getCropId(), 300);
												farmController.fieldInputSeed(farmCropDTO);

												fieldArr[imgindex] = 6;

												cornSumExp[imgindex] = 0;

												break;
											case 7:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/garlic/Garlic_Stage_1.png");
												new FarmCropDTO(1, userNo, retainCropList.get(index).getCropId(), 400);
												farmController.fieldInputSeed(farmCropDTO);

												fieldArr[imgindex] = 7;
												garlicSumExp[imgindex] = 0;

												break;
											case 8:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/pumpkin/Pumpkin_Stage_1.png");
												new FarmCropDTO(1, userNo, retainCropList.get(index).getCropId(), 500);
												farmController.fieldInputSeed(farmCropDTO);

												fieldArr[imgindex] = 8;
												pumpkinSumExp[imgindex] = 0;

												break;

											default:
												break;
											}
										} else {
											JOptionPane.showMessageDialog(farmPanel, "씨앗심기를 실패하였습니다.", "씨앗 심음 알림", 1);
										}
									}
								});
							}
						} else {
							seedText.setVisible(false);
							conversationLabel.setVisible(false);
							jSeedList.setVisible(false);

							JOptionPane.showMessageDialog(null, "보유중인 씨앗이 없습니다.", "씨앗보유 여부", 0);
						}
						break;
					}

				}
			});

			fieldButton[1].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					FrameManager.panelRefresh(farmPanel);
					/*--------------버튼 값이 있을경우-------------*/
					int fieldArrIndex = 1; // 누른 배열의 인덱스 값
					switch (fieldArr[fieldArrIndex]) {
					case 5:
						tomatoSumExp[fieldArrIndex] += farmExp;
						if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_1.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_2.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_3.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_4.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/tomato/Tomato.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 1);
						}
						break;
					case 6:
						cornSumExp[fieldArrIndex] += farmExp;
						if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage_2.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage_3.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage_4.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/corn/Corn.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 2);
						}
						break;
					case 7:
						garlicSumExp[fieldArrIndex] += farmExp;
						if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_1.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_2.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_3.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_4.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/garlic/garlic.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 3);
						}
						break;
					case 8:
						pumpkinSumExp[fieldArrIndex] += farmExp;
						if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_1.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_2.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_3.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_4.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 4);
						}
						break;
					case 0:
						conversationSetVisible(true);
						int x = 860;
						int y = 300;
						retainCropList = farmcontroller.selectSeed(farmCropDTO);
						if (retainCropList != null) {
							selectButtons = new JButton[retainCropList.size()];
							Image selectSeed = new ImageIcon("img/mngInterface/triangleButton.png").getImage()
									.getScaledInstance(25, 25, 0);

							defaultSeedList.removeAllElements();
							for (i = 0; i < retainCropList.size(); i++) {
								defaultSeedList.addElement(retainCropList.get(i).getCropName() + ""
										+ retainCropList.get(i).getCropAmount() + "개" + " " + ">");// 빈 모델

								selectButtons[i] = new JButton(new ImageIcon(selectSeed)); // 생성된 버튼에 이미지 삽입
								selectButtons[i].setLocation(x, y);
								selectButtons[i].setSize(20, 20); // 좌표와 크기 지정
								y += 25; // 버튼 세로 정렬을 위해 y축 값 증가
								selectButtons[i].setVisible(true);
								farmPanel.add(selectButtons[i]); // 완성된 버튼 패널 추가
								FrameManager.refresh();
								selectButtons[i].addActionListener(new ActionListener() { // 버튼에 이벤트 추가
									private int index; // 버튼의 자체 인덱스를 저장하기 위해 변수 선언
									{
										this.index = i; // 자체 인덱스에 for문의 시작값 대입
									}

									@Override
									public void actionPerformed(ActionEvent e) {
										retainCropDTO.setCropId(retainCropList.get(index).getCropId());
										System.out.println(retainCropList.get(index).getCropId());
										int result = farmcontroller.chooseInputSeed(retainCropDTO);
										int imgindex = 1;
										FarmController farmController = new FarmController();
										if (result > 0) {
											switch (retainCropList.get(index).getCropId()) {
											case 5:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/tomato/Tomato_Stage_1.png");
												farmCropDTO.setFarmList(2);
												farmCropDTO.setCropId(retainCropList.get(index).getCropId());
												farmCropDTO.setAccumulate(200);
												farmController.fieldInputSeed(farmCropDTO);
												fieldArr[imgindex] = 5;
												tomatoSumExp[imgindex] = 0;

												break;
											case 6:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/corn/Corn_Stage.png");
												farmCropDTO.setFarmList(2);
												farmCropDTO.setCropId(retainCropList.get(index).getCropId());
												farmCropDTO.setAccumulate(300);
												farmController.fieldInputSeed(farmCropDTO);

												fieldArr[imgindex] = 6;
												cornSumExp[imgindex] = 0;

												break;
											case 7:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/garlic/Garlic_Stage_1.png");
												farmCropDTO.setFarmList(2);
												farmCropDTO.setCropId(retainCropList.get(index).getCropId());
												farmCropDTO.setAccumulate(400);
												farmController.fieldInputSeed(farmCropDTO);

												fieldArr[imgindex] = 7;
												garlicSumExp[imgindex] = 0;

												break;
											case 8:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/pumpkin/Pumpkin_Stage_1.png");
												farmCropDTO.setFarmList(2);
												farmCropDTO.setCropId(retainCropList.get(index).getCropId());
												farmCropDTO.setAccumulate(500);
												farmController.fieldInputSeed(farmCropDTO);

												fieldArr[imgindex] = 8;
												pumpkinSumExp[imgindex] = 0;

												break;

											default:
												break;
											}
										} else {
											JOptionPane.showMessageDialog(farmPanel, "씨앗심기를 실패하였습니다.", "씨앗 심음 알림", 1);
										}
									}
								});
							}
						} else {
							seedText.setVisible(false);
							conversationLabel.setVisible(false);
							jSeedList.setVisible(false);

							JOptionPane.showMessageDialog(null, "보유중인 씨앗이 없습니다.", "씨앗보유 여부", 0);
						}
						break;
					}

				}
			});
			fieldButton[2].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					FrameManager.panelRefresh(farmPanel);
					/*--------------버튼 값이 있을경우-------------*/
					int fieldArrIndex = 2; // 누른 배열의 인덱스 값
					switch (fieldArr[fieldArrIndex]) {
					case 5:
						tomatoSumExp[fieldArrIndex] += farmExp;
						if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_1.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_2.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_3.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/tomato/Tomato_Stage_4.png");
						} else if ((double) tomatoSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/tomato/Tomato.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 1);
						}
						break;
					case 6:
						cornSumExp[fieldArrIndex] += farmExp;
						if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage_2.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage_3.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/corn/Corn_Stage_4.png");
						} else if ((double) cornSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/corn/Corn.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 2);
						}
						break;
					case 7:
						garlicSumExp[fieldArrIndex] += farmExp;
						if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_1.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_2.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_3.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/garlic/Garlic_Stage_4.png");
						} else if ((double) garlicSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/garlic/garlic.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 3);
						}
						break;
					case 8:
						pumpkinSumExp[fieldArrIndex] += farmExp;
						if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.25) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_1.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.5) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_2.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 0.75) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_3.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin_Stage_4.png");
						} else if ((double) pumpkinSumExp[fieldArrIndex] / farmCropDTO.getAccumulate() < 1.1) {
							setIcon(fieldArrIndex, "img/pumpkin/Pumpkin.png");
						} else {
							deleteHarvestCrop(fieldArrIndex, 4);
						}
						break;
					case 0:
						conversationSetVisible(true);
						int x = 860;
						int y = 300;
						retainCropList = farmcontroller.selectSeed(farmCropDTO);
						if (retainCropList != null) {
							selectButtons = new JButton[retainCropList.size()];
							Image selectSeed = new ImageIcon("img/mngInterface/triangleButton.png").getImage()
									.getScaledInstance(25, 25, 0);

							defaultSeedList.removeAllElements();
							for (i = 0; i < retainCropList.size(); i++) {
								defaultSeedList.addElement(retainCropList.get(i).getCropName() + ""
										+ retainCropList.get(i).getCropAmount() + "개" + " " + ">");// 빈 모델

								selectButtons[i] = new JButton(new ImageIcon(selectSeed)); // 생성된 버튼에 이미지 삽입
								selectButtons[i].setLocation(x, y);
								selectButtons[i].setSize(20, 20); // 좌표와 크기 지정
								y += 25; // 버튼 세로 정렬을 위해 y축 값 증가
								selectButtons[i].setVisible(true);
								farmPanel.add(selectButtons[i]); // 완성된 버튼 패널 추가
								FrameManager.refresh();
								selectButtons[i].addActionListener(new ActionListener() { // 버튼에 이벤트 추가
									private int index; // 버튼의 자체 인덱스를 저장하기 위해 변수 선언
									{
										this.index = i; // 자체 인덱스에 for문의 시작값 대입
									}

									@Override
									public void actionPerformed(ActionEvent e) {
										retainCropDTO.setCropId(retainCropList.get(index).getCropId());
										System.out.println(retainCropList.get(index).getCropId());
										int result = farmcontroller.chooseInputSeed(retainCropDTO);
										int imgindex = 2;
										FarmController farmController = new FarmController();
										if (result > 0) {
											switch (retainCropList.get(index).getCropId()) {
											case 5:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/tomato/Tomato_Stage_1.png");
												farmCropDTO.setFarmList(3);
												farmCropDTO.setCropId(retainCropList.get(index).getCropId());
												farmCropDTO.setAccumulate(200);
												farmController.fieldInputSeed(farmCropDTO);
												fieldArr[imgindex] = 5;
												tomatoSumExp[imgindex] = 0;

												break;
											case 6:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/corn/Corn_Stage.png");
												farmCropDTO.setFarmList(3);
												farmCropDTO.setCropId(retainCropList.get(index).getCropId());
												farmCropDTO.setAccumulate(300);
												farmController.fieldInputSeed(farmCropDTO);

												fieldArr[imgindex] = 6;
												cornSumExp[imgindex] = 0;

												break;
											case 7:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/garlic/Garlic_Stage_1.png");
												farmCropDTO.setFarmList(3);
												farmCropDTO.setCropId(retainCropList.get(index).getCropId());
												farmCropDTO.setAccumulate(400);
												farmController.fieldInputSeed(farmCropDTO);

												fieldArr[imgindex] = 7;
												garlicSumExp[imgindex] = 0;

												break;
											case 8:
												JOptionPane.showMessageDialog(farmPanel,
														retainCropList.get(index).getCropName() + "를 심었습니다", "씨앗 심음 알림", 1);
												setIcon(imgindex, "img/pumpkin/Pumpkin_Stage_1.png");
												farmCropDTO.setFarmList(3);
												farmCropDTO.setCropId(retainCropList.get(index).getCropId());
												farmCropDTO.setAccumulate(500);
												farmController.fieldInputSeed(farmCropDTO);

												fieldArr[imgindex] = 8;
												pumpkinSumExp[imgindex] = 0;

												break;

											default:
												break;
											}
										} else {
											JOptionPane.showMessageDialog(farmPanel, "씨앗심기를 실패하였습니다.", "씨앗 심음 알림", 1);
										}
									}
								});
							}
						} else {
							conversationSetVisible(false);

							JOptionPane.showMessageDialog(null, "보유중인 씨앗이 없습니다.", "씨앗보유 여부", 0);
						}
						break;
					}

				}
			});
			
		
		public void conversationSetVisible(boolean isTrue) {
			seedText.setVisible(isTrue);
			conversationLabel.setVisible(isTrue);
			jSeedList.setVisible(isTrue);
			btnGoBack.setVisible(isTrue);
			
		}
		public void deleteHarvestCrop(int fieldArrIndex, int cropId) {

			setIcon(fieldArrIndex, "img/field.png");
			fieldArr[fieldArrIndex] = 0; // 필드arr에 있는값을 0 으로 초기화
			int delete = 0;
			int harvestCrop = 0;
			farmCropDTO.setCropId(cropId);
			harvestCrop = farmcontroller.harvestCrop(farmCropDTO);// cropid 값추가
			delete = farmcontroller.deleteFarmList(farmCropDTO, fieldArrIndex + 1); // 테이블 값 삭제

			FrameManager.refresh();
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

		public JButton btnMainNpc() {
			Image imgMainNpc = new ImageIcon("img/interface/mainNpc.png").getImage().getScaledInstance(30, 50, 0);
			btnMainNpc = new JButton(new ImageIcon(imgMainNpc));
			btnMainNpc.setLocation(570, 190);
			btnMainNpc.setSize(30, 50);
			btnMainNpc.setBorderPainted(false);
			btnMainNpc.setContentAreaFilled(false);
			btnMainNpc.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					BuyHouseAndCookPanel mainNpcPanel = new BuyHouseAndCookPanel(userNo);
					FrameManager.changePanel(farmPanel, mainNpcPanel);

				}
			});

			return btnMainNpc;
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

		public JButton btnStoreNpc() {
			Image imgStoreNpc = new ImageIcon("img/interface/storeNpc.png").getImage().getScaledInstance(30, 50, 0);
			btnStoreNpc = new JButton(new ImageIcon(imgStoreNpc));
			btnStoreNpc.setLocation(750, 150);
			btnStoreNpc.setSize(30, 50);
			btnStoreNpc.setBorderPainted(false);
			btnStoreNpc.setContentAreaFilled(false);

			btnStoreNpc.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MainStorePanel storePanel = new MainStorePanel(userNo);
					FrameManager.changePanel(farmPanel, storePanel);

				}
			});
			return btnStoreNpc;
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

		public void setIcon(int index, String src) {

			Image imgField = new ImageIcon(src).getImage().getScaledInstance(30, 30, 0);

			fieldButton[index].setIcon(new ImageIcon(imgField));
			fieldButton[index].setContentAreaFilled(false);

			seedText.setVisible(false);
			conversationLabel.setVisible(false);
			jSeedList.setVisible(false);
			btnGoBack.setVisible(false);

			selectButtons[0].setVisible(false);
			selectButtons[1].setVisible(false);
			selectButtons[2].setVisible(false);
			selectButtons[3].setVisible(false);

			FrameManager.panelRefresh(farmPanel);
		}
	}
}
