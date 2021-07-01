package com.farm3.uhgrow.farm.controller;


import java.awt.List;

import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.service.FarmService;
import com.farm3.uhgrow.farm.view.RetainResultView;

public class FarmController {
	private RetainCropDTO croplist;
	private List retainCropList;
	private RetainResultView retainResultView = new RetainResultView();
	private FarmService farmService = new FarmService();

	public FarmController() {}
	
	public List selectSeed() {
		List retaincroplist = farmService.selectAllSeed();
		if(retainCropList!=null) {
			
		}else {
			retainResultView.displayDmlResult("selectFailed");
		}
		return retaincroplist;
	}
	
	public void chooseSeed(int cropId) {
//		RetainCropDTO retainCropDTO = new RetainCropDTO();
//		retainCropDTO.setCropId(cropId);
//		
//		int result = farmService.chooseSeed(retainCropDTO);
		
//		if(result>0) {
//			retainResultView.display("selectSuccess");
//		}else {
//			retainResultView.displayDmlResult("selectFailed");
//		}
	}
	
	
}
