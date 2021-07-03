package com.farm3.uhgrow.management.model.dto;

public class ModifyFoodRecipeDTO {
	
	private int foodId;
	private int cropRqAmount;
	
	public ModifyFoodRecipeDTO() {}

	public ModifyFoodRecipeDTO(int foodId, int cropRqAmount) {
		super();
		this.foodId = foodId;
		this.cropRqAmount = cropRqAmount;
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
		return "ModifyFoodRecipeDTO [foodId=" + foodId + ", cropRqAmount=" + cropRqAmount + "]";
	}
	
	

}
