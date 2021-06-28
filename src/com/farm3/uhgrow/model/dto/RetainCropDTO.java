package com.farm3.uhgrow.model.dto;

public class RetainCropDTO {
	
	private int userNO;
	private int cropId;
	private int cropAmount;
	
	public RetainCropDTO(int userNO, int cropId, int cropAmount) {
		super();
		this.userNO = userNO;
		this.cropId = cropId;
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
	public int getCropAmount() {
		return cropAmount;
	}
	public void setCropAmount(int cropAmount) {
		this.cropAmount = cropAmount;
	}
	@Override
	public String toString() {
		return "RetainCropDTO [userNO=" + userNO + ", cropId=" + cropId + ", cropAmount=" + cropAmount + "]";
	}
	
	
}
