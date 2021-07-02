package com.farm3.uhgrow.management.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.management.model.dao.GameDataDAO;
import com.farm3.uhgrow.management.model.dto.CropPriceDTO;
import com.farm3.uhgrow.management.model.dto.ModifyCropPriceDTO;
import com.farm3.uhgrow.management.model.dto.SelectCropPriceDTO;

public class GameDataService {
	
	private static GameDataDAO gameDataDAO;
	
	public GameDataService() {
		this.gameDataDAO = new GameDataDAO();
	}

	public int modifyCropPrice(ModifyCropPriceDTO modifyPriceList) {
		Connection con = getConnection();
		int result = gameDataDAO.modifyCropPrice(con, modifyPriceList);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int modifyHousePrice(int inputHousePrice) {
		
		Connection con = getConnection();
		
		int result = gameDataDAO.modifyHousePrice(con, inputHousePrice);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}

	public static List<SelectCropPriceDTO> selectCropPriceData() {
		Connection con = getConnection();
		List<SelectCropPriceDTO> userList = gameDataDAO.selectCropPrice(con);
		close(con);
		return userList;
	}

}