package com.farm3.uhgrow.member.model.dto;

public class LoginDTO {

	
	private String userPwd;					// 유저비밀번호
	private String userName;				// 유저아이디
	
	public LoginDTO() {}
	
	public LoginDTO(String userPwd, String userName) {
		super();
		this.userPwd = userPwd;
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "LoginDTO [userPwd=" + userPwd + ", userName=" + userName + "]";
	}
	
	
}
