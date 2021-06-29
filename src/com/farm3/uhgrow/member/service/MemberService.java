package com.farm3.uhgrow.member.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.farm3.uhgrow.member.model.dao.MemberDAO;
import com.farm3.uhgrow.member.model.dto.SignUpDTO;
import com.farm3.uhgrow.member.model.dto.UserDTO;

public class MemberService {

	MemberDAO memberDAO = new MemberDAO();
		
	public int signUpMember(SignUpDTO dto) {
		
		Connection con = getConnection();
		
		// dto로 회원가입 정보 입력받은값 전달받음 
		
		int result = 0;
		int signUpResult = memberDAO.signUpMember(con, dto);
		
		if (signUpResult > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public UserDTO loginInfo(String loginId) {
		Connection con = getConnection();
		
		UserDTO dto = memberDAO.loginInfo(con, loginId);
		
		
		return dto;
	}

}
