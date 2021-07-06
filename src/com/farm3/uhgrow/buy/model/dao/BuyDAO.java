package com.farm3.uhgrow.buy.model.dao;

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

import com.farm3.uhgrow.buy.model.dto.BuyDTO;

public class BuyDAO {
	private Properties prop;

	public BuyDAO() {									
		this.prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream("mapper/user-buycroplist.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<BuyDTO> userTomatoList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<BuyDTO> userTomatoList = null;

		String query = prop.getProperty("user-tomatolist");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userTomatoList = new ArrayList<>();

			while(rset.next()) {
				BuyDTO userCrop = new BuyDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));  
				userCrop.setCoin(rset.getInt("COIN"));
				userCrop.setCropPrice(rset.getInt("CROP_PRICE"));

				userTomatoList.add(userCrop);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userTomatoList;
	}
	
	public List<BuyDTO> userCornList(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BuyDTO> userCornList = null;
		
		String query = prop.getProperty("user-cornList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			userCornList = new ArrayList<>();
			
			while(rset.next()) {
				BuyDTO userCrop = new BuyDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));  
				userCrop.setCoin(rset.getInt("COIN"));
				
				userCornList.add(userCrop);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    close(rset);
		    close(pstmt);
		}
		
		return userCornList;
	}
	
	public List<BuyDTO> userGarlicList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BuyDTO> userGarlicList = null;
		
		String query = prop.getProperty("user-garlicList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			userGarlicList = new ArrayList<>();
			
			while(rset.next()) {
				BuyDTO userCrop = new BuyDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));  
				userCrop.setCoin(rset.getInt("COIN"));
				
				userGarlicList.add(userCrop);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    close(rset);
		    close(pstmt);
		}
		
		return userGarlicList;	
	}
	
	public List<BuyDTO> userPumpkinList(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BuyDTO> userPumpkinList = null;
		
		String query = prop.getProperty("user-pumpkinList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			userPumpkinList = new ArrayList<>();
			
			while(rset.next()) {
				BuyDTO userCrop = new BuyDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));  
				userCrop.setCoin(rset.getInt("COIN"));
				
				userPumpkinList.add(userCrop);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    close(rset);
		    close(pstmt);
		}
		
		return userPumpkinList;	
	}
	
	/* 토마토씨앗 갯수 업데이트*/
	public int updateTomatoCropAmount(Connection con, int buyAmount) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateTomatoCropAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* 옥수수씨앗 갯수 업데이트*/
	public int updateCornCropAmount(Connection con, int buyAmount) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateCornCropAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* 마늘씨앗 갯수 업데이트*/
	public int updateGarlicCropAmount(Connection con, int buyAmount) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateGarlicCropAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/* 호박씨앗 갯수 업데이트*/
	public int updatePumpkinCropAmount(Connection con, int buyAmount) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updatePumpkinCropAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
		
	/* 토마토 사고 난 금액 업데이트*/
	public int buyTomatoGetCoin(Connection con, int buyAmount, int tomatoPrice) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("buyTomatoGetCoin");
			
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);
			pstmt.setInt(2, tomatoPrice);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}




}
