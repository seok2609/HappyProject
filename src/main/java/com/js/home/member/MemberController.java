package com.js.home.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	@GetMapping(value = "join")
	public String setMemberJoin(@ModelAttribute MemberVO memberVO) throws Exception{
		 
		return "member/join";
	}
	
	
	@PostMapping(value = "join")
	public ModelAndView setMemberJoin(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = memberService.setMemberJoin(memberVO);
		
		return mv;
	}

}
