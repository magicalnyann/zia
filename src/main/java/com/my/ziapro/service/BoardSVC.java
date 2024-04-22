package com.my.ziapro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ziapro.mapper.BoardMapper;
import com.my.ziapro.model.BoardVO;
import com.my.ziapro.model.MemberVO;

@Service
public class BoardSVC 
{ 

	 @Autowired
	    private BoardMapper boardMapper;
	    private BoardVO board; 

	    public boolean eventBoard(BoardVO newBoard) 
	    {	       
	        int r = boardMapper.attendEvent(newBoard); 
	        return r>0; 
	    }
	    
	    
	    public List<BoardVO> getAllComments() {
	        return boardMapper.getAllComments(); 
	    }
	}
