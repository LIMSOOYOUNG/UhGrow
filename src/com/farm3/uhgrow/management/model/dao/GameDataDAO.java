package com.farm3.uhgrow.management.model.dao;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.farm3.uhgrow.management.model.dto.CropPriceDTO;

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

	public int modifyTomatoPrice(Connection con, CropPriceDTO cropPrice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyTomatoPrice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cropPrice.getTomatoPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int modifyCornPrice(Connection con, CropPriceDTO cropPrice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyCornPrice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cropPrice.getCornPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	public int modifyGarlicPrice(Connection con, CropPriceDTO cropPrice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyGarlicPrice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cropPrice.getGarlicPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int modifyPumpkinPrice(Connection con, CropPriceDTO cropPrice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyPumpkinPrice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cropPrice.getPumpkinPirce());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
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

}