<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입</h2>
	<hr>
	<font color="${text_color }">${msg }</font><br>
	<form action="insertMember.do" method="post">
		아이디 : <input type="text" name="id"><br>
		암호 : <input type="password" name="pwd"><br>
		이름 : <input type="text" name="name"><br>
		전화 : <input type="tel" name="tel"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>