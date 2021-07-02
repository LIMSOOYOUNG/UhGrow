package com.farm3.uhgrow.management.controller;

import java.util.List;

import com.farm3.uhgrow.management.model.dto.ModifyCropPriceDTO;
import com.farm3.uhgrow.management.model.dto.SelectCropPriceDTO;
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
		
		if(result > 0) {
			MngResultView.mngResult("modifySuccess");
		}
		
	}

	


	public List<SelectCropPriceDTO> selectCropPriceData() {
		List<SelectCropPriceDTO> userList = GameDataService.selectCropPriceData();
		return userList;
	}

}