<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
</head>
<body>
	<h1>야옹이 카페</h1>

	<div class="d-flex justify-content-between">
		
			<img alt="" src="./images/cat5.JPG" width="400px" height="600px">
			
			<button type="button" class="btn btn-primary" onclick="location='./notice/list'">목록가기</button>
			
			<img alt="" src="./images/naeun.jpg">

	</div>
		
		
		
	
	<h3>야옹 야옹</h3>
	
	<%-- <h1><a href="./notice/list?page=${page}&search=${search}">QNA</a></h1> --%>
	<button type="button" class="btn btn-primary" onclick="location='./notice/list'">목록가기</button>
</body>
</html>