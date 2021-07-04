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

import oracle.net.aso.c;

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

	public int startNewGameDataReset(Connection con, int userNo) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;

		int result = 0;

		String query1 = prop.getProperty("resetUserInfo");
		String query2 = prop.getProperty("deleteToolList");
		String query3 = prop.getProperty("deleteFarmCrop");
		String query4 = prop.getProperty("resetCropAmount");
		String query5 = prop.getProperty("resetFoodAmount");
				
		try {
			pstmt1 = con.prepareStatement(query1);
			pstmt1.setInt(1, userNo);
			result += pstmt1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			pstmt2 = con.prepareStatement(query2);
			pstmt2.setInt(1, userNo);
			result += pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt2);
		}
		
		try {
			pstmt3 = con.prepareStatement(query3);
			pstmt3.setInt(1, userNo);
			result += pstmt3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt3);
		}
		
		try {
			pstmt4 = con.prepareStatement(query4);
			pstmt4.setInt(1, userNo);
			result += pstmt4.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt4);
			
		}
		try {
			pstmt5 = con.prepareStatement(query5);
			pstmt5.setInt(1, userNo);
			result += pstmt5.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt5);
		}
	
		return result;
	}


}
