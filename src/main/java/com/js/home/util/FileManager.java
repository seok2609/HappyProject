package com.js.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.js.home.notice.NoticeFileVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager extends AbstractView{
	
	@Value("${app.download.base}")
	private String base;
	
	public String saveFile(MultipartFile mf, String path) throws Exception{
		
		
		
		// 1. UUID를 써서 fileNum을 중복되지 않게 설정
		// 아래 StringBuffer의 결과물을 대입하기위해 toString()사용
		String fileName = UUID.randomUUID().toString();	
		
		// 2. 확장자
		StringBuffer bf = new StringBuffer(); //StringBuffer = 여러개의 문자열을 연결해 하나의 문자열로 만드는것
		bf.append(fileName);
		bf.append("_");
		// bf변수에 fileName의 값을 넣고 "_"로 문자열들을 append(이어줌)시켜준다
		
		
		//파일명과 확장자 분리
		String ex = mf.getOriginalFilename();	//ex) ***.jpg, ***.png
		
		// 파일명은 항상 같지 않고 확장자는 거의 일정하기 때문에 
		// 끝에서부터 (lastIndexOf)를 사용해 .위치를 찾아 잘라낸다(substring)
		ex = ex.substring(ex.lastIndexOf("."));
		
		
		bf.append(ex);
		log.info("fileName : {} ", fileName);
		
		fileName = bf.toString();	//StringBuffer때문에 toString사용
		
		// 3. File 저장
		
		File file = new File(path, bf.toString());
		
		mf.transferTo(file);
		
		
		
		return fileName;
	}
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		NoticeFileVO noticeFileVO = (NoticeFileVO)model.get("noticeFileVO");
		
		String path = (String)model.get("path");
		
		File file = new File(base + path, noticeFileVO.getFileName());
		
		//한글로 처리
		response.setCharacterEncoding("UTF-8");
		
		//총 파일의 크기
		response.setContentLengthLong(file.length());
		
		//다운로드시 파일의 이름을 인코딩
		String oriName = URLEncoder.encode(noticeFileVO.getOriName(), "UTF-8");
		
		//header 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+oriName+"\"");//attachment : 첨부
		response.setHeader("Content-Transfer-Encoding", "binary"); //binary : text가 아니라 이진 파일이다.
		
		//Hdd에서 파일을 읽고
		//위에 생성한 file객체를 읽는다 (input=읽기)
		FileInputStream fis = new FileInputStream(file);
		
		//클라이언트로 전송할 준비
		OutputStream os = response.getOutputStream();
		
		//전송
		FileCopyUtils.copy(fis, os);
		
		//자원해제
		os.close();
		fis.close();
		
	}
	
	
	

}
