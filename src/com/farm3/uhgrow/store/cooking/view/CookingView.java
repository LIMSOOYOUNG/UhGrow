package com.farm3.uhgrow.store.cooking.view;

import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import com.farm3.uhgrow.store.cooking.controller.CookingController;
import com.farm3.uhgrow.store.cooking.model.dto.RetainCropDTO;

public class CookingView extends JFrame {
	
	private int userNo;
	private CookingController cookingController;
	
	
	public CookingView() {
		
		this.userNo = 1;
		this.cookingController = new CookingController();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(userNo);
		List<RetainCropDTO> userHavingCrop = cookingController.selectUserCropAmount(userNo);
		System.out.print("만들 요리를 선택하세요 : ");
		int selectFoodId = sc.nextInt();
		
		System.out.print("갯수를 입력하세요 : ");
		int inputAmount = sc.nextInt();
		
		int modifyCropAmount = cookingController.modifyCropAmount(userNo, selectFoodId, inputAmount);
		int modifyFoodAmount = cookingController.modifyFoodAmount(userNo, selectFoodId, inputAmount);
		
		
	}

}
