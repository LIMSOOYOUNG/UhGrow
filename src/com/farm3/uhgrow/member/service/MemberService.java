package com.farm3.uhgrow.member.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.farm3.uhgrow.buy.model.dao.BuyDAO;
import com.farm3.uhgrow.member.model.dao.MemberDAO;
import com.farm3.uhgrow.member.model.dto.BuyHouseDTO;
import com.farm3.uhgrow.member.model.dto.FindIdPwdDTO;
import com.farm3.uhgrow.member.model.dto.LoginDTO;
import com.farm3.uhgrow.member.model.dto.SignUpDTO;

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

	public LoginDTO loginInfo(String loginId) {
		Connection con = getConnection();

		LoginDTO dto = memberDAO.loginInfo(con, loginId);
		close(con);


		return dto;
	}

	public String StartGameContinueYn(int userNo) {

		Connection con = getConnection();

		String continueYn = memberDAO.StartGameContinueYn(con, userNo);

		close(con);
		return continueYn;
	}

	public int startNewGameDataReset(int userNo) {
		Connection con = getConnection();
		int result = memberDAO.startNewGameDataReset(con, userNo);

		close(con);
		System.out.println(result);
		return result;
	}


	public FindIdPwdDTO findId(FindIdPwdDTO findIdPwdDTO) {
		Connection con = getConnection();

		FindIdPwdDTO resultId = memberDAO.findId(con, findIdPwdDTO);

		close(con);
		
		return resultId;
	}

	public int findPwd(FindIdPwdDTO findPwdDTO) {
		Connection con = getConnection();
		
		int resultFindPwd = memberDAO.findPwd(con, findPwdDTO);
		
		close(con);
		
		
		
		return resultFindPwd;
	}

	public int changePwd(FindIdPwdDTO findPwdDTO) {
		Connection con = getConnection();
		
		int result = 0;
		
		String checkPwd = memberDAO.checkPwd(con, findPwdDTO);
		
		if(!checkPwd.equals(findPwdDTO.getUserPwd())) {
			
			result = memberDAO.changePwd(con, findPwdDTO);
			
		}
		close(con);
		
		return result;
	}

	// 집 구매
	public BuyHouseDTO buyHouse(int userNo) {
		Connection con = getConnection();
		
		BuyHouseDTO buyHouseDTO = memberDAO.buyHouse(con, userNo);
		
		close(con);

		return buyHouseDTO;
	}

	public void ending(int userNo) {
		Connection con = getConnection();
		
		memberDAO.ending(con, userNo);
		
		close(con);
		
	}





}
