package com.farm3.uhgrow.sellcrops.model.dto;

public class ToolDTO {
	
	private int userNo;	  	  		 // 회원 아이디
	private String toolName;		 // 농기구 이름
	private int toolId;				 // 농기구 아이디
	private int coin;		 		 // 회원 보유 코인
	private int toolPrice; 		     // 농기구 가격 

	public ToolDTO() {}

	public ToolDTO(int userNo, String toolName, int toolId, int coin, int toolPrice) {
		super();
		this.userNo = userNo;
		this.toolName = toolName;
		this.toolId = toolId;
		this.coin = coin;
		this.toolPrice = toolPrice;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public int getToolId() {
		return toolId;
	}

	public void setToolId(int toolId) {
		this.toolId = toolId;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getToolPrice() {
		return toolPrice;
	}

	public void setToolPrice(int toolPrice) {
		this.toolPrice = toolPrice;
	}

	@Override
	public String toString() {
		return "ToolDTO [userNo=" + userNo + ", toolName=" + toolName + ", toolId=" + toolId + ", coin=" + coin
				+ ", toolPrice=" + toolPrice + "]";
	}
	
	


}
