package com.farm3.uhgrow.model.dto;

public class RetainFoodDTO {
	
	private int foodId;      // 요리아이디
	private int userNo;  // 회원번호
	private int foodAmount;  // 요리보유수량
	
	public RetainFoodDTO() {}

	public RetainFoodDTO(int foodId, int userNo, int foodAmount) {
		super();
		this.foodId = foodId;
		this.userNo = userNo;
		this.foodAmount = foodAmount;
	}

	public int getFoodId() {
		return foodId;
	}

	public int getUserNo() {
		return userNo;
	}

	public int getFoodAmount() {
		return foodAmount;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setFoodAmount(int foodAmount) {
		this.foodAmount = foodAmount;
	}

	@Override
	public String toString() {
		return "RetainFoodDTO [foodId=" + foodId + ", userNo=" + userNo + ", foodAmount=" + foodAmount + "]";
	}
	
	
	

}
