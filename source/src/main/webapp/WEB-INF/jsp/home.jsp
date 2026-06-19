<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>ホーム画面</h1>
	
	<c:forEach var="character" items="${characterList }">
	<img src="${character.characterMainImg}" alt="キャラ画像" width="505.6" height="337.2">
	</c:forEach>
	
	<h2>キャラクター</h2>
	<p><a href="/f4/SearchServlet">アルバム</a></p>
	<p><a href="/f4/QrServlet">QR</a></p>
	<p><a href="/f4/EditServlet">落書き</a></p>
	
	

</body>
</html>