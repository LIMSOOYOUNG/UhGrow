package com.farm3.uhgrow.management.controller;

import java.util.List;

import com.farm3.uhgrow.management.model.dto.ModifyCropPriceDTO;
import com.farm3.uhgrow.management.model.dto.ModifyFoodPriceDTO;
import com.farm3.uhgrow.management.model.dto.ModifyFoodRecipeDTO;
import com.farm3.uhgrow.management.model.dto.SelectCropPriceDTO;
import com.farm3.uhgrow.management.model.dto.SelectFoodPriceDTO;
import com.farm3.uhgrow.management.model.dto.SelectFoodRecipeDTO;
import com.farm3.uhgrow.management.model.service.GameDataService;
import com.farm3.uhgrow.management.view.MngResultView;

public class GameDataController {
	
	

	public GameDataController() {
		this.gameDataService = new GameDataService();
	}
	
	private GameDataService gameDataService = new GameDataService();
	

	public int modifyCropPrice(int i, int inputCornPrice) {
		
		ModifyCropPriceDTO modifyPriceList = new ModifyCropPriceDTO();
		modifyPriceList.setCropId(i);
		modifyPriceList.setNewCropPrice(inputCornPrice);
		
		int result = gameDataService.modifyCropPrice(modifyPriceList);
		
		return result;
	}


	public void modifyHousePrice(int inputHousePrice) {
		
		int result = gameDataService.modifyHousePrice(inputHousePrice);
		
	}

	


	public List<SelectCropPriceDTO> selectCropPriceData() {
		List<SelectCropPriceDTO> userList = GameDataService.selectCropPriceData();
		return userList;
	}


	public List<SelectFoodPriceDTO> selectFoodPriceData() {
		List<SelectFoodPriceDTO> userList = GameDataService.selectFoodPriceData();
		return userList;
	}


	public int modifyFoodPrice(int index, int inputNewFoodPrice) {
		ModifyFoodPriceDTO modifyPriceList = new ModifyFoodPriceDTO();
		modifyPriceList.setFoodId(index);
		modifyPriceList.setNewFoodPrice(inputNewFoodPrice);
		
		int result = gameDataService.modifyFoodPrice(modifyPriceList);
		
		return result;
	}


	public List<ModifyFoodRecipeDTO> selectFoodRecipeData() {
		List<ModifyFoodRecipeDTO> userList = GameDataService.selectFoodRecipeData();
		return userList;
	}


	public int modifyFoodRecipe(int index, int inputNewFoodRecipe) {
		ModifyFoodRecipeDTO modifyRecipeList = new ModifyFoodRecipeDTO();
		modifyRecipeList.setFoodId(index);
		modifyRecipeList.setCropRqAmount(inputNewFoodRecipe);
		
		int result = gameDataService.modifyFoodRecipe(modifyRecipeList);
		
		return result;
	}

}
