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

	
	public List<CropDTO> userCornList() {
		
		Connection con = getConnection();
		
		List<CropDTO> userCornList = sellCropsDAO.userCornList(con);

		close(con);
		
		return userCornList;
	}

	
	public List<CropDTO> userGarlicList() {
		
		Connection con = getConnection();
		
		List<CropDTO> userGarlicList = sellCropsDAO.userGarlicList(con);

		close(con);
		
		return userGarlicList;
	}

	public List<CropDTO> userPumpkinList() {
		
		Connection con = getConnection();
		
		List<CropDTO> userPumpkinList = sellCropsDAO.userPumpkinList(con);

		close(con);
		
		return userPumpkinList;
	}
	
	/*토마토 판매 수량 업데이트*/
	public int updateUserTomatoAmount(int sellAmount) {
		
		Connection con = getConnection();
		
		int updateTomatoAmount = sellCropsDAO.updateTomatoCropAmount(con, sellAmount);
		
		close(con);
		
		return updateTomatoAmount;
	}


	/* 토마토 팔고 난 후 금액 받기*/
	public int sellTomatoGetCoin(int sellAmount) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellTomatoGetCoin(con, sellAmount);
		
		close(con);
		
		return result;
	}
		
		
















	


}
