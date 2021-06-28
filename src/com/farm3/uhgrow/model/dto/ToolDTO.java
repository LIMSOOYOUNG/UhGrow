package com.farm3.uhgrow.model.dto;

public class ToolDTO {

	private int toolId; 			// 농기구아이디
	private String toolName;		// 농기구이름
	private int plusExp; 			// 농기구추가경험치
	private int toolPrice;			// 농기구가격
	public ToolDTO(int toolId, String toolName, int plusExp, int toolPrice) {
		super();
		this.toolId = toolId;
		this.toolName = toolName;
		this.plusExp = plusExp;
		this.toolPrice = toolPrice;
	}
	public int getToolId() {
		return toolId;
	}
	public void setToolId(int toolId) {
		this.toolId = toolId;
	}
	public String getToolName() {
		return toolName;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	public int getPlusExp() {
		return plusExp;
	}
	public void setPlusExp(int plusExp) {
		this.plusExp = plusExp;
	}
	public int getToolPrice() {
		return toolPrice;
	}
	public void setToolPrice(int toolPrice) {
		this.toolPrice = toolPrice;
	}
	@Override
	public String toString() {
		return "ToolDTO [toolId=" + toolId + ", toolName=" + toolName + ", plusExp=" + plusExp + ", toolPrice="
				+ toolPrice + "]";
	}
	
	
}
