package com.farm3.uhgrow.management.model.dto;

public class CropPriceDTO {
	
	private int tomatoPrice;
	private int cornPrice;
	private int garlicPrice;
	private int pumpkinPirce;
	
	public CropPriceDTO() {}

	public CropPriceDTO(int tomatoPrice, int cornPrice, int garlicPrice, int pumpkinPirce) {
		super();
		this.tomatoPrice = tomatoPrice;
		this.cornPrice = cornPrice;
		this.garlicPrice = garlicPrice;
		this.pumpkinPirce = pumpkinPirce;
	}

	public int getTomatoPrice() {
		return tomatoPrice;
	}

	public int getCornPrice() {
		return cornPrice;
	}

	public int getGarlicPrice() {
		return garlicPrice;
	}

	public int getPumpkinPirce() {
		return pumpkinPirce;
	}

	public void setTomatoPrice(int tomatoPrice) {
		this.tomatoPrice = tomatoPrice;
	}

	public void setCornPrice(int cornPrice) {
		this.cornPrice = cornPrice;
	}

	public void setGarlicPrice(int garlicPrice) {
		this.garlicPrice = garlicPrice;
	}

	public void setPumpkinPirce(int pumpkinPirce) {
		this.pumpkinPirce = pumpkinPirce;
	}

	@Override
	public String toString() {
		return "CropPriceDTO [tomatoPrice=" + tomatoPrice + ", cornPrice=" + cornPrice + ", garlicPrice=" + garlicPrice
				+ ", pumpkinPirce=" + pumpkinPirce + "]";
	}
	
	

}
