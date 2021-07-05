package com.farm3.uhgrow.farm.model.dto;

import java.io.Serializable;

public class RetainToolDTO implements Serializable {
	private int tool_id;

	public RetainToolDTO() {}

	public RetainToolDTO(int tool_id) {
		super();
		this.tool_id = tool_id;
	}

	public int getTool_id() {
		return tool_id;
	}

	public void setTool_id(int tool_id) {
		this.tool_id = tool_id;
	}

	@Override
	public String toString() {
		return "RetainToolDTO [tool_id=" + tool_id + "]";
	}

	
}
