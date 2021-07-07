package com.farm3.uhgrow.sellcrops.controller.sell;

import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dto.FoodDTO;
import com.farm3.uhgrow.sellcrops.model.service.SellFoodService;

public class SellFoodController {

	private FoodDTO foodDTO = new FoodDTO();
	private SellFoodService sellFoodService = new SellFoodService();
	
	/*재화 라벨*/ 
	public int selectCoin(int userNo) {
		
		int result = sellFoodService.selectCoin(userNo);
		return result;
	}

	/*유저 토마토 피자수량 조회*/
	public List<FoodDTO> userTomatoPizza(int userNo) {
		
		List<FoodDTO> userTomatoPizza = sellFoodService.userTomatoPizza(userNo);
		
		return userTomatoPizza;
	}
	
	/*토마토 피자 수량 업데이트*/
	public int updateUserTomatoPizzaAmount(int sellAmount, int userNo) {
		
		int result = sellFoodService.updateUserTomatoPizzaAmount(sellAmount, userNo);
		
		return result;
	}
	
	/*토마토 피자 팔고 받는 돈*/	
	public int sellTomatoPizzaGetCoin(int sellAmount, int tomatoPizzaPrice, int userNo) {
		
		int result = sellFoodService.sellTomatoPizzaGetCoin(sellAmount, tomatoPizzaPrice, userNo);
		
		return result;
	}
	
	
	/* 옥수수 또띠아*/
	public List<FoodDTO> userCornTotilla(int userNo) {
		
		List<FoodDTO> userCornTotilla = sellFoodService.userCornTotilla(userNo);
		
		return userCornTotilla;
	}
	
	/*옥수수 또띠아 수량 업데이트*/
	public int updateUserCornTotillaAmount(int sellAmount, int userNo) {
		
		int result = sellFoodService.updateUserCornTotillaAmount(sellAmount, userNo);
		
		return result;
	}
	
	/* 옥수수 팔고 받는 코인*/
	public int sellCornTotillaGetCoin(int sellAmount, int cornTortillaPrice, int userNo) {
	
		int result = sellFoodService.sellCornTotillaGetCoin(sellAmount, cornTortillaPrice, userNo);
		
		return result;
	}
	
	/*마늘즙*/
	public List<FoodDTO> usergarlicJuice(int userNo) {
		
		List<FoodDTO> usergarlicJuice = sellFoodService.userGarlicJuice(userNo);
		
		return usergarlicJuice;
	}
	
	/*마늘즙 수량 업데이트*/
	public int updateUserGarlicJuiceAmount(int sellAmount, int userNo) {	
		
		int result = sellFoodService.updateUserGarlicJuiceAmount(sellAmount, userNo);
		
		return result;
	}
	
	/*마늘즙 팔고 받는 코인*/
	public int sellGarlicJuiceGetCoin(int sellAmount, int garilcJuicePrice, int userNo) {
		
		int result = sellFoodService.sellGarlicJuiceGetCoin(sellAmount, garilcJuicePrice, userNo);
		
		return result;
	}
	
	
	/*호박죽*/
	public List<FoodDTO> userPumpkinSoup(int userNo) {
		
		List<FoodDTO> userPumpkinSoup = sellFoodService.userPumpkinSoup(userNo);
		
		return userPumpkinSoup;
	}
	
	/*호박죽 수량 업데이트*/
	public int updateUserPumpkinSoupAmount(int sellAmount, int userNo) {
		
		int result = sellFoodService.updateUserPumpkinSoupAmount(sellAmount, userNo);
		
		return result;
	}
	
	/*호박죽 팔고 받는 코인*/
	public int sellPumpkinSoupGetCoin(int sellAmount, int pumpkinSoupPrice, int userNo) {

		int result = sellFoodService.sellPumpkinSoupGetCoin(sellAmount, pumpkinSoupPrice, userNo);
		
		return result;
	}







	
	
}
