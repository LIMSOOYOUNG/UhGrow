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

import com.farm3.uhgrow.sellcrops.model.dto.ToolDTO;

public class SellToolDAO {
	private Properties prop;
	
	public SellToolDAO() {
		this.prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/sellList.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public List<ToolDTO> userPick(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<ToolDTO> userPickList = null;

		String query = prop.getProperty("userPick");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			userPickList = new ArrayList<>();

			while (rset.next()) {
				ToolDTO userPick = new ToolDTO();
				userPick.setToolId(rset.getInt("TOOL_ID"));
				userPick.setToolName(rset.getString("Tool_NAME"));
				userPick.setCoin(rset.getInt("COIN"));
				userPick.setToolPrice(rset.getInt("CROP_PRICE"));

				userPickList.add(userPick);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userPickList;
		
	}
}
