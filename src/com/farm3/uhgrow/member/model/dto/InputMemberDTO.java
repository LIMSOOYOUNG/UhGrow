package com.farm3.uhgrow.member.model.dto;

public class InputMemberDTO implements java.io.Serializable{

	private String memberId;
	private String memberPwd;
	private String memberName;
	private String email;
	public InputMemberDTO() {};
	
	public InputMemberDTO(String memberId, String memberPwd, String memberName, String email) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.email = email;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", email=" + email + "]";
	}
	
	
}
