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
		
		String query = prop.getProperty("userCropList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			userCropList = new ArrayList<>();
			
			while(rset.next()) {
				CropDTO userCrop = new CropDTO();
				userCrop.setuserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
//				userCrop.setCropAmout(rset.getInt("CROP_AMOUNT"));  DTO 필드에 cropAmount 추가예정
				
				userCropList.add(userCrop);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    close(rset);
		}   close(pstmt);
		
		
		return userCropList;
	}


	
	
//	public int sellTomato(Connection con, CropDTO crop) {
//		
//		PreparedStatement pstmt = null;
//		
//		int sellCropResult = 0;
//		
//		String query = prop.getProperty("sellTomato");
//		
//		try {
//			pstmt = con.prepareStatement(query);
////			pstmt.setString(1, crop.getCropName());						// 농작물을 가지고 회원의 정보를 알아야되는데 CropDTO에 userId를 추가해야될거 같애서 주석 처리 해놨습니다.
////			pstmt.setInt(2, crop.getCropId());							// 각 농작물마다 dto를 만들어줘야될거 같습니다.
////			pstmt.setInt(3, crop.getCropPrice());						// 위랑 동일
//			
//			sellCropResult = pstmt.executeUpdate();
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return sellCropResult;
//	}
//
//	public int sellCorn(Connection con, CropDTO crop) {
//		
//		PreparedStatement pstmt = null;
//		
//		int sellCropResult = 0;
//		
//		String query = prop.getProperty("sellCorn");
//		
//		try {
//			pstmt = con.prepareStatement(query);
//			
////			pstmt.setString(1, crop.getCropName());						// 토마토 판매랑 동일한 이유로 
////			pstmt.setInt(2, crop.getCropId());
////			pstmt.setInt(3, crop.getCropPrice());
//			
//			sellCropResult = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return sellCropResult;
//	}
//
//	
//	
//	
//	
}
