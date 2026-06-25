<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぱぱっとコミュ！|未入力結果画面</title>
<link rel="stylesheet" href="/f4/css/all.css">
</head>
<body id="top">
        <div class="container">

            <img src="images_back/album.png" class="background">

            

            <div class="album-contents">

			<div class="album">
                <img src="images_back/search_all.png" class="album-img">
            </div>
			
			<a href="/f4/SearchServlet" class="back">
			<img src="images_back/RETURN.png" alt="戻る" width="200" height="200">
			</a>
			   <!-- 左ページ -->
			   <div class="page left-page">
			       <c:forEach var="record" items="${recordList}" begin="0" end="1">
			           <div class="photo-card">
			               <span class="date-badge">${record.createDate}</span>
			               <img src="images_screenshot/${record.userId}/${record.editScreenShot}" alt="写真">
			           </div>
			       </c:forEach>
			   </div>
			
			   <!-- 右ページ -->
			   <div class="page right-page">
			       <c:forEach var="record" items="${recordList}" begin="2" end="3">
			           <div class="photo-card">
			               <span class="date-badge">${record.createDate}</span>
			               <img src="images_screenshot/${record.userId}/${record.editScreenShot}" alt="写真">
			           </div>
			       </c:forEach>
			       <!-- <a href="#" class="next-arrow">➔</a>  -->
			  
			   </div>
			</div>
        </div>
    </body>
</html>