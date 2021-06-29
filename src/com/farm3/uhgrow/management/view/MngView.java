package com.farm3.uhgrow.management.view;

import java.util.Scanner;

import com.farm3.uhgrow.management.controller.GameDataController;
import com.farm3.uhgrow.management.controller.UserDataController;

public class MngView {
	
	private Scanner sc = new Scanner(System.in);
	
	public void mngMenu() {
		
		do {
			System.out.println("\n ***** 관리자 모드 ***** \n");
			System.out.println("1. 회원관리");
			System.out.println("2. 게임관리");
			System.out.println("9. 돌아가기");
			System.out.print("번호 선택 : ");
			int inputNo = sc.nextInt();
			
			switch(inputNo) {
			case 1: userDataMenu(); break;
			case 2: gameDataMenu(); break;
			case 9: return;
			default : System.out.println("다시 입력해주세요."); break;
			}
		} while(true);
	}
	
	public void userDataMenu() {
		UserDataController userDataController = new UserDataController();
		do {
			System.out.println("\n ***** 회원관리 ***** \n");
			System.out.println("1. 회원정보 조회 및 수정");
			System.out.println("2. 회원정보 삭제");
			System.out.println("3. 회원정보 복구");
			System.out.println("9. 돌아가기");
			System.out.print("번호 입력 : ");
			int inputNo = sc.nextInt();
			sc.nextLine();
			switch(inputNo) {
			case 1: userDataController.selectAllUserData(); 
			        userDataController.modifyUserData(inputUserId(), inputNewId(), inputNewPwd());
			        break;
			case 2: break;
			case 3: break;
			case 9: return;
			default : System.out.println("다시 입력해주세요"); break;
			
			}
		} while(true);
	}
	
	public void gameDataMenu() {
		System.out.println("\n ***** 게임관리 ***** \n");
		System.out.println("1. 요리 수정");
		System.out.println("2. 농작물 가격 수정");
		System.out.println("3. 집 가격 수정");
		System.out.print("번호 입력 : ");
		int inputNo = sc.nextInt();
		sc.nextLine();
		switch(inputNo) {
		case 1: modifyFoodMenu(); break;
		case 2: GameDataController.modifyCropPrice(inputTomatoPrice(), inputCornPrice(), inputGarlicPrice(), inputPumpkinPrice()); break;
		}
	}
	
	public void modifyFoodMenu() {
		
	}
	
	public String inputUserId() {
		System.out.print("회원 아이디 : ");
		return sc.nextLine();
	}
	
	public String inputNewId() {
		System.out.print("새로운 아이디 : ");
		return sc.nextLine();
	}
	
	public String inputNewPwd() {
		System.out.print("새로운 비밀번호 : ");
		return sc.nextLine();
	}
	
	public int inputTomatoPrice() {
		System.out.print("토마토 변경 가격 : ");
		return sc.nextInt();
	}
	
	public int inputCornPrice() {
		System.out.print("옥수수 변경 가격 : ");
		return sc.nextInt();
	}
	
	public int inputGarlicPrice() {
		System.out.print("마늘 변경 가격 : ");
		return sc.nextInt();
	}
	
	public int inputPumpkinPrice() {
		System.out.print("호박 변경 가격 : ");
		return sc.nextInt();
	}
}
