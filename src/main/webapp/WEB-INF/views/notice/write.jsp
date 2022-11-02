<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer type="text/javascript" src="/js/fileManager.js"></script>
<script defer src="/js/util.js"></script>
<script defer src="/js/noticeAdd.js"></script>
</head>
<body>
<section class="container-fluid col-lg-10 mt-5">
	<h1>글쓰기 페이지</h1>

	<div>
		<form:form modelAttribute="noticeVO" action="write" method="post" enctype="multipart/form-data" id="writeForm">
			
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">작성자</label>
				<form:input path="writer" cssClass="form-control" id="inputWriter"/>
				<!-- <input type="text" class="form-control" name="writer" placeholder="작성자를 입력하세요."> -->
				<form:errors path="writer"></form:errors>
				<span id="writerHelp"></span>
			</div>
	
			<div class="mb-3">
			  <label for="formGroupExampleInput" class="form-label">제목</label>
			  <form:input path="title" cssClass="form-control" id="inputTitle"/>
			  <!-- <input type="text" class="form-control" name="title" placeholder="제목을 입력하세요."> -->
			  <form:errors path="title"></form:errors>
			  <span id="titleHelp"></span>
			</div>
			
			<div class="mb-3">
			  <label for="formGroupExampleInput2" class="form-label">글내용</label>
			  <form:textarea path="contents" cssClass="form-control" id="contents"/>
			  <!-- <textarea class="form-control" name="contents" id="contents" rows="5" placeholder="내용을 입력하세요."></textarea> -->
			  <form:errors path="contents"></form:errors>
			  <span id="contentsHelp"></span>
			</div>
			
 			<div class="mb-3" id="fileAddResult">
			
			</div>
			
			<div class="mb-3">
				<button type="button" id="fileAdd">파일추가</button>
			</div> 
				
			<div style="display: inline-block; margin: 0 5px;  float: right;">
				<button class="btn btn-primary" id="noticeAddBtn">작성완료</button>
			</div>	
		
	
		</form:form>
	</div>
	
	<div style="margin-top: 10px;">
		<button class="btn btn-secondary" type="button" onclick="location='/'">홈</button>
		<button class="btn btn-primary" type="button" onclick="location='./list'">list</button>
	</div>

</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script type="text/javascript">
    $('#contents').summernote({
        tabsize: 4,
        height: 250
      });
	</script>
</body>
</html>