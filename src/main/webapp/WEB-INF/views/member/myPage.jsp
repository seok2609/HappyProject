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
</head>
<body>
	<h1>마이페이지</h1>
	<sec:authentication property="Principal" var="user"/>
		<h3>ID: ${user.id} </h3>
		<h3>NAME: ${user.name}</h3>
		<h3>EMAIL: ${user.email}</h3>
		
	<h3>ID : <sec:authentication property="Principal.id"/> </h3>
	<h3>NAME : <sec:authentication property="Principal.name"/> </h3>
	<h3>EMAIL : <sec:authentication property="Principal.email"/> </h3>
	
	
	
	

</body>
</html>