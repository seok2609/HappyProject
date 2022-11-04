package com.js.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "login")
	public String getMemberLogin() throws Exception{
		
		return "member/login";
	}
	
	
	@GetMapping(value = "logout")
	public String getLogout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:../";
	}
	
	
	@GetMapping(value = "myPage")
	public String getMyPage() throws Exception{
		
		return "member/myPage";
	}

}
