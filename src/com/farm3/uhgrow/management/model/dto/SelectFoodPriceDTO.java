package com.farm3.uhgrow.management.model.dto;

public class SelectFoodPriceDTO {

	private String foodName;
	private int foodPrice;
	
	public SelectFoodPriceDTO() {}

	public SelectFoodPriceDTO(String foodName, int foodPrice) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() {
		return "SelectFoodPriceDTO [foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}
	
	
}
