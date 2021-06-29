package com.farm3.uhgrow.farm.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.dto.SeedDTO;

public class FarmDAO {
	private Properties prop;
	
	public FarmDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/RetainCrop-query.xml"));	//	properties클래스를 사용한 파일을 읽어들어와서 xml파일로 경로 지정
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<RetainCropDTO> selectAllSeed(Connection con) {
		
		PreparedStatement pstmt = null;											//	쿼리 경로를 불러오기위한 statement 선언
		ResultSet rset = null;													//	결과값 저장을위한 ResultSet선언

		List<RetainCropDTO> seedList = null;	
		
		String query = prop.getProperty("selectAllCrop");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			seedList = new ArrayList<>();
			while(rset.next()) {
				SeedDTO seed = new SeedDTO();
				RetainCropDTO countSeed = new RetainCropDTO();
				seed.setSeedName(rset.getString("SEED_NAME"));
				countSeed.setCropAmount(rset.getInt("CROP_AMOUNT"));
				
				seedList.add(seed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return seedList;
	}

}
