<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぱぱっとコミュ！｜スライダー入力画面</title>
<link rel="stylesheet" href="css/slider.css">
</head>
<body>

<form method="POST" action="/f4/SliderServlet">
    <div class="slider-container">
        <div class="slider-V">
            <label>きぶん</label>
            <div class="heart-container">
                <div class="heart-fill" id="kibun-fill"></div>
                <input type="range" name="mind" class="vertical-slider" min="0" max="100" value="50" oninput="updateFill(this, 'kibun-fill')">
            </div>
        </div>

        <div class="slider-V">
            <label>からだ</label>
            <div class="bolt-container">
                <div class="bolt-fill" id="karada-fill"></div>
                <input type="range" name="body" class="vertical-slider" min="0" max="100" value="50" oninput="updateFill(this, 'karada-fill')">
            </div>
        </div>
    </div>
    <button type="submit" class="send-btn"></button>
</form>

<script>
function updateFill(slider, fillId) {
    document.getElementById(fillId).style.height = slider.value + '%';
}

// ページ読み込み時に初期値を反映
window.onload = function() {
    updateFill(document.getElementsByName('mind')[0], 'kibun-fill');
    updateFill(document.getElementsByName('body')[0], 'karada-fill');
};
</script>