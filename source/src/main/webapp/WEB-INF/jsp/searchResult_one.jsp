<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぱぱっとコミュ！|日別結果画面</title>
<link rel="stylesheet" href="/f4/css/one.css">
</head>
<body id="top">
<div class="container">

            <img src="images_back/album.png" class="background">

            <div class="album">
                <img src="images_back/search_one1.png" class="album-img">
            </div>

            <div class="album-contents">

			   <!-- 左ページ -->
			   <div class="page center-page">
			       <c:forEach var="record" items="${recordList}" begin="0" end="1">
			           <div class="photo-card">
							<div class="date-font">
								<span class="date-badge date-font">
							        ${record.createDate}
							    </span>
							</div>
			               <!--  <span class="date-badge">
			                   ${record.createDate}
			               </span>
							-->
			               <img src="images_screenshot/${record.editScreenShot}" alt="写真">
			           </div>
			       </c:forEach>
			   </div>
	</div>
</div>

<!--<c:forEach var="e" items="${recordList}" >
	<form method="POST" action="/f4/SearchServlet">
	ユーザーID<input type="text" name="company" value="${e.userId}"><br>
	日付<input type="date" name="department" value="${e.createDate}"><br>

	</form>
</c:forEach> -->

<p><a href="/f4/SearchServlet">検索画面に戻る</a></p>

</body>
</html>