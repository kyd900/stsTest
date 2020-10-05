<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${title }</h2>
	<a href="insertBoard.do">등록</a><br>
	<table border="1" width="80%">
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>첨부파일</td>
		</tr>
		
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.no }</td>
				<td>
					<c:if test="${b.b_level>0 }">
						<c:forEach begin="1" end="${b.b_level }">
							&nbsp;&nbsp;
						</c:forEach>
					</c:if>
					<a href="detailBoard.do?no=${b.no }">${b.title }</a>
				</td>
				<td>${b.writer }</td>
				<td>	
					<c:if test="${b.fsize > 0 }">
						<img src="file.png" width="20" height="20">
						${b.fname }(${b.fsize }bytes)
					</c:if>
					&nbsp;
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	
	<c:forEach var="i" begin="1" end="${totalPage }">
		<a href="listBoard.do?pageNUM=${i }">${i }</a>&nbsp;
	</c:forEach>
	
	
</body>
</html>












