package com.farm3.uhgrow.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

import com.farm3.uhgrow.member.model.dto.InputMemberDTO;

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

	public int signUpMember(Connection con, InputMemberDTO dto) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("signUpMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPwd());
			pstmt.setString(3, dto.getMemberName());
			pstmt.setString(4, dto.getEmail());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		
		
		return result;
	}

}
