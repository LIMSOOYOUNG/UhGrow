package com.farm3.uhgrow.farm.model.dto;

import java.io.Serializable;

public class RetainToolDTO implements Serializable {
	private int userNo;
	private int toolId;
	private char retainToolYn;
	
	public RetainToolDTO() {}

	public RetainToolDTO(int userNo, int toolId, char retainToolYn) {
		super();
		this.userNo = userNo;
		this.toolId = toolId;
		this.retainToolYn = retainToolYn;
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

	public char getRetainToolYn() {
		return retainToolYn;
	}

	public void setRetainToolYn(char retainToolYn) {
		this.retainToolYn = retainToolYn;
	}

	@Override
	public String toString() {
		return "RetainToolDTO [userNo=" + userNo + ", toolId=" + toolId + ", retainToolYn=" + retainToolYn + "]";
	}
	
	
	
}
