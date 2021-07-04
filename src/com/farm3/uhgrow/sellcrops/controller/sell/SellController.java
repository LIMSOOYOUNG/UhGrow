package com.farm3.uhgrow.sellcrops.controller.sell;

import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;
import com.farm3.uhgrow.sellcrops.model.service.SellCropsService;

public class SellController {
	
	private CropDTO cropDTO = new CropDTO();
	private SellCropsService sellCropsService = new SellCropsService();
	
	/* 유저, 유저의 재화, 유저가 가지고 있는 농작물 , 농작물 갯수*/
	public List<CropDTO> userCropList() {
		
		List<CropDTO> userCropList = sellCropsService.userCropList();
		
		return userCropList;
	}

	public List<CropDTO> userCornList() {


		List<CropDTO> userCornList = sellCropsService.userCornList();
		
		return userCornList;
	}
		
	
	public List<CropDTO> userGarlicList() {

		List<CropDTO> userGarlicList = sellCropsService.userGarlicList();
		
		return userGarlicList;
	}	
	
	public List<CropDTO> userPumpkinList() {

		List<CropDTO> userPumpkinList = sellCropsService.userPumpkinList();
		
		return userPumpkinList;
	}	

	/* 토마토 수량 업데이트*/
	public int updateUserToamtoAmount(int sellAmount) {
		
		int result = sellCropsService.updateUserTomatoAmount(sellAmount);
		
		return result;
	}

	/* 토마토 금액 업데이트*/
	public int sellTomatoGetCoin(int sellAmount) {
		
		int result = sellCropsService.sellTomatoGetCoin(sellAmount);
		
		return result;
	}
	








}