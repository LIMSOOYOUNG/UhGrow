package com.farm3.uhgrow.member.model.dao;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.farm3.uhgrow.member.model.dto.LoginDTO;
import com.farm3.uhgrow.member.model.dto.SignUpDTO;

public class MemberDAO {

	Properties prop;

	public MemberDAO(){
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int signUpMember(Connection con, SignUpDTO dto) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("signUpMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPwd());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getEmail());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);

		}


		return result;
	}

	public LoginDTO loginInfo(Connection con, String loginId) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		LoginDTO dto = null;

		String query = prop.getProperty("tryRogin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginId);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				dto = new LoginDTO();

				dto.setUserNo(rset.getInt("USER_NO"));
				dto.setUserId(rset.getString("USER_ID"));
				dto.setUserPwd(rset.getString("USER_PWD"));
				dto.setDeleteYn(rset.getString("DELETE_YN").charAt(0));
				//		dto.setContinueYn(rset.getString("CONTINUE_YN").charAt(0));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		// 입력한 아이디와 일치할때 유저 정보 넘겨줌
		return dto;
	}

	public String StartGameContinueYn(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String continueYn = null;

		String query = prop.getProperty("continueYn");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				continueYn = rset.getString("CONTINUE_YN");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return continueYn;
	}


}
