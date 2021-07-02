package com.farm3.uhgrow;

public class CropDTO {
	
	private int cropId;       // 농작물아이디
	private String cropName;  // 농작물이름
	private int cropPrice;    // 농작물가격
	
	
	public CropDTO() {}

	public CropDTO(int cropId, String cropName, int cropPrice) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropPrice = cropPrice;
	}

	public int getCropId() {
		return cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public int getCropPrice() {
		return cropPrice;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public void setCropPrice(int cropPrice) {
		this.cropPrice = cropPrice;
	}

	@Override
	public String toString() {
		return "CropDTO [cropId=" + cropId + ", cropName=" + cropName + ", cropPrice=" + cropPrice + "]";
	}

	

}
