package com.farm3.uhgrow.store.cooking.controller;

import java.util.List;

import com.farm3.uhgrow.store.cooking.model.dto.RecipeDTO;
import com.farm3.uhgrow.store.cooking.model.dto.RetainCropDTO;
import com.farm3.uhgrow.store.cooking.model.service.CookingService;

public class CookingController {
	
	private CookingService cookingService;
	
	public CookingController() {
		this.cookingService = new CookingService();
	}

	public List<RetainCropDTO> selectUserCropAmount(int userNo) {
		List<RetainCropDTO> list = cookingService.selectUserCropAmount(userNo);

		return list;
	}

	public int modifyCropAmount(int userNo, int selectFoodId, int inputAmount) {
		RecipeDTO cook = new RecipeDTO();
		cook.setUserNo(userNo);
		cook.setFoodId(selectFoodId);
		cook.setFoodAmount(inputAmount);
		
		int result = cookingService.modifyCropAmount(cook);
		
		return result;
	}

	public int modifyFoodAmount(int userNo, int selectFoodId, int inputAmount) {
		RecipeDTO cook = new RecipeDTO();
		cook.setUserNo(userNo);
		cook.setFoodId(selectFoodId);
		cook.setFoodAmount(inputAmount);
		
		int result = cookingService.modifyFoodAmount(cook);
		
		return result;
	}

}
