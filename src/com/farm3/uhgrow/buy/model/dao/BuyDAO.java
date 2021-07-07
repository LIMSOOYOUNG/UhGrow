package com.farm3.uhgrow.buy.model.dao;

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

import com.farm3.uhgrow.buy.model.dto.BuyDTO;
import com.farm3.uhgrow.farm.model.dto.RetainToolDTO;

public class BuyDAO {
	private Properties prop;

	public BuyDAO() {
		this.prop = new Properties();

		try {
			prop.loadFromXML(new FileInputStream("mapper/user-buycroplist.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 유저 재화 라벨 */
	public int selectCoin(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int result = 0;

		String query = prop.getProperty("selectCoin");
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
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

	public List<BuyDTO> userTomatoList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<BuyDTO> userTomatoList = null;

		String query = prop.getProperty("user-tomatolist");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userTomatoList = new ArrayList<>();

			while (rset.next()) {
				BuyDTO userCrop = new BuyDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userCrop.setCoin(rset.getInt("COIN"));
				userCrop.setCropPrice(rset.getInt("CROP_PRICE"));

				userTomatoList.add(userCrop);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return userTomatoList;
	}

	public List<BuyDTO> userCornList(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<BuyDTO> userCornList = null;

		String query = prop.getProperty("user-cornList");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userCornList = new ArrayList<>();

			while (rset.next()) {
				BuyDTO userCrop = new BuyDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userCrop.setCoin(rset.getInt("COIN"));

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

	public List<BuyDTO> userGarlicList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<BuyDTO> userGarlicList = null;

		String query = prop.getProperty("user-garlicList");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userGarlicList = new ArrayList<>();

			while (rset.next()) {
				BuyDTO userCrop = new BuyDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userCrop.setCoin(rset.getInt("COIN"));

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

	public List<BuyDTO> userPumpkinList(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<BuyDTO> userPumpkinList = null;

		String query = prop.getProperty("user-pumpkinList");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			userPumpkinList = new ArrayList<>();

			while (rset.next()) {
				BuyDTO userCrop = new BuyDTO();
				userCrop.setUserNo(rset.getInt("USER_NO"));
				userCrop.setCropName(rset.getString("CROP_NAME"));
				userCrop.setCropAmount(rset.getInt("CROP_AMOUNT"));
				userCrop.setCoin(rset.getInt("COIN"));

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

	/* 토마토씨앗 갯수 업데이트 */
	public int updateTomatoCropAmount(Connection con, int buyAmount) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateTomatoCropAmount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* 옥수수씨앗 갯수 업데이트 */
	public int updateCornCropAmount(Connection con, int buyAmount) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateCornCropAmount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* 마늘씨앗 갯수 업데이트 */
	public int updateGarlicCropAmount(Connection con, int buyAmount) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateGarlicCropAmount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* 호박씨앗 갯수 업데이트 */
	public int updatePumpkinCropAmount(Connection con, int buyAmount) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updatePumpkinCropAmount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/* 토마토 사고 난 금액 업데이트 */
	public int buyTomatoGetCoin(Connection con, int buyAmount, int tomatoPrice) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("buyTomatoGetCoin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);
			pstmt.setInt(2, tomatoPrice);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int buyCornGetCoin(Connection con, int buyAmount, int cornPrice) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("buyCornGetCoin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);
			pstmt.setInt(2, cornPrice);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int buyGarlicGetCoin(Connection con, int buyAmount, int garlicPrice) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("buyGarlicGetCoin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);
			pstmt.setInt(2, garlicPrice);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int buyPumpkinGetCoin(Connection con, int buyAmount, int pumpkinPrice) {

		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("buyPumpkinGetCoin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyAmount);
			pstmt.setInt(2, pumpkinPrice);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int selectPrice(Connection con, int toolId) {
		PreparedStatement pstmt = null;

		ResultSet rset = null;
		int selectPrice = 0;
		
		String query = prop.getProperty("getToolPrice");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, toolId);

			rset= pstmt.executeQuery();
			while(rset.next()) {				
				selectPrice = rset.getInt("TOOL_PRICE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return selectPrice;
	}

	public RetainToolDTO isToolYN(Connection con, int userNo, int toolId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		RetainToolDTO retainToolDTO =null;
		String query = prop.getProperty("isToolYN");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo); 
			pstmt.setInt(2, toolId); 
			
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				retainToolDTO = new RetainToolDTO();
				retainToolDTO.setRetainToolYn(rset.getString("RETAIN_TOOL_YN").charAt(0));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return retainToolDTO;
	}

	public int currentCoin(Connection con, BuyDTO buyDTO) {
		PreparedStatement pstmt = null;

		ResultSet rset = null;
		int currentCoin = 0;
	
		String query = prop.getProperty("currentCoin");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, buyDTO.getUserNo());
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				currentCoin = rset.getInt("COIN");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return currentCoin;
		
		
	}

	public int updateCoinTool(Connection con, BuyDTO buyDTO) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;

		int result1 = 0; // 수정 성공여부 초기화
		int result2 = 0; // 수정 성공여부 초기화
		int sum = result1+result2;
		String query1 = prop.getProperty("updateCoinExp");
		String query2 = prop.getProperty("updateToolYN");

		try {
			pstmt1 = con.prepareStatement(query1);
			pstmt1.setInt(1, buyDTO.getCoin());
			pstmt1.setInt(2, buyDTO.getToolPrice());
			pstmt1.setInt(3, buyDTO.getPlusExp());
			pstmt1.setInt(4, buyDTO.getUserNo());
			
			pstmt2 = con.prepareStatement(query2);
			pstmt2.setInt(1, buyDTO.getUserNo());
			pstmt2.setInt(2, buyDTO.getToolId());
			
			result1= pstmt1.executeUpdate();
			result2 = pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
			close(pstmt2);
		}
		return sum;
	}

	public int plusExp(Connection con, int toolId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int plusExp = 0;

		String query = prop.getProperty("plusExp");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, toolId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				plusExp = rset.getInt("PLUS_EXP");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return plusExp;
		
		
	}

	public List<RetainToolDTO> selectRetainToolList(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<RetainToolDTO> retainToolList = null;
		RetainToolDTO retainToolDTO = null;

		String query = prop.getProperty("selectRetainToolList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();
			retainToolList = new ArrayList<>();
			while (rset.next()) {
				retainToolDTO = new RetainToolDTO();
				retainToolDTO.setUserNo(rset.getInt("USER_NO"));
				retainToolDTO.setToolId(rset.getInt("TOOL_ID"));
				retainToolDTO.setRetainToolYn(rset.getString("RETAIN_TOOL_YN").charAt(0));

				retainToolList.add(retainToolDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return retainToolList;
	}

	public int createRetainToolList(Connection con, int userNo) {
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
int	sum =0;
		String query1 = prop.getProperty("insertRetainTool1");
		String query2 = prop.getProperty("insertRetainTool2");
		String query3 = prop.getProperty("insertRetainTool3");
		String query4 = prop.getProperty("insertRetainTool4");

		try {
			pstmt1 = con.prepareStatement(query1);
			pstmt1.setInt(1, userNo);
			result1 = pstmt1.executeUpdate();

			pstmt2 = con.prepareStatement(query2);
			pstmt2.setInt(1, userNo);
			result2 = pstmt2.executeUpdate();
			
			pstmt3 = con.prepareStatement(query3);
			pstmt3.setInt(1, userNo);
			result3 = pstmt3.executeUpdate();
			
			pstmt4 = con.prepareStatement(query4);
			pstmt4.setInt(1, userNo);
			result4 = pstmt4.executeUpdate();
			sum = result1 +result2+result3+result4;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt1);
			close(pstmt2);
			close(pstmt3);
			close(pstmt4);
		}
		return sum;
		
	}

}
