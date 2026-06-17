<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぱぱっとコミュ！</title>
</head>
<body>
<div class="container">

            <!-- 背景画像 -->
            <!-- <img src="images/carenderhaikei.png" class="background"> -->

            <!-- アルバム -->
            <form method="POST" action="/f4/SearchServlet">                   
	                        <p>ここに日付を入力</p>
	                        <input type="text" placeholder="例：20XX/MM/DD">
	                    	<h1>Album</h1>
	                    	<input type="submit" name="kensaku" value="検索">
			</form>           
</div>
</body>
</html>