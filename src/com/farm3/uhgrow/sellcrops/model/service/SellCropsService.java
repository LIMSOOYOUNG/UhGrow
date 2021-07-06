package com.farm3.uhgrow.sellcrops.model.service;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dao.SellCropsDAO;
import com.farm3.uhgrow.sellcrops.model.dto.CropDTO;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
//import static com.farm3.uhgrow.common.JDBCTemplate.commit;
//import static com.farm3.uhgrow.common.JDBCTemplate.rollback;
import static com.farm3.uhgrow.common.JDBCTemplate.close;

public class SellCropsService {
	
	private SellCropsDAO sellCropsDAO;
	
	public SellCropsService() {
		this.sellCropsDAO = new SellCropsDAO();
	}
	
	
	/* 재화 라벨*/
	public int selectCoin() {
		Connection con = getConnection();
		int result = sellCropsDAO.selectCoin(con);
		close(con);
		return result;
	}

	

	public List<CropDTO> userTomatoList(int userNo) {
		
		Connection con = getConnection();
		
		List<CropDTO> userCropList = sellCropsDAO.userTomatoList(con, userNo);

		close(con);
		
		return userCropList;
	}
	
	/*토마토 판매 수량 업데이트*/
	public int updateUserTomatoAmount(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int updateTomatoAmount = sellCropsDAO.updateTomatoCropAmount(con, sellAmount, userNo);
		
		close(con);
		
		return updateTomatoAmount;
	}


	/* 토마토 팔고 난 후 금액 받기*/
	public int sellTomatoGetCoin(int sellAmount, int tomaotoPrice, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellTomatoGetCoin(con, sellAmount, tomaotoPrice, userNo);
		
		close(con);
		
		return result;
	}

/////////////////////////////////////////////////////////////////////////

	public List<CropDTO> userCornList(int userNo) {
		
		Connection con = getConnection();
		
		List<CropDTO> userCornList = sellCropsDAO.userCornList(con, userNo);

		close(con);
		
		return userCornList;
	}
	
	/* 옥수수 판매 수량 업데이트*/
	public int updateUserCornAmount(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int updateCornAmount = sellCropsDAO.updateCornAmount(con, sellAmount, userNo);
		
		close(con);
		
		return updateCornAmount;
	
	}


	/* 옥수수 팔고 난 후 금액 받기*/	
	
	public int sellCornGetCoin(int sellAmount, int cornPrice, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellCornGetCoin(con, sellAmount, cornPrice, userNo);
		
		close(con);
		
		return result;
	}

/////////////////////////////////////////////////////////////////////////

	/* 마늘 수량 업데이트*/

	public List<CropDTO> userGarlicList(int userNo) {
		
		Connection con = getConnection();
		
		List<CropDTO> userGarlicList = sellCropsDAO.userGarlicList(con, userNo);

		close(con);
		
		return userGarlicList;
	}

	public int updateUserGarlicAmount(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int updateGarlicAmount = sellCropsDAO.updateGarlicAmount(con, sellAmount, userNo);
		
		close(con);
		
		return updateGarlicAmount;
	
	}
	
	public int sellGarlicGetCoin(int sellAmount, int garlicPrice, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellGarlicGetCoin(con, sellAmount, garlicPrice, userNo);
		
		close(con);
		
		return result;
	}

/////////////////////////////////////////////////////////////////////////
	
	public List<CropDTO> userPumpkinList(int userNo) {
		
		Connection con = getConnection();
		
		List<CropDTO> userPumpkinList = sellCropsDAO.userPumpkinList(con, userNo);

		close(con);
		
		return userPumpkinList;
	}
	
	/* 호박 수량 업데이트*/
	public int updateUserPumpkinAmount(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int updatePumpkinAmount = sellCropsDAO.updatePumpkinAmount(con, sellAmount, userNo);
		
		close(con);
		
		return updatePumpkinAmount;
	}



	public int sellPumpkinGetCoin(int sellAmount, int pumpkinPrice, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellPumpkinCoin(con, sellAmount, pumpkinPrice, userNo);
		
		close(con);
		
		return result;
	}

/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	
	
	
	
	/* 씨앗 판매*/
	
	
	/*토마토 씨앗 판매 */
	public List<CropDTO> userTomatoSeed(int userNo) {
		
		Connection con = getConnection();
		
		List<CropDTO> userTomatoSeed = sellCropsDAO.userTomatoSeed(con, userNo);
		
		close(con);
		
		return userTomatoSeed;
	}



	public int updateUserTomatoSeed(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int updateUserTomatoSeed = sellCropsDAO.updateUserTomatoSeed(con, sellAmount, userNo);
		
		close(con);
		
		return updateUserTomatoSeed;
	}



	public int sellTomatoSeedGetCoin(int sellAmount, int tomatoSeedPrice, int userNo) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellTomatoSeedGetCoin(con, sellAmount, tomatoSeedPrice, userNo);
		
		close(con);
		
		return result;
	}


/////////////////////////////////////////////////////////////////////////
	 /* 옥수수 씨앗 판매*/
	public List<CropDTO> userCornSeed(int userNo) {
		
		Connection con = getConnection();
		
		List<CropDTO> userCornSeed = sellCropsDAO.userCornSeed(con, userNo);
		
		close(con);
		
		return userCornSeed;
	}


	public int updateUserCornSeed(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int updateUserCornSeed = sellCropsDAO.updateUserCornSeed(con, sellAmount, userNo);
		
		close(con);
		
		return updateUserCornSeed;
	}


	public int sellCornSeedGetCoin(int sellAmount, int cornSeedPrice, int userNo) {
		
		Connection con = getConnection();

		int result = sellCropsDAO.sellCornSeedGetCoin(con, sellAmount, cornSeedPrice, userNo);
		
		close(con);
		
		return result;
	}

	
/////////////////////////////////////////////////////////////////////////	
	/* 유저 마늘 씨앗 판매*/
	public List<CropDTO> userGarlicSeed(int userNo) {
		
		Connection con = getConnection();
		
		List<CropDTO> userGarlicSeed = sellCropsDAO.userGarlicSeed(con, userNo);
		
		close(con);
		
		return userGarlicSeed;
		
	}


	public int updateUserGarlicSeed(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int updateUserGarlicSeed = sellCropsDAO.updateUserGarlicSeed(con, sellAmount, userNo);
		
		close(con);
		
		return updateUserGarlicSeed;
	}


	public int sellGarlicSeedGetCoin(int sellAmount, int garlicSeedPrice, int userNo) {
		
		Connection con = getConnection();

		int result = sellCropsDAO.sellGarlicSeedGetCoin(con, sellAmount, garlicSeedPrice, userNo);
		
		close(con);
		
		return result;
		
	}

	public List<CropDTO> userPumpkinSeed(int userNo) {
		
		Connection con = getConnection();
		
		List<CropDTO> userPumpkinSeed = sellCropsDAO.userPumpkinSeed(con, userNo);
		
		close(con);
		
		return userPumpkinSeed;
		
	}

	public int updateUserPumpkinSeed(int sellAmount, int userNo) {
		
		Connection con = getConnection();
		
		int updateUserGarlicSeed = sellCropsDAO.updateUserPumpkinSeed(con, sellAmount, userNo);
		
		close(con);
		
		return updateUserGarlicSeed;
	}


	public int sellPumpkinSeedGetCoin(int sellAmount, int pumpkinSeedPrice, int userNo) {
	
		Connection con = getConnection();

		int result = sellCropsDAO.sellPumpkinSeedGetCoin(con, sellAmount, pumpkinSeedPrice, userNo);
		
		close(con);
		
		return result;
		
	}


}
