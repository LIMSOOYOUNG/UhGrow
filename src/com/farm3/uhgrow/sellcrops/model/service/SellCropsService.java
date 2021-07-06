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

	

	public List<CropDTO> userTomatoList() {
		
		Connection con = getConnection();
		
		List<CropDTO> userCropList = sellCropsDAO.userTomatoList(con);

		close(con);
		
		return userCropList;
	}
	
	/*토마토 판매 수량 업데이트*/
	public int updateUserTomatoAmount(int sellAmount) {
		
		Connection con = getConnection();
		
		int updateTomatoAmount = sellCropsDAO.updateTomatoCropAmount(con, sellAmount);
		
		close(con);
		
		return updateTomatoAmount;
	}


	/* 토마토 팔고 난 후 금액 받기*/
	public int sellTomatoGetCoin(int sellAmount, int tomaotoPrice) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellTomatoGetCoin(con, sellAmount, tomaotoPrice);
		
		close(con);
		
		return result;
	}

/////////////////////////////////////////////////////////////////////////

	public List<CropDTO> userCornList() {
		
		Connection con = getConnection();
		
		List<CropDTO> userCornList = sellCropsDAO.userCornList(con);

		close(con);
		
		return userCornList;
	}
	
	/* 옥수수 판매 수량 업데이트*/
	public int updateUserCornAmount(int sellAmount) {
		
		Connection con = getConnection();
		
		int updateCornAmount = sellCropsDAO.updateCornAmount(con, sellAmount);
		
		close(con);
		
		return updateCornAmount;
	
	}


	/* 옥수수 팔고 난 후 금액 받기*/	
	
	public int sellCornGetCoin(int sellAmount, int cornPrice) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellCornGetCoin(con, sellAmount, cornPrice);
		
		close(con);
		
		return result;
	}

/////////////////////////////////////////////////////////////////////////

	/* 마늘 수량 업데이트*/

	public List<CropDTO> userGarlicList() {
		
		Connection con = getConnection();
		
		List<CropDTO> userGarlicList = sellCropsDAO.userGarlicList(con);

		close(con);
		
		return userGarlicList;
	}

	public int updateUserGarlicAmount(int sellAmount) {
		
		Connection con = getConnection();
		
		int updateGarlicAmount = sellCropsDAO.updateGarlicAmount(con, sellAmount);
		
		close(con);
		
		return updateGarlicAmount;
	
	}
	
	public int sellGarlicGetCoin(int sellAmount, int garlicPrice) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellGarlicGetCoin(con, sellAmount, garlicPrice);
		
		close(con);
		
		return result;
	}

/////////////////////////////////////////////////////////////////////////
	
	public List<CropDTO> userPumpkinList() {
		
		Connection con = getConnection();
		
		List<CropDTO> userPumpkinList = sellCropsDAO.userPumpkinList(con);

		close(con);
		
		return userPumpkinList;
	}
	
	/* 호박 수량 업데이트*/
	public int updateUserPumpkinAmount(int sellAmount) {
		
		Connection con = getConnection();
		
		int updatePumpkinAmount = sellCropsDAO.updatePumpkinAmount(con, sellAmount);
		
		close(con);
		
		return updatePumpkinAmount;
	}



	public int sellPumpkinGetCoin(int sellAmount, int pumpkinPrice) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellPumpkinCoin(con, sellAmount, pumpkinPrice);
		
		close(con);
		
		return result;
	}

/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	
	
	
	
	/* 씨앗 판매*/
	
	
	/*토마토 씨앗 판매 */
	public List<CropDTO> userTomatoSeed() {
		
		Connection con = getConnection();
		
		List<CropDTO> userTomatoSeed = sellCropsDAO.userTomatoSeed(con);
		
		close(con);
		
		return userTomatoSeed;
	}



	public int updateUserTomatoSeed(int sellAmount) {
		
		Connection con = getConnection();
		
		int updateUserTomatoSeed = sellCropsDAO.updateUserTomatoSeed(con, sellAmount);
		
		close(con);
		
		return updateUserTomatoSeed;
	}



	public int sellTomatoSeedGetCoin(int sellAmount, int tomatoSeedPrice) {
		
		Connection con = getConnection();
		
		int result = sellCropsDAO.sellTomatoSeedGetCoin(con, sellAmount, tomatoSeedPrice);
		
		close(con);
		
		return result;
	}


/////////////////////////////////////////////////////////////////////////
	 /* 옥수수 씨앗 판매*/
	public List<CropDTO> userCornSeed() {
		
		Connection con = getConnection();
		
		List<CropDTO> userCornSeed = sellCropsDAO.userCornSeed(con);
		
		close(con);
		
		return userCornSeed;
	}


	public int updateUserCornSeed(int sellAmount) {
		
		Connection con = getConnection();
		
		int updateUserCornSeed = sellCropsDAO.updateUserCornSeed(con, sellAmount);
		
		close(con);
		
		return updateUserCornSeed;
	}


	public int sellCornSeedGetCoin(int sellAmount, int cornSeedPrice) {
		
		Connection con = getConnection();

		int result = sellCropsDAO.sellCornSeedGetCoin(con, sellAmount, cornSeedPrice);
		
		close(con);
		
		return result;
	}

	
/////////////////////////////////////////////////////////////////////////	
	/* 유저 마늘 씨앗 판매*/
	public List<CropDTO> userGarlicSeed() {
		
		Connection con = getConnection();
		
		List<CropDTO> userGarlicSeed = sellCropsDAO.userGarlicSeed(con);
		
		close(con);
		
		return userGarlicSeed;
		
	}


	public int updateUserGarlicSeed(int sellAmount) {
		
		Connection con = getConnection();
		
		int updateUserGarlicSeed = sellCropsDAO.updateUserGarlicSeed(con, sellAmount);
		
		close(con);
		
		return updateUserGarlicSeed;
	}


	public int sellGarlicSeedGetCoin(int sellAmount, int garlicSeedPrice) {
		
		Connection con = getConnection();

		int result = sellCropsDAO.sellGarlicSeedGetCoin(con, sellAmount, garlicSeedPrice);
		
		close(con);
		
		return result;
		
	}

	public List<CropDTO> userPumpkinSeed() {
		
		Connection con = getConnection();
		
		List<CropDTO> userPumpkinSeed = sellCropsDAO.userPumpkinSeed(con);
		
		close(con);
		
		return userPumpkinSeed;
		
	}

	public int updateUserPumpkinSeed(int sellAmount) {
		
		Connection con = getConnection();
		
		int updateUserGarlicSeed = sellCropsDAO.updateUserPumpkinSeed(con, sellAmount);
		
		close(con);
		
		return updateUserGarlicSeed;
	}


	public int sellPumpkinSeedGetCoin(int sellAmount, int pumpkinSeedPrice) {
	
		Connection con = getConnection();

		int result = sellCropsDAO.sellPumpkinSeedGetCoin(con, sellAmount, pumpkinSeedPrice);
		
		close(con);
		
		return result;
		
	}


}
