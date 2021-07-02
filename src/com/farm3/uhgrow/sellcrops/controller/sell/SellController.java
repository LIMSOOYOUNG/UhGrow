package com.farm3.uhgrow.sellcrops.controller.sell;

import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;
import com.farm3.uhgrow.sellcrops.model.service.SellCropsService;

public class SellController {
	
	private CropDTO cropDTO = new CropDTO();
	private SellCropsService sellCropsService = new SellCropsService();
	
//	public List<CropDTO> userCropList(CropDTO userCrop) {
//		
//		List<CropDTO> userCropList = sellCropsService.userCropList();
//		
//		return userCropList;
//	}


	public List<CropDTO> userCropList() {
		
		List<CropDTO> userCropList = sellCropsService.userCropList();
		
		return userCropList;
	}

}