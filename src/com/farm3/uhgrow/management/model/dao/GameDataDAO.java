package com.farm3.uhgrow.management.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.farm3.uhgrow.management.model.dto.CropPriceDTO;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class GameDataDAO {
	
	private static Properties prop;
	
	public GameDataDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/game-data.xml"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static int modifyCropPrice(Connection con, CropPriceDTO cropPrice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("modifyCropPrice");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cropPrice.getTomatoPrice());
			pstmt.setInt(2, cropPrice.getCornPrice());
			pstmt.setInt(3, cropPrice.getGarlicPrice());
			pstmt.setInt(4, cropPrice.getPumpkinPirce());
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
