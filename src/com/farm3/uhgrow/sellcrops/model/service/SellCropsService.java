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
	
//	public List<CropDTO> userCropList() {
//	
//		Connection con = getConnection();
//		
//		List<CropDTO> userCropList = sellCropsDAO.userCropList(con);
//		
//		close(con);
//		
//		return userCropList;
//	}


	public List<CropDTO> userCropList() {
		
		Connection con = getConnection();
		
		List<CropDTO> userCropList = sellCropsDAO.userCropList(con);
		
		return userCropList;
	}

	


}
