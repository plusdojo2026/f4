<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スライダー入力画面</title>
<link rel="stylesheet" href="css/slider.css">
</head>
<body>

<form method="POST" action="/f4/HomeServlet">
    <div class="slider-container">

        <div class="slider-V">
            <label>げんき</label>
            <input type="range" name="genki" class="vertical-slider" min="0" max="100" value="50">
        </div>

        <div class="slider-V">
            <label>からだ</label>
            <input type="range" name="karada" class="vertical-slider" min="0" max="100" value="50">
        </div>
    </div>
    <button type="submit">送信</button>
</form>

</body>
</html>