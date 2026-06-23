<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css">
<!-- JavaScriptファイルを読み込む -->
<script src="${pageContext.request.contextPath}/javascript/character.js" defer></script>

</head>
<body>

	<h1>ホーム画面</h1>
	
	<c:forEach var="character" items="${characterList }">
	<img 
		id="characterImage"
		src="${pageContext.request.contextPath}/${character.characterMainImg}" 
		alt="キャラ画像" 
		width="500" height="300"
	>
		
		
	<!-- 画像切り替え用の画像リスト -->
    <div id="imageList" style="display: none;">

        <!-- 最初のメイン画像もリストに入れる -->
        <span data-img="${pageContext.request.contextPath}/${character.characterMainImg}"></span>

        <!-- 差分画像リスト -->
        <c:forEach var="sub" items="${characterSubList}">
            <span data-img="${pageContext.request.contextPath}/${sub.characterSubImg}"></span>
        </c:forEach>

    </div>
		
		
	</c:forEach>
	
	<h2>キャラクター</h2>
	<p><a href="/f4/SearchServlet">アルバム</a></p>
	<p><a href="/f4/QrServlet">QR</a></p>
	<p><a href="/f4/EditServlet">落書き</a></p>
	
	

</body>
</html>