package com.farm3.uhgrow.sellcrops.controller.sell;

import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;
import com.farm3.uhgrow.sellcrops.model.service.SellCropsService;

/* 농작물 씨앗 컨트롤러*/

public class SellController {
	
	private CropDTO cropDTO = new CropDTO();
	private SellCropsService sellCropsService = new SellCropsService();
	
	/* 코인 라벨*/
	public int selectCoin(int userNo) {
		int result = sellCropsService.selectCoin(userNo);
		return result;
	}

	/* 유저, 유저의 재화, 유저가 가지고 있는 농작물 , 농작물 갯수*/
	public List<CropDTO> userTomatoList(int userNo) {
		
		List<CropDTO> userCropList = sellCropsService.userTomatoList(userNo);
		
		return userCropList;
	}


	/* 토마토 수량 업데이트*/
	public int updateUserToamtoAmount(int sellAmount, int userNo) {
		
		int result = sellCropsService.updateUserTomatoAmount(sellAmount, userNo);
		
		return result;
	}

	/* 토마토 금액 업데이트*/
	public int sellTomatoGetCoin(int sellAmount, int tomatoPrice, int userNo) {
		
		int result = sellCropsService.sellTomatoGetCoin(sellAmount, tomatoPrice, userNo);
		
		return result;
	}

//////////////////////////////////////////////////////////////////////////////////
	

	public List<CropDTO> userCornList(int userNo) {

		List<CropDTO> userCornList = sellCropsService.userCornList(userNo);
		
		return userCornList;
	}
	
	/* 옥수수 수량 업데이트*/
	public int updateUserCornAmount(int sellAmount, int userNo) {

		int result = sellCropsService.updateUserCornAmount(sellAmount, userNo);
		
		return result;
	}

	/* 옥수수 금액 업데이트 */
	public int sellCornGetCoin(int sellAmount, int cornPrice, int userNo) {
		
		int result = sellCropsService.sellCornGetCoin(sellAmount, cornPrice, userNo);
		
		return result; 
	}
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////
	
	public List<CropDTO> userGarlicList(int userNo) {

		List<CropDTO> userGarlicList = sellCropsService.userGarlicList(userNo);
		
		return userGarlicList;
	}	
	
	/* 마늘 수량 업데이트*/
	public int updateUserGarlicAmount(int sellAmount, int userNo) {
		
		int result = sellCropsService.updateUserGarlicAmount(sellAmount, userNo);
		
		return result;
	}
	
	/* 마늘 금액 업데이트 */
	public int sellGarlicGetCoin(int sellAmount, int garlicPrice, int userNo) {
		
		int result = sellCropsService.sellGarlicGetCoin(sellAmount, garlicPrice, userNo);
		
		return result;
	}

	
////////////////////////////////////////////////////////////////////////////////////	

	public List<CropDTO> userPumpkinList(int userNo) {

		List<CropDTO> userPumpkinList = sellCropsService.userPumpkinList(userNo);
		
		return userPumpkinList;
	}	
	
	/* 호박 수량 업데이트*/
	public int updateUserPumpkinAmount(int sellAmount, int userNo) {
		
		int result = sellCropsService.updateUserPumpkinAmount(sellAmount, userNo);
		
		return result;
	}
	
	/* 호박 금액 업데이트 */
	public int sellPumpkinGetCoin(int sellAmount, int pumpkinPrice, int userNo) {
		
		int result = sellCropsService.sellPumpkinGetCoin(sellAmount, pumpkinPrice, userNo);
		
		return result;
	}


	
	/* 씨앗 판매*/
	
	
	/*유저 토마토 씨앗 */
	public List<CropDTO> userTomatoSeed(int userNo) {
		
		List<CropDTO> userTomatoSeed = sellCropsService.userTomatoSeed(userNo);
		
		return userTomatoSeed;
	}


	public int updateUserToamtoSeed(int sellAmount, int userNo) {
		
		int result = sellCropsService.updateUserTomatoSeed(sellAmount, userNo);
		
		return result;
	}


	public int sellTomatoSeedGetCoin(int sellAmount, int tomatoSeedPrice, int userNo) {
		
		int result = sellCropsService.sellTomatoSeedGetCoin(sellAmount, tomatoSeedPrice, userNo);
		
		return result;
	}
	


	
	/* 유저 옥수수 씨앗*/
	public List<CropDTO> userCornSeed(int userNo) {
		
		List<CropDTO> userCornSeed = sellCropsService.userCornSeed(userNo);
		
		return userCornSeed;
	}


	public int updateUserCornSeed(int sellAmount, int userNo) {
		
		int result = sellCropsService.updateUserCornSeed(sellAmount, userNo);
		
		return result;
	}

	public int sellCornSeedGetCoin(int sellAmount, int cornSeedPrice, int userNo) {
			
		int result = sellCropsService.sellCornSeedGetCoin(sellAmount, cornSeedPrice, userNo);
		
		return result; 
	}

	
	
	public List<CropDTO> userGarlicSeed(int userNo) {
		
		List<CropDTO> userGarlicSeed = sellCropsService.userGarlicSeed(userNo);
		
		return userGarlicSeed;
	}

	public int updateUserGarlicSeed(int sellAmount, int userNo) {
		
		int result = sellCropsService.updateUserGarlicSeed(sellAmount, userNo);
		
		return result;
	}

	public int sellGarlicSeedGetCoin(int sellAmount, int garlicSeedPrice, int userNo) {
		
		int result = sellCropsService.sellGarlicSeedGetCoin(sellAmount, garlicSeedPrice, userNo);
		
		return result; 
	}

	
	
	
	
	
	
	public List<CropDTO> userPumpkinSeed(int userNo) {
	
	List<CropDTO> userPumpkinSeed = sellCropsService.userPumpkinSeed(userNo);
		
		return userPumpkinSeed;
	}


	public int updateUserPumpkinSeed(int sellAmount, int userNo) {
		
		int result = sellCropsService.updateUserPumpkinSeed(sellAmount, userNo);
		
		return result;
	}

	public int sellPumpkinSeedGetCoin(int sellAmount, int pumpkinSeedPrice, int userNo) {
		
		int result = sellCropsService.sellPumpkinSeedGetCoin(sellAmount, pumpkinSeedPrice, userNo);
		
		return result; 
	}
		
		


	








}