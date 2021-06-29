package com.farm3.uhgrow.farm.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.farm.model.dao.FarmDAO;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;

public class FarmService {
	
	private FarmDAO farmDAO;

	public List<RetainCropDTO> selectAllSeed() {
		Connection con = getConnection();	
		List<RetainCropDTO> farmSeedList = farmDAO.selectAllSeed(con);			//	리턴할 리스트 선언후 connection을 

		close(con);
		
		return farmSeedList;
	}

}
