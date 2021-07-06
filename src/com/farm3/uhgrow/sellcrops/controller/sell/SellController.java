package com.farm3.uhgrow.sellcrops.controller.sell;

import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;
import com.farm3.uhgrow.sellcrops.model.service.SellCropsService;

public class SellController {
	
	private CropDTO cropDTO = new CropDTO();
	private SellCropsService sellCropsService = new SellCropsService();
	
	/* 코인 라벨*/
	public int selectCoin() {
		int result = sellCropsService.selectCoin();
		return result;
	}

	/* 유저, 유저의 재화, 유저가 가지고 있는 농작물 , 농작물 갯수*/
	public List<CropDTO> userTomatoList() {
		
		List<CropDTO> userCropList = sellCropsService.userTomatoList();
		
		return userCropList;
	}


	/* 토마토 수량 업데이트*/
	public int updateUserToamtoAmount(int sellAmount) {
		
		int result = sellCropsService.updateUserTomatoAmount(sellAmount);
		
		return result;
	}

	/* 토마토 금액 업데이트*/
	public int sellTomatoGetCoin(int sellAmount, int tomatoPrice) {
		
		int result = sellCropsService.sellTomatoGetCoin(sellAmount, tomatoPrice);
		
		return result;
	}

//////////////////////////////////////////////////////////////////////////////////
	

	public List<CropDTO> userCornList() {

		List<CropDTO> userCornList = sellCropsService.userCornList();
		
		return userCornList;
	}
	
	/* 옥수수 수량 업데이트*/
	public int updateUserCornAmount(int sellAmount) {

		int result = sellCropsService.updateUserCornAmount(sellAmount);
		
		return result;
	}

	/* 옥수수 금액 업데이트 */
	public int sellCornGetCoin(int sellAmount, int cornPrice) {
		
		int result = sellCropsService.sellCornGetCoin(sellAmount, cornPrice);
		
		return result; 
	}
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////
	
	public List<CropDTO> userGarlicList() {

		List<CropDTO> userGarlicList = sellCropsService.userGarlicList();
		
		return userGarlicList;
	}	
	
	/* 마늘 수량 업데이트*/
	public int updateUserGarlicAmount(int sellAmount) {
		
		int result = sellCropsService.updateUserGarlicAmount(sellAmount);
		
		return result;
	}
	
	/* 마늘 금액 업데이트 */
	public int sellGarlicGetCoin(int sellAmount, int garlicPrice) {
		
		int result = sellCropsService.sellGarlicGetCoin(sellAmount, garlicPrice);
		
		return result;
	}

	
////////////////////////////////////////////////////////////////////////////////////	

	public List<CropDTO> userPumpkinList() {

		List<CropDTO> userPumpkinList = sellCropsService.userPumpkinList();
		
		return userPumpkinList;
	}	
	
	/* 호박 수량 업데이트*/
	public int updateUserPumpkinAmount(int sellAmount) {
		
		int result = sellCropsService.updateUserPumpkinAmount(sellAmount);
		
		return result;
	}
	
	/* 호박 금액 업데이트 */
	public int sellPumpkinGetCoin(int sellAmount, int pumpkinPrice) {
		
		int result = sellCropsService.sellPumpkinGetCoin(sellAmount, pumpkinPrice);
		
		return result;
	}


	
	/* 씨앗 판매*/
	
	
	/*유저 토마토 씨앗 */
	public List<CropDTO> userTomatoSeed() {
		
		List<CropDTO> userTomatoSeed = sellCropsService.userTomatoSeed();
		
		return userTomatoSeed;
	}


	public int updateUserToamtoSeed(int sellAmount) {
		
		int result = sellCropsService.updateUserTomatoSeed(sellAmount);
		
		return result;
	}


	public int sellTomatoSeedGetCoin(int sellAmount, int tomatoSeedPrice) {
		
		int result = sellCropsService.sellTomatoSeedGetCoin(sellAmount, tomatoSeedPrice);
		
		return result;
	}
	


	
	/* 유저 옥수수 씨앗*/
	public List<CropDTO> userCornSeed() {
		
		List<CropDTO> userCornSeed = sellCropsService.userCornSeed();
		
		return userCornSeed;
	}


	public int updateUserCornSeed(int sellAmount) {
		
		int result = sellCropsService.updateUserCornSeed(sellAmount);
		
		return result;
	}

	public int sellCornSeedGetCoin(int sellAmount, int cornSeedPrice) {
			
		int result = sellCropsService.sellCornSeedGetCoin(sellAmount, cornSeedPrice);
		
		return result; 
	}

	
	
	public List<CropDTO> userGarlicSeed() {
		
		List<CropDTO> userGarlicSeed = sellCropsService.userGarlicSeed();
		
		return userGarlicSeed;
	}

	public int updateUserGarlicSeed(int sellAmount) {
		
		int result = sellCropsService.updateUserGarlicSeed(sellAmount);
		
		return result;
	}

	public int sellGarlicSeedGetCoin(int sellAmount, int garlicSeedPrice) {
		
		int result = sellCropsService.sellGarlicSeedGetCoin(sellAmount, garlicSeedPrice);
		
		return result; 
	}

	
	
	
	
	
	
	public List<CropDTO> userPumpkinSeed() {
		
	List<CropDTO> userPumpkinSeed = sellCropsService.userPumpkinSeed();
		
		return userPumpkinSeed;
	}


	public int updateUserPumpkinSeed(int sellAmount) {
		
		int result = sellCropsService.updateUserPumpkinSeed(sellAmount);
		
		return result;
	}

	public int sellPumpkinSeedGetCoin(int sellAmount, int pumpkinSeedPrice) {
		
		int result = sellCropsService.sellPumpkinSeedGetCoin(sellAmount, pumpkinSeedPrice);
		
		return result; 
	}
		
		


	








}