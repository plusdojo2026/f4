<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ぱぱっとコミュ！｜アルバム画面(検索)</title>
    <link rel="stylesheet" href="css/seach.css">
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
        <img src="images/carenderhaikei.png" class="background">

        <!-- アルバム -->
        <div class="album">
            <img src="images/album.png" class="album-img">
        </div>

        <div class="album-contents">

            <form action="SearchServlet" method="post">

                <div class="date">
                    <p>ここに日付を入力</p>
                    <input type="text" name="date"
                           placeholder="例：20XX/MM/DD">
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