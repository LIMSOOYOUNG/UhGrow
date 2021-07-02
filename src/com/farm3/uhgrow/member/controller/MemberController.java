package com.farm3.uhgrow.member.controller;

import java.util.Map;

import com.farm3.uhgrow.farm.view.FarmPanel;
import com.farm3.uhgrow.member.model.dto.SignUpDTO;
import com.farm3.uhgrow.member.model.dto.UserDTO;
import com.farm3.uhgrow.member.service.MemberService;

public class MemberController {

	MemberService memberService = new MemberService();
	

	public int signUpMember(Map<String, String> map) {
	
		SignUpDTO dto = new SignUpDTO();
		
		dto.setUserId(map.get("signUpId"));
		dto.setUserPwd(map.get("signUpPwd"));
		dto.setUserName(map.get("signUpName"));
		dto.setEmail(map.get("signUpMail"));
		
		int signUpResult = memberService.signUpMember(dto);
		
		return signUpResult;
		
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
