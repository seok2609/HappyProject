package com.js.home.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.js.home.notice.NoticeFileVO;
import com.js.home.notice.NoticeService;
import com.js.home.notice.NoticeVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {

	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping(value = "/fileDown/{path}")
	public ModelAndView fileDown(@PathVariable String path, NoticeFileVO noticeFileVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		//DB에서 정보조회
		if(path.equals("notice")) { //path가 notice로 간다면
			
			noticeFileVO = noticeService.getNoticeFileDetail(noticeFileVO);
			
		}else if(path.equals("notice")){
			noticeFileVO.setFileName(noticeFileVO.getFileName());
			noticeFileVO.setOriName(noticeFileVO.getOriName());
		}
		
		mv.addObject("noticeFileVO", noticeFileVO);
		mv.addObject("path", path);
		
		//fileManager로 가서 쓰여라
		mv.setViewName("fileManager");
		
		return mv;
	}
	
	
	
}
