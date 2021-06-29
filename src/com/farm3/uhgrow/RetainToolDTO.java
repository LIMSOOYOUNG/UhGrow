package com.farm3.uhgrow;

public class RetainToolDTO implements java.io.Serializable{

	private int userNo;			// 회원번호
	private int toolId;			// 농기구 아이디
	
	public RetainToolDTO() {}	// 기본 생성자

	public RetainToolDTO(int userNo, int toolId) {		// 모든 필드 초기화 생성자
		super();
		this.userNo = userNo;
		this.toolId = toolId;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getToolId() {
		return toolId;
	}

	public void setToolId(int toolId) {
		this.toolId = toolId;
	}

	@Override
	public String toString() {
		return "RetainToolDTO [userNo=" + userNo + ", toolId=" + toolId + "]";
	}
	
}
