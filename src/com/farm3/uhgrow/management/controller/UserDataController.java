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
	public int modifyUserData(String inputUserId, String inputNewId, String inputNewPwd) {
		ModifyUserDTO modifyUserInfo = new ModifyUserDTO();
		modifyUserInfo.setOldId(inputUserId);
		modifyUserInfo.setNewId(inputNewId);
		modifyUserInfo.setNewPwd(inputNewPwd);
		
		int result = UserDataService.modifyUserData(modifyUserInfo);
		
		return result;
		
		
	}
	public List<SelectUserDTO> selectDeleteUserData() {
		List<SelectUserDTO> userList = UserDataService.selectDeleteUserData();
		return userList;
	}
	public List<SelectUserDTO> selectRecoverUserData() {
		List<SelectUserDTO> userList = UserDataService.selectRecoverUserData();
		return userList;
	}
	public int deleteUserData(String userId) {
		int result = UserDataService.deleteUserData(userId);
		return result;
	}
	public int recoverUserData(String userId) {
		int result = UserDataService.recoverUserData(userId);
		return result;
	}
	


}