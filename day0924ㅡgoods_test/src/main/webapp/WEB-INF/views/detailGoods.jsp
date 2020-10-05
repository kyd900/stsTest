<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품상세</h2><br>
	<a href="listGoods.do">상품목록</a>
	<form action="detailGoods.do" method="post" >
		상품번호 : ${g.no }<br>
		상품이름 : ${g.name }<br>
		상품가격 : ${g.price }<br> 
		상품수량 : ${g.qty }<br>
		파일 :<br>
		<img src="img/${g.fname }">
		
		<input type="submit" value="등록">
		<input type="reset" value="삭제">
	
	</form>
</body>
</html>