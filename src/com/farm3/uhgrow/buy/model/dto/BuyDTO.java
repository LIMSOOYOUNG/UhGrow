package com.farm3.uhgrow.buy.model.dto;

import java.io.Reader;
import java.util.List;

public class BuyDTO {
	
	private int cropId;       // 농작물아이디
	private String cropName;  // 농작물이름
	private int cropPrice;    // 농작물가격
	private String seedName;		// 씨앗 이름
	private int seedPrice;			// 씨앗 가격
	private int seedAmount;			// 씨앗 보유 수량
	private int toolId; 			// 농기구아이디
	private String toolName;		// 농기구이름
	private int toolPrice;			// 농기구가격
	private int coin;						// 재화
	private int housePrice;					// 집 가격
	private char havingHouseYn;	            // 집 보유 여부
	private List<BuyDTO> buyList;
	
	public BuyDTO() {}
	
	public BuyDTO(int cropId, String cropName, int cropPrice, String seedName, int seedPrice, int seedAmount,
			int toolId, String toolName, int toolPrice, int coin, int housePrice, char havingHouseYn) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropPrice = cropPrice;
		this.seedName = seedName;
		this.seedPrice = seedPrice;
		this.seedAmount = seedAmount;
		this.toolId = toolId;
		this.toolName = toolName;
		this.toolPrice = toolPrice;
		this.coin = coin;
		this.housePrice = housePrice;
		
	}
	
	public void setHavingHouseYn(char havingHouseYn) {
		this.havingHouseYn = havingHouseYn;
	}

	public List<BuyDTO> getBuyList() {
		return buyList;
	}
	
	public void setBuyList(List<BuyDTO> buyList) {
		this.buyList = buyList;
	}


	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public int getCropPrice() {
		return cropPrice;
	}

	public void setCropPrice(int cropPrice) {
		this.cropPrice = cropPrice;
	}

	public String getSeedName() {
		return seedName;
	}

	public void setSeedName(String seedName) {
		this.seedName = seedName;
	}

	public int getSeedPrice() {
		return seedPrice;
	}

	public void setSeedPrice(int seedPrice) {
		this.seedPrice = seedPrice;
	}

	public int getSeedAmount() {
		return seedAmount;
	}

	public void setSeedAmount(int seedAmount) {
		this.seedAmount = seedAmount;
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

	public int getToolPrice() {
		return toolPrice;
	}

	public void setToolPrice(int toolPrice) {
		this.toolPrice = toolPrice;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	public char getHavingHouseYn() {
		return havingHouseYn;
	}

	@Override
	public String toString() {
		return "BuyDTO [cropId=" + cropId + ", cropName=" + cropName + ", cropPrice=" + cropPrice + ", seedName="
				+ seedName + ", seedPrice=" + seedPrice + ", seedAmount=" + seedAmount + ", toolId=" + toolId
				+ ", toolName=" + toolName + ", toolPrice=" + toolPrice + ", coin=" + coin + ", housePrice="
				+ housePrice + ", havingHouseYn=" + havingHouseYn + ", buyList=" + buyList + "]";
	}

	

}
