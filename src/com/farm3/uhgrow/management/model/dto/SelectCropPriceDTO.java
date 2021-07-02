package com.farm3.uhgrow.management.model.dto;

public class SelectCropPriceDTO implements java.io.Serializable {
	
	private String cropName;
	private int cropPrice;
	
	public SelectCropPriceDTO() {}

	public SelectCropPriceDTO(String cropName, int cropPrice) {
		super();
		this.cropName = cropName;
		this.cropPrice = cropPrice;
	}

	public String getCropName() {
		return cropName;
	}

	public int getCropPrice() {
		return cropPrice;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public void setCropPrice(int cropPrice) {
		this.cropPrice = cropPrice;
	}

	@Override
	public String toString() {
		return "SelectCropPriceDTO [cropName=" + cropName + ", cropPrice=" + cropPrice + "]";
	}

}
