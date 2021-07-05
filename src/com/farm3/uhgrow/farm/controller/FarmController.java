package com.farm3.uhgrow.farm.controller;

import java.util.List;

import com.farm3.uhgrow.farm.model.dto.FarmCropDTO;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.service.FarmService;

public class FarmController {
	private List<RetainCropDTO> retainCropList;
	private FarmService farmService = new FarmService();

	public FarmController() {
	}

	public List<RetainCropDTO> selectSeed() {
		retainCropList = farmService.selectAllSeed();
		System.out.println(retainCropList);

		return retainCropList;
	}

	public int chooseInputSeed(RetainCropDTO cropDTO) {
		int result = farmService.chooseInputSeed(cropDTO);

		return result;
	}

	

	public int fieldInputSeed(FarmCropDTO farmCropDTO) {
		int result = farmService.fieldInputSeed(farmCropDTO);

		return result;
	}

	public int selectFarmExp(int userId) {
		int farmExp = farmService.selectFarmExp(userId);

		return farmExp;
	}

	public int deleteFarmList(int farmList) {
		int deleteResult = farmService.deleteFarmList(farmList);

		return deleteResult;
	}

	public int harvestCrop(int CropId) {
		int harvestCrop = farmService.harvestCrop(CropId);

		return harvestCrop;
	}

	public List<RetainCropDTO> inventoryCrop(int userId) {
		List<RetainCropDTO> inventoryCrop = farmService.inventoryCrop(userId);

		return inventoryCrop;
	}

}
