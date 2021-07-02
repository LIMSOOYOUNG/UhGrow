package com.farm3.uhgrow.management.model.dto;

public class SelectUserDTO implements java.io.Serializable {
	
	private int userNo;
	private String userId;
	private String userPwd;
	
	public SelectUserDTO() {}

	public SelectUserDTO(int userNo, String userId, String userPwd) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public int getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "SelectUserDTO [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + "]";
	}
	
	

}
