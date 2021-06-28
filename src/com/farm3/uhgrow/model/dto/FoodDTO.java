package com.farm3.uhgrow.model.dto;

public class FoodDTO {
	
	private int foodId;       // 요리아이디
	private String foodName;  // 요리이름
	private int foodPrice;    // 요리가격
	
	public FoodDTO() {}

	public FoodDTO(int foodId, String foodName, int foodPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}

	public int getFoodId() {
		return foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() {
		return "FoodDTO [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}

	
	
	
	

}
