<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	<br>
	<font color="red">${msg }</font><br>
	<form action="insertMember.do" method="post">
	회원id : <input type="text" name="id"><br>
	비밀번호 : <input type="text" name="pwd"><br>
	회원이름 : <input type="text" name="name"><br>
	전화번호 : <input type="tel" name="tel">
			<a href="confirmTel.do">번호인증</a>
	<br>
	<input type="submit" value="회원가입">
	<input type="reset" value="취소">
	</form>
</body>
</html>