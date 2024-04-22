package com.my.ziapro;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.ziapro.model.BoardVO;
import com.my.ziapro.model.MemberVO;
import com.my.ziapro.service.BoardSVC;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/event")
public class EventController 
{

	@Autowired
	private BoardSVC svc;
	private BoardVO event;
	private ResponseEntity<MemberVO> eventBoard;
	private String loggedInMember;
	private Object memberName;
	private BoardVO m;
	private Object member;
	
	@GetMapping("/eventMain")
	public String eventMain() {
		return "eventMain";
	}

	@GetMapping("/dugudugu")
	public String dugudugu() {
		return "dugudugu";
	}

	@GetMapping("/dugu")
	public String dugu() {
		return "dugu";
	}
	
	// 이벤트 참여 board 
	@GetMapping("/board")
	public String board() {
		return "board";
	}

	 @PostMapping("/eventBoard")
	    public ResponseEntity<MemberVO> eventBoard(HttpSession sess, @RequestBody BoardVO newBoard) 
	 {
	        String userName = (String) sess.getAttribute("member");	        
	        log.info("고객이름: " + userName);
	            	
	        boolean result = svc.eventBoard(newBoard);
	        
	        if (result) 
		    {
		    	return new ResponseEntity<>(HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	 }       
	 		
	 @GetMapping("/comments")
	 @ResponseBody
	    public List<BoardVO> getAllComments() {
	        // 댓글을 가져와서 리턴
	        return svc.getAllComments();
	 }
	
}