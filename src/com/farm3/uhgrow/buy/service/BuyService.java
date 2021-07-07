package com.farm3.uhgrow.buy.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.buy.model.dao.BuyDAO;
import com.farm3.uhgrow.buy.model.dto.BuyDTO;
import com.farm3.uhgrow.farm.model.dto.RetainToolDTO;

public class BuyService {

	private BuyDAO buyCropsDAO;

	public BuyService() {
		this.buyCropsDAO = new BuyDAO();
	}

	public List<BuyDTO> userTomatoList() {

		Connection con = getConnection();

		List<BuyDTO> userTomatoList = buyCropsDAO.userTomatoList(con);

		close(con);

		return userTomatoList;
	}
	public List<BuyDTO> userCornList() {

		Connection con = getConnection();

		List<BuyDTO> userCornList = buyCropsDAO.userCornList(con);

		close(con);

		return userCornList;
	}

	public List<BuyDTO> userGarlicList() {

		Connection con = getConnection();

		List<BuyDTO> userGarlicList = buyCropsDAO.userGarlicList(con);

		close(con);

		return userGarlicList;
	}

	public List<BuyDTO> userPumpkinList() {

		Connection con = getConnection();

		List<BuyDTO> userPumpkinList = buyCropsDAO.userPumpkinList(con);

		close(con);

		return userPumpkinList;
	}

	public int updateTomatoCropAmount(int buyAmount) {

		Connection con = getConnection();

		int updateTomatoCropAmount = buyCropsDAO.updateTomatoCropAmount(con, buyAmount);

		close(con);

		return updateTomatoCropAmount;
	}

	public int updateCornCropAmount(int buyAmount) {

		Connection con = getConnection();

		int updateCornCropAmount = buyCropsDAO.updateCornCropAmount(con, buyAmount);

		close(con);

		return updateCornCropAmount;
	}

	public int updateGarlicCropAmount(int buyAmount) {

		Connection con = getConnection();

		int updateGarlicCropAmount = buyCropsDAO.updateGarlicCropAmount(con, buyAmount);

		close(con);

		return updateGarlicCropAmount;
	}

	public int updatePumpkinCropAmount(int buyAmount) {

		Connection con = getConnection();

		int updatePumpkinCropAmount = buyCropsDAO.updatePumpkinCropAmount(con, buyAmount);

		close(con);

		return updatePumpkinCropAmount;
	}

	/* 토마토씨앗 구매 후 금액 */
	public int buyTomatoGetCoin(int buyAmount, int tomatoPrice) {

		Connection con = getConnection();

		int result = buyCropsDAO.buyTomatoGetCoin(con, buyAmount, tomatoPrice);

		close(con);

		return result;
	}

	public int buyCornGetCoin(int buyAmount, int cornPrice) {

		Connection con = getConnection();

		int result = buyCropsDAO.buyCornGetCoin(con, buyAmount, cornPrice);

		close(con);

		return result;
	}

	public int buyGarlicGetCoin(int buyAmount, int GarlicPrice) {

		Connection con = getConnection();

		int result = buyCropsDAO.buyGarlicGetCoin(con, buyAmount, GarlicPrice);

		close(con);

		return result;
	}

	public int buyPumpkinGetCoin(int buyAmount, int pumpkinPrice) {

		Connection con = getConnection();

		int result = buyCropsDAO.buyPumpkinGetCoin(con, buyAmount, pumpkinPrice);

		close(con);

		return result;
	}
	public int selectPrice(int toolId) {
		Connection con = getConnection();

		int selectPrice = buyCropsDAO.selectPrice(con, toolId );

		close(con);

		return selectPrice;
	}



	public char istoolYN(int userNo) {

		Connection con = getConnection();

		char istoolYN = buyCropsDAO.istoolYN(con, userNo);

		close(con);

		return istoolYN;
	}



	public int currentCoin(BuyDTO buyDTO) {
		Connection con = getConnection();

		int currentCoin = buyCropsDAO.currentCoin(con, buyDTO);

		close(con);

		return currentCoin;
	}



	public void updateCoinTool(BuyDTO buyDTO) {
		Connection con = getConnection();

		buyCropsDAO.updateCoinTool(con, buyDTO);

		close(con);
	}



	public int plusExp(int toolId) {
		Connection con = getConnection();

		int plusExp = buyCropsDAO.plusExp(con, toolId);

		close(con);
		return plusExp;
	}



	public List<RetainToolDTO> selectRetainToolList(int userNo) {
		Connection con = getConnection();

		List<RetainToolDTO> retainToolList = buyCropsDAO.selectRetainToolList(con, userNo);

		close(con);

		return retainToolList;
	}



	public void createRetainToolList(int userNo) {
		Connection con = getConnection();

		buyCropsDAO.createRetainToolList(con, userNo);

		close(con);

	}





  int result = buyCropsDAO.buyGarlicGetCoin(con, buyAmount, GarlicPrice);

		close(con);

		return result;
	}

	public int buyPumpkinGetCoin(int buyAmount, int pumpkinPrice) {

		Connection con = getConnection();

		int result = buyCropsDAO.buyPumpkinGetCoin(con, buyAmount, pumpkinPrice);

		close(con);

		return result;
	}

	public int selectPrice(int toolId) {
		Connection con = getConnection();

		int selectPrice = buyCropsDAO.selectPrice(con, toolId);


		if (selectPrice >0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return selectPrice;
	}

	public RetainToolDTO isToolYN(int userNo, int toolId) {
		Connection con = getConnection();

		RetainToolDTO isToolYN = buyCropsDAO.isToolYN(con, userNo,toolId);

		if (isToolYN !=null) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return isToolYN;
	}

	public int currentCoin(BuyDTO buyDTO) {
		Connection con = getConnection();

		int currentCoin = buyCropsDAO.currentCoin(con, buyDTO);
		if (currentCoin >0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return currentCoin;

	}

	public int updateCoinTool(BuyDTO buyDTO) {
		Connection con = getConnection();

		int result = buyCropsDAO.updateCoinTool(con, buyDTO);
		if (result >0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public int plusExp(int toolId) {
		Connection con = getConnection();

		int plusExp = buyCropsDAO.plusExp(con, toolId);
		
		if (plusExp >0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return plusExp;
	}

	public List<RetainToolDTO> selectRetainToolList(int userNo) {
		Connection con = getConnection();
		
		List<RetainToolDTO> retainToolList = buyCropsDAO.selectRetainToolList(con,userNo);
		if (retainToolList.size() >0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return retainToolList;
	}

	public int createRetainToolList(int userNo) {
		Connection con = getConnection();

		int result = buyCropsDAO.createRetainToolList(con, userNo);
		if (result >0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
