package com.farm3.uhgrow.farm.model.dto;

import java.io.Serializable;

public class FarmCropDTO implements Serializable{
	
	private int farmList;
	private int userNo;
	private int cropId;
	private int accumulate;

	public FarmCropDTO() {}

	public FarmCropDTO(int farmList, int userNo, int cropId, int accumulate) {
		super();
		this.farmList = farmList;
		this.userNo = userNo;
		this.cropId = cropId;
		this.accumulate = accumulate;
	}

	public int getFarmList() {
		return farmList;
	}

	public void setFarmList(int farmList) {
		this.farmList = farmList;
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

	public int getAccumulate() {
		return accumulate;
	}

	public void setAccumulate(int accumulate) {
		this.accumulate = accumulate;
	}

	@Override
	public String toString() {
		return "FarmCropDTO [farmList=" + farmList + ", userNo=" + userNo + ", cropId=" + cropId + ", accumulate="
				+ accumulate + "]";
	}
	
}
