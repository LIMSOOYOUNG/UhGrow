package com.farm3.uhgrow.farm.model.dto;

import java.io.Serializable;

public class UserInfoDTO implements Serializable {
	private int userNo;
	private int farmExp;
	
	public UserInfoDTO(int userNo, int farmExp) {
		super();
		this.userNo = userNo;
		this.farmExp = farmExp;
	}
	
	public UserInfoDTO() {}
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getFarmExp() {
		return farmExp;
	}
	public void setFarmExp(int farmExp) {
		this.farmExp = farmExp;
	}
	@Override
	public String toString() {
		return "UserInfoDTO [userNo=" + userNo + ", farmExp=" + farmExp + "]";
	}
	
}
