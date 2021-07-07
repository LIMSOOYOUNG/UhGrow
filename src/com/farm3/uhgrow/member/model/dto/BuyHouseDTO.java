package com.farm3.uhgrow.member.model.dto;

public class BuyHouseDTO implements java.io.Serializable  {
	
	private int userNo;
	private int coin;
	private int housePrice;
	

	public BuyHouseDTO(){}


	public BuyHouseDTO(int userNo, int coin, int housePrice) {
		super();
		this.userNo = userNo;
		this.coin = coin;
		this.housePrice = housePrice;
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


	public int getHousePrice() {
		return housePrice;
	}


	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}


	@Override
	public String toString() {
		return "BuyHouseDTO [userNo=" + userNo + ", coin=" + coin + ", housePrice=" + housePrice + "]";
	}
	
	
}
