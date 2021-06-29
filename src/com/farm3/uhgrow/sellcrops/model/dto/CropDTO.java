package com.farm3.uhgrow.sellcrops.model.dto;

public class CropDTO {
	
	private int userNo;		  // 회원 아이디
	private int cropId;       // 농작물아이디
	private String cropName;  // 농작물이름
	private int cropPrice;    // 농작물가격
	
	public CropDTO() {}

	public CropDTO(int userNo, int cropId, String cropName, int cropPrice) {
		super();
		this.userNo = userNo;
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropPrice = cropPrice;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
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

	@Override
	public String toString() {
		return "CropDTO [userNo=" + userNo + ", cropId=" + cropId + ", cropName=" + cropName + ", cropPrice="
				+ cropPrice + "]";
	}


}

	

