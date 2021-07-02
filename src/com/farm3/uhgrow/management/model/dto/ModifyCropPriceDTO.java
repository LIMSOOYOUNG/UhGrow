package com.farm3.uhgrow.management.model.dto;

public class ModifyCropPriceDTO implements java.io.Serializable {
	
	private int cropId;
	private int newCropPrice;
	
	public ModifyCropPriceDTO() {}

	public ModifyCropPriceDTO(int cropId, int newCropPrice) {
		super();
		this.cropId = cropId;
		this.newCropPrice = newCropPrice;
	}

	public int getCropId() {
		return cropId;
	}

	public int getNewCropPrice() {
		return newCropPrice;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	public void setNewCropPrice(int newCropPrice) {
		this.newCropPrice = newCropPrice;
	}

	@Override
	public String toString() {
		return "ModifyCropPriceDTO [cropId=" + cropId + ", newCropPrice=" + newCropPrice + "]";
	}
	
	


}
