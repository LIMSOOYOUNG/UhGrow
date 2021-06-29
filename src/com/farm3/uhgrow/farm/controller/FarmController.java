package com.farm3.uhgrow.farm.controller;

import java.util.List;

import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.service.FarmService;
import com.farm3.uhgrow.farm.view.FarmResultView;

public class FarmController {
	
	private FarmResultView farmResultView = new FarmResultView();
	private FarmService farmService = new FarmService();

	public FarmController() {}
	
	public void selectSeed() {
		List<RetainCropDTO> retainCropDTO =  farmService.selectAllSeed();
		
		if(retainCropDTO.size()>0) {
			farmResultView.display("selectSuccess");
			farmResultView.chooseSeed();
		}else {
			farmResultView.displayDmlResult("selectFailed");
		}
	}
}
