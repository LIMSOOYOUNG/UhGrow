package com.farm3.uhgrow.member.controller;

import java.util.Map;

import com.farm3.uhgrow.farm.view.MainFrame;
import com.farm3.uhgrow.member.model.dto.SignUpDTO;
import com.farm3.uhgrow.member.model.dto.UserDTO;
import com.farm3.uhgrow.member.service.MemberService;

public class MemberController {

	MemberService memberService = new MemberService();
	

	public void signUpMember(Map<String, String> map) {
	
		SignUpDTO dto = new SignUpDTO();
		
		dto.setUserId(map.get("userId"));
		dto.setUserPwd(map.get("userPwd"));
		dto.setUserName(map.get("userName"));
		dto.setEmail(map.get("email"));
		
		int signUpResult = memberService.signUpMember(dto);
		
		if(signUpResult > 0) {
			// 성공 출력 
			System.out.println("성공");
		} else {
			// 실패 출력
			System.out.println("실패");
		}
	}
	
	public UserDTO loginInfo(Map<String, String> map) {
	
		
		String loginId = map.get("loginId");
		String loginPwd = map.get("loginPwd");
		UserDTO loginResult = memberService.loginInfo(loginId);
	

		return loginResult;
		
	}
	
	public void selectFindId() {}
	
	public void selectFindPwd() {}
	
}
