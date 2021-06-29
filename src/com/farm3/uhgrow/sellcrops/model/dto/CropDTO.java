package com.farm3.uhgrow.sellcrops.model.dto;

public class CropDTO {
	
	private String userId;	  // 회원 아이디
	private int cropId;       // 농작물아이디
	private String cropName;  // 농작물이름
	private int cropPrice;    // 농작물가격
	
	public CropDTO() {}

	public CropDTO(String userId, int cropId, String cropName, int cropPrice) {
		super();
		this.userId = userId;
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropPrice = cropPrice;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
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
		return "CropDTO [userId=" + userId + ", cropId=" + cropId + ", cropName=" + cropName + ", cropPrice="
				+ cropPrice + "]";
	}


}

	

