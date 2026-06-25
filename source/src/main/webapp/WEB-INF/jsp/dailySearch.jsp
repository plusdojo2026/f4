<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ぱぱっとコミュ！｜アルバム画面(検索)</title>
    <!-- ${pageContext.request.contextPath} -->
    <link rel="stylesheet" href="/f4/css/search.css">
    <!--
    <style>
        * {
            outline: 1px solid #FF0000;
        }
    </style>
    -->
</head>
<body id="top">
    <div class="container">

        <!-- 背景画像 -->
        <img src="/f4/images_back/album.png" class="background">

        <!-- アルバム -->
        <div class="album">
            <img src="/f4/images_back/search_one.png" class="album-img">
        </div>
		
		
		
        <div class="album-contents">

			<a href="/f4/DailyCharacterServlet" class="back">
			<img src="images_back/RETURN.png" alt="戻る" width="150" height="150">
			</a>

            <form action="/f4/SearchServlet" method="post">

                <div class="date">
                    <p>ここに日付を入力</p>
                    <input type="date" name="create_date"
                           placeholder="例：20XX-MM-DD">
                </div>

                <h1>Album</h1>

                <div class="btn">
                    <input type="submit" value="検索" class="button">
                </div>
			
            </form>
			
        </div>
        
    </div>
</body>
</html>