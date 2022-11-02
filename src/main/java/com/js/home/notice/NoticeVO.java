package com.js.home.notice;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeVO {

	private Long num;
	@NotBlank(message = "공백은 No")
	private String writer;
	@NotBlank
	private String title;
	@NotBlank
	private String contents;
	private Long hit;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
	
	private List<NoticeFileVO> noticeFileVOs;
	
	private MultipartFile [] Files;
	
}
