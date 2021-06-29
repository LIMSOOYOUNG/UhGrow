package com.farm3.uhgrow.member.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.farm3.uhgrow.member.controller.MemberController;

public class Member{

	Scanner sc = new Scanner(System.in);
	MemberController memberController = null;
	
	public Member () {
		this.memberController = new MemberController();
	}
	public void displayMenu() {

		

		do {
	
			System.out.println("1. 회원가입 창으로 이동 ");
			System.out.println("2. 아이디와 비밀번호를 이용해 정보 일치시 로그인 기능");
			System.out.println("3. id, pwd 찾기 창으로 이동 ");
			System.out.println("4. 관리자모드 창으로 이동 ");
			
			int no = sc.nextInt();
			sc.nextLine();
			
				
			switch(no) {
			case 1 : memberController.signUpMember(inputMember()); break;
			case 2 : memberController.loginInfo(login()); break;
			case 3 : findUserInfo(); break;
//			case 4 : 관리자 로그인창

			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요. \n");

			}

		}while(true);

	}
	

	private void findUserInfo() {
		
		do {
			
			System.out.println("1. 이름, 메일을 이용해 id찾기  ");
			System.out.println("2. 아이디 이름 메일을 이용해 pwd 변경 ");
			System.out.println("3. 돌아가기");
			
			int no = sc.nextInt();
			sc.nextLine();
			
				
			switch(no) {
			case 1 : memberController.selectFindId(); break;
			case 2 : memberController.selectFindPwd(); break;
			case 3 : return;

			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요. \n");

			}

		}while(true);

	
		
	}


	public Map<String, String> inputMember() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비번 : ");
		String userPwd = sc.nextLine();
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		map.put("userId", userId);
		map.put("userPwd", userPwd);
		map.put("userName", userName);
		map.put("email", email);
		
		return map;
	}
	public Map<String, String> login(){
		
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("비번 : ");
		String pwd = sc.nextLine();

		map.put("loginId", id);
		map.put("loginPwd", pwd);
		
		return map;
		
	}

	
}
