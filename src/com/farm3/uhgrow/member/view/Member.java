package com.farm3.uhgrow.member.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.farm3.uhgrow.member.controller.MemberController;

public class Member {

	Scanner sc = new Scanner(System.in);
	public void displayMenu() {

		
		MemberController memberController = new MemberController();

		do {
	
			System.out.println("1. 회원가입 ");
			System.out.println("2. 아이디와 비밀번호를 이용해 정보 일치시 로그인 기능");
			System.out.println("3. 이름, 이메일로 아이디 찾기");
			System.out.println("4. 아이디, 이름, 이메일로 비밀번호 변경");
			
			int no = sc.nextInt();
				
			switch(no) {
			case 1 : memberController.signUpMember(inputMember()); break;
			case 2 : memberController.loginInfo(); break;
			case 3 : memberController.selectFindId(); break;
			case 4 : memberController.selectFindPwd(); break;

			default : System.out.println("잘못된 번호입니다. 다시 입력해주세요. \n");

			}

		}while(true);

	}

	private Map<String, String> inputMember() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		sc.nextLine();
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비번 : ");
		String memberPwd = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		map.put("memberId", memberId);
		map.put("memberPwd", memberPwd);
		map.put("memberName", memberName);
		map.put("email", email);
		
		return map;
	}

	
}
