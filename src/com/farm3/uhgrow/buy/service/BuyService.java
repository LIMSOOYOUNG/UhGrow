package com.farm3.uhgrow.buy.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.buy.model.dao.BuyDAO;
import com.farm3.uhgrow.buy.model.dto.BuyDTO;

public class BuyService {
	
	private BuyDAO buyCropsDAO;

	public BuyService() {
		this.buyCropsDAO = new BuyDAO();
	}
	


	public List<BuyDTO> userTomatoList() {
		
		Connection con = getConnection();
		
		List<BuyDTO> userTomatoList = buyCropsDAO.userTomatoList(con);

		close(con);
		
		return userTomatoList;
	}

	
	public List<BuyDTO> userCornList() {
		
		Connection con = getConnection();
		
		List<BuyDTO> userCornList = buyCropsDAO.userCornList(con);

		close(con);
		
		return userCornList;
	}

	
	public List<BuyDTO> userGarlicList() {
		
		Connection con = getConnection();
		
		List<BuyDTO> userGarlicList = buyCropsDAO.userGarlicList(con);

		close(con);
		
		return userGarlicList;
	}

	public List<BuyDTO> userPumpkinList() {
		
		Connection con = getConnection();
		
		List<BuyDTO> userPumpkinList = buyCropsDAO.userPumpkinList(con);

		close(con);
		
		return userPumpkinList;
	}
	
	/*토마토씨앗 구매 수량 업데이트*/
	public int updateUserTomatoAmount(int buyAmount) {
		
		Connection con = getConnection();
		
		int updateTomatoAmount = buyCropsDAO.updateTomatoCropAmount(con, buyAmount);
		
		close(con);
		
		return updateTomatoAmount;
	}
	
	/*옥수수씨앗 구매 수량 업데이트*/
	public int updateCornCropAmount(int buyAmount) {
		
		Connection con = getConnection();
		
		int updateTomatoAmount = buyCropsDAO.updateTomatoCropAmount(con, buyAmount);
		
		close(con);
		
		return updateTomatoAmount;
	}
	
	/*마늘씨앗 구매 수량 업데이트*/
	public int updateGarlicCropAmount(int buyAmount) {
		
		Connection con = getConnection();
		
		int updateTomatoAmount = buyCropsDAO.updateTomatoCropAmount(con, buyAmount);
		
		close(con);
		
		return updateTomatoAmount;
	}
	
	/*호박씨앗 구매 수량 업데이트*/
	public int updatePumpkinCropAmount(int buyAmount) {
		
		Connection con = getConnection();
		
		int updateTomatoAmount = buyCropsDAO.updateTomatoCropAmount(con, buyAmount);
		
		close(con);
		
		return updateTomatoAmount;
	}


	/* 토마토씨앗 구매 후 금액 */
	public int buyTomatoGetCoin(int buyAmount, int tomatoPrice) {
		
		Connection con = getConnection();
		
		int result = buyCropsDAO.buyTomatoGetCoin(con, buyAmount, tomatoPrice);
		
		close(con);
		
		return result;
	}
		
		









}
