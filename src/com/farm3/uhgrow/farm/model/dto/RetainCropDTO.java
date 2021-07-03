package com.farm3.uhgrow.farm.model.dto;

import java.io.Serializable;
import java.util.List;

public class RetainCropDTO implements Serializable{
	private String userId;
	private int cropId;
	private String cropName;
	private int cropAmount;
	private List retainCropList;

	
	public RetainCropDTO() {}


	
	public RetainCropDTO(String userId, int cropId, String cropName, int cropAmount, List retainCropList) {
		super();
		this.userId = userId;
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropAmount = cropAmount;
		this.retainCropList = retainCropList;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
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


	public int getCropAmount() {
		return cropAmount;
	}


	public void setCropAmount(int cropAmount) {
		this.cropAmount = cropAmount;
	}


	public List getRetainCropList() {
		return retainCropList;
	}


	public void setRetainCropList(List retainCropList) {
		this.retainCropList = retainCropList;
	}



	@Override
	public String toString() {
		return "RetainCropDTO [userId=" + userId + ", cropId=" + cropId + ", cropName=" + cropName + ", cropAmount="
				+ cropAmount + ", retainCropList=" + retainCropList + "]";
	}


	
	
	
	
	
	
	
}
