package com.farm3.uhgrow.sellcrops.model.dto;

public class CropDTO {
	
	private int userNo;	  	  // 회원 아이디
	private int coin;		  // 회원 보유 코인	
	private int cropId;       // 농작물아이디
	private String cropName;  // 농작물이름
	private int cropPrice;    // 농작물가격
	private int cropAmount;   // 농작물 수량
	
	public CropDTO() {}

	public CropDTO(int userNo, int coin, int cropId, String cropName, int cropPrice, int cropAmount) {
		super();
		this.userNo = userNo;
		this.coin = coin;
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropPrice = cropPrice;
		this.cropAmount = cropAmount;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
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

	public int getCropAmount() {
		return cropAmount;
	}

	public void setCropAmount(int cropAmount) {
		this.cropAmount = cropAmount;
	}

	@Override
	public String toString() {
		return "CropDTO [userNo=" + userNo + ", coin=" + coin + ", cropId=" + cropId + ", cropName=" + cropName
				+ ", cropPrice=" + cropPrice + ", cropAmount=" + cropAmount + "]";
	}
	

}

	

