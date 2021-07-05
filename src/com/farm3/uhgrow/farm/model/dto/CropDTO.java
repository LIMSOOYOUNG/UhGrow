package com.farm3.uhgrow.farm.model.dto;

import java.io.Serializable;

public class CropDTO implements java.io.Serializable {
	
	private int userNO;
	private int cropId;				// 씨앗 아이디
	private String cropName;		// 씨앗 이름
	private int cropPrice;			// 씨앗 가격
	private int cropAmount;

	
	
	public CropDTO() {}				// 기본 생성자



	public CropDTO(int userNO, int cropId, String cropName, int cropPrice, int cropAmount) {
		super();
		this.userNO = userNO;
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropPrice = cropPrice;
		this.cropAmount = cropAmount;
	}



	public int getUserNO() {
		return userNO;
	}



	public void setUserNO(int userNO) {
		this.userNO = userNO;
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



	public void setetCropName(String cropName) {
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
		return "CropDTO [userNO=" + userNO + ", cropId=" + cropId + ", seedName=" + cropName + ", cropPrice="
				+ cropPrice + ", cropAmount=" + cropAmount + "]";
	}

	

	
}
