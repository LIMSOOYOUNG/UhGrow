package com.farm3.uhgrow.sellcrops.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.farm3.uhgrow.sellcrops.controller.sell.SellCropsController;
import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

public class SellCropsView {

//	private Scanner sc = new Scanner(System.in);

	public void sellCropMenu() {

		List<CropDTO> userCropList = new ArrayList<>();
		int getPrice = 0;
		
		SellCropsController sellCropsController = new SellCropsController();
		
		Scanner sc = new Scanner(System.in);
		
		
		
		
		
//		SellCropsController sellCropsController = new SellCropsController();
//
//		do {
//			System.out.println("-- 농작물 판매창 --");
//			System.out.println("1. 토마토 판매");
//			System.out.println("2. 옥수수 판매");
//			System.out.println("3. 마늘 판매");
//			System.out.println("4. 호박 판매");
//			System.out.println("5. 돌아가기");
//			int no = sc.nextInt();
//
//			switch (no) {
//			case 1:
//				sellCropsController.sellTomato(sellCrops());
//			case 2:
//				sellCropsController.sellCorns(sellCrops());
//			case 3:
//				sellCropsController.sellGalic(sellCrops());
//			case 4:
//				sellCropsController.sellPumpkin(sellCrops());
//			case 5:
//				return;
//			default: System.out.println("다시 입력");
//
//			}
//
//		} while (true);
//
//	}
//
//	public Map<Object, Object> sellCrops() {
//
//		sc.nextLine();
//		System.out.print("회원 아이디를 입력하세요 : ");
//		String userId = sc.nextLine();
//		System.out.print("판매할 작물을 입력하세오 : ");
//		String cropName = sc.nextLine();
//		System.out.print("판매할 작물 갯수를 입력하세요 :");
//		int sellAmount = sc.nextInt();
//
//		Map<Object, Object> map = new HashMap<>();
//
//		map.put("userId", userId);
//		map.put("CropName", cropName);
//		map.put("sellAmount", sellAmount);
//
//		return map;

	}

}
