package com.farm3.uhgrow.management.model.dto;

public class ModifyUserDTO {
	
	private String oldId;
	private String newId;
	private String newPwd;
	
	public ModifyUserDTO() {}

	public ModifyUserDTO(String oldId, String newId, String newPwd) {
		super();
		this.oldId = oldId;
		this.newId = newId;
		this.newPwd = newPwd;
	}

	public String getOldId() {
		return oldId;
	}

	public String getNewId() {
		return newId;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	@Override
	public String toString() {
		return "ModifyUserDTO [oldId=" + oldId + ", newId=" + newId + ", newPwd=" + newPwd + "]";
	}
	
	

}
