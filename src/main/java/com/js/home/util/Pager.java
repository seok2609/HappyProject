package com.js.home.util;

import java.util.List;

import com.js.home.notice.NoticeVO;

import lombok.Data;

@Data
public class Pager {
	
	/*
	 * perPage : 한페이지(jsp)에 출력할 글의 갯수
	 * perBlock : 한페이지(jsp)에 출력할 번호의 갯수 
	 * */
	
	private Long page;
	private Long perPage;
	private Long startRow;
	private Long startNum;
	private Long lastRow;
	private Long perBlock;
	private Long lastNum;
	
	private String kind;
	private String search;
	
	//이전 블럭의 유무
	private boolean pre;
	//다음 블럭의 유무
	private boolean next;
	
	private List<NoticeVO> noticeVOs;
	private Long num;
	
	
	public Pager() {
		this.perPage = 10L;	//한 페이지에 10 ROW를 출력하고
		this.perBlock = 5L;	//한 페이지에 보이는 블럭의 개수를 1,2,3,4,5로 한다
	}
	
	public void getRowNum() throws Exception{
		this.startRow = (this.getPage()-1)*this.getPerPage() + 1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	public void getNum(Long totalCount) throws Exception{
		
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0 ) {
			totalPage++;
		}
		
	//2_1 totalPage보다 page가 더 클 경우
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		
	//3. totalPage로 totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
			if(totalPage%this.getPerBlock() != 0) {
				totalBlock++;
				}
			
	//4. page로 curBlock 찾기
		Long curBlock = this.getPage()/this.getPerBlock();
			if(this.getPage()%this.getPerBlock() != 0) {
				curBlock++;
				}
			
	//5. curBlock으로 startNum, lastNum구하기
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		
	//6. curBlock(현재블럭)이 totalBlock(마지막블럭)과 같을때
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
	//7. 이전, 다음블럭의 유무
		if(curBlock>1) {
			pre = true;
		}
		
		if(curBlock<totalBlock) {
			next = true;
		}
	}
	
	// 시작줄을 만들기
	public void makeStartRow() {
		this.startRow = (this.getPage()-1)*this.perPage;
	}
	
	//페이지가 null이거나 1보다 작으면 1페이지로 이동
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page=1L;
			
		}
		
		return this.page;
	}
	
	
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage = 5L;
			
		}
		return perPage;
	}
	
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	
	

}
