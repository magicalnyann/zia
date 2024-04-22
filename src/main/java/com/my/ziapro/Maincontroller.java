package com.my.ziapro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class Maincontroller { 
	
	//메인페이지 컨트롤러
	@GetMapping("/mainpage")
	public String mainpage() {
	    return "mainpage";
	}

@GetMapping("megazine") 
public String megazine() {
    return "megazine"; 
}


@GetMapping("soge")
public String soge() {
	return "soge";
}

}