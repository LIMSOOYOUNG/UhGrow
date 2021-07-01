package com.farm3.uhgrow.management.controller;

import com.farm3.uhgrow.management.model.dto.CropPriceDTO;
import com.farm3.uhgrow.management.model.service.GameDataService;
import com.farm3.uhgrow.management.view.MngResultView;

public class GameDataController {
	
	private GameDataService gameDataService;

	public GameDataController() {
		this.gameDataService = new GameDataService();
	}
	

	public void modifyCropPrice(int inputTomatoPrice, int inputCornPrice, int inputGarlicPrice,
			int inputPumpkinPrice) {
		
		CropPriceDTO cropPrice = new CropPriceDTO();
		cropPrice.setTomatoPrice(inputTomatoPrice);
		cropPrice.setCornPrice(inputCornPrice);
		cropPrice.setGarlicPrice(inputGarlicPrice);
		cropPrice.setPumpkinPirce(inputPumpkinPrice);
		int result = gameDataService.modifyCropPrice(cropPrice);
		
		if(result > 3) {
			MngResultView.mngResult("modifySuccess");
		} else {
			MngResultView.mngResult("modifyFailed");
		}
		
	}


	public void modifyHousePrice(int inputHousePrice) {
		
		int result = gameDataService.modifyHousePrice(inputHousePrice);
		
		if(result > 0) {
			MngResultView.mngResult("modifySuccess");
		}
		
	}

}
