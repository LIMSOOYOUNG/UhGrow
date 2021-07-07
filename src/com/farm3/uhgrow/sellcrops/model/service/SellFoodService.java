package com.farm3.uhgrow.sellcrops.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dao.SellFoodDAO;
import com.farm3.uhgrow.sellcrops.model.dto.FoodDTO;


public class SellFoodService {
	
	private SellFoodDAO sellFoodDAO;
	
	public SellFoodService() {
		this.sellFoodDAO = new SellFoodDAO();
	}
	
	
	public int selectCoin(int userNo) {
		Connection con = getConnection();
		
		int result = sellFoodDAO.selectCoin(con, userNo);
		
		close(con);
		
		return result;
	}

	
	/*토마토피자*/
	public List<FoodDTO> userTomatoPizza(int userNo) {
		
		Connection con = getConnection();
		
		List<FoodDTO> userTomatoPizza = sellFoodDAO.userTomatoPizza(con, userNo);
		
		close(con);
		
		return userTomatoPizza;
	}

	public int updateUserTomatoPizzaAmount(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellFoodDAO.updateUserTomatoPizzaAmount(con, sellAmount, userNo);
		
		close(con);
		
		return result;
	}
	
	public int sellTomatoPizzaGetCoin(int sellAmount, int tomatoPizzaPrice, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellFoodDAO.sellTomatoPizzaGetCoin(con, sellAmount, tomatoPizzaPrice, userNo);
		
		
		return result;
	}
	
	
	/*옥수수또띠아*/
	public List<FoodDTO> userCornTotilla(int userNo) {
		
		Connection con = getConnection();
		
		List<FoodDTO> userCornTotilla = sellFoodDAO.userCornTotilla(con, userNo);
		
		return userCornTotilla;
	}
	
	public int updateUserCornTotillaAmount(int sellAmount, int userNo) {

		Connection con = getConnection();
		
		int result = sellFoodDAO.updateUserCornTotillaAmount(con, sellAmount, userNo);
		
		close(con);
		
		return result;
	}
	
	public int sellCornTotillaGetCoin(int sellAmount, int cornTortillaPrice, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellFoodDAO.sellCornTotillaGetCoin(con, sellAmount, cornTortillaPrice, userNo);
		
		close(con);
		
		return result;
	}


	/*마늘즙*/
	public List<FoodDTO> userGarlicJuice(int userNo) {
		
		Connection con = getConnection();
		
		List<FoodDTO> userGarlicJuice = sellFoodDAO.userGarlicJuice(con, userNo);
		
		return userGarlicJuice;
	}
	
	public int updateUserGarlicJuiceAmount(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellFoodDAO.updateUserGarlicJuiceAmount(con, sellAmount, userNo);
		
		close(con);
		
		return result;
	}

	public int sellGarlicJuiceGetCoin(int sellAmount, int garilcJuicePrice, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellFoodDAO.sellGarlicJuiceGetCoin(con, sellAmount, garilcJuicePrice, userNo);
		
		close(con);
		
		return result;
	}

	/*호박죽*/
	public List<FoodDTO> userPumpkinSoup(int userNo) {

		Connection con = getConnection();
		
		List<FoodDTO> userTomatoPizza = sellFoodDAO.userPumpkinSoup(con, userNo);
		
		return userTomatoPizza;
	}
	
	public int updateUserPumpkinSoupAmount(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellFoodDAO.updateUserPumpkinSoupAmount(con, sellAmount, userNo);
		
		close(con);
		
		return result;
	}


	public int sellPumpkinSoupGetCoin(int sellAmount, int pumpkinSoupPrice, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellFoodDAO.sellPumpkinSoupGetCoin(con, sellAmount, pumpkinSoupPrice, userNo);
		
		close(con);
		
		return result;
	}


	




	
	


}
