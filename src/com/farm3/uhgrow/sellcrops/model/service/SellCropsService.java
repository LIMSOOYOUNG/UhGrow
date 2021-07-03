package com.farm3.uhgrow.sellcrops.model.service;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dao.SellCropsDAO;
import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
//import static com.farm3.uhgrow.common.JDBCTemplate.commit;
//import static com.farm3.uhgrow.common.JDBCTemplate.rollback;
import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class SellCropsService {
	
	private SellCropsDAO sellCropsDAO;
	
	public SellCropsService() {
		this.sellCropsDAO = new SellCropsDAO();
	}
	


	public List<CropDTO> userCropList() {
		
		Connection con = getConnection();
		
		List<CropDTO> userCropList = sellCropsDAO.userCropList(con);

		close(con);
		
		return userCropList;
	}



	public int cropPrice(int sellAmount) {

		Connection con = getConnection();
		
		CropDTO getCropPrice = sellCropsDAO.getCropPrice(con);
		
		int cropPrice = 0;
		int totalGetPrice = 0;
		
		cropPrice = getCropPrice.getCropPrice();
		
		totalGetPrice = ((cropPrice * sellAmount) / 10);
		
		close(con);
		
		return totalGetPrice;
	}



	public int updateUserCropAmount(int sellAmount) {
		
		Connection con = getConnection();
		
		CropDTO updateCropAmount = sellCropsDAO.updateCropAmount(con, sellAmount);
		
		int userCropAmount = updateCropAmount.getCropAmount(); 
		
		close(con);
		
		return userCropAmount;
	}



	


}
