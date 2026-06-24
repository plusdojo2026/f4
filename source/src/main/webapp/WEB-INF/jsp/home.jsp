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
	<div class="container">
	<h1>ホーム画面</h1>
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
			<label for="slot_left">左の引き出し</label>
		</li>
	<!-- 引き出し（中央） -->
		<li class="menu-center">
			<input type="checkbox" id="slot_center" name="menu_slot">
			<label for="slot_center">中央の引き出し</label>
		</li>
	<!-- 引き出し（右） -->
		<li class="menu-right">
			<input type="checkbox" id="slot_right" name="menu_slot">
			<label for="slot_right">右の引き出し</label>
		</li> 
	</ul>
</div>

	
	<h2>キャラクター</h2>
	<p><a href="/f4/SearchServlet">アルバム</a></p>
	<p><a href="/f4/QrServlet">QR</a></p>
	<p><a href="/f4/EditServlet">落書き</a></p>
	</div>
	

</body>
</html>