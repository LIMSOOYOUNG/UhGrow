package com.farm3.uhgrow.management.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.commit;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;
import static com.farm3.uhgrow.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.management.model.dao.GameDataDAO;
import com.farm3.uhgrow.management.model.dto.ModifyCropPriceDTO;
import com.farm3.uhgrow.management.model.dto.ModifyFoodPriceDTO;
import com.farm3.uhgrow.management.model.dto.ModifyFoodRecipeDTO;
import com.farm3.uhgrow.management.model.dto.SelectCropPriceDTO;
import com.farm3.uhgrow.management.model.dto.SelectFoodPriceDTO;

public class GameDataService {
	
	private static GameDataDAO gameDataDAO;
	
	public GameDataService() {
		this.gameDataDAO = new GameDataDAO();
	}

	public int modifyCropPrice(ModifyCropPriceDTO modifyPriceList) {
		Connection con = getConnection();
		int result = gameDataDAO.modifyCropPrice(con, modifyPriceList);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int modifyHousePrice(int inputHousePrice) {
		
		Connection con = getConnection();
		
		int result = gameDataDAO.modifyHousePrice(con, inputHousePrice);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}

	public static List<SelectCropPriceDTO> selectCropPriceData() {
		Connection con = getConnection();
		List<SelectCropPriceDTO> userList = gameDataDAO.selectCropPrice(con);
		close(con);
		return userList;
	}

	public static List<SelectFoodPriceDTO> selectFoodPriceData() {
		Connection con = getConnection();
		List<SelectFoodPriceDTO> userList = gameDataDAO.selectFoodPrice(con);
		close(con);
		return userList;
	}

	public int modifyFoodPrice(ModifyFoodPriceDTO modifyPriceList) {
		Connection con = getConnection();
		int result = gameDataDAO.modifyFoodPrice(con, modifyPriceList);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public static List<ModifyFoodRecipeDTO> selectFoodRecipeData() {
		Connection con = getConnection();
		List<ModifyFoodRecipeDTO> userList = gameDataDAO.selectFoodRecipe(con);
		close(con);
		return userList;
	}

	public int modifyFoodRecipe(ModifyFoodRecipeDTO modifyRecipeList) {
		Connection con = getConnection();
		int result = gameDataDAO.modifyFoodRecipe(con, modifyRecipeList);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}