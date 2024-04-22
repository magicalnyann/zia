package com.my.ziapro.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.my.ziapro.model.MemberVO;
import com.my.ziapro.model.ProductVO;

@Mapper
public interface ProductMapper 
{
	//상품 리스트
	public List<ProductVO> Category1();
		
	public List<ProductVO> Category2();

	public List<ProductVO> Category3();

	public List<ProductVO> Category4();	
	
	//상세정보
	public ProductVO productDetail(int pnum);
	
	public ProductVO mDetail(int pnum);
	
	public ProductVO gDetail(int pnum);
	
	public ProductVO sDetail(int pnum); 
	
	//검색
	
	public List<ProductVO> find(String pname);
	
}
