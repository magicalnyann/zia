package com.my.ziapro.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.my.ziapro.model.MemberVO;

@Mapper
public interface MemberMapper {


	public int memberJoin(MemberVO member);

	MemberVO findMemberByEmail(String email);

	public MemberVO memberLogin(MemberVO member);

	MemberVO userDetail(String memberID);

}
