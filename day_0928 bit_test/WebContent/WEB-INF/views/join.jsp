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
	<font color="red">${msg }</font><br>
	<form action="join.do" method="post">
		전화번호 : <input type="tel" name="to">
		<input type="submit" value="인증키전송">
	</form>
</body>
</html>