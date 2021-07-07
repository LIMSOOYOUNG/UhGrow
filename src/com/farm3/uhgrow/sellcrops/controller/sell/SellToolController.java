package com.farm3.uhgrow.sellcrops.controller.sell;

import java.util.List;

import com.farm3.uhgrow.sellcrops.model.dto.ToolDTO;
import com.farm3.uhgrow.sellcrops.model.service.SellToolService;

public class SellToolController {

	private ToolDTO toolDTO = new ToolDTO();
	private SellToolService sellToolService = new SellToolService();
	

	/* 유저의 곡괭이 유무, 유저의 재화조회 */
	public List<ToolDTO> userPick(int userNo) {
		
		List<ToolDTO> userPick = sellToolService.userPick(userNo);
		
		return userPick;
	}

}
