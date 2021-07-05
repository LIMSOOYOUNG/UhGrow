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
import com.farm3.uhgrow.farm.model.dto.UserInfoDTO;
import com.farm3.uhgrow.farm.model.dto.CropDTO;
import com.farm3.uhgrow.farm.model.dto.FarmCropDTO;
import com.farm3.uhgrow.farm.model.dto.InventoryDTO;

import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class FarmDAO {
	private Properties prop;

	public FarmDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/RetainCropList.xml")); // properties클래스를 사용한 파일을 읽어들어와서 xml파일로
																				// 경로 지정
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<RetainCropDTO> selectAllSeed(Connection con) {

		PreparedStatement pstmt = null; // 쿼리 경로를 불러오기위한 statement 선언
		ResultSet rset = null; // 결과값 저장을위한 ResultSet선언

		List<RetainCropDTO> retainCropList = null;

		String query = prop.getProperty("selectAllCategory");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();

			retainCropList = new ArrayList<>();
			while (rset.next()) {
				RetainCropDTO seed = new RetainCropDTO();
				seed.setCropId(rset.getInt("CROP_ID"));
				seed.setCropName(rset.getString("CROP_NAME"));
				seed.setCropAmount(rset.getInt("CROP_AMOUNT"));
				retainCropList.add(seed);
			}
			System.out.println(retainCropList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return retainCropList;
	}

	public int chooseInputSeed(Connection con, RetainCropDTO cropDTO) {
		PreparedStatement pstmt = null;

		int result = 0; // 수정 성공여부 초기화

		String query = prop.getProperty("chooseInputSeed"); // updateMemberPassword 쿼리문 선언

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cropDTO.getCropId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // statement 할당 반납
		}

		return result;
	}

	public int fieldInputSeed(Connection con, FarmCropDTO farmCropDTO) {
		PreparedStatement pstmt = null;

		int result = 0; // 수정 성공여부 초기화

		String query = prop.getProperty("fieldInputSeed"); // updateMemberPassword 쿼리문 선언

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, farmCropDTO.getFarmList());
			pstmt.setInt(2, farmCropDTO.getCropId());
			pstmt.setInt(3, farmCropDTO.getAccumulate());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // statement 할당 반납
		}

		return result;
	}

	public int selectFarmExp(Connection con, int userId) {
		PreparedStatement pstmt = null; // 쿼리 경로를 불러오기위한 statement 선언
		ResultSet rset = null; // 결과값 저장을위한 ResultSet선언

		
		UserInfoDTO userInfo = null;
		String query = prop.getProperty("selectFarmExp");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				userInfo = new UserInfoDTO();
				userInfo.setFarmExp(rset.getInt("FARM_EXP"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userInfo.getFarmExp();
	}

	public int deleteFarmList(Connection con, int farmList) {
		PreparedStatement pstmt = null;

		int result = 0; // 수정 성공여부 초기화

		String query = prop.getProperty("deleteFarmList"); // updateMemberPassword 쿼리문 선언

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, farmList);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // statement 할당 반납
		}

		return result;
	}

	public int harvestCrop(Connection con, int cropId) {
		PreparedStatement pstmt = null;

		int result = 0; // 수정 성공여부 초기화

		String query = prop.getProperty("harvestCrop"); // updateMemberPassword 쿼리문 선언

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cropId);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // statement 할당 반납
		}

		return result;
	}

	public List<RetainCropDTO> inventoryCrop(Connection con, int userId) {
		PreparedStatement pstmt = null; // 쿼리 경로를 불러오기위한 statement 선언
		ResultSet rset = null; // 결과값 저장을위한 ResultSet선언

		
		List<RetainCropDTO> inventoryCropList = null;
		RetainCropDTO inventoryCropDTO = null;
		String query = prop.getProperty("inventoryCrop");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			
			rset = pstmt.executeQuery();
			inventoryCropList = new ArrayList<>();
			while (rset.next()) {
				inventoryCropDTO = new RetainCropDTO();
				inventoryCropDTO.setCropId(rset.getInt("CROP_ID"));
				inventoryCropDTO.setCropAmount(rset.getInt("CROP_AMOUNT"));
				inventoryCropList.add(inventoryCropDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return inventoryCropList;
		
	}

}
