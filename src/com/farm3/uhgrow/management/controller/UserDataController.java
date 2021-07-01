package com.farm3.uhgrow.management.controller;

import java.util.List;

import com.farm3.uhgrow.management.model.dto.ModifyUserDTO;
import com.farm3.uhgrow.management.model.dto.SelectUserDTO;
import com.farm3.uhgrow.management.model.service.UserDataService;
import com.farm3.uhgrow.management.view.MngResultView;

public class UserDataController {

	public UserDataController() {
		this.userDataService = new UserDataService();
	}
	private UserDataService userDataService = new UserDataService();
	
	public List<SelectUserDTO> selectAllUserData() {
		List<SelectUserDTO> userList = UserDataService.selectAllUserData();
//		MngResultView.listResult(userList)
		return userList;
	}
	public void modifyUserData(String inputUserId, String inputNewId, String inputNewPwd) {
		ModifyUserDTO modifyUserInfo = new ModifyUserDTO();
		modifyUserInfo.setOldId(inputUserId);
		modifyUserInfo.setNewId(inputNewId);
		modifyUserInfo.setNewPwd(inputNewPwd);
		
		int result = UserDataService.modifyUserData(modifyUserInfo);
		
		if(result > 0) {
			MngResultView.mngResult("modifySuccess");
		} else {
			MngResultView.mngResult("modifyFailed");
		}
		
		
	}
	public List<SelectUserDTO> selectDeleteUserData() {
		List<SelectUserDTO> userList = UserDataService.selectDeleteUserData();
		return userList;
	}
	public List<SelectUserDTO> selectRecoverUserData() {
		List<SelectUserDTO> userList = UserDataService.selectRecoverUserData();
		return userList;
	}
	


}
