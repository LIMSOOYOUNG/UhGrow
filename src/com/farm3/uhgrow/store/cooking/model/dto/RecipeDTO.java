package com.farm3.uhgrow.store.cooking.model.dto;

public class RecipeDTO implements java.io.Serializable {
	
	private int userNo;
	private int FoodId;
	private int foodAmount;
	
	public RecipeDTO() {}

	public RecipeDTO(int userNo, int foodId, int foodAmount) {
		super();
		this.userNo = userNo;
		FoodId = foodId;
		this.foodAmount = foodAmount;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getFoodId() {
		return FoodId;
	}

	public void setFoodId(int foodId) {
		FoodId = foodId;
	}

	public int getFoodAmount() {
		return foodAmount;
	}

	public void setFoodAmount(int foodAmount) {
		this.foodAmount = foodAmount;
	}

	@Override
	public String toString() {
		return "RecipeDTO [userNo=" + userNo + ", FoodId=" + FoodId + ", foodAmount=" + foodAmount + "]";
	}

	

}
