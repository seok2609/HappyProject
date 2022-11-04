<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
<link href="./css/test.css" rel="styleSheet">
<script defer src="/js/test.js"></script>
</head>
<body>
	<h1>야옹이 카페</h1>
	
	<!-- 로그인 성공시 -->
	<sec:authorize access="isAuthenticated()">

		<sec:authentication property="Principal" var="member"/>
			<h4> <spring:message code="welcome" arguments="${member.name}"></spring:message> </h4>
			<h4> <spring:message code="welcome2" arguments="${member.id},${member.name}" argumentSeparator=","></spring:message> </h4>
			
			<a href="./member/logout">로그아웃</a>
			
			<!-- 로그인한 회원이 등급이 ADMIN이면 admin태그가 뜸, 회원등급이 ADMIN이 아니거나 비회원일시 안보임 -->
			<sec:authorize access="hasRole('ADMIN')">
				<a href="/admin">admin</a>
			</sec:authorize>
			
			<sec:authorize access="hasAnyRole('ADMIN','MANAGER')">
				<a href="/manager">manager</a>
			</sec:authorize>
			
			<sec:authorize access="hasAnyRole('ADMIN','MANAGER','MEMBER')">
				<a href="/member/mypage">마이페이지</a>
			</sec:authorize>
			
	</sec:authorize>
			
	
	
	<!-- 로그인 상태가 아닐때 -->
	
	<sec:authorize access="!isAuthenticated()">
		<a href="./member/login">로그인</a>
		<a href="./member/join">회원가입</a>
	</sec:authorize>

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