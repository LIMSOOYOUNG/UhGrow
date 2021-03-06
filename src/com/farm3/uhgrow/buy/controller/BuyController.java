package com.farm3.uhgrow.buy.controller;

import java.util.List;

import com.farm3.uhgrow.buy.model.dto.BuyDTO;
import com.farm3.uhgrow.buy.service.BuyService;
import com.farm3.uhgrow.farm.model.dto.RetainToolDTO;

public class BuyController {

	private BuyDTO buyDTO = new BuyDTO();
	private BuyService buyCropsService = new BuyService();

	/* 유저, 유저의 재화, 유저가 가지고 있는 농작물 , 농작물 갯수 */
	public List<BuyDTO> userTomatoList(int userNo) {

		List<BuyDTO> userTomatoList = buyCropsService.userTomatoList(userNo);

		return userTomatoList;
	}

	public List<BuyDTO> userCornList(int userNo) {

		List<BuyDTO> userCornList = buyCropsService.userCornList(userNo);

		return userCornList;
	}

	public List<BuyDTO> userGarlicList(int userNo) {

		List<BuyDTO> userGarlicList = buyCropsService.userGarlicList(userNo);

		return userGarlicList;
	}

	public List<BuyDTO> userPumpkinList(int userNo) {

		List<BuyDTO> userPumpkinList = buyCropsService.userPumpkinList(userNo);

		return userPumpkinList;
	}

	/* 토마토씨앗 수량 업데이트 */
	public int updateTomatoCropAmount(int userNo,int buyAmount) {

		int result = buyCropsService.updateTomatoCropAmount(userNo,buyAmount);

		return result;
	}

	/* 옥수수씨앗 수량 업데이트 */
	public int updateCornCropAmount(int buyAmount) {

		int result = buyCropsService.updateCornCropAmount(buyAmount);

		return result;
	}

	/* 마늘씨앗 수량 업데이트 */
	public int updateGarlicCropAmount(int buyAmount) {

		int result = buyCropsService.updateGarlicCropAmount(buyAmount);

		return result;
	}

	/* 호박씨앗 수량 업데이트 */
	public int updatePumpkinCropAmount(int buyAmount) {

		int result = buyCropsService.updatePumpkinCropAmount(buyAmount);

		return result;
	}

	/* 토마토 금액 업데이트 */
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

	public RetainToolDTO isToolYN(int userNo, int toolId) {
		RetainToolDTO isToolYN = buyCropsService.isToolYN(userNo,toolId);

		return isToolYN;
	}

	public int currentCoin(BuyDTO buyDTO) {
		int currentCoin = buyCropsService.currentCoin(buyDTO);
		return currentCoin;
	}

	public int updateCoinTool(BuyDTO buyDTO) {
		int result = buyCropsService.updateCoinTool(buyDTO);
		return result;
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
