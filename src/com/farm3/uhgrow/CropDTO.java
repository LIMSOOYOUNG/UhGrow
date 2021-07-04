ackage com.farm3.uhgrow;

public class CropDTO {
	
	private int cropId;       // 농작물아이디
	private String cropName;  // 농작물이름
	private int cropPrice;    // 농작물가격
	private int cropAmount;	  // 작물 수량
	
	
	public CropDTO() {}


	public CropDTO(int cropId, String cropName, int cropPrice, int cropAmount) {
		super();
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropPrice = cropPrice;
		this.cropAmount = cropAmount;
	}


	public int getCropId() {
		return cropId;
	}


	public void setCropId(int cropId) {
		this.cropId = cropId;
	}


	public String getCropName() {
		return cropName;
	}


	public void setCropName(String cropName) {
		this.cropName = cropName;
	}


	public int getCropPrice() {
		return cropPrice;
	}


	public void setCropPrice(int cropPrice) {
		this.cropPrice = cropPrice;
	}


	public int getCropAmount() {
		return cropAmount;
	}


	public void setCropAmount(int cropAmount) {
		this.cropAmount = cropAmount;
	}


	@Override
	public String toString() {
		return "CropDTO [cropId=" + cropId + ", cropName=" + cropName + ", cropPrice=" + cropPrice + ", cropAmount="
				+ cropAmount + "]";
	}

	
	

}
