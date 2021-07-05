package com.farm3.uhgrow.member.model.dto;

public class FindIdPwdDTO implements java.io.Serializable{
	
	private String userId;
	private String userName;
	private String userPwd;
	private String mail;
	
	public FindIdPwdDTO() {}
	public FindIdPwdDTO(String userId, String userName, String userPwd, String mail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.mail = mail;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "FindIdPwdDTO [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", mail=" + mail
				+ "]";
	}

	
	
}
