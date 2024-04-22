package com.my.ziapro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ziapro.mapper.MemberMapper;
import com.my.ziapro.model.BoardVO;
import com.my.ziapro.model.MemberVO;

import jakarta.servlet.http.HttpSession;



@Service
public class MemberSVC
{
	@Autowired
	private MemberMapper memberMapper;
	private MemberVO member;
	 
	
	public boolean join(MemberVO member) {
	    MemberVO existingMember = memberMapper.findMemberByEmail(member.getMemberMail());
	    if (existingMember != null) {
	        return false;
	    }
	    int rowsAffected = memberMapper.memberJoin(member);    
	    return rowsAffected > 0;
	}

	
	public boolean login(MemberVO member, HttpSession sess) 
	{
	    MemberVO mem = memberMapper.memberLogin(member);
	    if (mem != null) {
	        sess.setAttribute("loggedInMember", mem);
	        return true;
	    }
	    return false;
	}
	
	

	public MemberVO userDetail(String memberID) 
	{
		return memberMapper.userDetail(memberID);
	}
	
}
