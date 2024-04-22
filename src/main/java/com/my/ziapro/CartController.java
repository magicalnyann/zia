package com.my.ziapro;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.my.ziapro.model.*;
import com.my.ziapro.model.MemberVO;
import com.my.ziapro.model.ProductVO;
import com.my.ziapro.service.CartSVC;
import com.my.ziapro.service.MemberSVC;
import com.my.ziapro.service.ProductSVC;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/shop")
public class CartController {
	

	@Autowired
	private ProductSVC productSVC;
	private MemberSVC svc;
	private CartSVC cartSVC;
	private ProductVO productVO;
	private MemberVO memberVO;
	
	
	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}

	@GetMapping("/cartinfo")
	public ResponseEntity<MemberVO> cartinfo(HttpSession sess) {
		Object sessionObject = sess.getAttribute("loggedInMember");
	
		if (sessionObject instanceof MemberVO) {
			MemberVO loggedInMember = (MemberVO) sessionObject;

			if (loggedInMember != null) {
				return new ResponseEntity<>(loggedInMember, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	@PostMapping("/insertcart")
	public String addCart(ProductVO pv, HttpSession sess) {
	    Object sessionObject = sess.getAttribute("loggedInMember");
	    
	    if (sessionObject instanceof MemberVO) {
	        MemberVO loggedInMember = (MemberVO) sessionObject;

	        log.info("사용자가 로그인되었습니다. 사용자 ID: " + loggedInMember.getMemberID());
	        
	        List<ProductVO> cart = (List<ProductVO>) sess.getAttribute("cart");
	        
	        if (cart == null) {
	            cart = new ArrayList<>();
	            sess.setAttribute("cart", cart);
	        }
	        
	        cart.add(pv);
	        log.info("상품이 장바구니에 추가되었습니다. 현재 장바구니에 있는 상품 수: " + cart.size());
	      
	        return "viewcart"; 
	    } else {
	        return "redirect:/user/loginForm";
	    }
	}
	
	
	@GetMapping("/viewcart")
	public String viewCart(Model model, HttpSession sess) {
	    List<ProductVO> cart = (List<ProductVO>) sess.getAttribute("cart");
	    model.addAttribute("list", cart);
	    return "viewcart";
	}

	@GetMapping("/moneyinfo")
	public ResponseEntity<MemberVO> moneyinfo(HttpSession sess) {
		Object sessionObject = sess.getAttribute("loggedInMember");
		if (sessionObject instanceof MemberVO) {
			MemberVO loggedInMember = (MemberVO) sessionObject;
			 log.info("사용자가 로1그2인3되었습니다44. 사용자 ID: " + loggedInMember.getMemberID());

			if (loggedInMember != null) {
				return new ResponseEntity<>(loggedInMember, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	@PostMapping("/order")
	public String payment(@SessionAttribute("loggedInMember") MemberVO loggedInMember, HttpSession sess) {
	    log.info("사용자가 로그인되었습니다. 사용자 ID: " + loggedInMember.getMemberID());

	    int memberMoney = loggedInMember.getMoney();
	    int memberPoint = loggedInMember.getPoint();

	    Object cartObject = sess.getAttribute("cart");
	    if (cartObject instanceof CartItemVO) {
	        CartItemVO cart = (CartItemVO) cartObject;
	        List<ProductVO> cartProducts = cart.getProducts();

	        int totalAmount = cartSVC.TotalAmount(cartProducts);

	        if (totalAmount <= (memberMoney + memberPoint) && cartSVC.pay(loggedInMember, totalAmount)) {
	            sess.removeAttribute("cart");
	            return "/zoomoonOk";
	        }
	    }
	    
	    return "redirect:/shop/cart";
	}


	@GetMapping("/zoomoonOk")
	public String zoomoonOk() {
		
		return "zoomoonOk";
	}
}
	

	
	
	
