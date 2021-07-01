package com.farm3.uhgrow.farm.model.dto;

import java.awt.List;
import java.io.Serializable;

public class RetainCropDTO implements Serializable{
	private String userName;
	private String cropName;
	private int cropAmount;
	private List retainCropList;

	
	public RetainCropDTO() {}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
	
	
	
	
	
}
