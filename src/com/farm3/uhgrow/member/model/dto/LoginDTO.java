package com.farm3.uhgrow.member.model.dto;

public class LoginDTO {

	private int userNo;
	private String userPwd;					// 유저비밀번호
	private String userId;
	private char deleteYn;		

	public LoginDTO() {}

	public LoginDTO(int userNo, String userPwd, String userId, char deleteYn) {
		super();
		this.userNo = userNo;
		this.userPwd = userPwd;
		this.userId = userId;
		this.deleteYn = deleteYn;
	}


	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public char getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(char deleteYn) {
		this.deleteYn = deleteYn;
	}


	@Override
	public String toString() {
		return "LoginDTO [userNo=" + userNo + ", userPwd=" + userPwd + ", userId=" + userId + ", deleteYn=" + deleteYn
				+ "]";
	}

}
