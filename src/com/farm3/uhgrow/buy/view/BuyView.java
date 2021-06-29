package com.farm3.uhgrow.buy.view;

import java.util.Scanner;

import com.farm3.uhgrow.buy.controller.BuyController;

public class BuyView {
	
	Scanner sc = new Scanner(System.in);
	public void displayBuyMenu() {
		
		BuyController buyController = new BuyController();
		
		do {
			
			System.out.println("1. 집구매");
			
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : buyController.buyNewHouse(null);
			
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요. \n");
			
			}
		} while(true);
		
	}

}
