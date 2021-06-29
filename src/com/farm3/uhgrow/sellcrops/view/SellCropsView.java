package com.farm3.uhgrow.sellcrops.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.farm3.uhgrow.sellcrops.controller.sell.SellCropsController;
import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

public class SellCropsView {

	private SellCropsController sellCropsController = new SellCropsController();
	private CropDTO cropDTO = new CropDTO();
	
	public void sellCropMenu() {

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("==농작물 판매==");
			
			List<CropDTO> userCropList = sellCropsController.userCropList(cropDTO);
			 
			
			
		} while(true);
		
		
		
		
		
	}

}
