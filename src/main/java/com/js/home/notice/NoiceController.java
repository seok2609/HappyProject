package com.js.home.notice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.js.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/notice/*")
public class NoiceController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@GetMapping(value = "list")
	public ModelAndView getNoticeList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		List<NoticeVO> ar = noticeService.getNoticeList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("notice/list");
		
		return mv;
		
	}
	
	@GetMapping(value = "detail")
	public ModelAndView getNoticeDetail(NoticeVO noticeVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		noticeVO = noticeService.getNoticeDetail(noticeVO);
		
		mv.addObject("noticeVO", noticeVO);
		mv.setViewName("notice/detail");
		
		return mv;
	}
	
	@GetMapping(value= "write")
	public String setNoticeAdd(@ModelAttribute NoticeVO noticeVO) throws Exception{
		
		return "notice/write";
	}
	
	@PostMapping(value = "write")
	public ModelAndView setNoticeAdd(@Valid NoticeVO noticeVO, BindingResult bindingResult) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			log.info("!!!!!!!!!!!!에러발생!!!!!!!!!!");
			mv.setViewName("notice/write");
			return mv;
		}
		
		int result = noticeService.setNoticeAdd(noticeVO);
		
		mv.addObject("noticeVO", noticeVO);
		mv.setViewName("redirect:./list");
		
		return mv;
		
	}

}
