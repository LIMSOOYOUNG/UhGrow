package com.farm3.uhgrow.farm.controller;


import java.util.List;


import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.dto.SeedDTO;
import com.farm3.uhgrow.farm.model.service.FarmService;

public class FarmController {
	private List<RetainCropDTO> retainSeedList;
	private FarmService farmService = new FarmService();

	public FarmController() {}
	
	public List<SeedDTO> selectSeed() {
		retainSeedList = farmService.selectAllSeed();
		System.out.println(retainSeedList);
		
		return retainSeedList;
	}
	
	public int chooseInputSeed(RetainCropDTO cropDTO) {
		int result = farmService.chooseInputSeed(cropDTO);
		
		return result;
	}
	
	
}
