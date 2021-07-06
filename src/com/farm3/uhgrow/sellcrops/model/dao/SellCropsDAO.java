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

import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

public class SellCropsDAO {
	private Properties prop;

	public SellCropsDAO() {
		this.prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream("mapper/sellList.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 유저 재화 라벨*/
	public int selectCoin(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int result = 0;
		
		String query = prop.getProperty("selectCoin");
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt("COIN");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	/* 유저 토마토 리스트 */
	public List<CropDTO> userTomatoList(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<CropDTO> userCropList = null;

		String query = prop.getProperty("user-toamtolist");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();

			userCropList = new ArrayList<>();

			while (rset.next()) {
				CropDTO userCrop = new CropDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userCrop.setCoin(rset.getInt("COIN"));
				userCrop.setCropPrice(rset.getInt("CROP_PRICE"));

				userCropList.add(userCrop);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userCropList;
	}

	/* 토마토 갯수 업데이트 */
	public int updateTomatoCropAmount(Connection con, int sellAmount, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateTomatoAmount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* 토마토 팔고 난 금액 업데이트 */
	public int sellTomatoGetCoin(Connection con, int sellAmount, int tomatoPrice, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("sellTomatoGetCoin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, tomatoPrice);
			pstmt.setInt(3, userNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

//////////////////////////////////////////////////////////

	/* 유저 옥수수 리스트 조회 */
	public List<CropDTO> userCornList(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<CropDTO> userCornList = null;

		String query = prop.getProperty("user-cornList");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userCornList = new ArrayList<>();

			while (rset.next()) {
				CropDTO userCrop = new CropDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userCrop.setCoin(rset.getInt("COIN"));
				userCrop.setCropPrice(rset.getInt("CROP_PRICE"));

				userCornList.add(userCrop);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userCornList;
	}

	/* 옥수수 갯수 업데이트 */

	public int updateCornAmount(Connection con, int sellAmount, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateCornAmount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	/* 옥수수 팔고 난 금액 업데이트 */
	public int sellCornGetCoin(Connection con, int sellAmount, int cornPrice, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("sellCornGetCoin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, cornPrice);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

////////////////////////////////////////////////////////

	public List<CropDTO> userGarlicList(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<CropDTO> userGarlicList = null;

		String query = prop.getProperty("user-garlicList");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userGarlicList = new ArrayList<>();

			while (rset.next()) {
				CropDTO userCrop = new CropDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userCrop.setCoin(rset.getInt("COIN"));
				userCrop.setCropPrice(rset.getInt("CROP_PRICE"));

				userGarlicList.add(userCrop);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userGarlicList;
	}

	public int updateGarlicAmount(Connection con, int sellAmount, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateGarlicAmount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int sellGarlicGetCoin(Connection con, int sellAmount, int garlicPrice, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("sellGarlicGetCoin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, garlicPrice);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/////////////////////////////////////////////////////////////////////////////////////

	public List<CropDTO> userPumpkinList(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<CropDTO> userPumpkinList = null;

		String query = prop.getProperty("user-pumpkinList");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userPumpkinList = new ArrayList<>();

			while (rset.next()) {
				CropDTO userCrop = new CropDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userCrop.setCoin(rset.getInt("COIN"));
				userCrop.setCropPrice(rset.getInt("CROP_PRICE"));

				userPumpkinList.add(userCrop);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userPumpkinList;
	}


	public int updatePumpkinAmount(Connection con, int sellAmount, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updatePumpkinAmount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int sellPumpkinCoin(Connection con, int sellAmount, int pumpkinPrice, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("sellPumpkinGetCoin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, pumpkinPrice);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* 씨앗 판매 */

	/////////////////////////////////////////////////////////////////////////////////////

	public List<CropDTO> userTomatoSeed(Connection con, int userNo) {

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		List<CropDTO> userTomatoSeed = null;

		String query = prop.getProperty("user-tomatoSeedAmount");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userTomatoSeed = new ArrayList<>();

			while (rset.next()) {
				CropDTO userSeed = new CropDTO();
				userSeed.setUserNo(rset.getInt("USER_NO"));
				userSeed.setCropName(rset.getString("CROP_NAME"));
				userSeed.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userSeed.setCoin(rset.getInt("COIN"));
				userSeed.setCropPrice(rset.getInt("CROP_PRICE"));

				userTomatoSeed.add(userSeed);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userTomatoSeed;
	}

	public int updateUserTomatoSeed(Connection con, int sellAmount, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateTomatoSeedAmount");

		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int sellTomatoSeedGetCoin(Connection con, int sellAmount, int tomatoSeedPrice, int userNo) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("sellTomatoSeedGetCoin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, tomatoSeedPrice);
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public List<CropDTO> userCornSeed(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;

		ResultSet rset = null;

		List<CropDTO> userTomatoSeed = null;

		String query = prop.getProperty("user-cornSeedAmount");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userTomatoSeed = new ArrayList<>();

			while (rset.next()) {
				CropDTO userSeed = new CropDTO();
				userSeed.setUserNo(rset.getInt("USER_NO"));
				userSeed.setCropName(rset.getString("CROP_NAME"));
				userSeed.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userSeed.setCoin(rset.getInt("COIN"));
				userSeed.setCropPrice(rset.getInt("CROP_PRICE"));

				userTomatoSeed.add(userSeed);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userTomatoSeed;
		
	}


	public int updateUserCornSeed(Connection con, int sellAmount, int userNo) {
		
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateCornSeedAmount");

		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int sellCornSeedGetCoin(Connection con, int sellAmount, int cornSeedPrice, int userNo) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("sellCornSeedGetCoin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, cornSeedPrice);
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/* 마늘 씨앗 리스트*/
	
	public List<CropDTO> userGarlicSeed(Connection con, int userNo) {

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		List<CropDTO> userGarlicSeed = null;

		String query = prop.getProperty("user-garlicSeedAmount");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userGarlicSeed = new ArrayList<>();

			while (rset.next()) {
				CropDTO userSeed = new CropDTO();
				userSeed.setUserNo(rset.getInt("USER_NO"));
				userSeed.setCropName(rset.getString("CROP_NAME"));
				userSeed.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userSeed.setCoin(rset.getInt("COIN"));
				userSeed.setCropPrice(rset.getInt("CROP_PRICE"));

				userGarlicSeed.add(userSeed);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userGarlicSeed;
		
	}

	public int updateUserGarlicSeed(Connection con, int sellAmount, int userNo) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateGarlicSeedAmount");

		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}

	public int sellGarlicSeedGetCoin(Connection con, int sellAmount, int garlicSeedPrice, int userNo) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("sellGarlicSeedGetCoin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, garlicSeedPrice);
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<CropDTO> userPumpkinSeed(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;

		ResultSet rset = null;

		List<CropDTO> userPumpkinSeed = null;

		String query = prop.getProperty("user-pumpkinSeedAmount");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userPumpkinSeed = new ArrayList<>();

			while (rset.next()) {
				CropDTO userSeed = new CropDTO();
				userSeed.setUserNo(rset.getInt("USER_NO"));
				userSeed.setCropName(rset.getString("CROP_NAME"));
				userSeed.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userSeed.setCoin(rset.getInt("COIN"));
				userSeed.setCropPrice(rset.getInt("CROP_PRICE"));

				userPumpkinSeed.add(userSeed);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userPumpkinSeed;
	}

	public int updateUserPumpkinSeed(Connection con, int sellAmount, int userNo) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updatePumpkinSeedAmount");

		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, userNo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public int sellPumpkinSeedGetCoin(Connection con, int sellAmount, int pumpkinSeedPrice, int userNo) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("sellPumpkinSeedGetCoin");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellAmount);
			pstmt.setInt(2, pumpkinSeedPrice);
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}