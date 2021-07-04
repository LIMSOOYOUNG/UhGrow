package com.farm3.uhgrow.management.model.dao;

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

import com.farm3.uhgrow.management.model.dto.ModifyCropPriceDTO;
import com.farm3.uhgrow.management.model.dto.ModifyFoodPriceDTO;
import com.farm3.uhgrow.management.model.dto.ModifyFoodRecipeDTO;
import com.farm3.uhgrow.management.model.dto.SelectCropPriceDTO;
import com.farm3.uhgrow.management.model.dto.SelectFoodPriceDTO;
import com.farm3.uhgrow.management.model.dto.SelectFoodRecipeDTO;

public class GameDataDAO {
	
	private Properties prop;
	
	public GameDataDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/game-data.xml"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


	public int modifyHousePrice(Connection con, int inputHousePrice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyHousePrice");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, inputHousePrice);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public List<SelectCropPriceDTO> selectCropPrice(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SelectCropPriceDTO> priceList = null;
		String query = prop.getProperty("selectCropPrice");
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			priceList = new ArrayList<>();
			
			while(rset.next()) {
				SelectCropPriceDTO row = new SelectCropPriceDTO();
				row.setCropName(rset.getString("CROP_NAME"));
				row.setCropPrice(rset.getInt("CROP_PRICE"));
				
				priceList.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return priceList;
	}

	public int modifyCropPrice(Connection con, ModifyCropPriceDTO modifyPriceList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyCropPrice");
		int cropId = (modifyPriceList.getCropId() + 1);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, modifyPriceList.getNewCropPrice());
			pstmt.setInt(2, cropId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public List<SelectFoodPriceDTO> selectFoodPrice(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SelectFoodPriceDTO> list = null;
		String query = prop.getProperty("selectFoodPrice");
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				SelectFoodPriceDTO row = new SelectFoodPriceDTO();
				row.setFoodName(rset.getString("FOOD_NAME"));
				row.setFoodPrice(rset.getInt("FOOD_PRICE"));
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


	public int modifyFoodPrice(Connection con, ModifyFoodPriceDTO modifyPriceList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyFoodPrice");
		int foodId = (modifyPriceList.getFoodId() + 1);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, modifyPriceList.getNewFoodPrice());
			pstmt.setInt(2, foodId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public List<ModifyFoodRecipeDTO> selectFoodRecipe(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ModifyFoodRecipeDTO> list = null;
		String query = prop.getProperty("selectFoodRecipe");
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rset.next()) {
				ModifyFoodRecipeDTO row = new ModifyFoodRecipeDTO();
				row.setFoodId(rset.getInt("FOOD_ID"));
				row.setCropRqAmount(rset.getInt("CROP_RQ_AMOUNT"));
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


	public int modifyFoodRecipe(Connection con, ModifyFoodRecipeDTO modifyRecipeList) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyFoodRecipe");
		int foodId = (modifyRecipeList.getFoodId() + 1);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, modifyRecipeList.getCropRqAmount());
			pstmt.setInt(2, foodId);
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