package com.farm3.uhgrow.member.controller;

import java.util.Map;

import com.farm3.uhgrow.member.model.dto.FindIdPwdDTO;
import com.farm3.uhgrow.member.model.dto.LoginDTO;
import com.farm3.uhgrow.member.model.dto.SignUpDTO;
import com.farm3.uhgrow.member.service.MemberService;

public class MemberController {

	private MemberService memberService = new MemberService();
	private FindIdPwdDTO findIdPwdDTO = new FindIdPwdDTO();
	

	public int signUpMember(Map<String, String> map) {
	
		SignUpDTO dto = new SignUpDTO();
		
		dto.setUserId(map.get("signUpId"));
		dto.setUserPwd(map.get("signUpPwd"));
		dto.setUserName(map.get("signUpName"));
		dto.setEmail(map.get("signUpMail"));
		
		int signUpResult = memberService.signUpMember(dto);
		
		return signUpResult;
		
	}
	
	public LoginDTO loginInfo(String loginId) {
	
		LoginDTO loginResult = memberService.loginInfo(loginId);
			
		return loginResult;
		
	}
	
	public void selectFindId() {}
	
	public void selectFindPwd() {}

	public String StartGameContinueYn(int userNo) {
		
		String continueYn = memberService.StartGameContinueYn(userNo);
		
		return continueYn;
	}

	public int startNewGameDataReset(int userNo) {
		int result = memberService.startNewGameDataReset(userNo);
		
		return result;
	}

	public FindIdPwdDTO findId(String fieldName, String fieldMail) {
		
		
		
		findIdPwdDTO.setUserName(fieldName);
		findIdPwdDTO.setMail(fieldMail);
		
		FindIdPwdDTO resultId = memberService.findId(findIdPwdDTO);
		
		return resultId;
	}

	public int findPwd(Map<String, String> insertUserInfo) {
		
		FindIdPwdDTO findPwdDTO = new FindIdPwdDTO();
		
		findPwdDTO.setUserId(insertUserInfo.get("insertId"));
		findPwdDTO.setUserName(insertUserInfo.get("insertName"));
		findPwdDTO.setMail(insertUserInfo.get("insertMail"));
		
		int result = memberService.findPwd(findPwdDTO);
		
		
		return result;
	}

	public int changePwd(Map<String, String> insertUserInfoForChangePwd) {
		FindIdPwdDTO findPwdDTO = new FindIdPwdDTO();
		
		findPwdDTO.setUserPwd(insertUserInfoForChangePwd.get("insertPwd"));
		findPwdDTO.setUserId(insertUserInfoForChangePwd.get("userId"));
		findPwdDTO.setUserName(insertUserInfoForChangePwd.get("userName"));
		findPwdDTO.setMail(insertUserInfoForChangePwd.get("userMail"));
		
		int result = memberService.changePwd(findPwdDTO);
		
		
		return result;
	}


	
}
