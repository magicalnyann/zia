package com.my.ziapro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.ziapro.mapper.MemberMapper;
import com.my.ziapro.model.CartItemVO;
import com.my.ziapro.model.MemberVO;
import com.my.ziapro.model.ProductVO;

import jakarta.servlet.http.HttpSession;


@Service
public class CartSVC {

	@Autowired
	private MemberMapper memberMapper;
	private int pnum;

	
	public MemberVO getCartInfo(String memberID) {
		return memberMapper.userDetail(memberID);
	}

	
	public MemberVO getmoneyinfo(String memberID) {
		return memberMapper.userDetail(memberID);
	}
	
	
	public boolean addCart(ProductVO pro, CartItemVO cartItems) {
		return cartItems.add(pro);
	}
	 
	public List<ProductVO> viewCart(HttpSession sess) {
	    CartItemVO cart = (CartItemVO) sess.getAttribute("cart");
	    List<ProductVO> cartItems = new ArrayList<>();
	    if (cart != null) {
	        cartItems = cart.getProducts();
	    }
	    return cartItems;
	}
  
	
    public int TotalAmount(List<ProductVO> cartProducts) {
        int totalAmount = 0;
        for (ProductVO product : cartProducts) {
            totalAmount += product.getPrice(); 
        }
        return totalAmount;
    }
      
    
    public boolean pay(MemberVO member, int totalAmount) {
        int memberMoney = member.getMoney();
        int memberPoint = member.getPoint();

        if (totalAmount <= memberMoney + memberPoint) {
            return true; 
        } else {
            return false;
        }
    }
}
