package com.farm3.uhgrow.management.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farm3.uhgrow.management.model.dto.UserDTO;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class UserDataDAO {
	
	private Properties prop;
	
	public UserDataDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/user-data.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<UserDTO> selectAllUserData(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<UserDTO> userList = null;
		String query = prop.getProperty("selectAllUser");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			userList = new ArrayList<>();
			
			while(rset.next()) {
				UserDTO row = new UserDTO();
				row.setUserNo(rset.getInt("USER_NO"));
				row.setUserId(rset.getString("USER_ID"));
				row.setUserPwd(rset.getString("USER_PWD"));
				
				userList.add(row);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userList;
	}

}
