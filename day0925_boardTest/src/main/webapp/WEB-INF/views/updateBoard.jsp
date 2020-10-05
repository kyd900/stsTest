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
	<h2>게시물 수정</h2>
	<hr>
	<form 
		action="updateBoard.do" 
		method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="no" value="${b.no }">
		글제목 : <input type="text" name="title" value="${b.title }"><br>
		작성자 : <input type="text" name="writer" value="${b.writer }" readonly="readonly"><br>
		글암호 : <input type="password" name="pwd"><br>
		글내용 : <br>
		<textarea rows="10" cols="60" name="content">${b.content }</textarea><br>
		파일 : ${b.fname }(${b.fsize }bytes) 
		<input type="text" name="fname" value="${b.fname }">
		<input type="text" name="fsize" value="${b.fsize }">
		<input type="file" name="uploadFile"><br>
		
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</body>











</html>