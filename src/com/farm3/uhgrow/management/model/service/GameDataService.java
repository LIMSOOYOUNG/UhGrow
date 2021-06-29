package com.farm3.uhgrow.management.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.farm3.uhgrow.management.model.dao.GameDataDAO;
import com.farm3.uhgrow.management.model.dto.CropPriceDTO;

public class GameDataService {

	public static int modifyCropPrice(CropPriceDTO cropPrice) {
		Connection con = getConnection();
		int result = GameDataDAO.modifyCropPrice(con, cropPrice);
		close(con);
		return result;
	}

}
