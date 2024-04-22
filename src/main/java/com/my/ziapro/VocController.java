package com.my.ziapro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/voc") 

public class VocController {	
	
	
		@GetMapping("/vocmain") 
	    public String vocmain() {
	        return "vocmain"; 
	    }
		
		@GetMapping("/zaju") 
	    public String zaju() {
	        return "zaju"; 
	    }
		
	
}

