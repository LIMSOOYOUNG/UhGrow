package com.farm3.uhgrow.management.model.dao;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farm3.uhgrow.management.model.dto.ModifyUserDTO;
import com.farm3.uhgrow.management.model.dto.SelectUserDTO;

public class UserDataDAO {
	
	private static Properties prop;
	
	public UserDataDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/user-data.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<SelectUserDTO> selectAllUserData(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SelectUserDTO> userList = null;
		String query = prop.getProperty("selectAllUser");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			userList = new ArrayList<>();
			
			while(rset.next()) {
				SelectUserDTO row = new SelectUserDTO();
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

	public static int modifyUserData(Connection con, ModifyUserDTO modifyUserInfo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyIdPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, modifyUserInfo.getNewId());
			pstmt.setString(2, modifyUserInfo.getNewPwd());
			pstmt.setString(3, modifyUserInfo.getOldId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
