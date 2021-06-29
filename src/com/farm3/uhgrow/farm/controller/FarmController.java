package com.farm3.uhgrow.farm.controller;

import java.util.List;

import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.service.FarmService;
import com.farm3.uhgrow.farm.view.RetainResultView;

public class FarmController {
	
	private RetainResultView retainResultView = new RetainResultView();
	private FarmService farmService = new FarmService();

	public FarmController() {}
	
	public void selectSeed() {
		List<RetainCropDTO> retainCropList =  farmService.selectAllSeed();
		
		if(retainCropList.size()>0) {
			retainResultView.display("selectSuccess");
			retainResultView.chooseSeed();
		}else {
			retainResultView.displayDmlResult("selectFailed");
		}
	}
	
	public void chooseSeed(int cropId) {
		RetainCropDTO retainCropDTO = new RetainCropDTO();
		retainCropDTO.setCropId(cropId);
		
		int result = farmService.chooseSeed(retainCropDTO);
		
		if(result>0) {
			retainResultView.display("selectSuccess");
		}else {
			retainResultView.displayDmlResult("selectFailed");
		}
	}
	
	
}
