package com.js.home.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest

@WebAppConfiguration
@Slf4j
class NoticeTest {

	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void NoticeAddTest() throws Exception{
		
		for(int i=0; i<100; i++) {
			NoticeVO noticeVO = new NoticeVO();
			
			noticeVO.setNum(null);
			noticeVO.setWriter("writer" + i);
			noticeVO.setTitle("title" + i);
			noticeVO.setContents("contents" + i);
			
			
			int result = noticeMapper.setNoticeAdd(noticeVO);
			log.info("result : {}", result);
			
		}
		log.info("finish!!");
	
	}

}
