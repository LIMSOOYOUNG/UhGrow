package com.farm3.uhgrow.buy.view;

import java.util.Scanner;

import com.farm3.uhgrow.buy.controller.BuyController;

public class BuyView {
	
	
	Scanner sc = new Scanner(System.in);
	BuyController buyController = null;
	
	public BuyView() {
		this.buyController = new BuyController();
	}
	
	public void displayBuyMenu() {
		
		do {
			
			System.out.println("1. 집구매로 이동");
			System.out.println("2. 씨앗 구매로 이동");
			System.out.println("3. 농기구 구매로 이동");
			
			int no = sc.nextInt();
			sc.nextLine();
			
			switch(no) {
			case 1 : moveBuyHouse(); 
			case 2 : moveBuySeed();
			case 3 : moveBuyTool();
			
			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			
			}
		} while(true);
		
	}
	
	private void moveBuyTool() {
		
	}

	private void moveBuySeed() {
		
	}

	private void moveBuyHouse() {
		
		
			System.out.println("집을 구매하시겠습니까?(y/n)");
			String answer = sc.next();
			if (answer.equals("y")||answer.equals("Y")) {
				System.out.println("집구매 성공!");
			} else {
				System.out.println("집구매 실패!");
			} 
		
	} 

}
