package com.farm3.uhgrow.farm.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;
import static com.farm3.uhgrow.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.farm.model.dao.FarmDAO;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.dto.UserInfoDTO;
import com.farm3.uhgrow.farm.model.dto.CropDTO;
import com.farm3.uhgrow.farm.model.dto.FarmCropDTO;

public class FarmService {

	private FarmDAO farmDAO;

	public FarmService() {
		farmDAO = new FarmDAO();
	}
	public List<RetainCropDTO> selectAllCrop(FarmCropDTO farmCropDTO) {
		Connection con = getConnection();
		List<RetainCropDTO> retainAllList = farmDAO.selectAllCrop(con,farmCropDTO); // 리턴할 리스트 선언후 connection을
		close(con);

		return retainAllList;
	}

	public List<RetainCropDTO> selectAllSeed(FarmCropDTO farmCropDTO) {
		Connection con = getConnection();
		List<RetainCropDTO> retainCropList = farmDAO.selectAllSeed(con,farmCropDTO); // 리턴할 리스트 선언후 connection을
		close(con);

		return retainCropList;
	}

	public int chooseInputSeed(RetainCropDTO cropDTO) { // 씨앗 고르기
		Connection con = getConnection();

		int chooseResult = farmDAO.chooseInputSeed(con, cropDTO);

		if (chooseResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return chooseResult;
	}


	public int fieldInputSeed(FarmCropDTO farmCropDTO) {
		Connection con = getConnection();

		int result = farmDAO.fieldInputSeed(con, farmCropDTO);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public UserInfoDTO selectFarmExp(int userId) {
		Connection con = getConnection();

		UserInfoDTO farmExp = farmDAO.selectFarmExp(con, userId);

		if (farmExp !=null) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return farmExp;
	}

	public int deleteFarmList(FarmCropDTO farmCropDTO, int farmListNo) {
		Connection con = getConnection();

		int deleteResult = farmDAO.deleteFarmList(con,farmCropDTO, farmListNo);

		if (deleteResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return deleteResult;
	}

	public int harvestCrop(FarmCropDTO farmCropDTO) {
		Connection con = getConnection();

		int harvestCrop = farmDAO.harvestCrop(con, farmCropDTO);

		if (harvestCrop > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return harvestCrop;
	}

	public List<RetainCropDTO> inventoryCrop(int userId) {
		Connection con = getConnection();

		List<RetainCropDTO> inventoryCrop = farmDAO.inventoryCrop(con, userId);

		if (inventoryCrop!=null) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return inventoryCrop;
	}

	public int createCrop(int cropId) {
		Connection con = getConnection();

		int createCrop = farmDAO.createCrop(con, cropId);

		if (createCrop > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return createCrop;
	}
	public int resetFarmList(int userNo) {
		Connection con = getConnection();

		int resetResult = farmDAO.resetFarmList(con, userNo);

		if (resetResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return resetResult;
	}
	public int updateContinueYN(int userNo) {
		Connection con = getConnection();

		int updateContinueYN = farmDAO.updateContinueYN(con, userNo);

		if (updateContinueYN > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return updateContinueYN;
	}


}
