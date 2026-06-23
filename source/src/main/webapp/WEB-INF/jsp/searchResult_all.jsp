<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぱぱっとコミュ！|未入力結果画面</title>
</head>
<body>
<div class="container">

            <!-- 背景画像 -->
            <!-- <img src="images/carenderhaikei.png" class="background"> -->

            <!-- アルバム -->
            
            <h1>未入力画面</h1>
            <form method="POST" action="/f4/DetailServlet"> 
            	<input type="submit" name="syousai" value="詳細">
            </form>
            

<p><a href="/f4/SearchServlet">検索画面に戻る</a></p>          
</div>
</body>
</html>