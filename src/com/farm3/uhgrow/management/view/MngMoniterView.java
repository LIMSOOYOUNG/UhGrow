package com.farm3.uhgrow.management.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.farm3.uhgrow.management.controller.GameDataController;
import com.farm3.uhgrow.management.controller.UserDataController;
import com.farm3.uhgrow.management.model.dto.SelectCropPriceDTO;
import com.farm3.uhgrow.management.model.dto.SelectUserDTO;

public class MngMoniterView extends JFrame {
	UserDataController userDataController;
	GameDataController gameDataController;
	
	private int i;

	public MngMoniterView() {
		
		this.gameDataController = new GameDataController();
		this.userDataController = new UserDataController();

		this.setBounds(300, 200, 960, 565);
		this.setTitle("UhGrow");
		this.setLayout(null);
		playSound("sound/배경음악1.wav");

		JPanel backGroundPanel = new JPanel();
		JPanel mngModePanel = new JPanel();
		JPanel adminTextPanel = new JPanel();
		
//		---------------------------------------------------------------------------------------------------
		
		/* 관리자 모드 메인 */
		backGroundPanel.setLayout(null);
		backGroundPanel.setSize(960, 540);
		adminTextPanel.setLayout(null);
		adminTextPanel.setBounds(230, 10, 500, 70);
		adminTextPanel.setVisible(true);
		mngModePanel.setLayout(null);
		mngModePanel.setBounds(230, 90, 500, 420);
		mngModePanel.setVisible(true);
		
		Image background = new ImageIcon("img/interface/backGround1.png").getImage().getScaledInstance(960, 540, 0);
		JLabel backGroundLabel = new JLabel(new ImageIcon(background));
		backGroundLabel.setLocation(0, 0);
		backGroundLabel.setSize(960, 540);

		Image adminText = new ImageIcon("img/mngInterface/adminText.png").getImage().getScaledInstance(500, 70, 0);
		JLabel adminTextLabel = new JLabel(new ImageIcon(adminText));
		adminTextLabel.setLocation(0, 0);
		adminTextLabel.setSize(500, 70);
		
		Image mngMain = new ImageIcon("img/mngInterface/mngMain.png").getImage().getScaledInstance(500, 450, 0);
		JLabel mngMainLabel = new JLabel(new ImageIcon(mngMain));
		mngMainLabel.setLocation(0, 0);
		mngMainLabel.setSize(500, 450);
		
		Image userMng = new ImageIcon("img/mngInterface/userMng.png").getImage().getScaledInstance(200, 300, 0);
		JButton userMngButton = new JButton(new ImageIcon(userMng));
		userMngButton.setLocation(35, 30);
		userMngButton.setSize(200, 300);
		
		Image gameMng = new ImageIcon("img/mngInterface/gameMng.png").getImage().getScaledInstance(200, 300, 0);
		JButton gameMngButton = new JButton(new ImageIcon(gameMng));
		gameMngButton.setLocation(265, 30);
		gameMngButton.setSize(200, 300);

		Image exitMng = new ImageIcon("img/mngInterface/exitMng.png").getImage().getScaledInstance(220, 50, 0);
		JButton exitMngButton = new JButton(new ImageIcon(exitMng));
		exitMngButton.setLocation(148, 350);
		exitMngButton.setSize(200, 50);
		
		adminTextPanel.add(adminTextLabel);
		mngModePanel.add(userMngButton);
		mngModePanel.add(gameMngButton);
		mngModePanel.add(exitMngButton);
		mngModePanel.add(mngMainLabel);
		backGroundPanel.add(backGroundLabel);
		
//		--------------------------------------------------------------------------------------------------------------
		
		/* 회원관리 메인 */
		JPanel userMngMainPanel = new JPanel();
		userMngMainPanel.setLayout(null);
		userMngMainPanel.setBounds(230, 90, 500, 420);
		userMngMainPanel.setVisible(false);
		
		Image userMngMain = new ImageIcon("img/mngInterface/userMngMain.png").getImage().getScaledInstance(500, 450, 0);
		JLabel userMngMainLabel = new JLabel(new ImageIcon(userMngMain));
		userMngMainLabel.setLocation(0, 0);
		userMngMainLabel.setSize(500, 450);
		
		Image selectAndUpdate = new ImageIcon("img/mngInterface/selectAndUpdateButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton selectAndUpdateButton = new JButton(new ImageIcon(selectAndUpdate));
		selectAndUpdateButton.setLocation(15, 20);
		selectAndUpdateButton.setSize(200, 50);

		Image delete = new ImageIcon("img/mngInterface/deleteButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton deleteButton = new JButton(new ImageIcon(delete));
		deleteButton.setLocation(15, 80);
		deleteButton.setSize(200, 50);
		
		Image recover = new ImageIcon("img/mngInterface/recoverButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton recoverButton = new JButton(new ImageIcon(recover));
		recoverButton.setLocation(15, 140);
		recoverButton.setSize(200, 50);

		Image userCrt = new ImageIcon("img/mngInterface/userMngCrt.png").getImage().getScaledInstance(122, 134, 0);
		JLabel userCrtLabel = new JLabel(new ImageIcon(userCrt));
		userCrtLabel.setLocation(56, 200);
		userCrtLabel.setSize(122, 134);
		
		Image back = new ImageIcon("img/mngInterface/backButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton backButton = new JButton(new ImageIcon(back));
		backButton.setLocation(148, 350);
		backButton.setSize(200, 50);
		
		
		
		
		userMngMainPanel.add(selectAndUpdateButton);
		userMngMainPanel.add(deleteButton);
		userMngMainPanel.add(recoverButton);
		userMngMainPanel.add(backButton);
		userMngMainPanel.add(userCrtLabel);
		userMngMainPanel.add(userMngMainLabel);
		
//		-----------------------------------------------------------------------------------------------------------------
		
		/* 계정 조회 및 수정 메인 */
		JPanel selectAndUpdateMainPanel = new JPanel();
		selectAndUpdateMainPanel.setLayout(null);
		selectAndUpdateMainPanel.setBounds(230, 90, 500, 420);
		selectAndUpdateMainPanel.setVisible(false);
		
		Image sauMngMain = new ImageIcon("img/mngInterface/userMngMain.png").getImage().getScaledInstance(500, 450, 0);
		JLabel selectAndUpdateMainLabel = new JLabel(new ImageIcon(sauMngMain));
		selectAndUpdateMainLabel.setLocation(0, 0);
		selectAndUpdateMainLabel.setSize(500, 450);
		
		Image focusInSelectAndUpdate = new ImageIcon("img/mngInterface/selectAndUpdateButton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel focusInSelectAndUpdateLabel = new JLabel(new ImageIcon(focusInSelectAndUpdate));
		focusInSelectAndUpdateLabel.setLocation(15, 20);
		focusInSelectAndUpdateLabel.setSize(200, 50);

		Image updateText = new ImageIcon("img/mngInterface/updateText.png").getImage().getScaledInstance(200, 180, 0);
		JLabel updateTextLabel = new JLabel(new ImageIcon(updateText));
		updateTextLabel.setLocation(15, 80);
		updateTextLabel.setSize(200, 180);
		
		Image sauNo = new ImageIcon("img/mngInterface/number.png").getImage().getScaledInstance(49, 26, 0);
		JLabel sauNoLabel = new JLabel(new ImageIcon(sauNo));
		sauNoLabel.setLocation(230, 33);
		sauNoLabel.setSize(49, 26);

		Image sauId = new ImageIcon("img/mngInterface/id.png").getImage().getScaledInstance(23, 20, 0);
		JLabel sauIdLabel = new JLabel(new ImageIcon(sauId));
		sauIdLabel.setLocation(338, 36);
		sauIdLabel.setSize(23, 20);

		Image sauPwd = new ImageIcon("img/mngInterface/pwd.png").getImage().getScaledInstance(58, 20, 0);
		JLabel sauPwdLabel = new JLabel(new ImageIcon(sauPwd));
		sauPwdLabel.setLocation(408, 36);
		sauPwdLabel.setSize(58, 20);
		
		Font f1 = new Font("Times", Font.BOLD, 24);
		
		DefaultListModel model = new DefaultListModel(); // 데이터를 담을 빈 모델 선언
		JList userAllList = new JList(model); // 데이터가 담긴 JLsit 선언과 동시에 할당 및 대입
		userAllList.setLocation(230, 90);
		userAllList.setSize(180, 200);
		userAllList.setFont(f1);
		
		Image backToMng = new ImageIcon("img/mngInterface/backButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton backToMngButton = new JButton(new ImageIcon(backToMng));
		backToMngButton.setLocation(148, 350);
		backToMngButton.setSize(200, 50);

		selectAndUpdateMainPanel.add(updateTextLabel);
		selectAndUpdateMainPanel.add(focusInSelectAndUpdateLabel);
		selectAndUpdateMainPanel.add(sauNoLabel);
		selectAndUpdateMainPanel.add(sauIdLabel);
		selectAndUpdateMainPanel.add(sauPwdLabel);
		selectAndUpdateMainPanel.add(userAllList);
		selectAndUpdateMainPanel.add(backToMngButton);
		selectAndUpdateMainPanel.add(selectAndUpdateMainLabel);
		
//		----------------------------------------------------------------------------------------------------------------
		
		/* 계정 삭제 메인 */
		
		JPanel deleteMainPanel = new JPanel();
		deleteMainPanel.setLayout(null);
		deleteMainPanel.setBounds(230, 90, 500, 420);
		deleteMainPanel.setVisible(false);
		
		Image deleteMngMain = new ImageIcon("img/mngInterface/userMngMain.png").getImage().getScaledInstance(500, 450, 0);
		JLabel deleteMainLabel = new JLabel(new ImageIcon(deleteMngMain));
		deleteMainLabel.setLocation(0, 0);
		deleteMainLabel.setSize(500, 450);
		
		Image focusInDelete = new ImageIcon("img/mngInterface/deleteButton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel focusInDeleteLabel = new JLabel(new ImageIcon(focusInDelete));
		focusInDeleteLabel.setLocation(15, 20);
		focusInDeleteLabel.setSize(200, 50);
		
		Image deleteText = new ImageIcon("img/mngInterface/deleteText.png").getImage().getScaledInstance(200, 180, 0);
		JLabel deleteTextLabel = new JLabel(new ImageIcon(deleteText));
		deleteTextLabel.setLocation(15, 80);
		deleteTextLabel.setSize(200, 180);
		
		Image backToMngFromDelete = new ImageIcon("img/mngInterface/backButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton backToMngFromDeleteButton = new JButton(new ImageIcon(backToMngFromDelete));
		backToMngFromDeleteButton.setLocation(148, 350);
		backToMngFromDeleteButton.setSize(200, 50);
		
		Image deleteNo = new ImageIcon("img/mngInterface/number.png").getImage().getScaledInstance(49, 26, 0);
		JLabel deleteNoLabel = new JLabel(new ImageIcon(deleteNo));
		deleteNoLabel.setLocation(230, 33);
		deleteNoLabel.setSize(49, 26);

		Image deleteId = new ImageIcon("img/mngInterface/id.png").getImage().getScaledInstance(23, 20, 0);
		JLabel deleteIdLabel = new JLabel(new ImageIcon(deleteId));
		deleteIdLabel.setLocation(338, 36);
		deleteIdLabel.setSize(23, 20);

		Image deletePwd = new ImageIcon("img/mngInterface/pwd.png").getImage().getScaledInstance(58, 20, 0);
		JLabel deletePwdLabel = new JLabel(new ImageIcon(deletePwd));
		deletePwdLabel.setLocation(408, 36);
		deletePwdLabel.setSize(58, 20);
				
		DefaultListModel deleteModel = new DefaultListModel();
		JList userDeleteList = new JList(deleteModel);
		userDeleteList.setLocation(230, 90);
		userDeleteList.setSize(180, 200);
		userDeleteList.setFont(f1);
		
		
		deleteMainPanel.add(focusInDeleteLabel);
		deleteMainPanel.add(deleteTextLabel);
		deleteMainPanel.add(backToMngFromDeleteButton);	
		deleteMainPanel.add(deleteNoLabel);	
		deleteMainPanel.add(deleteIdLabel);
		deleteMainPanel.add(userDeleteList);
		deleteMainPanel.add(deletePwdLabel);	
		deleteMainPanel.add(deleteMainLabel);
		
//		------------------------------------------------------------------------------------------------------------
		
		/* 계정 복구 메인 */
		
		JPanel recoverMainPanel = new JPanel();
		recoverMainPanel.setLayout(null);
		recoverMainPanel.setBounds(230, 90, 500, 420);
		recoverMainPanel.setVisible(false);
		
		Image recoverMngMain = new ImageIcon("img/mngInterface/userMngMain.png").getImage().getScaledInstance(500, 450, 0);
		JLabel recoverMainLabel = new JLabel(new ImageIcon(recoverMngMain));
		recoverMainLabel.setLocation(0, 0);
		recoverMainLabel.setSize(500, 450);
		
		Image focusInRecover = new ImageIcon("img/mngInterface/recoverButton.png").getImage().getScaledInstance(200, 50, 0);
		JLabel focusInRecoverLabel = new JLabel(new ImageIcon(focusInRecover));
		focusInRecoverLabel.setLocation(15, 20);
		focusInRecoverLabel.setSize(200, 50);
		
		Image recoverText = new ImageIcon("img/mngInterface/recoverText.png").getImage().getScaledInstance(200, 180, 0);
		JLabel recoverTextLabel = new JLabel(new ImageIcon(recoverText));
		recoverTextLabel.setLocation(15, 80);
		recoverTextLabel.setSize(200, 180);
		
		Image backToMngFromRecover = new ImageIcon("img/mngInterface/backButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton backToMngFromRecoverButton = new JButton(new ImageIcon(backToMngFromRecover));
		backToMngFromRecoverButton.setLocation(148, 350);
		backToMngFromRecoverButton.setSize(200, 50);
		
		Image recoverNo = new ImageIcon("img/mngInterface/number.png").getImage().getScaledInstance(49, 26, 0);
		JLabel recoverNoLabel = new JLabel(new ImageIcon(recoverNo));
		recoverNoLabel.setLocation(230, 33);
		recoverNoLabel.setSize(49, 26);

		Image recoverId = new ImageIcon("img/mngInterface/id.png").getImage().getScaledInstance(23, 20, 0);
		JLabel recoverIdLabel = new JLabel(new ImageIcon(recoverId));
		recoverIdLabel.setLocation(338, 36);
		recoverIdLabel.setSize(23, 20);

		Image recoverPwd = new ImageIcon("img/mngInterface/pwd.png").getImage().getScaledInstance(58, 20, 0);
		JLabel recoverPwdLabel = new JLabel(new ImageIcon(recoverPwd));
		recoverPwdLabel.setLocation(408, 36);
		recoverPwdLabel.setSize(58, 20);
			
		DefaultListModel recoverModel = new DefaultListModel();
		JList userRecoverList = new JList(recoverModel);
		userRecoverList.setLocation(230, 90);
		userRecoverList.setSize(180, 200);
		userRecoverList.setFont(f1);
		
		recoverMainPanel.add(focusInRecoverLabel);
		recoverMainPanel.add(recoverTextLabel);
		recoverMainPanel.add(backToMngFromRecoverButton);
		recoverMainPanel.add(recoverNoLabel);
		recoverMainPanel.add(recoverIdLabel);
		recoverMainPanel.add(userRecoverList);
		recoverMainPanel.add(recoverPwdLabel);
		recoverMainPanel.add(recoverMainLabel);
		
//		-------------------------------------------------------------------------------------------------------------
		
		/* 게임관리 메인 */
		
		JPanel gameMngMainPanel = new JPanel();
		gameMngMainPanel.setLayout(null);
		gameMngMainPanel.setBounds(230, 90, 500, 420);
		gameMngMainPanel.setVisible(false);
		
		Image gameMngMain = new ImageIcon("img/mngInterface/userMngMain.png").getImage().getScaledInstance(500, 450, 0);
		JLabel gameMngMainLabel = new JLabel(new ImageIcon(gameMngMain));
		gameMngMainLabel.setLocation(0, 0);
		gameMngMainLabel.setSize(500, 450);
		
		Image mainGameMng = new ImageIcon("img/mngInterface/gameMngButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton gameMngMainButton = new JButton(new ImageIcon(mainGameMng));
		gameMngMainButton.setLocation(33, 20);
		gameMngMainButton.setSize(200, 50);

		Image backToMain = new ImageIcon("img/mngInterface/backButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton backToMainButton = new JButton(new ImageIcon(backToMain));
		backToMainButton.setLocation(266, 20);
		backToMainButton.setSize(200, 50);
		
		Image foodUdt = new ImageIcon("img/mngInterface/foodUpdate.png").getImage().getScaledInstance(106, 27, 0);
		JLabel foodUdtLabel = new JLabel(new ImageIcon(foodUdt));
		foodUdtLabel.setLocation(33, 130);
		foodUdtLabel.setSize(106, 27);

		Image cropPriceUdt = new ImageIcon("img/mngInterface/cropPriceUpdate.png").getImage().getScaledInstance(190, 27, 0);
		JLabel cropPriceUdtLabel = new JLabel(new ImageIcon(cropPriceUdt));
		cropPriceUdtLabel.setLocation(33, 200);
		cropPriceUdtLabel.setSize(190, 27);
		
		Image housePriceUdt = new ImageIcon("img/mngInterface/housePriceUpdate.png").getImage().getScaledInstance(139, 27, 0);
		JLabel housePriceUdtLabel = new JLabel(new ImageIcon(housePriceUdt));
		housePriceUdtLabel.setLocation(33, 270);
		housePriceUdtLabel.setSize(139, 27);
		
		Image foodBtn = new ImageIcon("img/mngInterface/triangleButton.png").getImage().getScaledInstance(36, 40, 0);
		JLabel foodUdtBtn = new JLabel(new ImageIcon(foodBtn));
		foodUdtBtn.setLocation(410, 130);
		foodUdtBtn.setSize(36, 40);
		
		Image cropPriceBtn = new ImageIcon("img/mngInterface/triangleButton.png").getImage().getScaledInstance(36, 40, 0);
		JLabel cropPriceUdtBtn = new JLabel(new ImageIcon(cropPriceBtn));
		cropPriceUdtBtn.setLocation(410, 200);
		cropPriceUdtBtn.setSize(36, 40);
		
		Image housePriceBtn = new ImageIcon("img/mngInterface/triangleButton.png").getImage().getScaledInstance(36, 40, 0);
		JLabel housePriceUdtBtn = new JLabel(new ImageIcon(housePriceBtn));
		housePriceUdtBtn.setLocation(410, 270);
		housePriceUdtBtn.setSize(36, 40);
		
		gameMngMainPanel.add(foodUdtBtn);
		gameMngMainPanel.add(cropPriceUdtBtn);
		gameMngMainPanel.add(housePriceUdtBtn);
		gameMngMainPanel.add(housePriceUdtLabel);
		gameMngMainPanel.add(cropPriceUdtLabel);
		gameMngMainPanel.add(foodUdtLabel);
		gameMngMainPanel.add(backToMainButton);
		gameMngMainPanel.add(gameMngMainButton);
		gameMngMainPanel.add(gameMngMainLabel);
		
//		--------------------------------------------------------------------------------------------------------------------------
		
		/* 집 가격 수정 */
		
		JPanel houseMainPanel = new JPanel();
		houseMainPanel.setLayout(null);
		houseMainPanel.setBounds(230, 90, 500, 420);
		houseMainPanel.setVisible(false);
		
		Image houseMngMain = new ImageIcon("img/mngInterface/userMngMain.png").getImage().getScaledInstance(500, 450, 0);
		JLabel houseMngMainLabel = new JLabel(new ImageIcon(houseMngMain));
		houseMngMainLabel.setLocation(0, 0);
		houseMngMainLabel.setSize(500, 450);
		
		Image mainGameMngH = new ImageIcon("img/mngInterface/gameMngButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton gameMngMainHButton = new JButton(new ImageIcon(mainGameMngH));
		gameMngMainHButton.setLocation(33, 20);
		gameMngMainHButton.setSize(200, 50);

		Image backToMainH = new ImageIcon("img/mngInterface/backButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton backToMainHButton = new JButton(new ImageIcon(backToMainH));
		backToMainHButton.setLocation(266, 20);
		backToMainHButton.setSize(200, 50);
		
		Image modifyHousePrice = new ImageIcon("img/mngInterface/modifyHousePrice.png").getImage().getScaledInstance(211, 27, 0);
		JLabel mHousePriceLabel = new JLabel(new ImageIcon(modifyHousePrice));
		mHousePriceLabel.setLocation(150, 150);
		mHousePriceLabel.setSize(211, 27);
		
		Image modifyScsH = new ImageIcon("img/mngInterface/modifyScs.png").getImage().getScaledInstance(215, 54, 0);
		JButton modifyScsHButton = new JButton(new ImageIcon(modifyScsH));
		modifyScsHButton.setLocation(150, 330);
		modifyScsHButton.setSize(215, 54);
		
		Font f2 = new Font("돋움", Font.BOLD, 20);
		JLabel housePrice = new JLabel("가격 = ");
		housePrice.setLocation(120, 200);
		housePrice.setSize(100, 50);
		housePrice.setFont(f2);
		
		JTextField inputHPrice = new JTextField(30);
		inputHPrice.setLocation(200, 210);
		inputHPrice.setSize(200, 23);
		
		
		houseMainPanel.add(modifyScsHButton);
		houseMainPanel.add(mHousePriceLabel);
		houseMainPanel.add(backToMainHButton);
		houseMainPanel.add(gameMngMainHButton);
		houseMainPanel.add(inputHPrice);
		houseMainPanel.add(housePrice);
		houseMainPanel.add(houseMngMainLabel);
		
//		-------------------------------------------------------------------------------------------------------------------------------------
		
		/* 농작물 가격 수정 */
		
		JPanel cropMainPanel = new JPanel();
		cropMainPanel.setLayout(null);
		cropMainPanel.setBounds(230, 90, 500, 420);
		cropMainPanel.setVisible(false);
		
		Image cropMngMain = new ImageIcon("img/mngInterface/userMngMain.png").getImage().getScaledInstance(500, 450, 0);
		JLabel cropMngMainLabel = new JLabel(new ImageIcon(cropMngMain));
		cropMngMainLabel.setLocation(0, 0);
		cropMngMainLabel.setSize(500, 450);
		
		Image mainGameMngC = new ImageIcon("img/mngInterface/gameMngButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton gameMngMainCButton = new JButton(new ImageIcon(mainGameMngC));
		gameMngMainCButton.setLocation(33, 20);
		gameMngMainCButton.setSize(200, 50);

		Image backToMainC = new ImageIcon("img/mngInterface/backButton.png").getImage().getScaledInstance(200, 50, 0);
		JButton backToMainCButton = new JButton(new ImageIcon(backToMainC));
		backToMainCButton.setLocation(266, 20);
		backToMainCButton.setSize(200, 50);
		
		Image modifyScsC = new ImageIcon("img/mngInterface/modifyScs.png").getImage().getScaledInstance(215, 54, 0);
		JButton modifyScsCButton = new JButton(new ImageIcon(modifyScsC));
		modifyScsCButton.setLocation(150, 330);
		modifyScsCButton.setSize(215, 54);
		
		Image tomato = new ImageIcon("img/mngInterface/tomato.png").getImage().getScaledInstance(75, 27, 0);
		JLabel tomatoLabel = new JLabel(new ImageIcon(tomato));
		tomatoLabel.setLocation(33, 120);
		tomatoLabel.setSize(75, 27);
		
		Image corn = new ImageIcon("img/mngInterface/corn.png").getImage().getScaledInstance(75, 27, 0);
		JLabel cornLabel = new JLabel(new ImageIcon(corn));
		cornLabel.setLocation(33, 160);
		cornLabel.setSize(75, 27);
		
		Image garlic = new ImageIcon("img/mngInterface/garlic.png").getImage().getScaledInstance(49, 27, 0);
		JLabel garlicLabel = new JLabel(new ImageIcon(garlic));
		garlicLabel.setLocation(33, 200);
		garlicLabel.setSize(49, 27);
		
		Image pumpkin = new ImageIcon("img/mngInterface/pumpkin.png").getImage().getScaledInstance(50, 27, 0);
		JLabel pumpkinLabel = new JLabel(new ImageIcon(pumpkin));
		pumpkinLabel.setLocation(33, 240);
		pumpkinLabel.setSize(50, 27);
		
		Font f3 = new Font("times", Font.BOLD, 27);
		DefaultListModel cropPriceModel = new DefaultListModel();
		JList cropPriceList = new JList(cropPriceModel);
		cropPriceList.setLocation(230, 120);
		cropPriceList.setSize(180, 150);
		cropPriceList.setFont(f3);
		
		
		
		
		
		cropMainPanel.add(cropPriceList);
		cropMainPanel.add(modifyScsCButton);
		cropMainPanel.add(backToMainCButton);
		cropMainPanel.add(gameMngMainCButton);
		cropMainPanel.add(pumpkinLabel);
		cropMainPanel.add(garlicLabel);
		cropMainPanel.add(cornLabel);
		cropMainPanel.add(tomatoLabel);
		cropMainPanel.add(cropMngMainLabel);
		
		
		
		
		
		
		
		
		
		this.add(cropMainPanel);
		this.add(houseMainPanel);
		this.add(gameMngMainPanel);
		this.add(recoverMainPanel);
		this.add(deleteMainPanel);
		this.add(selectAndUpdateMainPanel);
		this.add(userMngMainPanel);
		this.add(adminTextPanel);
		this.add(mngModePanel);
		this.add(backGroundPanel);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		userMngButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mngModePanel.setVisible(false);
				userMngMainPanel.setVisible(true);	// 패널 교체
			}

		});
		
		
		selectAndUpdateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userMngMainPanel.setVisible(false);
				selectAndUpdateMainPanel.setVisible(true); // 패널 교체
				
				List<SelectUserDTO> list = userDataController.selectAllUserData(); // 모든 유저 정보 조회 메소드 호출 후 리턴값을 리스트에 대입
				JButton[] selectButtons = new JButton[list.size()]; // 조회된 정보의 인덱스 갯수마다 각각 하나의 버튼 생성
				int x = 450;
				int y = 100; // 버튼의 좌표 지정
				
				Image select = new ImageIcon("img/mngInterface/triangleButton.png").getImage().getScaledInstance(24, 22, 0); // 버튼 이미지 생성
				for(i = 0; i < list.size() ; i++) {
					model.addElement((i + 1) + "  " + list.get(i).getUserId() + "  " + "****"); // 빈 모델 리스트에 값 대입
					selectButtons[i] = new JButton(new ImageIcon(select)); // 생성된 버튼에 이미지 삽입
					selectButtons[i].setLocation(x, y);
					selectButtons[i].setSize(24, 22); // 좌표와 크기 지정
					y += 34; // 버튼 세로 정렬을 위해 y축 값 증가
					selectAndUpdateMainPanel.add(selectButtons[i]); // 완성된 버튼 패널 추가
					
					selectButtons[i].addActionListener(new ActionListener() { // 버튼에 이벤트 추가
						private int index; // 버튼의 자체 인덱스를 저장하기 위해 변수 선언
						{
							this.index = i; // 자체 인덱스에 for문의 시작값 대입
						}
						@Override
						public void actionPerformed(ActionEvent e) {
							String inputNewId = JOptionPane.showInputDialog("새로운 아이디를 입력하세요"); 
							String inputNewPwd = JOptionPane.showInputDialog("새로운 비밀번호를 입력하세요"); // 새로운 아이디와 비밀번호를 입력받는 팝업창
							int result = userDataController.modifyUserData(list.get(index).getUserId(), inputNewId, inputNewPwd); 
							// 컨트롤러의 정보수정 메소드 호출 후 리턴값 받음
							
							if(result > 0) { // 리턴값이 0보다 크면 수정 성공 메시지 출력
								JOptionPane.showMessageDialog(null, "계정 정보가 수정되었습니다!", "닫기", 1);
							}
						}
					});
				}
			}
		});
		
		backButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				userMngMainPanel.setVisible(false);
				mngModePanel.setVisible(true);
				
			}
		});
		
		backToMngButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				selectAndUpdateMainPanel.setVisible(false);
				userMngMainPanel.setVisible(true);
			}
			
		});
		
		deleteButton.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				List<SelectUserDTO> list = userDataController.selectDeleteUserData(); // 삭제할 정보 조회 메소드 호출 후 리턴값 리스트에 대입

				for(int i = 0; i < list.size() ; i++) {
					deleteModel.addElement((i + 1) + "  " + list.get(i).getUserId() + "  " + "****");
				}
				userMngMainPanel.setVisible(false);
				deleteMainPanel.setVisible(true);
			}
		
		});
		
		backToMngFromDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteMainPanel.setVisible(false);
				userMngMainPanel.setVisible(true);
			}
			
		});
		
		recoverButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<SelectUserDTO> list = userDataController.selectRecoverUserData();

				for(int i = 0; i < list.size() ; i++) {
					recoverModel.addElement((i + 1) + "  " + list.get(i).getUserId() + "  " + "****");
				}
				userMngMainPanel.setVisible(false);
				recoverMainPanel.setVisible(true);
				
			}
		});
		
		backToMngFromRecoverButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recoverMainPanel.setVisible(false);
				userMngMainPanel.setVisible(true);
				
			}
		});
		
		gameMngButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mngModePanel.setVisible(false);
				gameMngMainPanel.setVisible(true);
				
			}
		});
		
		backToMainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameMngMainPanel.setVisible(false);
				mngModePanel.setVisible(true);
				}
		});
		
		foodUdtBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("111");
			}
		});
		
		backToMainCButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cropMainPanel.setVisible(false);
				gameMngMainPanel.setVisible(true);
			}
		});
		
		cropPriceUdtBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameMngMainPanel.setVisible(false);
				cropMainPanel.setVisible(true);
				
				List<SelectCropPriceDTO> list = gameDataController.selectCropPriceData(); // 모든 농작물의 가격 조회 메소드 호출 후 리턴값을 리스트에 대입
				JButton[] selectButton = new JButton[list.size()]; // 조회된 정보의 인덱스 갯수마다 각각 하나의 버튼 생성
				int x = 450;
				int y = 130; // 버튼의 좌표 지정
				
				Image select = new ImageIcon("img/mngInterface/triangleButton.png").getImage().getScaledInstance(24, 22, 0); // 버튼 이미지 생성
				for(i = 0; i < list.size() ; i++) {
					cropPriceModel.addElement(list.get(i).getCropPrice()); // 빈 모델 리스트에 값 대입
					selectButton[i] = new JButton(new ImageIcon(select)); // 생성된 버튼에 이미지 삽입
					selectButton[i].setLocation(x, y);
					selectButton[i].setSize(24, 22); // 좌표와 크기 지정
					y += 37; // 버튼 세로 정렬을 위해 y축 값 증가
					cropMainPanel.add(selectButton[i]); // 완성된 버튼 패널 추가
					
					selectButton[i].addActionListener(new ActionListener() { // 버튼에 이벤트 추가
						private int index; // 버튼의 자체 인덱스를 저장하기 위해 변수 선언
						{
							this.index = i; // 자체 인덱스에 for문의 시작값 대입
						}
						@Override
						public void actionPerformed(ActionEvent e) {
							int inputNewCropPrice = Integer.parseInt(JOptionPane.showInputDialog("가격을 입력해주세요"));
							int result = gameDataController.modifyCropPrice(index, inputNewCropPrice);
							// 컨트롤러의 정보수정 메소드 호출 후 리턴값 받음
							
							if(result > 0) { // 리턴값이 0보다 크면 수정 성공 메시지 출력
								JOptionPane.showMessageDialog(null, "가격이 수정되었습니다!", "닫기", 1);
							}
						}
					});
				}
				
			}
		});
		housePriceUdtBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameMngMainPanel.setVisible(false);
				houseMainPanel.setVisible(true);
			}
		});
		
		backToMainHButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				houseMainPanel.setVisible(false);
				gameMngMainPanel.setVisible(true);
			}
		});
		
		modifyScsHButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int intHPrice = Integer.parseInt(inputHPrice.getText()); // 입력받은  String 값을 Integer 형변환 후 int 타입의 변수에 대입
				gameDataController.modifyHousePrice(intHPrice); // 집 가격 수정 메소드 호출
				JOptionPane.showMessageDialog(null, "집 가격이 수정되었습니다!", "닫기", 1); // 수정에 성공해서 팝업창 출력
				houseMainPanel.setVisible(false);
				gameMngMainPanel.setVisible(true);
			}
		
		});
	}

	
	public static void playSound(String fn) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fn));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}