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
            <label>きぶん</label>
            <div class="heart-container">
                <div class="heart-fill" id="karada-fill"></div>
                <input type="range" name="karada" class="vertical-slider" min="0" max="100" value="50" oninput="updateFill(this, 'karada-fill')">
            </div>
        </div>

        <div class="slider-V">
            <label>からだ</label>
            <div class="bolt-container">
                <div class="bolt-fill" id="genki-fill"></div>
                <input type="range" name="genki" class="vertical-slider" min="0" max="100" value="50" oninput="updateFill(this, 'genki-fill')">
            </div>
        </div>
    </div>
    <button type="submit">☑</button>
</form>

<script>
function updateFill(slider, fillId) {
    document.getElementById(fillId).style.height = slider.value + '%';
}

// ページ読み込み時に初期値を反映
window.onload = function() {
    updateFill(document.getElementsByName('genki')[0], 'genki-fill');
    updateFill(document.getElementsByName('karada')[0], 'karada-fill');
};
</script>