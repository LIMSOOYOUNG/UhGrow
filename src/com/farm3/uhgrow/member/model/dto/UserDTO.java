package com.farm3.uhgrow.member.model.dto;

public class UserDTO {

	private int userNo;
	private String userId; 					// 유저아이디
	private String userPwd;					// 유저비밀번호
	private String userName;				// 유저이름
	private String email;					// 유저이메일
	private String authority;				// 권한 여부 (사용자 or 관리자)
	private int coin;						// 재화
	private char deleteYn;					// 회원삭제여부
	private char havingHouseYn;				// 집보유여부
	private int farmExp;					// 농부기본경험치 (재배시 기본 능력치)
	private int housePrice;					// 집 가격
	
	
	public UserDTO() {}
	
	public UserDTO(int userNo, String userId, String userPwd, String userName, String email, String authority, int coin,
			char deleteYn, char havingHouseYn, int farmExp, int housePrice) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.authority = authority;
		this.coin = coin;
		this.deleteYn = deleteYn;
		this.havingHouseYn = havingHouseYn;
		this.farmExp = farmExp;
		this.housePrice = housePrice;
	}
	public UserDTO(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public char getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(char deleteYn) {
		this.deleteYn = deleteYn;
	}
	public char getHavingHouseYn() {
		return havingHouseYn;
	}
	public void setHavingHouseYn(char havingHouseYn) {
		this.havingHouseYn = havingHouseYn;
	}
	public int getFarmExp() {
		return farmExp;
	}
	public void setFarmExp(int farmExp) {
		this.farmExp = farmExp;
	}
	public int getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}
	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", email=" + email + ", authority=" + authority + ", coin=" + coin + ", deleteYn=" + deleteYn
				+ ", havingHouseYn=" + havingHouseYn + ", farmExp=" + farmExp + ", housePrice=" + housePrice + "]";
	}
	
}
