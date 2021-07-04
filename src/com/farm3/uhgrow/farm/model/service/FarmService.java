package com.farm3.uhgrow.farm.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;
import static com.farm3.uhgrow.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.farm.model.dao.FarmDAO;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.dto.SeedDTO;

public class FarmService {
	
	private FarmDAO farmDAO;
	public FarmService() {
		farmDAO = new FarmDAO();
	}

	public List<SeedDTO> selectAllSeed() {
		Connection con = getConnection();	
		List<SeedDTO> retainSeedList = farmDAO.selectAllSeed(con);			//	리턴할 리스트 선언후 connection을 
		close(con);
		
		return retainSeedList;
	}


	public int chooseInputSeed(RetainCropDTO cropDTO) {						//씨앗 고르기
		Connection con = getConnection();
		
		int chooseResult = farmDAO.chooseInputSeed(con,cropDTO);
		
		if(chooseResult>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		
		return chooseResult;
	}


}
