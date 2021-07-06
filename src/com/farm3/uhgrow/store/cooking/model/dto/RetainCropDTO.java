package com.farm3.uhgrow.store.cooking.model.dto;

public class RetainCropDTO {
	
	private int userNo;
	private int cropAmount;
	
	public RetainCropDTO() {}

	public RetainCropDTO(int userNo, int cropAmount) {
		super();
		this.userNo = userNo;
		this.cropAmount = cropAmount;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCropAmount() {
		return cropAmount;
	}

	public void setCropAmount(int cropAmount) {
		this.cropAmount = cropAmount;
	}

	@Override
	public String toString() {
		return "RetainCropDTO [userNo=" + userNo + ", cropAmount=" + cropAmount + "]";
	}
	
	

}
