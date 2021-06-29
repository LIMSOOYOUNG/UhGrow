package com.farm3.uhgrow;

import java.io.Serializable;

public class SeedDTO implements java.io.Serializable {
	
	private int cropId;				// 씨앗 아이디
	private String seedName;		// 씨앗 이름
	private int seedPrice;			// 씨앗 가격
	private int seedAmount;			// 씨앗 보유 수량
	
	
	public SeedDTO() {}				// 기본 생성자


	public SeedDTO(int cropId, String seedName, int seedPrice, int seedAmount) {		// 전체 필드를 초기화하는 생성자
		super();
		this.cropId = cropId;
		this.seedName = seedName;
		this.seedPrice = seedPrice;
		this.seedAmount = seedAmount;
	}


	public int getCropId() {
		return cropId;
	}


	public void setCropId(int cropId) {
		this.cropId = cropId;
	}


	public String getSeedName() {
		return seedName;
	}


	public void setSeedName(String seedName) {
		this.seedName = seedName;
	}


	public int getSeedPrice() {
		return seedPrice;
	}


	public void setSeedPrice(int seedPrice) {
		this.seedPrice = seedPrice;
	}


	public int getSeedAmount() {
		return seedAmount;
	}


	public void setSeedAmount(int seedAmount) {
		this.seedAmount = seedAmount;
	}


	@Override
	public String toString() {
		return "SeedDTO [cropId=" + cropId + ", seedName=" + seedName + ", seedPrice=" + seedPrice + ", seedAmount="
				+ seedAmount + "]";
	}
	
	
}
