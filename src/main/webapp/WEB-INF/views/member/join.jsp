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
<script defer src="/js/memberAdd.js"></script>
<script defer src="/js/util.js"></script>
</head>
<body>
<section class="container-fluid col-lg-10 mt-5">
	<h1>회원가입 페이지</h1>

	<form:form modelAttribute="memberVO" action="add" method="post">

	
		  <div class="mb-3">
			  <label for="inputID" class="form-label">아이디</label>
		  <form:input path="id" cssClass="form-control" id="inputID"/>
		  <!--   <input type="text" class="form-control" id="inputID" name="id" placeholder="ID를 입력하세요"> -->
			<form:errors path="id"></form:errors>
			<span id="idHelp"></span>
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="inputPW" class="form-label">비밀번호</label>
		    <form:password path="pw" cssClass="form-control" id="inputPW1"/>
		    <!-- <input type="password" class="form-control" id="inputPW1" name="pw" placeholder="비밀번호를 입력하세요"> -->
		    <form:errors path="pw"></form:errors>
			<span id="pwHelp1"></span>
		  </div>

		  <div class="mb-3">
		    <label for="inputPW2" class="form-label">비밀번호 확인</label>
		    <form:password path="pwCheck" cssClass="form-control" id="inputPW2"/>
		    <!-- <input type="password" class="form-control" id="inputPW2" placeholder="비밀번호 확인"> -->
		    <form:errors path="pwCheck"></form:errors>
			<span id="pwHelp2"></span>
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="inputName" class="form-label">이름</label>
		    <form:input path="name" cssClass="form-control" id="inputName"/>
		    <!-- <input type="text" class="form-control" id="inputName" name="name" placeholder="이름을 입력하세요"> -->
		    <form:errors path="name"></form:errors>
			<span id="nameHelp">
				${name}
			</span>
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="inputEmail" class="form-label">이메일</label>
		    <form:input path="email" cssClass="form-control" id="inputEmail"/>
		    <!-- <input type="text" class="form-control" id="inputEmail" name="email" placeholder="이메일을 입력하세요"> -->
		    <form:errors path="email"></form:errors>
			<span id="emailHelp"></span>
		  </div>
		  
		  <div class="mb-3">
		    <label for="inputAge" class="form-label">나이</label>
		    <form:input path="age" cssClass="form-control" id="inputAge"/>
		    <!-- <input type="text" class="form-control" id="inputEmail" name="email" placeholder="이메일을 입력하세요"> -->
		    <form:errors path="age"></form:errors>
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="inputBirth" class="form-label">birth</label>
		    <form:input path="birth" cssClass="form-control" id="inputBirth"/>
		    <!-- <input type="text" class="form-control" id="inputEmail" name="email" placeholder="이메일을 입력하세요"> -->
		    <form:errors path="birth"></form:errors>
		  </div>
		
		  <button type="submit" id="joinBtn" class="btn btn-primary">회원가입</button>
		  

	</form:form>
		<div>
			<select id="s1">
			   <option>1</option>
			   <option>2</option>
			</select>
			<button type="button" id="s1Add">Add</button>
		 </div>
	 
	 </section>

</body>
</html>