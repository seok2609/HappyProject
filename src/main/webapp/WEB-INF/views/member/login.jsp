<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
		 rel="stylesheet" 
		 integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" 
		 crossorigin="anonymous">
</head>
<body>
	
	<section class="container-fluid col-lg-4 mt-5">
	
		<h1>로그인을 하세요</h1>
	  
		  <form action="login" method="post">
		  
			  <div class="mb-3">
			    <label for="userName" class="form-label">ID</label>
			    <input type="text" name="id" class="form-control" id="id" placeholder="ID를 입력하세요">
			  </div>
			  
			  
			  <div class="mb-3">
			    <label for="password" class="form-label">PW</label>
			    <input type="password" name="pw"  class="form-control" id="pw" placeholder="비밀번호를 입력하세요">
			  </div>
			  
			  <h4 id="d1">로그인 할래??</h4>
			  
			  
			  	<button id="btn1" type="submit" class="btn btn-primary" id="btn">로그인</button>
			</form>
	</section>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
			  crossorigin="anonymous">
</script>    
</body>
</html>