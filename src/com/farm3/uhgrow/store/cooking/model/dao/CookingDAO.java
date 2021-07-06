package com.farm3.uhgrow.store.cooking.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farm3.uhgrow.store.cooking.model.dto.RecipeDTO;
import com.farm3.uhgrow.store.cooking.model.dto.RetainCropDTO;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class CookingDAO {
	
	private Properties prop;
	
	public CookingDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/cooking.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int cookingFood(Connection con, RecipeDTO cook) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("cooking");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cook.getFoodAmount());
			pstmt.setInt(2, cook.getFoodAmount());
			pstmt.setInt(3, cook.getUserNo());
			pstmt.setInt(4, cook.getFoodId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<RetainCropDTO> selectUserCropAmount(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<RetainCropDTO> list = null;
		String query = prop.getProperty("selectUserCrop");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				RetainCropDTO row = new RetainCropDTO();
				row.setUserNo(rset.getInt("USER_NO"));
				row.setCropAmount(rset.getInt("CROP_AMOUNT"));
				
				list.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int modifyCropAmount(Connection con, RecipeDTO cook) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyCropAmount");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cook.getFoodAmount());
			pstmt.setInt(2, cook.getFoodId());
			pstmt.setInt(3, cook.getFoodId());
			pstmt.setInt(4, cook.getUserNo());
			pstmt.setInt(5, cook.getFoodId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int modifyFoodAmount(Connection con, RecipeDTO cook) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyFoodAmount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cook.getFoodAmount());
			pstmt.setInt(2, cook.getUserNo());
			pstmt.setInt(3, cook.getFoodId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
