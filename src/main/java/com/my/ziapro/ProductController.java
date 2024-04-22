package com.my.ziapro;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.ziapro.model.ProductVO;
import com.my.ziapro.service.ProductSVC;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j; 

@Slf4j
@Controller
@RequestMapping("/product")

public class ProductController {

	@Autowired
	private ProductSVC svc;
	private Object categoryId;
	private Object product;
	private ProductVO productDetail;
	private String noresult;

	@GetMapping("/product1")
	public String product1() {
		return "product1";
	}

	@GetMapping("/Category1")
	@ResponseBody
	public List<ProductVO> Category1() {
		// log.info("카테고리 {} 조회");
		return svc.Category1();
	}

	@GetMapping("/productDetail")
	public String productDetail(@RequestParam("pnum") int pnum, Model model) {
		// log.info("받아 온 품번: {}", pnum);
		ProductVO productDetail = svc.getProductDetail(pnum);
		model.addAttribute("productDetail", productDetail);
		return "productDetail";
	}

	@GetMapping("/product2")
	public String product2() {
		return "product2";
	}

	@GetMapping("/Category2")
	@ResponseBody
	public List<ProductVO> Category2() {
		// log.info("카테고리 {} 조회");
		return svc.Category2();
	}

	@GetMapping("/mDetail")
	public String mealkitDetail(@RequestParam("pnum") int pnum, Model model) {
		// log.info("받아 온 품번: {}", pnum);
		ProductVO mDetail = svc.getmDetail(pnum);
		model.addAttribute("mDetail", mDetail);
		return "mDetail";
	}

	@GetMapping("/product3")
	public String product3() {
		// log.info("카테고리 {} 조회");
		return "product3";
	}

	@GetMapping("/Category3")
	@ResponseBody
	public List<ProductVO> Category3() {
		// log.info("카테고리 {} 조회");
		return svc.Category3();
	}

	@GetMapping("/gDetail")
	public String gDetail(@RequestParam("pnum") int pnum, Model model) {
		// log.info("받아 온 품번: {}", pnum);
		ProductVO gDetail = svc.getgDetail(pnum);
		model.addAttribute("gDetail", gDetail);
		return "gDetail";
	}

	@GetMapping("/product4")
	public String product4() {
		return "product4";
	}

	@GetMapping("/Category4")
	@ResponseBody
	public List<ProductVO> Category4() {
		log.info("카테고리 {} 조회");
		return svc.Category4();
	}

	@GetMapping("/sDetail")
	public String sDetail(@RequestParam("pnum") int pnum, Model model) {
		// log.info("받아 온 품번: {}", pnum);
		ProductVO sDetail = svc.getsDetail(pnum);
		model.addAttribute("sDetail", sDetail);
		return "sDetail";
	}

	
	@PostMapping("/find")
	public String find(@RequestParam("pname") String pname, Model model) {
	    List<ProductVO> find = svc.find(pname);
	    if (find != null && !find.isEmpty()) {
	        log.info("검색 성공: 검색어 = {}, 결과 개수 = {}", pname, find.size());
	        model.addAttribute("products", find);
	        log.info("검색어 '{}'에 대한 검색이 성공적으로 수행되었습니다.", pname);
	        return "search"; 
	    } else {
	        log.info("검색 실패: 검색어 = {}", pname);
	        model.addAttribute("pname", pname);
	        return "noresult"; 
	    }
	}

	
	
}
