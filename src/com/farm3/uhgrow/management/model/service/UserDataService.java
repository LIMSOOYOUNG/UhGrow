package com.farm3.uhgrow.management.model.service;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.management.model.dao.UserDataDAO;
import com.farm3.uhgrow.management.model.dto.UserDTO;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class UserDataService {
	
	private static UserDataDAO userDataDAO;
	
	public UserDataService() {
		this.userDataDAO = new UserDataDAO();
	}

	public static List<UserDTO> selectAllUserData() {
		Connection con = getConnection();
		List<UserDTO> userList = userDataDAO.selectAllUserData(con);
		close(con);
		return userList;
	}

}
