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
import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class FarmDAO {
	private Properties prop;
	
	public FarmDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/cropList.xml"));	//	properties클래스를 사용한 파일을 읽어들어와서 xml파일로 경로 지정
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<RetainCropDTO> selectAllSeed(Connection con) {
		
		PreparedStatement pstmt = null;											//	쿼리 경로를 불러오기위한 statement 선언
		ResultSet rset = null;													//	결과값 저장을위한 ResultSet선언

		List<RetainCropDTO> seedList = null;	
		
		String query = prop.getProperty("selectAllCategory");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			seedList = new ArrayList<>();
			while(rset.next()) {
				RetainCropDTO seed = new RetainCropDTO();
				seed.setCropId(rset.getInt("CROP_ID"));
				seed.setCropName(rset.getString("CROP_NAME"));
				seed.setCropAmount(rset.getInt("CROP_AMOUNT"));
				seedList.add(seed);
			}
			System.out.println(seedList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return seedList;
	}


	public int chooseInputSeed(Connection con, RetainCropDTO cropDTO) {
		PreparedStatement pstmt = null;		
		
		int result = 0;															//	수정 성공여부 초기화

		String query = prop.getProperty("chooseInputSeed");							//	updateMemberPassword 쿼리문 선언

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cropDTO.getCropId());
			
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);														//	statement 할당 반납
		}
		
		return result;
	}

}
