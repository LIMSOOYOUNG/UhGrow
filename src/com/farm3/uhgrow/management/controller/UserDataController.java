package com.farm3.uhgrow.management.controller;

import java.util.List;

import com.farm3.uhgrow.management.model.dto.UserDTO;
import com.farm3.uhgrow.management.model.service.UserDataService;

public class UserDataController {

	public UserDataController() {
		this.userDataService = new UserDataService();
	}
	private UserDataService userDataService = new UserDataService();
	public List<UserDTO> selectAllUserData() {
		List<UserDTO> userList = UserDataService.selectAllUserData();
		return userList;
	}
	public void modifyUserData(String inputUserId, String inputNewId, String inputNewPwd) {
		UserDTO modifyUserInfo = new UserDTO();
		
		
	}
	


}
