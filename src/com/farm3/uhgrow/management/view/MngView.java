package com.farm3.uhgrow.management.view;

import java.util.Scanner;

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
			
			switch(inputNo) {
			case 1: userDataController.selectAllUserData(); 
			        userDataController.modifyUserData(inputUserId(), inputNewId(), inputNewPwd());
			        break;
			
			}
		} while(true);
	}
	
	public void gameDataMenu() {
		
	}
	
	public String inputUserId() {
		System.out.print("회원 아이디 : ");
		sc.nextLine();
		return sc.nextLine();
	}
	
	public String inputNewId() {
		System.out.print("새로운 아이디 : ");
		sc.nextLine();
		return sc.nextLine();
	}
	
	public String inputNewPwd() {
		System.out.print("새로운 비밀번호 : ");
		sc.nextLine();
		return sc.nextLine();
	}
}
