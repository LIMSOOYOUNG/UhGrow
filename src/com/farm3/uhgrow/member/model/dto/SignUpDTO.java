package com.farm3.uhgrow.member.model.dto;

public class SignUpDTO {
	private String userId; 					// 유저아이디
	private String userPwd;					// 유저비밀번호
	private String userName;				// 유저이름
	private String email;					// 유저이메일
	
	public SignUpDTO() {}
	
	public SignUpDTO(String userId, String userPwd, String userName, String email) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SignUpDTO [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ "]";
	}

	
}
