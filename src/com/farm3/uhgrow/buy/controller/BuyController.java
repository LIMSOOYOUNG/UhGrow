package com.farm3.uhgrow.buy.controller;


import java.util.Map;

import com.farm3.uhgrow.buy.model.dto.BuyDTO;
import com.farm3.uhgrow.buy.service.BuyService;


public class BuyController {

	BuyService buyService = new BuyService();


	public void buyNewHouse(Map<Object, Object> map) {

		BuyDTO dto = new BuyDTO();
		
		dto.setHavingHouseYn((char) map.get("HouseYn"));
		dto.setCoin((int) map.get("Coin"));
		
	
		int resultbuyHouseResult = buyService.buyNewHouse(dto);

		if(resultbuyHouseResult > 0) {
			System.out.println("집 구매 성공");
		} else {
			System.out.println("집 구매 실패");
		}  
	}
}
