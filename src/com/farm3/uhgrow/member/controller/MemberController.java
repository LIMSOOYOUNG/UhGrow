package com.farm3.uhgrow.member.controller;

import java.util.Map;

import com.farm3.uhgrow.member.model.dto.InputMemberDTO;
import com.farm3.uhgrow.member.service.MemberService;

public class MemberController {

	MemberService memberService = new MemberService();
	

	public void signUpMember(Map<String, String> map) {
	
		InputMemberDTO dto = new InputMemberDTO();
		
		dto.setMemberId(map.get("memberId"));
		dto.setMemberPwd(map.get("MemberPwd"));
		dto.setMemberName(map.get("memberName"));
		dto.setEmail(map.get("email"));
		
		int resultSignUpResult = memberService.signUpMember(dto);
		
		if(resultSignUpResult > 0) {
			// 성공 출력 
			System.out.println("성공");
		} else {
			// 실패 출력
			System.out.println("실패");
		}
	}
	
	public void loginInfo() {
		
	}
	
	public void selectFindId() {}
	
	public void selectFindPwd() {}
	
}
