package com.farm3.uhgrow.buy.model.dao;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.farm3.uhgrow.buy.model.dto.BuyDTO;

public class BuyDAO {
	private Properties prop;

	public BuyDAO() {									
		this.prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int buyHouse(Connection con, BuyDTO buy) {

		PreparedStatement pstmt = null;

		int buyHouseResult = 0;

		String query = prop.getProperty("buyHouse");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buy.getCoin());

			buyHouseResult = pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return buyHouseResult;
	}


}
