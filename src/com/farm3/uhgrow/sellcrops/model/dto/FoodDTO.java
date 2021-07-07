package com.farm3.uhgrow.sellcrops.model.dto;

public class FoodDTO {
	
	private int userNo;
	private int coin;
	private int foodId;
	private String foodName;
	private int foodPrice;
	private int foodAmount;
	
	public FoodDTO() {}

	public FoodDTO(int userNo, int coin, int foodId, String foodName, int foodPrice, int foodAmount) {
		super();
		this.userNo = userNo;
		this.coin = coin;
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodAmount = foodAmount;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
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

	public int getFoodAmount() {
		return foodAmount;
	}

	public void setFoodAmount(int foodAmount) {
		this.foodAmount = foodAmount;
	}

	@Override
	public String toString() {
		return "FoodDTO [userNo=" + userNo + ", coin=" + coin + ", foodId=" + foodId + ", foodName=" + foodName
				+ ", foodPrice=" + foodPrice + ", foodAmount=" + foodAmount + "]";
	}
	
	
	
}
