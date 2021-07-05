package com.farm3.uhgrow.farm.model.dto;

public class RetainFoodDTO {
	private int foodId;
	private int foodAmount;
	
	public RetainFoodDTO() {}

	public RetainFoodDTO(int foodId, int foodAmount) {
		super();
		this.foodId = foodId;
		this.foodAmount = foodAmount;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getFoodAmount() {
		return foodAmount;
	}

	public void setFoodAmount(int foodAmount) {
		this.foodAmount = foodAmount;
	}

	@Override
	public String toString() {
		return "InventoryFoodDTO [foodId=" + foodId + ", foodAmount=" + foodAmount + "]";
	}
	
	

}
