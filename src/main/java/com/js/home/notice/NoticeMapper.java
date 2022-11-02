package com.js.home.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.js.home.util.Pager;

@Mapper
public interface NoticeMapper {

	public List<NoticeVO> getNoticeList(Pager pager) throws Exception;
	
	public NoticeVO getNoticeDetail(NoticeVO noticeVO) throws Exception;
	
	public Long getCount(Pager pager) throws Exception;
	
	public int setNoticeAdd(NoticeVO noticeVO) throws Exception;
	
	public int setNoticeFileAdd(NoticeFileVO noticeFileVO) throws Exception;
	
	public NoticeFileVO getNoticeFileDetail(NoticeFileVO noticeFileVO) throws Exception;
}

