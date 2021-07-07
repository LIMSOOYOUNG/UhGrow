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
import com.farm3.uhgrow.farm.model.dto.FarmCropDTO;

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
	public List<RetainCropDTO> selectAllCrop(Connection con, FarmCropDTO farmCropDTO) {
		PreparedStatement pstmt = null; // 쿼리 경로를 불러오기위한 statement 선언
		ResultSet rset = null; // 결과값 저장을위한 ResultSet선언

		List<RetainCropDTO> retainAllList = null;

		String query = prop.getProperty("selectAllCropAndSeed");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, farmCropDTO.getUserNo());

			rset = pstmt.executeQuery();

			retainAllList = new ArrayList<>();
			while (rset.next()) {
				RetainCropDTO seed = new RetainCropDTO();
				seed.setCropId(rset.getInt("CROP_ID"));
				seed.setCropName(rset.getString("CROP_NAME"));
				seed.setCropAmount(rset.getInt("CROP_AMOUNT"));
				retainAllList.add(seed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return retainAllList;
	}

	public List<RetainCropDTO> selectAllSeed(Connection con, FarmCropDTO farmCropDTO) {

		PreparedStatement pstmt = null; // 쿼리 경로를 불러오기위한 statement 선언
		ResultSet rset = null; // 결과값 저장을위한 ResultSet선언

		List<RetainCropDTO> retainCropList = null;

		String query = prop.getProperty("selectAllCategory");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, farmCropDTO.getUserNo());

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
			pstmt.setInt(2, cropDTO.getUserNo());
			

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
			pstmt.setInt(2, farmCropDTO.getUserNo());
			pstmt.setInt(3, farmCropDTO.getCropId());
			pstmt.setInt(4, farmCropDTO.getAccumulate());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // statement 할당 반납
		}

		return result;
	}

	public UserInfoDTO selectFarmExp(Connection con, int userId) {
		PreparedStatement pstmt = null; // 쿼리 경로를 불러오기위한 statement 선언
		ResultSet rset = null; // 결과값 저장을위한 ResultSet선언

		UserInfoDTO userInfo = new UserInfoDTO();
		String query = prop.getProperty("selectFarmExp");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				userInfo.setUserNo(userId);
				userInfo.setFarmExp(rset.getInt("FARM_EXP"));				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return userInfo;
	}

	public int deleteFarmList(Connection con, FarmCropDTO farmCropDTO, int farmList) {
		PreparedStatement pstmt = null;

		int result = 0; // 수정 성공여부 초기화

		String query = prop.getProperty("deleteFarmList"); // updateMemberPassword 쿼리문 선언

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, farmCropDTO.getUserNo());
			pstmt.setInt(2, farmList);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // statement 할당 반납
		}

		return result;
	}

	public int harvestCrop(Connection con, FarmCropDTO farmCropDTO) {
		PreparedStatement pstmt = null;

		int result = 0; // 수정 성공여부 초기화

		String query = prop.getProperty("harvestCrop"); // updateMemberPassword 쿼리문 선언

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, farmCropDTO.getUserNo());
			pstmt.setInt(2, farmCropDTO.getCropId());

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

	public int createCrop(Connection con, int cropId) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		PreparedStatement pstmt7 = null;
		PreparedStatement pstmt8 = null;
		int sum = 0;
		int result1 = 0; // 수정 성공여부 초기화
		int result2 = 0; // 수정 성공여부 초기화
		int result3 = 0; // 수정 성공여부 초기화
		int result4 = 0; // 수정 성공여부 초기화
		int result5 = 0; // 수정 성공여부 초기화
		int result6 = 0; // 수정 성공여부 초기화
		int result7 = 0; // 수정 성공여부 초기화
		int result8 = 0; // 수정 성공여부 초기화

		String query1 = prop.getProperty("createCrop1"); // updateMemberPassword 쿼리문 선언
		String query2 = prop.getProperty("createCrop2"); // updateMemberPassword 쿼리문 선언
		String query3 = prop.getProperty("createCrop3"); // updateMemberPassword 쿼리문 선언
		String query4 = prop.getProperty("createCrop4"); // updateMemberPassword 쿼리문 선언
		String query5 = prop.getProperty("createCrop5"); // updateMemberPassword 쿼리문 선언
		String query6 = prop.getProperty("createCrop6"); // updateMemberPassword 쿼리문 선언
		String query7 = prop.getProperty("createCrop7"); // updateMemberPassword 쿼리문 선언
		String query8 = prop.getProperty("createCrop8"); // updateMemberPassword 쿼리문 선언

		try {
			pstmt1 = con.prepareStatement(query1);
			pstmt2 = con.prepareStatement(query2);
			pstmt3 = con.prepareStatement(query3);
			pstmt4 = con.prepareStatement(query4);
			pstmt5 = con.prepareStatement(query5);
			pstmt6 = con.prepareStatement(query6);
			pstmt7 = con.prepareStatement(query7);
			pstmt8 = con.prepareStatement(query8);
			pstmt1.setInt(1, cropId);
			pstmt2.setInt(1, cropId);
			pstmt3.setInt(1, cropId);
			pstmt4.setInt(1, cropId);
			pstmt5.setInt(1, cropId);
			pstmt6.setInt(1, cropId);
			pstmt7.setInt(1, cropId);
			pstmt8.setInt(1, cropId);

			result1 = pstmt1.executeUpdate();
			result2 = pstmt2.executeUpdate();
			result3 = pstmt3.executeUpdate();
			result4 = pstmt4.executeUpdate();
			result5 = pstmt5.executeUpdate();
			result6 = pstmt6.executeUpdate();
			result7 = pstmt7.executeUpdate();
			result8 = pstmt8.executeUpdate();

			sum = result1 + result2 + result3 + result4 + result5 + result6 + result7 + result8;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt1); // statement 할당 반납
			close(pstmt2); // statement 할당 반납
			close(pstmt3); // statement 할당 반납
			close(pstmt4); // statement 할당 반납
			close(pstmt5); // statement 할당 반납
			close(pstmt6); // statement 할당 반납
			close(pstmt7); // statement 할당 반납
			close(pstmt8); // statement 할당 반납
		}

		return sum;
	}
	public int resetFarmList(Connection con, int userNo) {
		PreparedStatement pstmt = null;

		int result = 0; // 수정 성공여부 초기화

		String query = prop.getProperty("resetFarmList"); // updateMemberPassword 쿼리문 선언

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // statement 할당 반납
		}

		return result;
	}
	public int updateContinueYN(Connection con, int userNo) {
		PreparedStatement pstmt = null;

		int result = 0; // 수정 성공여부 초기화

		String query = prop.getProperty("updateContinueYN"); // updateMemberPassword 쿼리문 선언

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt); // statement 할당 반납
		}

		return result;
	}


}
