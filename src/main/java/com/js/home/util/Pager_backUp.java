package com.js.home.util;

import lombok.Data;

@Data
public class Pager_backUp {
	
	private Long page;
	private Long perPage = 10L;
	private Long startRow;
	
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

}
