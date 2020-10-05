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
	<c:if test="${no==0 }">
		<h2>새글 등록</h2>
	</c:if>
	
	<c:if test="${no!=0 }">
		<h2>답글 등록</h2>
	</c:if>
	
	<hr>
	<form 
		action="insertBoard.do" 
		method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="no" value="${no }">
		글제목 : <input type="text" name="title" value="${title }"><br>
		작성자 : <input type="text" name="writer"><br>
		글암호 : <input type="password" name="pwd"><br>
		글내용 : <br>
		<textarea rows="10" cols="60" name="content"></textarea><br>
		파일 : <input type="file" name="uploadFile"><br>
		
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>











</html>