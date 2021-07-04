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

import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

public class SellCropsDAO {
	private Properties prop;
	
	public SellCropsDAO() {									
		this.prop = new Properties();
	
		try {
			prop.loadFromXML(new FileInputStream("mapper/user-croplist.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<CropDTO> userCropList(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CropDTO> userCropList = null;
		
		String query = prop.getProperty("user-croplist");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			userCropList = new ArrayList<>();
			
			while(rset.next()) {
				CropDTO userCrop = new CropDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));  
				userCrop.setCoin(rset.getInt("COIN"));
				userCrop.setCropPrice(rset.getInt("CROP_PRICE"));
				
				userCropList.add(userCrop);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    close(rset);
		    close(pstmt);
		}
		
		return userCropList;
	}

	public List<CropDTO> userCornList(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CropDTO> userCornList = null;
		
		String query = prop.getProperty("user-cornList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			userCornList = new ArrayList<>();
			
			while(rset.next()) {
				CropDTO userCrop = new CropDTO();
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
	
	public List<CropDTO> userGarlicList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CropDTO> userGarlicList = null;
		
		String query = prop.getProperty("user-garlicList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			userGarlicList = new ArrayList<>();
			
			while(rset.next()) {
				CropDTO userCrop = new CropDTO();
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
	
	public List<CropDTO> userPumpkinList(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CropDTO> userPumpkinList = null;
		
		String query = prop.getProperty("user-pumpkinList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			userPumpkinList = new ArrayList<>();
			
			while(rset.next()) {
				CropDTO userCrop = new CropDTO();
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
	
	/* 토마토 갯수 업데이트*/
	public int updateTomatoCropAmount(Connection con, int sellAmount) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateTomatoCropAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
		
	/* 토마토 팔고 난 금액 업데이트*/
	public int sellTomatoGetCoin(Connection con, int sellAmount) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("sellTomatoGetCoin");
			
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}








	
}
