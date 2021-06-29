package com.farm3.uhgrow.management.model.dto;

public class RecipeDTO {

	private int cropId;					// 농작물아이디
	private int foodId;					// 요리아이디
	private int cropRqAmount;			// 농작물필요수랑
	
	public RecipeDTO(int cropId, int foodId, int cropRqAmount) {
		super();
		this.cropId = cropId;
		this.foodId = foodId;
		this.cropRqAmount = cropRqAmount;
	}
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getCropRqAmount() {
		return cropRqAmount;
	}
	public void setCropRqAmount(int cropRqAmount) {
		this.cropRqAmount = cropRqAmount;
	}
	@Override
	public String toString() {
		return "RecipeDTO [cropId=" + cropId + ", foodId=" + foodId + ", cropRqAmount=" + cropRqAmount + "]";
	}
	
}
