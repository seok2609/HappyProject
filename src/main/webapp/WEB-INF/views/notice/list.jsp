<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
<section class="container-fluid col-lg-10 mt-5">
	<h1>리스트 페이지</h1>
	<img alt="" src="../images/cat2.jpg">
	<form action="./list" class="row row-cols-lg-auto g-3 align-items-center">
	
	  <div class="col-12">
	    <label class="visually-hidden" for="kind">Kind</label>
	    <select name="kind" class="form-select" id="kind">
	      <option selected>선택하세요</option>
	      <option class="kinds" value="contents">Contents</option>
	      <option class="kinds" value="title">Title</option>
	      <option class="kinds" value="writer">Writer</option>
	    </select>
	  </div>
	  
	  <div class="col-12">
	    <label class="visually-hidden" for="search">검색어</label>
	    <div class="input-group">
	      <input type="text" name="search" value="${param.search}" class="form-control" id="search">
	  	</div>
	  </div>
	 
  

	  <div class="col-12">
	    <button type="submit" class="btn btn-primary">검색</button>
	  </div>
</form>
	<br>
	
	<div style="display: inline-block; margin: 0 5px;  float: right;">
		<button type="button" class="btn btn-secondary" onclick="location='./write'">글쓰기</button>
	</div>
	
	<br>
	<br>
	
	<table border="1" class="table table-striped table-hover">
		<thead>
			<tr>
				<th>NUM</th>
				<th>WRITER</th>
				<th>TITLE</th>
				<th>CONTENTS</th>
				<th>REGDATE</th>
			</tr>
		</thead>
		
			<tbody>
				<c:forEach items="${requestScope.list}" var="noticeVO">
					
					<tr>
						<td>${noticeVO.num}</td>
						<td>${noticeVO.writer}</td>
						<td><a href="./detail?num=${noticeVO.num}">${noticeVO.title}</a></td>
						<!-- <td>${dto.title}</td> -->
				 		<td>${noticeVO.contents}</td>
						<td>${noticeVO.regDate}</td>
					</tr>
					
				</c:forEach>
				
			</tbody>
	</table>
	
	<nav aria-label="Page navigation example">
	
	  <ul class="pagination">
	  
	  	<c:if test="${pager.pre}">
	  	
		    <li class="page-item">
		    
		      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		      
		    </li>
		    
	    </c:if>
	    
	    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	    	    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
	    </c:forEach>
	
		<li class="page-item ${pager.next?'':'disabled'}">
		
	      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	      
	    </li>
	    
	  </ul>
	  
	</nav>
			
	
	<button type="button" class="btn btn-primary" onclick="location='../'">홈으로</button>
	
<!-- 	<button type="button" class="btn btn-primary" onclick="location='./write'">글쓰기</button> -->
	
	
<script type="text/javascript">
		let result = '${param.result}';
		if(result != ""){
			if(result == '1'){
				alert('등록 성공');
			}else{
				alert('등록 실패');
			}
		}
</script>	
	
</section>
</body>
</html>