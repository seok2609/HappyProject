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

	<h1>디테일 페이지</h1>
    <h3>제목 : ${noticeVO.title}</h3>
    <table border="1" class="table table-striped col-lg-16">
        <thead class="table-info">
            <tr>
                <th>글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성날짜</th>
            </tr>
        </thead>
        
        <tbody>
                <tr>
                    <td>${noticeVO.num}</td>
                    <td>${noticeVO.writer}</td>
                    <td>${noticeVO.title}</td>
                    <td>${noticeVO.contents}</td>
                    <td>${noticeVO.regDate}</td>
                </tr>


                
            </tbody>
        </table>

        <div class="row border border-top-2 border-danger bg-light"  style="min-height: 60vh" >
            <div class="col">지니야 사진 보여줘
                <c:forEach items="${noticeVO.noticeFileVOs}" var="noticeFileVO">
                    <!-- <a href="../../../static/upload/qna/${fileVO.fileName}">${fileVO.oriName}</a> -->
                    <!-- <img src="./result/upload/qna/${qnaFileVO.fileName}" width="300px" height="300px"> -->
                    <img src="/file/notice/${noticeFileVO.fileName}" alt="">
                  <a href="/fileDown/notice?fileNum=${noticeFileVO.fileNum}">${noticeFileVO.oriName}</a>
                </c:forEach>
            </div>
        </div>

        <button class="btn btn-primary" type="button" onclick="location='./list'">목록</button>
</section>

</body>
</html>