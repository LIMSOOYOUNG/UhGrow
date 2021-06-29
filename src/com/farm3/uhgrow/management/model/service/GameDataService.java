package com.farm3.uhgrow.management.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.farm3.uhgrow.management.model.dao.GameDataDAO;
import com.farm3.uhgrow.management.model.dto.CropPriceDTO;

public class GameDataService {
	
	private GameDataDAO gameDataDAO;
	
	public GameDataService() {
		this.gameDataDAO = new GameDataDAO();
	}

	public int modifyCropPrice(CropPriceDTO cropPrice) {
		Connection con = getConnection();
		int result1 = gameDataDAO.modifyTomatoPrice(con, cropPrice);
		if(result1 > 0) {
			commit(con);
		} else {
			rollback(con);
		}
        int result2 = gameDataDAO.modifyCornPrice(con, cropPrice);
        if(result2 > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		int result3 = gameDataDAO.modifyGarlicPrice(con, cropPrice);
		if(result3 > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		int result4 = gameDataDAO.modifyPumpkinPrice(con, cropPrice);
		if(result4 > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		int result = result1 + result2 + result3 + result4;
		close(con);
		return result;
	}

}
