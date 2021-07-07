package com.farm3.uhgrow.sellcrops.model.dao;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farm3.uhgrow.sellcrops.model.dto.FoodDTO;

public class SellFoodDAO {
	private Properties prop;
	
	public SellFoodDAO() {
		this.prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/sellList.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int selectCoin(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int result = 0;
		
		String query = prop.getProperty("selectCoin");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt("COIN");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public List<FoodDTO> userTomatoPizza(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<FoodDTO> userTomatoPizza = null;
		
		String query = prop.getProperty("userTomatoPizza");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			userTomatoPizza = new ArrayList<>();
			
			while(rset.next()) {
				FoodDTO userFood = new FoodDTO();
				userFood.setFoodName(rset.getString("FOOD_NAME"));
				userFood.setFoodAmount(rset.getInt("FOOD_AMOUnT"));
				userFood.setCoin(rset.getInt("COIN"));
				userFood.setFoodPrice(rset.getInt("FOOD_PRICE"));
				
				userTomatoPizza.add(userFood);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userTomatoPizza;
	}

	public int updateUserTomatoPizzaAmount(Connection con, int sellAmount, int userNo) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateUserTomatoPizzaAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int sellTomatoPizzaGetCoin(Connection con, int sellAmount, int tomatoPizzaPrice, int userNo) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("sellTomatoPizzaGetCoin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, tomatoPizzaPrice);
			pstmt.setInt(3, userNo);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		
		return result;
	}

	public List<FoodDTO> userCornTotilla(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<FoodDTO> userCornTotilla = null;
		
		String query = prop.getProperty("userCornTotilla");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			userCornTotilla = new ArrayList<>();
			
			while(rset.next()) {
				FoodDTO userFood = new FoodDTO();
				userFood.setFoodName(rset.getString("FOOD_NAME"));
				userFood.setFoodAmount(rset.getInt("FOOD_AMOUnT"));
				userFood.setCoin(rset.getInt("COIN"));
				userFood.setFoodPrice(rset.getInt("FOOD_PRICE"));
				
				userCornTotilla.add(userFood);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userCornTotilla;
	}

	public int updateUserCornTotillaAmount(Connection con, int sellAmount, int userNo) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateUserCornTotillaAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int sellCornTotillaGetCoin(Connection con, int sellAmount, int cornTortillaPrice, int userNo) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("sellCornTotillaGetCoin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, cornTortillaPrice);
			pstmt.setInt(3, userNo);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		
		return result;
	}

	public List<FoodDTO> userGarlicJuice(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<FoodDTO> userGarlicJuice = null;
		
		String query = prop.getProperty("userGarlicJuice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			userGarlicJuice = new ArrayList<>();
			
			while(rset.next()) {
				FoodDTO userFood = new FoodDTO();
				userFood.setFoodName(rset.getString("FOOD_NAME"));
				userFood.setFoodAmount(rset.getInt("FOOD_AMOUnT"));
				userFood.setCoin(rset.getInt("COIN"));
				userFood.setFoodPrice(rset.getInt("FOOD_PRICE"));
				
				userGarlicJuice.add(userFood);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userGarlicJuice;
	}

	public int updateUserGarlicJuiceAmount(Connection con ,int sellAmount, int userNo) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateUserGarlicJuiceAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int sellGarlicJuiceGetCoin(Connection con, int sellAmount, int garilcJuicePrice, int userNo) {
		
		
		return 0;
	}

	public List<FoodDTO> userPumpkinSoup(Connection con, int userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateUserPumpkinSoupAmount(Connection con, int sellAmount, int userNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int sellPumpkinSoupGetCoin(Connection con, int sellAmount, int pumpkinSoupPrice, int userNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
