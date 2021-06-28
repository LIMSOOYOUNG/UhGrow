package com.farm3.uhgrow.model.dto;

public class NeedExpDTO {

	private int growthLevel;			//	단계
	private int rqExp;					//	필요 경험치
	private int cropId;					//	농작물 아이디
	
	public NeedExpDTO(int growthLevel, int rqExp, int cropId) {
		super();
		this.growthLevel = growthLevel;
		this.rqExp = rqExp;
		this.cropId = cropId;
	}

	public int getGrowthLevel() {
		return growthLevel;
	}

	public void setGrowthLevel(int growthLevel) {
		this.growthLevel = growthLevel;
	}

	public int getRqExp() {
		return rqExp;
	}

	public void setRqExp(int rqExp) {
		this.rqExp = rqExp;
	}

	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	@Override
	public String toString() {
		return "NeedExpDTO [growthLevel=" + growthLevel + ", rqExp=" + rqExp + ", cropId=" + cropId + "]";
	}
	
	
	
}
