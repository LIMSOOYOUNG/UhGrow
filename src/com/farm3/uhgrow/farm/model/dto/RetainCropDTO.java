package com.farm3.uhgrow.farm.model.dto;

import java.io.Serializable;
import java.util.List;

public class RetainCropDTO implements Serializable{
	private int userNo;
	private int cropId;
	private String cropName;
	private int cropAmount;

	
	public RetainCropDTO() {}


	public RetainCropDTO(int userNo, int cropId, String cropName, int cropAmount) {
		super();
		this.userNo = userNo;
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropAmount = cropAmount;
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


	public int getCropAmount() {
		return cropAmount;
	}


	public void setCropAmount(int cropAmount) {
		this.cropAmount = cropAmount;
	}


	@Override
	public String toString() {
		return "RetainCropDTO [userNo=" + userNo + ", cropId=" + cropId + ", cropName=" + cropName + ", cropAmount="
				+ cropAmount + "]";
	}

}
