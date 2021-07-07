package com.farm3.uhgrow.sellcrops.model.service;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dao.SellToolDAO;
import com.farm3.uhgrow.sellcrops.model.dto.ToolDTO;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class SellToolService {
	
	private SellToolDAO sellToolDAO;
	
	public SellToolService() {
		this.sellToolDAO = new SellToolDAO();
	}
	

	public List<ToolDTO> userPick(int userNo) {
		
		Connection con = getConnection();
		
		List<ToolDTO> userPick = sellToolDAO.userPick(con, userNo);
		
		close(con);

		return userPick;
		
	}

}
