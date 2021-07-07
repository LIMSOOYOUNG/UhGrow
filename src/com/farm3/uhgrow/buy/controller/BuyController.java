package com.farm3.uhgrow.buy.controller;


import java.util.List;

import com.farm3.uhgrow.buy.model.dto.BuyDTO;
import com.farm3.uhgrow.buy.service.BuyService;
import com.farm3.uhgrow.farm.model.dto.RetainToolDTO;


public class BuyController {

	private BuyDTO buyDTO = new BuyDTO();
	private BuyService buyCropsService = new BuyService();

	/* 유저, 유저의 재화, 유저가 가지고 있는 농작물 , 농작물 갯수*/
	public List<BuyDTO> userTomatoList() {

		List<BuyDTO> userTomatoList = buyCropsService.userTomatoList();

		return userTomatoList;
	}

	public List<BuyDTO> userCornList() {


		List<BuyDTO> userCornList = buyCropsService.userCornList();

		return userCornList;
	}


	public List<BuyDTO> userGarlicList() {

		List<BuyDTO> userGarlicList = buyCropsService.userGarlicList();

		return userGarlicList;
	}	

	public List<BuyDTO> userPumpkinList() {

		List<BuyDTO> userPumpkinList = buyCropsService.userPumpkinList();

		return userPumpkinList;
	}	

	/* 토마토씨앗 수량 업데이트*/
	public int updateTomatoCropAmount(int buyAmount) {

		int result = buyCropsService.updateTomatoCropAmount(buyAmount);

		return result;
	}

	/* 옥수수씨앗 수량 업데이트*/
	public int updateCornCropAmount(int buyAmount) {

		int result = buyCropsService.updateCornCropAmount(buyAmount);

		return result;
	}

	/* 마늘씨앗 수량 업데이트*/
	public int updateGarlicCropAmount(int buyAmount) {

		int result = buyCropsService.updateGarlicCropAmount(buyAmount);

		return result;
	}

	/* 호박씨앗 수량 업데이트*/
	public int updatePumpkinCropAmount(int buyAmount) {

		int result = buyCropsService.updatePumpkinCropAmount(buyAmount);

		return result;
	}

	/* 토마토 금액 업데이트*/
	public int buyTomatoGetCoin(int buyAmount, int tomatoPrice) {

		int result = buyCropsService.buyTomatoGetCoin(buyAmount, tomatoPrice);

		return result;
	}

	public int buyGarlicGetCoin(int buyAmount, int garlicPrice) {

		int result = buyCropsService.buyGarlicGetCoin(buyAmount, garlicPrice);

		return result;
	}

	public int buyCornGetCoin(int buyAmount, int cornPrice) {
		
		int result = buyCropsService.buyCornGetCoin(buyAmount, cornPrice);
		
		return result;
	}
	public int buyPumpkinGetCoin(int buyAmount, int pumpkinPrice) {

		int result = buyCropsService.buyPumpkinGetCoin(buyAmount, pumpkinPrice);

		return result;
	}

	public int selectPrice(int toolId) {
        int selectPrice = buyCropsService.selectPrice(toolId);

        return selectPrice;
    }

	public char istoolYN(int userNo) {
		char istoolYN = buyCropsService.istoolYN(userNo);

        return istoolYN;
	}

	public int currentCoin(BuyDTO buyDTO) {
		int currentCoin = buyCropsService.currentCoin(buyDTO);

		return currentCoin;
	}

	public void updateCoinTool(BuyDTO buyDTO) {
		
		buyCropsService.updateCoinTool(buyDTO);
		
	}

	public int plusExp(int toolId) {

		int plusExp = buyCropsService.plusExp(toolId);
		
		return plusExp;
	}

	public List<RetainToolDTO> selectRetainToolList(int userNo) {
		List<RetainToolDTO> retainToolList = buyCropsService.selectRetainToolList(userNo);
		return retainToolList;
	}

	public void createRetainToolList(int userNo) {
		
		buyCropsService.createRetainToolList(userNo);
		
	}

}
