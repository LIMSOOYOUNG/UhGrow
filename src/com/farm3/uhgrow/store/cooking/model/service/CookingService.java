package com.farm3.uhgrow.store.cooking.model.service;

import static com.farm3.uhgrow.common.JDBCTemplate.close;
import static com.farm3.uhgrow.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.farm3.uhgrow.store.cooking.model.dao.CookingDAO;
import com.farm3.uhgrow.store.cooking.model.dto.RecipeDTO;
import com.farm3.uhgrow.store.cooking.model.dto.RetainCropDTO;

public class CookingService {
	
	private CookingDAO cookingDAO;
	
	public CookingService() {
		this.cookingDAO = new CookingDAO();
	}

	public int cookingFood(RecipeDTO cook) {
		Connection con = getConnection();
		int result = cookingDAO.cookingFood(con, cook);
		close(con);
		return result;
	}

	public List<RetainCropDTO> selectUserCropAmount(int userNo) {
		Connection con = getConnection();
		List<RetainCropDTO> list = cookingDAO.selectUserCropAmount(con, userNo);
		close(con);
		return list;
	}

	public int modifyCropAmount(RecipeDTO cook) {
		Connection con = getConnection();
		int result = cookingDAO.modifyCropAmount(con, cook);
		close(con);
		return result;
	}

	public int modifyFoodAmount(RecipeDTO cook) {
		Connection con = getConnection();
		int result = cookingDAO.modifyFoodAmount(con, cook);
		close(con);
		return result;
	}

}
