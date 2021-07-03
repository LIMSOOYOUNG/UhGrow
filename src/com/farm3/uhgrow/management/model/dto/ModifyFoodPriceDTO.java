package com.farm3.uhgrow.management.model.dto;

public class ModifyFoodPriceDTO {
	
	private int foodId;
	private int newFoodPrice;
	
	public ModifyFoodPriceDTO() {}

	public ModifyFoodPriceDTO(int foodId, int newFoodPrice) {
		super();
		this.foodId = foodId;
		this.newFoodPrice = newFoodPrice;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getNewFoodPrice() {
		return newFoodPrice;
	}

	public void setNewFoodPrice(int newFoodPrice) {
		this.newFoodPrice = newFoodPrice;
	}

	@Override
	public String toString() {
		return "ModifyFoodPriceDTO [foodId=" + foodId + ", newFoodPrice=" + newFoodPrice + "]";
	}
	
	

}
