package com.my.ziapro.model;


import lombok.Data;

@Data

public class MemberVO {
	
	private String memberID;
	
	private String memberPw;
	
	private String memberName;
	
	private String memberMail;

	private String memberAddr1;
	private String memberAddr2;
	private String memberAddr3;
	
	private int adminCK;
	
	private int rdgDate;
	
	private int money;
	
	private int point;

	
	@Override
	public String toString() {
		return "MemberVO [memberID=" + memberID + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberMail=" + memberMail + ", memberAddr1=" + memberAddr1 + ", memberAddr2=" + memberAddr2
				+ ", memberAddr3=" + memberAddr3 + ", adminCK=" + adminCK + ", rdgDate=" + rdgDate + ", money=" + money
				+ ", point=" + point + "]";	
		
	}


}
