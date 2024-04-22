package com.my.ziapro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my.ziapro.model.BoardVO;

@Mapper
public interface BoardMapper {
	// 이벤트 댓글달기
	public int attendEvent(BoardVO attend);
	
	//모든 댓글 보여주기
	 public List<BoardVO> getAllComments();
}