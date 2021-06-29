package com.farm3.uhgrow.sellcrops.model.service;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dao.SellCropsDAO;
import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;
import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class SellCropsService {
	
	private SellCropsDAO sellCropsDAO;

//	public List<CropDTO> sellTomato() {
	
//		Connection con = getConnection();
		
//		List<CropDTO> 
//		
//		
//		return null
//	}
	
//		return sellCropResult;

	public int sellCorn(CropDTO crop) {
		
		Connection con = getConnection();
		
		int sellCropResult = sellCropsDAO.sellCorn(con, crop);
		
		if(sellCropResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return 0;
	}


}
