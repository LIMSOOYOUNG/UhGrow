package com.farm3.uhgrow.farm.controller;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.service.FarmService;
import com.farm3.uhgrow.farm.view.RetainResultView;

public class FarmController {
	private List<RetainCropDTO> retainCropList;
	private RetainResultView retainResultView = new RetainResultView();
	private FarmService farmService = new FarmService();

	public FarmController() {}
	
	public List<RetainCropDTO> selectSeed() {
		retainCropList = farmService.selectAllSeed();
		System.out.println(retainCropList);
//		if(retainCropList!=null) {
//			
//		}else {
//		}
		return retainCropList;
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
