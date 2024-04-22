package com.my.ziapro;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.ziapro.model.MemberVO;
import com.my.ziapro.service.MemberSVC;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private MemberSVC svc;
	private Object SVC;
	private Object memberSVC;
	private Object m;
	private MemberVO member;
	private MemberVO memberID;
	private ResponseEntity<MemberVO> userDetail;
	private HttpSession session;
	private String MemberName;

	@GetMapping("/usermain")
	public String usermain() {
		return "usermain";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	@PostMapping("/join")
	@ResponseBody
	public ResponseEntity<String> join(@ModelAttribute MemberVO member) {
		log.info("Received join request: {}", member.toString());

		boolean joinResult = svc.join(member);

		if (joinResult) {
			log.info("User {} joined successfully.", member.getMemberID());
			return ResponseEntity.ok("{\"join\":true}");
		} else {
			log.error("Failed to join user {}", member.getMemberID());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"join\":false}");
		}
	}

	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}

	@PostMapping("/login")
	@ResponseBody
	public String login(MemberVO m, HttpSession sess) {
	    boolean login = svc.login(m, sess);
	    if (login) {
	        MemberVO loggedInMember = (MemberVO) sess.getAttribute("loggedInMember");
	        if (loggedInMember != null) 
	        {
	            String userId = loggedInMember.getMemberID();
	            String userName = loggedInMember.getMemberName();
	            String useradr = loggedInMember.getMemberAddr1();
	            String useradr2 = loggedInMember.getMemberAddr2();
	            String useradr3 = loggedInMember.getMemberAddr3();
	            log.info("uc,로그인: " + userId + userName + useradr + useradr2 + useradr3);
	        }
	    }
	    return "{\"login\":" + login + "}";
	}

	@GetMapping("/myDetail")
	public String myDetail() 
	{		
		 return "myDetail";
	} 
	 	
	@GetMapping("/getDetail")
	public ResponseEntity<MemberVO> getDetail(HttpSession sess) { 
	    Object sessionObject = sess.getAttribute("loggedInMember");
	    if (sessionObject instanceof MemberVO) {
	        MemberVO loggedInMember = (MemberVO) sessionObject;
	        MemberVO member = svc.userDetail(loggedInMember.getMemberID());
	        if (member != null) {
	            return new ResponseEntity<>(member, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } else {
	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	    }
	}
}