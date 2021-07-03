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


	public CropDTO getCropPrice(Connection con) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		CropDTO getCropPrice = null;
		
		String query = prop.getProperty("cropPrice");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				getCropPrice = new CropDTO();
				
				getCropPrice.setCropPrice(rset.getInt("CROP_PRICE"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return getCropPrice;
	}


	public CropDTO updateCropAmount(Connection con, int sellAmount) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		CropDTO updateCropAmount = null;
		
		String query = prop.getProperty("updateCropAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				updateCropAmount = new CropDTO();
				
				updateCropAmount.setCropAmount(rset.getInt("CROP_AMONT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return updateCropAmount;
	}
	
}
