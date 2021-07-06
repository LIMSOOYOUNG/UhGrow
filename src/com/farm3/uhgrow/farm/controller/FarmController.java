package com.farm3.uhgrow.farm.controller;

import java.util.List;

import com.farm3.uhgrow.farm.model.dto.FarmCropDTO;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.service.FarmService;

public class FarmController {
	private List<RetainCropDTO> retainCropList;
	private List<RetainCropDTO> retainAllList;
	private FarmService farmService = new FarmService();

	public FarmController() {
	}

	public List<RetainCropDTO> selectAllCrop(FarmCropDTO farmCropDTO) {
		retainAllList = farmService.selectAllCrop(farmCropDTO);
		System.out.println(retainAllList);

		return retainAllList;
	}
	public List<RetainCropDTO> selectSeed(FarmCropDTO farmCropDTO) {
		retainCropList = farmService.selectAllSeed(farmCropDTO);
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

	public int deleteFarmList(FarmCropDTO farmCropDTO, int farmListNo) {
		int deleteResult = farmService.deleteFarmList(farmCropDTO,farmListNo);

		return deleteResult;
	}

	public int harvestCrop(FarmCropDTO farmCropDTO) {
		int harvestCrop = farmService.harvestCrop(farmCropDTO);

		return harvestCrop;
	}

	public List<RetainCropDTO> inventoryCrop(int userId) {
		List<RetainCropDTO> inventoryCrop = farmService.inventoryCrop(userId);

		return inventoryCrop;
	}

	public int createCrop(int CropId) {
		int createCrop = farmService.createCrop(CropId);

		return createCrop;
	}

	public int resetFarmList(int userNo) {
		int resetResult = farmService.resetFarmList(userNo);

		return resetResult;
		
	}


}
