<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぱぱっとコミュ！ | ホーム画面</title>
<link rel="stylesheet" href="css/home.css">
<!-- JavaScriptファイルを読み込む -->
<script src="${pageContext.request.contextPath}/javascript/character.js" defer></script>

</head>
<body>
	<div class="container">
	<h1>ホーム画面</h1>
	<div class="desk"></div>
	<!-- キャラ画像の表示 -->
	<div class="character">
		<c:forEach var="character" items="${characterList }">
			
			<img 
			id="characterImage"
			src="${pageContext.request.contextPath}/${character.characterMainImg}" 
			alt="キャラ画像" 
			width="1000px" height="600px"
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
	</div>
	<div class="menu">
	<!-- 引き出しの画像 -->
	<!-- 画像：引き出し（左） -->
		<img src="images_home/slot_left_hover_1980.png" alt="" class="slot-img left-hover">
		<img src="images_home/ank_slot_left_open_1980.png" alt="" class="slot-img left-open">
	<!-- 画像：引き出し（中央） -->
		<img src="images_home/slot_center_hover_1980.png" alt="" class="slot-img center-hover">
		<img src="images_home/ank_slot_center_open_1980.png" alt="" class="slot-img center-open">
	<!-- 画像：引き出し（右） -->
		<img src="images_home/slot_right_hover_1980.png" alt="" class="slot-img right-hover">
		<img src="images_home/ank_slot_right_open_1980.png" alt="" class="slot-img right-open">
	<ul>
	<!-- 引き出し（左） -->
		<li class="menu-left">
			<input type="checkbox" id="slot_left" name="menu_slot">
			<label for="slot_left"></label>
		</li>
	<!-- 引き出し（中央） -->
		<li class="menu-center">
			<input type="checkbox" id="slot_center" name="menu_slot">
			<label for="slot_center"></label>
		</li>
	<!-- 引き出し（右） -->
		<li class="menu-right">
			<input type="checkbox" id="slot_right" name="menu_slot">
			<label for="slot_right"></label>
		</li> 
	</ul>
</div>

	<a href="/f4/SearchServlet" class="ank-left"></a> <!-- アルバム -->
	<a href="/f4/QrServlet" class="ank-center"></a>　<!-- QR（手紙） -->
	<a href="/f4/EditServlet" class="ank-right"></a>　<!-- ペン -->
	<a href="/f4/DeleteServlet" class="delete"><img src="images_back/clock.png" alt="削除"
	width="200px" height="200px"></a>
	</div>
	

</body>
</html>