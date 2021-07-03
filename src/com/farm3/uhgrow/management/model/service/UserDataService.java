package com.farm3.uhgrow.management.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.management.model.dao.UserDataDAO;
import com.farm3.uhgrow.management.model.dto.ModifyUserDTO;
import com.farm3.uhgrow.management.model.dto.SelectUserDTO;

public class UserDataService {
	
	private static UserDataDAO userDataDAO;
	
	public UserDataService() {
		this.userDataDAO = new UserDataDAO();
	}

	public static List<SelectUserDTO> selectAllUserData() {
		Connection con = getConnection();
		List<SelectUserDTO> userList = userDataDAO.selectAllUserData(con);
		close(con);
		return userList;
	}

	public static int modifyUserData(ModifyUserDTO modifyUserInfo) {
		Connection con = getConnection();
		int result = UserDataDAO.modifyUserData(con, modifyUserInfo);
		close(con);
		return result;
	}

	public static List<SelectUserDTO> selectDeleteUserData() {
		Connection con = getConnection();
		List<SelectUserDTO> userList = userDataDAO.selectDeleteUserData(con);
		close(con);
		return userList;
		
	}

	public static List<SelectUserDTO> selectRecoverUserData() {
		Connection con = getConnection();
		List<SelectUserDTO> userList = userDataDAO.selectRecoverUserData(con);
		close(con);
		return userList;
	}

	public static int deleteUserData(String userId) {
		Connection con = getConnection();
		int result = userDataDAO.deleteUserData(con, userId);
		close(con);
		return result;
	}

	public static int recoverUserData(String userId) {
		Connection con = getConnection();
		int result = userDataDAO.recoverUserData(con, userId);
		close(con);
		return result;
	}

}