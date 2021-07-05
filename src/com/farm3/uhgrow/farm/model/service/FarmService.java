package com.farm3.uhgrow.farm.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;
import static com.farm3.uhgrow.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.farm.model.dao.FarmDAO;
import com.farm3.uhgrow.farm.model.dto.RetainCropDTO;
import com.farm3.uhgrow.farm.model.dto.CropDTO;
import com.farm3.uhgrow.farm.model.dto.FarmCropDTO;
import com.farm3.uhgrow.farm.model.dto.InventoryDTO;

public class FarmService {

	private FarmDAO farmDAO;

	public FarmService() {
		farmDAO = new FarmDAO();
	}

	public List<RetainCropDTO> selectAllSeed() {
		Connection con = getConnection();
		List<RetainCropDTO> retainCropList = farmDAO.selectAllSeed(con); // 리턴할 리스트 선언후 connection을
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

	public int selectFarmExp(int userId) {
		Connection con = getConnection();

		int farmExp = farmDAO.selectFarmExp(con, userId);

		if (farmExp > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return farmExp;
	}

	public int deleteFarmList(int farmList) {
		Connection con = getConnection();

		int deleteResult = farmDAO.deleteFarmList(con, farmList);

		if (deleteResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return deleteResult;
	}

	public int harvestCrop(int cropId) {
		Connection con = getConnection();

		int harvestCrop = farmDAO.harvestCrop(con, cropId);

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

}
