package com.my.ziapro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ziapro.mapper.ProductMapper;
import com.my.ziapro.model.MemberVO;
import com.my.ziapro.model.ProductVO;


@Service
public class ProductSVC 
{

	@Autowired
	private ProductMapper productMapper;
	private ProductVO product;
	private int categoryId;
	private int pnum;
	

	public List<ProductVO> Category1() {
		return productMapper.Category1();
	}
		
	public List<ProductVO> Category2() {
		return productMapper.Category2();
	}

	public List<ProductVO> Category3() {
		return productMapper.Category3();
	}

	public List<ProductVO> Category4() {
		return productMapper.Category4();
	} 

	
	//상세정보
	public ProductVO getProductDetail(int pnum) {
        return productMapper.productDetail(pnum);
    }

	public ProductVO getmDetail(int pnum) {
        return productMapper.mDetail(pnum);
    }
	
	public ProductVO getgDetail(int pnum) {
        return productMapper.gDetail(pnum);
    }
	
	public ProductVO getsDetail(int pnum) {
        return productMapper.sDetail(pnum);
    }
	
	// 검색 서비스 
	public List<ProductVO> find(String pname) {
        return productMapper.find(pname);
    }

	
}
