package com.farm3.uhgrow.management.view;

import java.util.List;

import com.farm3.uhgrow.management.model.dto.SelectUserDTO;

public class MngResultView {
	
	public static void mngResult(String code) {
		
		switch(code) {
		case "modifySuccess" : System.out.println("계정수정이 완료되었습니다."); break;
		case "deleteSuccess" : System.out.println("계정삭제가 완료되었습니다."); break;
		case "recoverSuccess" : System.out.println("계정복구가 완료되었습니다."); break;
		case "modifyFailed" : System.out.println("계정수정에 실패했습니다."); break;
		case "deleteFailed" : System.out.println("계정삭제에 실패했습니다."); break;
		case "recoverFailed" : System.out.println("계정복구에 실패했습니다."); break;
		}
	}
	
	public static void listResult(List<SelectUserDTO> list) {
		for(SelectUserDTO u : list) {
			System.out.println(u);
		}
	}

}
