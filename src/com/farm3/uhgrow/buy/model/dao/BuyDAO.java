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

//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, buy.getCoin());
//			buyHouseResult = pstmt.executeUpdate();
//
//			int result = 0; //집을 살수 없음
//			if(buy.getCoin() > 100 && buy.getHavingHouseYn()=="n") { //가진 재화가 필요 요건을 충족하고, 집을 보유하고 있지 않을경우
//			buyHouseResult = 1;                                      //집을 구매 할 수 있음. 아닐 경우 구매 불가
//
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}

		return buyHouseResult;
	}


}
