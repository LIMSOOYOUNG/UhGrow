package com.farm3.uhgrow.buy.service;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;
import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.buy.model.dao.BuyDAO;
import com.farm3.uhgrow.buy.model.dto.BuyDTO;

public class BuyService {
	
	BuyDAO buyDAO = new BuyDAO();

	public int buyNewHouse(BuyDTO buy) {

		Connection con = getConnection();
		
		int result = 0;
		int buyHouseResult = buyDAO.buyHouse(con, buy);
		
		if (buyHouseResult > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		

		close(con);																

		return result;															
	}

}
