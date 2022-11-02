package com.js.home.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.js.home.util.FileManager;
import com.js.home.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	@Value("${app.upload.notice}")
	private String path;
	@Autowired
	private FileManager fileManager;
	
	public List<NoticeVO> getNoticeList(Pager pager) throws Exception{
		Long totalCount = noticeMapper.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		pager.makeStartRow();
		
		return noticeMapper.getNoticeList(pager);
	}
	
	public NoticeVO getNoticeDetail(NoticeVO noticeVO) throws Exception{
		
		return noticeMapper.getNoticeDetail(noticeVO);
	}
	
	public int setNoticeAdd(NoticeVO noticeVO) throws Exception{
		
		int result = noticeMapper.setNoticeAdd(noticeVO);
		
		File file = new File(path);
		
		if(!file.exists()) {	// file이 존재하지 않다면
			boolean check = file.mkdirs();
			
		}
		
		for(MultipartFile mf : noticeVO.getFiles()) {
			
			if(!mf.isEmpty()) {	// file이 비어있지 않다면
				
				String fileName = fileManager.saveFile(mf, path);
				NoticeFileVO noticeFileVO = new NoticeFileVO();
				noticeFileVO.setFileName(fileName);
				noticeFileVO.setOriName(mf.getOriginalFilename());
				noticeFileVO.setNum(noticeVO.getNum());
				
				noticeMapper.setNoticeFileAdd(noticeFileVO);
			}
		}
		
		return result;
	}
	
	public Long getCount(Pager Pager) throws Exception{
		
		return noticeMapper.getCount(Pager);
	}
	
	
	public NoticeFileVO getNoticeFileDetail(NoticeFileVO noticeFileVO) throws Exception{
		
		return noticeMapper.getNoticeFileDetail(noticeFileVO);
	}
	
	
	// 검증 메서드
	public boolean getNoticeAddError(NoticeVO noticeVO, BindingResult bindingResult) throws Exception{
		
		boolean check = false;
		
		// check값이 false면 검증이 성공
		// check값이 true면 검증 실패
		
		//1. Annotation 검증
		check = bindingResult.hasErrors();
		
		if(noticeVO.getWriter().isEmpty()) {
			check = true;
			bindingResult.rejectValue("writer", "NotBlank.noticeVO.writer");
		}else if(noticeVO.getTitle().isEmpty()) {
			check = true;
			bindingResult.rejectValue("title", "NotBlank.noticeVO.title");
		}else if(noticeVO.getContents().isEmpty()) {
			check = true;
			bindingResult.rejectValue("contents", "NotBlank.noticeVO.contents");
		}
		
		return check;
		
		
	}
	
	
	
	
	
	
	

}
