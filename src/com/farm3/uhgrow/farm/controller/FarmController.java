package com.farm3.uhgrow.farm.controller;


import java.util.List;


import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.service.FarmService;

public class FarmController {
	private List<RetainCropDTO> retainCropList;
	private FarmService farmService = new FarmService();

	public FarmController() {}
	
	public List<RetainCropDTO> selectSeed() {
		retainCropList = farmService.selectAllSeed();
		System.out.println(retainCropList);
		
		return retainCropList;
	}
	
	public int chooseInputSeed(RetainCropDTO cropDTO) {
		int result = farmService.chooseInputSeed(cropDTO);
		
		return result;
	}
	
	
}
