package com.farm3.uhgrow.management.controller;

import com.farm3.uhgrow.management.model.dto.CropPriceDTO;
import com.farm3.uhgrow.management.model.service.GameDataService;
import com.farm3.uhgrow.management.view.MngResultView;

public class GameDataController {

	public static void modifyCropPrice(int inputTomatoPrice, int inputCornPrice, int inputGarlicPrice,
			int inputPumpkinPrice) {
		
		CropPriceDTO cropPrice = new CropPriceDTO();
		cropPrice.setTomatoPrice(inputTomatoPrice);
		cropPrice.setCornPrice(inputCornPrice);
		cropPrice.setGarlicPrice(inputGarlicPrice);
		cropPrice.setPumpkinPirce(inputPumpkinPrice);
		int result = GameDataService.modifyCropPrice(cropPrice);
		
		if(result > 0) {
			MngResultView.mngResult("modifySuccess");
		} else {
			MngResultView.mngResult("modifyFailed");
		}
		
	}

}
