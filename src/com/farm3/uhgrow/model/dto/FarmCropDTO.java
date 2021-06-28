package com.farm3.uhgrow.model.dto;

public class FarmCropDTO {

	private int farmList;						//	재배 리스트
	private int userNO;							//	회원 번호
	private int accumaulateExp;					//	누적 경험치
	private String cropStatus;					//	농작물 상태
	private int cropId;							//	농작물 아이디
	
	public FarmCropDTO(int farmList, int userNO, int accumaulateExp, String cropStatus, int cropId) {
		super();
		this.farmList = farmList;
		this.userNO = userNO;
		this.accumaulateExp = accumaulateExp;
		this.cropStatus = cropStatus;
		this.cropId = cropId;
	}

	public int getFarmList() {
		return farmList;
	}

	public void setFarmList(int farmList) {
		this.farmList = farmList;
	}

	public int getUserNO() {
		return userNO;
	}

	public void setUserNO(int userNO) {
		this.userNO = userNO;
	}

	public int getAccumaulateExp() {
		return accumaulateExp;
	}

	public void setAccumaulateExp(int accumaulateExp) {
		this.accumaulateExp = accumaulateExp;
	}

	public String getCropStatus() {
		return cropStatus;
	}

	public void setCropStatus(String cropStatus) {
		this.cropStatus = cropStatus;
	}

	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	@Override
	public String toString() {
		return "FarmCropDTO [farmList=" + farmList + ", userNO=" + userNO + ", accumaulateExp=" + accumaulateExp
				+ ", cropStatus=" + cropStatus + ", cropNo=" + cropId + "]";
	}
	
		
}
